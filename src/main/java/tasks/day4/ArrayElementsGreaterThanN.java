package day4.homework;

import java.util.Arrays;
import java.util.Random;

public class ArrayElementsGreaterThanN {

    public static void main(String[] args) {

        int[] array = createArray(10);
        System.out.println(Arrays.toString(createNewArray(5, array)));

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

    private static int[] createNewArray(int nElement, int[] array) {
        int amount = 0;
        for (int i = 0; i < array.length; i++) {
            if (nElement < array[i]) {
                amount += 1;
            }
        }
        int[] resultArray = new int[amount];
        int index = amount - 1;
        for (int i = 0; i < array.length; i++) {
            if (nElement < array[i]) {
                resultArray[index] = array[i];
                index = index - 1;
            }
        }
        return resultArray;
    }


}
