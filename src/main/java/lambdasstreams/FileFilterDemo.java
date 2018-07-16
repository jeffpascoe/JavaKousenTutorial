package lambdasstreams;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileFilterDemo {

    public static void main(String[] args) {
        File directory = new File("./src/main/java/lambdasstreams");
        System.out.println(directory.getAbsolutePath());

        Arrays.stream(directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("java");
            }
        }));

        Arrays.stream(
                directory.list((dir, name) -> name.endsWith("java")))
                .forEach(System.out::println);

        FilenameFilter filter = (dir, name) -> name.endsWith("java");
        Arrays.stream(
                directory.list(filter))
                .forEach(System.out::println);
    }
}
