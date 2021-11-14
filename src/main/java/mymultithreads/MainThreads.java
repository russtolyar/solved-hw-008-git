package mymultithreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static javax.swing.UIManager.get;

public class MainThreads {
    private static final Logger LOGGER = LogManager.getLogger(MyConnection.class);

    public static void main(String[] args) {


/**
 *  This just to realise "how to" without classes Thread and Runnable
 *
 *       IntStream.range(0,100)
 *                 .boxed()
 *                 .forEach(index ->{
 *                             MyConnectionPool myConnectionListPool = MyConnectionPool.getConnectionPoolInstance(5);
 *                             Thread thread = new Thread(()->{
 *                                 MyConnection myConnection = myConnectionListPool.getMyConnection();
 *                                 myConnection.update();
 *                                 myConnection.create();
 *                                 myConnection.read();
 *                                 myConnection.print();
 *                                 MyConnectionPool.releaseConnection(myConnection);
 *                             });
 *                             thread.start();
 *                          });
 */


        IntStream.range(0, 100)
                .boxed()
                .forEach(i -> {
                    MyConnectionPool myConnectionPool = MyConnectionPool.getConnectionPoolInstance(5);
                    Thread thread1 = new ExampleThread(myConnectionPool);
                    thread1.start();
                });

        IntStream.range(0, 100)
                .boxed()
                .forEach(i -> {
                    MyConnectionPool myConnectionPool = MyConnectionPool.getConnectionPoolInstance(5);
                    ExampleRunnable exampleRunnable = new ExampleRunnable(myConnectionPool);
                    Thread thread2 = new Thread(exampleRunnable);
                    thread2.start();
                });

        LOGGER.debug("\n Second Part \n");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        IntStream.range(0, 100).boxed()
                .forEach(i -> executorService
                        .execute(() -> {
                            MyConnection myConnection = new MyConnection();
                            myConnection.create();
                            LOGGER.debug(" by ExecutorService ");
                            myConnection.read();
                            LOGGER.debug(" by ExecutorService ");
                            myConnection.print();
                            LOGGER.debug(" by ExecutorService ");
                            myConnection.update();
                            LOGGER.debug(" by ExecutorService ");
                            myConnection.delete();
                            LOGGER.debug(" by ExecutorService ");
                        }));


        IntStream
                .range(0, 100).boxed()
                .forEach(i -> executorService
                        .execute(() -> {
                            MyConnection myConnection = new MyConnection();
                            CompletableFuture<?> myFuture = CompletableFuture.runAsync(() -> {
                                        LOGGER.debug(" by CompletableFuture ");
                                        myConnection.update();
                                        LOGGER.debug(" by CompletableFuture ");
                                        myConnection.print();
                                        LOGGER.debug(" by CompletableFuture ");
                                        myConnection.read();
                                        LOGGER.debug(" by CompletableFuture ");
                                        myConnection.delete();
                                    }
                                    , executorService).thenRunAsync(() -> {
                                        LOGGER.debug(" by CompletableFuture ");
                                        myConnection.create();
                                    }
                                    , executorService);


                            CompletableFuture<?> allOfFutures = CompletableFuture.allOf(myFuture);
                            get(allOfFutures);
                        })

                );
    }
}
