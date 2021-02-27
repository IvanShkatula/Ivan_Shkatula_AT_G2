package day5.homeWork;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CurrentDateTime {

        public static void main(String[] args) {
            Locale locale = new Locale("ru");
            DateTimeFormatter date = DateTimeFormatter.ofPattern("dd MMMM, yyyy HH:mm").localizedBy(locale);
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Сейчас на дворе:\n" + date.format(now));

    }
}
