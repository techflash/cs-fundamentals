package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Process implements Runnable {

    private int id;

    public Process(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("running task : " + id);
            Thread.sleep(4000);

        } catch (InterruptedException e) {
        }

        System.out.println("task with id: " + id + " completed");
    }
}

public class ThreadPoolSample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Process(i));

        }

        executorService.shutdown();
        System.out.println("Submitted all tasks");


        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
