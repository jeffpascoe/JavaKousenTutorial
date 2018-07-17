package comparatorexamples;

import java.util.Comparator;

public class MyComparator implements Comparator<MyObject>  {

    @Override
    public int compare(MyObject o1, MyObject o2) {
       return o1.creationTime.isBefore(o2.creationTime) ? -1 : 1;
    }
}
