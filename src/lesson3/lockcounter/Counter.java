package lesson3.lockcounter;

public class Counter {

    private int counter = 0;

    public void increase() {
        counter++;
    }

    public void startCounter() {
        for (int i = 0; i <= 100; i++) {
            increase();
            System.out.println(i);
        }
    }

}
