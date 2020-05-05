package threading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LatchProcess implements Runnable {

    private int id;
    private CountDownLatch latch;

    public LatchProcess(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("running task : " + id);
            Thread.sleep(4000);

        } catch (InterruptedException e) {
        }

        System.out.println("task with id: " + id + " completed");
        latch.countDown();
    }

}

public class LatchSample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        for (int i = 0; i < 3; i++) {
            executorService.submit(new LatchProcess(i, countDownLatch));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("all thread completed processing!");
    }
}
