package org.kharitonov.learn.thread;

import org.kharitonov.learn.ThreadStarter;

import java.util.logging.Logger;

/**
 * shows how to order threads
 * Created by kharitonovp on 9/26/2015.
 */
public class OrderedRunExample extends Thread {
    private static Logger log = Logger.getLogger(ThreadStarter.class.getName());

    private static int currentMax = 1;
    private int mainId;
    private Object waitObject;

    public OrderedRunExample(int id, Object waitObject) {
        this.mainId = id;
        this.waitObject = waitObject;
    }

    public static void example() {
        Object waitObj = new Object();
        for (int i = currentMax; i <= 10; i++) {
            Thread thread = new OrderedRunExample(i, waitObj);
            thread.start();
        }
    }

    /**
     * shows gow to order threads execution
     */
    public void run() {
        try {
            synchronized (waitObject) {
                while (mainId > currentMax) {
                    waitObject.wait();
                }
                currentMax++;
                System.out.println("Ping from thread   " + mainId);
                waitObject.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
