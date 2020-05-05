package threading;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

class Processor {
    private Queue<Integer> queue;

    public Processor(Queue<Integer> queue) {
        this.queue = queue;
    }

    private Object lock = new Object();
    private static int QUEUE_SIZE = 10;

    public void produce() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (queue.size() == QUEUE_SIZE) lock.wait();
                int no = new Random().nextInt(100);
                queue.add(no);
                System.out.println("queue size: " + queue.size());
                lock.notify();
            }
        }
    }


    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                if (queue.size() == 0) lock.wait();
                System.out.println("consumed : " + queue.poll());
                lock.notify();
            }
            Thread.sleep(1000);

        }
    }


}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Processor p = new Processor(new ArrayDeque<>());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
