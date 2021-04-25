package tasks.day4;

import java.util.Random;

public class СountSumNElementOfArray {


    public static void main(String[] args) {

        int[] array = createArray(10);
        sumOfNElement(5, array);

    }

    private static int[] createArray(int numberOfElementsInArray) {

        int[] array = new int[numberOfElementsInArray];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;

    }

    private static void sumOfNElement(int nElement, int[] array) {
        int count = 1;
        int sum = 0;
        for (int j : array) {
            System.out.print(j + " ");
            if (nElement == count) {
                sum += j;
                count = 0;
            }
            count++;
        }
        System.out.println();
        System.out.println(sum);
    }

}
