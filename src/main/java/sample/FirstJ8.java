package sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by shraddha on 2/3/16.
 */
public class FirstJ8 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 100).forEach(i -> {
                    executorService.submit(() -> System.out.println("Running task : " + i));
                });
        executorService.shutdown();
    }
}
