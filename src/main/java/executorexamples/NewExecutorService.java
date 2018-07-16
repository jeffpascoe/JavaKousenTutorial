package executorexamples;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewExecutorService {

    public static void main(String[] args) {

        List<Callable<String>> callables = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .map(YourCallable::new)
                .collect(Collectors.toList());

        ExecutorService executor = Executors.newFixedThreadPool(10);

        try {
            List<Future<String>> futures = executor.invokeAll(callables);
            for(Future future : futures) {
                System.out.println(future.get());
            }
        } catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
