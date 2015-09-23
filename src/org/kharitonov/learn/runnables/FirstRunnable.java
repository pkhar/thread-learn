package org.kharitonov.learn.runnables;

/**
 * Created by kharitonovp on 9/23/2015.
 */
public class FirstRunnable implements Runnable {
    private static int numberOfThreads = 0;

    private int threadNumber;

    @Override
    public void run() {
        System.out.println("Thread number " + threadNumber + " started");
    }

    public FirstRunnable(){
        numberOfThreads++;
        threadNumber=numberOfThreads;
    }
}
