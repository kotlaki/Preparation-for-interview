package lesson3.pingpong;

/*
1. Реализовать программу, в которой два потока поочередно пишут ping и pong.
 */

public class PingPongQueue {

    boolean status;

    public synchronized void ping() {
        while (status) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ping");
        status = true;
        notifyAll();
    }

    public synchronized void pong() {
        while (!status) {
            try {
                wait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("pong");
        status = false;
        notifyAll();
    }
}

class Ping implements Runnable {

    PingPongQueue pingPongQueue;

    public Ping(PingPongQueue pingPongQueue) {
        this.pingPongQueue = pingPongQueue;
        new Thread(this, "Ping").start();
    }


    @Override
    public void run() {
        while (!Thread.interrupted()) {
            pingPongQueue.ping();
        }
    }
}

class Pong implements Runnable {

    PingPongQueue pingPongQueue;

    public Pong(PingPongQueue pingPongQueue) {
        this.pingPongQueue = pingPongQueue;
        new Thread(this, "Pong").start();
    }

    @Override
    public void run() {
        while (true) {
            pingPongQueue.pong();
        }
    }
}