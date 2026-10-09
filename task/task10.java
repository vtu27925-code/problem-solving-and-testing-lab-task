import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AuthenticationStressTest {

    public static void main(String[] args)
            throws InterruptedException {

        SecureAuthentication auth =
                new SecureAuthentication();

        int totalRequests = 1000;
        int threadCount = 50;

        ExecutorService executor =
                Executors.newFixedThreadPool(threadCount);

        CountDownLatch ready =
                new CountDownLatch(threadCount);
        CountDownLatch start = new CountDownLatch(1);

        AtomicInteger success = new AtomicInteger();
        AtomicInteger failure = new AtomicInteger();

        long startTime = System.nanoTime();

        for (int i = 0; i < totalRequests; i++) {
            final int request = i;

            executor.submit(() -> {
                ready.countDown();

                try {
                    start.await();

                    boolean result;

                    if (request % 2 == 0) {
                        result = auth.login(
                                "user1", "Pass@123");
                    } else {
                        result = auth.login(
                                "user1", "WrongPassword");
                    }

                    if (result) {
                        success.incrementAndGet();
                    } else {
                        failure.incrementAndGet();
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        ready.await();
        start.countDown();

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        long endTime = System.nanoTime();

        double seconds =
                (endTime - startTime) / 1_000_000_000.0;

        System.out.println("Total Requests: " + totalRequests);
        System.out.println("Successful Logins: " + success.get());
        System.out.println("Failed Logins: " + failure.get());
        System.out.printf("Execution Time: %.3f seconds%n",
                seconds);
        System.out.printf("Throughput: %.2f requests/second%n",
                totalRequests / seconds);
    }
}
