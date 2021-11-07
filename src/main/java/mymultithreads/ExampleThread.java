package mymultithreads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExampleThread extends Thread {

    private static final Logger LOGGER = LogManager.getLogger();

    private final MyConnectionPool connectionPoolInstance;

    public ExampleThread(MyConnectionPool connectionPoolInstance) {
        this.connectionPoolInstance = connectionPoolInstance;
    }

    @Override
    public void run() {
        MyConnection connection = connectionPoolInstance.getMyConnection();

        connection.create();
        LOGGER.debug(" extends Thread ");
        connection.read();
        LOGGER.debug(" extends Thread ");
        connection.print();
        LOGGER.debug(" extends Thread ");
        connection.update();
        LOGGER.debug(" extends Thread ");
        connection.delete();
        LOGGER.debug(" extends Thread ");

        connectionPoolInstance.releaseConnection(connection);
    }
}
