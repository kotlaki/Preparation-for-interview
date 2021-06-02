package lesson3.atomiccounter;

/*
2. Реализовать потокобезопасный счетчик с помощью интерфейса Lock.
 */

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicCounter {

    AtomicInteger counter = new AtomicInteger();

    void increase() {
        counter.incrementAndGet();
    }

    void startCounter() {
        for (int i = 0; i < 1000; i++) {
            this.increase();
            System.out.println(i);
        }
    }
}

