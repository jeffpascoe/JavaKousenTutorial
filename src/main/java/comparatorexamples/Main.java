package comparatorexamples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<MyObject> myObjectList = Stream.iterate(0, n -> n + 1)
                .limit(15)
                .map(MyObject::new)
                .collect(Collectors.toList());

        myObjectList.forEach(System.out::println);

//        List<MyObject> mySortedList = myObjectList.stream()
//                .sorted(Comparator.comparing(MyObject::compare))
//                .collect(Collectors.toList());
//
//        mySortedList.forEach(System.out::println);
    }
}
