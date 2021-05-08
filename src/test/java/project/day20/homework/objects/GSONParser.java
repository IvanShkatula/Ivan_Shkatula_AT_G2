package project.day20.homework.objects;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GSONParser {

    private final static String JSON = "src/test/java/project/day20/homework/sources/users.json";

    public String parserGSON(int numberOfUser) throws FileNotFoundException {
        Gson gson = new Gson();
        UsersList usersList = gson.fromJson(new JsonReader(new FileReader(JSON)), UsersList.class);
        System.out.println(usersList.data[numberOfUser]);
        return usersList.data[numberOfUser].toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        GSONParser gsonParser = new GSONParser();
        gsonParser.parserGSONAllUsers();
    }

    public String parserGSONAllUsers() throws FileNotFoundException {
        Gson gson = new Gson();
        Users usersList = gson.fromJson(new JsonReader(new FileReader(JSON)), Users.class);
        System.out.println(usersList);
        return usersList.toString();
    }

    public static String fromGSON (Search search) {
        Gson gson = new Gson();
        return gson.toJson(search);
    }

}
