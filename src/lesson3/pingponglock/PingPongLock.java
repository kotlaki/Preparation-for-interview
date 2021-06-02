package lesson3.pingponglock;

import lesson3.pingpong.PingPongQueue;

import java.util.concurrent.locks.Lock;

public class PingPongLock {
    boolean status;

    Lock lock;

    public void ping() {
        while (status) {
            try {
                lock.newCondition().await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("ping");
        status = true;
        lock.newCondition().signalAll();
    }

    public void pong() {
        while (!status) {
            try {
                lock.newCondition().await();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("pong");
        status = false;
        lock.newCondition().signalAll();
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
        while (true) {
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
