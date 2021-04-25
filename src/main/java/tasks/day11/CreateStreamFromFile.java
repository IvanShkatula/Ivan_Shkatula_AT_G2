package tasks.day11;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CreateStreamFromFile {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("text.txt"));
        Arrays.stream(bufferedReader.lines()
                .skip(4)
                .collect(Collectors.joining(";"))
                .split("<br>"))
                .filter(x -> x.startsWith("Date log:"))
                .map(x -> x.substring(0, Math.min(x.length(), 20)))
                .map(x -> x + "_" + LocalDateTime.now())
                .forEach(System.out::println);

    }

}
