package lesson3.pingpong;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        PingPongQueue pingPongQueue = new PingPongQueue();

        new Ping(pingPongQueue);
        new Pong(pingPongQueue);

//        Thread ping = new Thread(pingPongQueue::ping);
//        Thread pong = new Thread(pingPongQueue::pong);
//        Thread ping1 = new Thread(pingPongQueue::ping);
//        Thread pong1 = new Thread(pingPongQueue::pong);
//
//        ping.start();
//        pong.start();
//        ping1.start();
//        pong1.start();


    }
}
