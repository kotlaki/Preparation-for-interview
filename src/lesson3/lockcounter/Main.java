package lesson3.lockcounter;

/*
2. Реализовать потокобезопасный счетчик с помощью интерфейса Lock.
 */

public class Main {

    public static void main(String[] args) {

        LockCounter lockCounter = new LockCounter(new Counter());

        Thread thread = new Thread(lockCounter);
        Thread thread2 = new Thread(lockCounter);

        thread.start();
        thread2.start();
    }

}
