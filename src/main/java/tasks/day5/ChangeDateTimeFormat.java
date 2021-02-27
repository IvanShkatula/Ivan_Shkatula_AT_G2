package day5.homeWork;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ChangeDateTimeFormat {


    public static void main(String[] args) throws ParseException {

        String date = "22.00 07.09.2020";
        changeDateTimeFormat(date);

    }


    private static void changeDateTimeFormat(String date) {
        LocalDateTime dateString = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("HH.mm dd.MM.yyyy"));
        System.out.println(dateString.format(DateTimeFormatter.ofPattern("MMMM, d, yyyy HH:mm")));
    }
}
