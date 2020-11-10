package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ArrayListStreamTest {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        Stream<String> stream = list.stream();
        stream.forEach(s->System.out.println(s+ " "));

        System.out.println();
        
        list.stream().sorted().forEach(s -> System.out.println("s = " + s));

        list.stream().map(s -> s.length()).forEach(n-> System.out.println("n = " + n));

    }
}
