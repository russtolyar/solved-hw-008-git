package mymultithreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MyConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(MyConnection.class);

    private static volatile List<MyConnection> myConnectionListPool;
    private static MyConnectionPool connectionPoolInstance;
    Integer myMaxConnections;

    private MyConnectionPool() { }

    public static synchronized MyConnectionPool getConnectionPoolInstance(Integer myMaxConnections) {
        if (connectionPoolInstance == null) {
            connectionPoolInstance = new MyConnectionPool();
        }
        myConnectionListPool = Collections.synchronizedList(new ArrayList<>());
        IntStream.range(0, myMaxConnections).forEach(i -> myConnectionListPool.add(new MyConnection()));
        return connectionPoolInstance;
    }

      public synchronized MyConnection getMyConnection() {
        LOGGER.debug("get My Connection");
        return myConnectionListPool.remove(myConnectionListPool.size() - 1);
    }

    public synchronized void releaseConnection(MyConnection myConnection) {
        LOGGER.debug("Release Connection");
        myConnectionListPool.add(myConnection);

    }
}
