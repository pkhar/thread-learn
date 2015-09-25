package org.kharitonov.learn;

import org.kharitonov.learn.runnables.FirstRunnable;
import org.kharitonov.learn.thread.TestThread;
import org.kharitonov.learn.thread.ThreadInterference;

/**
 * Created by kharitonovp on 9/23/2015.
 */
public class ThreadStarter {
    public static void main(String args[]) throws InterruptedException {
        //try to run primitive self-made threads
        ThreadStarter.startTestThreads();
        ThreadInterference.example();
    }

    /**
     * run primitive self-made threads
     * @throws InterruptedException
     */
    private static void startTestThreads() throws InterruptedException {
        System.out.println("Start executing thread examples");
        Thread myThread = new Thread(new FirstRunnable());
        myThread.start();
        System.out.println(myThread.getName());
        myThread.sleep(1000);

        Thread myThread2 = new Thread(new FirstRunnable());
        myThread2.start();
        System.out.println(myThread2.getName());
        //interrupts thread execution
        myThread2.interrupt();
        System.out.println("Is thread2 interrupted?   " + myThread2.isInterrupted());

        TestThread myThread3 = new TestThread();
        myThread3.start();
        System.out.println("TestThread started");
        System.out.println(myThread3.getName());
    }
}
