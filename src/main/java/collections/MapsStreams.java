package collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapsStreams {
    public static void main(String[] args) {
        Map<Integer, Double> myMap = new HashMap<>();

        for(Integer i=0; i<10; i++) {
            myMap.put(i, Double.parseDouble(i.toString()));
        }

        myMap.values().stream()
                .forEach(System.out::println);

        List<Double> doubledDoubles = myMap.values().stream()
                .map(MapsStreams::doubleMyDouble)
                .collect(Collectors.toList());

        doubledDoubles.stream()
                .forEach(System.out::println);
    }

    public static Double doubleMyDouble(Double num) {
        return num*2;
    }
}
