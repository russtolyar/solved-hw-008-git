package mymultithreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleRunnable implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger();

    private final MyConnectionPool connectionPoolInstance;

    public ExampleRunnable(MyConnectionPool connectionPoolInstance) {
        this.connectionPoolInstance = connectionPoolInstance;
    }

    @Override
    public void run() {
        MyConnection connection = connectionPoolInstance.getMyConnection();

        connection.create();
        LOGGER.debug(" implements Runnable ");
        connection.read();
        LOGGER.debug(" implements Runnable ");
        connection.print();
        LOGGER.debug(" implements Runnable ");
        connection.update();
        LOGGER.debug(" implements Runnable ");
        connection.delete();
        LOGGER.debug(" implements Runnable ");

        connectionPoolInstance.releaseConnection(connection);
    }
}
