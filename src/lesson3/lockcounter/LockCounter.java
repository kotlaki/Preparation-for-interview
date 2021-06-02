package lesson3.lockcounter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Runnable {

    private Counter counter;
    private Lock lock;

    public LockCounter(Counter counter) {
        this.counter = counter;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
       lock.lock();
       counter.startCounter();
       lock.unlock();
    }
}
