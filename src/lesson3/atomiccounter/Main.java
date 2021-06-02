package lesson3.atomiccounter;

public class Main {
    public static void main(String[] args) {
        AtomicCounter atomicCounter = new AtomicCounter();

        for (int i = 0; i <= 1; i++) {
            Thread thread = new Thread(atomicCounter::startCounter);
            thread.start();
        }

    }
}
