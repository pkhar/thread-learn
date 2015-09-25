package org.kharitonov.learn.thread;

/**
 * Created by kharitonovp on 9/25/2015.
 */
public class ThreadInterference extends Thread {
    private static final int hundredMillion = 100000000;
    private static int counter = 0;
    private static int i = 0;
    private static Object lock = new Object();


    /**
     *
     */
    public static void example() {
        (new ThreadInterference()).start();
        (new ThreadInterference()).start();
    }

    /**
     * demonstrates difference between synchronized and non-synchronized variables
     */
    public void run() {
        while (counter < hundredMillion) {
            synchronized (lock) {
                counter++;
            }
            i++;
        }
        System.out.println("i: " + i + "   counter:  " + counter);
    }
}
