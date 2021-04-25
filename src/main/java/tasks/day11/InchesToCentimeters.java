package tasks.day11;


import java.util.stream.IntStream;


public class InchesToCentimeters {

    public static void main(String[] args) {
        double list2 = IntStream.rangeClosed(1, 21)
                .boxed()
                .filter(x -> x % 2 == 0)
                .peek(System.out::println)
                .map(x -> x * 2.54)
                .peek(System.out::println)
                .mapToDouble(x -> x * 1.0).sum();
        System.out.println(list2);
    }


}
