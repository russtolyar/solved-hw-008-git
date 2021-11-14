package mymultithreads;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyConnection {
    private static final Logger LOGGER = LogManager.getLogger(MyConnection.class);

    public void create() {
        sleep(1500);
        LOGGER.debug(Thread.currentThread().getName() + " Create new subject");
    }

    public void read() {
        sleep(1500);
        LOGGER.debug(Thread.currentThread().getName() + " Read all info about this subject");
    }

    public void update() {
        sleep(1500);
        LOGGER.debug(Thread.currentThread().getName() + " Change some info of our subject");
    }

    public void delete() {
        sleep(1500);
        LOGGER.debug(Thread.currentThread().getName() + " Removing that, sorry");
    }

    public void print() {
        sleep(1500);
        LOGGER.debug(Thread.currentThread().getName() + " Print some info about our subject");
    }

    public static void sleep(Integer millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



