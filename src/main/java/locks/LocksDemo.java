package locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LocksDemo {
    Counter counter = new Counter();
    SyncCounter syncCounter = new SyncCounter();
    LockedCounter lockCounter = new LockedCounter();

    public void demoCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(counter::increment));
        service.shutdown();
        System.out.println("Counter count=" + counter.getCount());
    }

    public void demoSyncCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(syncCounter::increment));
        System.out.println("SyncCounter count=" + syncCounter.getCount());
    }

    public void demoLockedCounter() {
        ExecutorService service = Executors.newCachedThreadPool();
        IntStream.range(0, 1000)
                .forEach(i -> service.submit(lockCounter::increment));
        System.out.println("LockCounter count=" + lockCounter.getCount());
    }
    public static void main(String[] args) {
        LocksDemo locksDemo = new LocksDemo();
//        locksDemo.demoCounter();
//        locksDemo.demoSyncCounter();
        locksDemo.demoLockedCounter();
    }
}
