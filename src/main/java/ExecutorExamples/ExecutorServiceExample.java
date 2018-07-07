package ExecutorExamples;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        List<Callable<String>> callables = Stream.iterate(0, n -> n + 1)
                .limit(10)
                .map(MyCallable::new)
                .collect(Collectors.toList());

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            List<Future<String>> futures = executorService.invokeAll(callables);

            for(Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }


    }
}
