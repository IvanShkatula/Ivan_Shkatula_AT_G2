package day4.homework;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class ElementsMultiplesMonth {


    public static void main(String[] args) {

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int month = localDate.getMonthValue();
        int[] array = createArray(5);

        sumOfNElement(month, array);

    }

    private static int[] createArray(int numberOfElementsInArray) {

        int[] array = new int[numberOfElementsInArray];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;

    }

    private static void sumOfNElement(int month, int[] array) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % month == 0) {
                sum += array[i];
            }
        }
        System.out.println(sum);
    }
}
