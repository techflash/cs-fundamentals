package threading;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantProducerConsumer {

  volatile int count = 0;
  int size = 10;
  int buffer[] = new int[size];

  Lock lock = new ReentrantLock();
  Condition producerCondition = lock.newCondition();
  Condition consumerCondition = lock.newCondition();

  private void produce() {
    while (true) {
      try {
        lock.lock();
        if (count >= 10) {
          producerCondition.await();
        }
        Integer no = new Random().nextInt(100);
        System.out.println("produced: " + no);
        buffer[count++] = no;
        System.out.println("count " + count);
        Thread.sleep(1000);
        consumerCondition.signal();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }
  }

  private void consumer() {
    while (true) {
      try {
        lock.lock();
        if (count == 0) {
          consumerCondition.await();
        }
        System.out.println("consumed: " + buffer[--count]);
        producerCondition.signal();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    }

  }

  public static void main(String[] args) {
    ReentrantProducerConsumer r = new ReentrantProducerConsumer();
    Thread t1 = new Thread(() -> r.produce(), "t1");
    Thread t2 = new Thread(() -> r.consumer(), "t2");
    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}