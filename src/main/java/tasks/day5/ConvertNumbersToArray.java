package tasks.day5;

public class ConvertNumbersToArray {

    static String text = "Ма1ма.1 2 мы1ла, Ра3му! Ра2ма мы4ла Мам5у?0 Ма1му мыл2и ра3ма!!!";
    ;

    public static void main(String[] args) {

        findNumbers(text);

    }

    private static void findNumbers(String text) {

        text = text.replaceAll("[\\D]", "");
        String[] arrayText = text.split("");
        int[] arrayNumbers = new int[arrayText.length];
        for (int i = 0; i < arrayText.length; i++) {
            arrayNumbers[i] = Integer.parseInt(arrayText[i]);
            System.out.print(arrayNumbers[i] + " ");
        }
    }
}
