package org.kharitonov.learn.thread;

import org.kharitonov.learn.ThreadStarter;

import java.util.logging.Logger;

/**
 * Demonstates, that we can't order threads execution
 *
 * Created by kharitonovp on 9/26/2015.
 */
public class RandomRunExample  extends Thread{
    private static Logger log = Logger.getLogger(ThreadStarter.class.getName());

    public void run(){
        log.info(Thread.currentThread().getName());
    }

    /**
     * Demonstates, that we can't order threads execution
     */
    public static void example(){
        for(int i=0;i<10;i++){
            Thread thread = new RandomRunExample();
            thread.start();
        }
    }
}
