package thread.fourMethod4createThread;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        new Thread(()->run("new Thread start")).start();

        new Thread(()->run("new Thread run")).run();

        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.execute(futureTask);

        System.out.println(futureTask.get());
    }

    private static void run(String name) {
        try {
            Thread.sleep(2000L);
            System.out.println(name+ ":"+ Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("MyThread " + Thread.currentThread());
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000L);
            System.out.println(Thread.currentThread());
            return "call!";
        }
    }

}
