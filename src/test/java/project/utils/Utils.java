package project.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {


    public Calendar setDate(int increaseByNumberOfDays) {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, increaseByNumberOfDays);
        return date;
    }

    public String parseCalendarToString(Calendar calendar) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        return date;
    }

    public int calculateDifferenceInDaysBetweenTwoDates(Calendar firstDate, Calendar secondDate) {
        long differenceMilliseconds = secondDate.getTimeInMillis() - firstDate.getTimeInMillis();
        int differenceDays = (int) (differenceMilliseconds / (24 * 60 * 60 * 1000));
        return differenceDays;
    }

    public int parseStringToInt(String string) {
        String allCharacters = string.replaceAll("[^0-9]", "");
        int numbers = Integer.parseInt(allCharacters);
        return numbers;
    }

    public void parserJsonReader() {
            JSONParser jsonParser = new JSONParser();
            try(FileReader reader = new FileReader("src/test/java/project/objects/credentials.json")) {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
                String email = (String) jsonObject.get("email");
                String password = (String) jsonObject.get("password");
                System.out.println(email + password);
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }

    public void parserJsonWriter(String email) {
        JSONParser jsonParser = new JSONParser();
        try(FileWriter writer = new FileWriter("src/test/java/project/objects/credentials.json", false)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("email", email);
            jsonObject.put("password", "Password1!");
            writer.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
