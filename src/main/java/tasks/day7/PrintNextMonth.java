package day7InputOutput.homework;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintNextMonth {

    public static void main(String[] args) {

       printNextMonth(enterMonth());

    }

    private static String enterMonth() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String month = null;
        try {
            month = bufferedReader.readLine();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return month;
    }


    private static void printNextMonth(String currentMonth) {

        switch (currentMonth) {
            case "January" -> System.out.println("February");
            case "February" -> System.out.println("March");
            case "March" -> System.out.println("April");
            case "April" -> System.out.println("May");
            case "May" -> System.out.println("June");
            case "June" -> System.out.println("July");
            case "July" -> System.out.println("August");
            case "August" -> System.out.println("September");
            case "September" -> System.out.println("October");
            case "October" -> System.out.println("November");
            case "November" -> System.out.println("December");
            case "December" -> System.out.println("January");
            default -> System.out.println("There is no such month");
        }
    }
}
