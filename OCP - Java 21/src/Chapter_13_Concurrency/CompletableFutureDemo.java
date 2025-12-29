package Chapter_13_Concurrency;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    private static final double DEFAULT_PRICE = 9.99;

    public static Future<Double> calculateAsync() throws InterruptedException {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        var executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(() -> {
            System.out.println("request to a server has been sent...");
            Double result = null;
            TimeUnit.SECONDS.sleep(2);
            return result;
        });
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);

        if (future.isDone() && !future.isCancelled()) {
            System.out.println(future.state());
            return future;
        } else {
            completableFuture.complete(DEFAULT_PRICE);
            return completableFuture;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(calculateAsync().get());

        CompletableFuture<String> futureResult = CompletableFuture.supplyAsync(() -> "Hello").thenApply((result) -> {
            return result + " World";
        });
        System.out.println(futureResult.get());

        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Request User Profile from external API...");
            return "Some String representing User Profile";
        }).thenAccept((result) -> {
            System.out.println("User Profile received: " + result);
        });

        if (future.isDone()) {
            System.out.println("Done");
        }
    }
}
