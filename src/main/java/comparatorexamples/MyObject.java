package comparatorexamples;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Random;

public class MyObject implements Comparator<MyObject>  {
    LocalDateTime creationTime;
    Integer id;

    public MyObject(Object o) {
        this.creationTime = LocalDateTime.now();
        this.id = new Random().nextInt(100);
    }

    @Override
    public int compare(MyObject o1, MyObject o2) {
        return o1.creationTime.isBefore(o2.creationTime) ? -1 : 1;
    }

    @Override
    public String toString() {
        return String.format("Id: %d", id);
    }
}
