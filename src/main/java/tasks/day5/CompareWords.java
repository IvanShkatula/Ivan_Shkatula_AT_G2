package day5.homeWork;

public class CompareWords {

    static String text = "Мама. мыла, Раму! Рама мыла Маму? Маму мыли рама!!!";

    public static void main(String[] args) {
        findSimilarWords(text);
    }

    private static void findSimilarWords(String text) {
        text = text.replaceAll("[,!\\-:.?]", "").trim();
        String[] textArray = text.split(" ");
            for (int i = 0; i < textArray.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (textArray[i].compareToIgnoreCase(textArray[j]) == 0) {
                        System.out.println("Word " + textArray[i] + " is duplicate");
                    }
                }
            }
    }


}
