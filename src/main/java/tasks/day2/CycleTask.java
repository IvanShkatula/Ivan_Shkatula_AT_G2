package tasks.day2;

import java.util.Random;

public class CycleTask {

    private static final int[] arrayCommon = fillInArray();


    public static void main(String[] args) {

        //fromTillTwentyWhile();
        //oddNumbers();
        showArrayStraightOrder(arrayCommon);
        showArrayReverseOrder(arrayCommon);
        showArrayXFive(arrayCommon);
        showSquareNumber(arrayCommon);
        showMinElement(arrayCommon);
        changeElements(arrayCommon);
        sortDescendingOrder(arrayCommon);

    }

    static void fromTillTwentyWhile() {
        int startNumber = 0;
        while (startNumber < 21) {
            System.out.print(startNumber + " ");
            startNumber++;
        }
    }

    static void oddNumbers() {
        for (int i = 3; i < 20; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    static int[] fillInArray() {
        int[] array = new int[7];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    static void showArrayStraightOrder(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    static void showArrayReverseOrder(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void showArrayXFive(int[] array) {
        for (int j : array) {
            System.out.print(j * 5 + " ");
        }
        System.out.println();
    }

    static void showSquareNumber(int[] array) {
        for (int i : array) {
            System.out.print(+i * i + " ");
        }
        System.out.println();
    }

    static void showMinElement(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("Минимальный из элементов массива = " + min);
    }

    static void changeElements(int[] array) {
        int intermediateValue;
        for (int i = 0; i < array.length; i++) {
            intermediateValue = array[0];
            array[0] = array[array.length - 1];
            array[array.length - 1] = intermediateValue;
        }
        System.out.println("Теперь первый элемент = " + array[0]);
        System.out.println("Теперь последний элемент = " + array[array.length - 1]);
    }

    static void sortDescendingOrder(int[] array) {
        int temp = 0;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] <= array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
