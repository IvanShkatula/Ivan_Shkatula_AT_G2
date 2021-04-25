package tasks.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListCollection {

    public static void main(String[] args) {

        int minValue = 0;
        int maxValue = 50;

        List<Integer> result = IntStream.rangeClosed(minValue, maxValue)
                .boxed()
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .collect(Collectors.toList());

        System.out.println(result);
    }

}
