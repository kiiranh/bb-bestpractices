package simple;

import java.util.stream.Stream;

public class StreamOne {
    public static void main(String[] args) {
        Stream.of("Fred", "Jim", "Sheila")
                .map(s -> s.toUpperCase())
                .filter(s -> s.length() > 3)
                .forEach(s -> System.out.println(s));

        Stream.of("Fred", "Jim", "Sheila")
                .map(s -> s.length())
                .filter(s -> s > 3)
                .forEach(s -> System.out.println(s));

        Stream.of("Fred", "Jim", "Sheila")
                .flatMap(s -> s.chars().mapToObj(x-> x))
                .forEach(s -> System.out.println((char)(s.intValue())));

//                .map(s -> s.toUpperCase())
    }
}
