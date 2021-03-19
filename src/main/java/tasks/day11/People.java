package day11.homework;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class People {

    private String name;
    private String surname;
    private int age;

    public People(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static List<People> createListOfPersons() {
        return IntStream.rangeClosed(0, 100)
                .mapToObj(i ->
                        new People(
                                "Name_" + i,
                                "Surname_" + i,
                                ThreadLocalRandom.current().nextInt(15, 30)))
                .collect(Collectors.toList());

    }


    public static void main(String[] args) {
        List<String> list = createListOfPersons()
                .stream()
                .filter(x -> x.age < 21)
                .peek(x -> System.out.println(x.name + " " + x.age))
                .sorted(Comparator.comparing(People::getSurname).thenComparing(People::getName))
                .limit(4)
                .map(People::getName)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}
