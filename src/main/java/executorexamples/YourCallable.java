package executorexamples;

import java.util.Random;
import java.util.concurrent.Callable;

public class YourCallable implements Callable<String> {
    private Integer id;

    public YourCallable(Integer id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception{
        return String.format("Random value %d", new Random().nextInt());
    }

    public String toString() {
        return String.format("YourCallable{id=%d}", id);
    }
}
