package day7InputOutput.homework;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordPunctuationCount {

    private static final String FILENAME = "text.txt";


    public static void main(String[] args) {

        System.out.println("words = " + countWords() + ",punctuation marks = " + countPunctuation());

    }

     private static int countPunctuation() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(FILENAME))) {
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                Pattern pattern = Pattern.compile("[!.,;:?\\-]+");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
                line = reader.readLine();
            }
            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static int countWords() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(FILENAME))) {
            String line = reader.readLine();
            int word = 0;
            while (line != null) {
                Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    word++;
                }
                line = reader.readLine();
            }
            return word;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
