package ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerDemo {

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        Producer p1 = new Producer(1, queue);
        Producer p2 = new Producer(2, queue);
        Consumer c1 = new Consumer(1, queue);
        Consumer c2 = new Consumer(2, queue);

        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors());

        executorService.execute(p1);
        executorService.execute(p2);
        executorService.execute(c1);
        executorService.execute(c2);
    }
}
