package dev.toddmartin.Jalgo.network;

import java.util.List;
import java.util.Queue;

public class NetworkScheduler implements Runnable {

    private long time;
    private int count; // how many times api request is made
    private boolean isAlive;

    public synchronized void changeState () {
        if (isAlive)
            isAlive = false;
        else
            isAlive = true;
    }

    private synchronized boolean getIsAlive () {
        return this.isAlive;
    }

    // entry point of thread
    public void run () {
        this.isAlive = true;

        while(this.getIsAlive()) {
            
        }
    }
}
