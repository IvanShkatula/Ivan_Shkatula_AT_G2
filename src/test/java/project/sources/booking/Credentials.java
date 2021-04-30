package project.sources.booking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Credentials {

    Map<Integer, List<String>> credentials = new LinkedHashMap<Integer, List<String>>();
    private final String FILE_NAME_CREDS = "creds.txt";
    int key = 1;
    LinkedHashMap<Integer, List<String>> mapFromFile;

    public void putValues(String email, String password) {
        credentials.put(key, Arrays.asList(email, password));
        key++;
        try {
            Files.write(Paths.get(FILE_NAME_CREDS), credentials.entrySet().stream()
                    .map(k -> k.getKey() + "\r\n" + k.getValue()).
                            collect(Collectors.toList()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        try {
            File toRead=new File(FILE_NAME_CREDS);
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            //ObjectInputStream toRead = new ObjectInputStream(new FileInputStream(new File(FILE_NAME_CREDS)));
            mapFromFile = (LinkedHashMap<Integer, List<String>>) ois.readObject();
            System.out.println(mapFromFile);
            fis.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getEmail(int key) {
        List<String> list = mapFromFile.get(key);
        String email = list.get(0);
        return email;
    }

    public String getPassword(int key) {
        List<String> list = mapFromFile.get(key);
        String password = list.get(1);
        return password;
    }


    public static void main(String[] args) {
        Credentials cred = new Credentials();
        //  cred.putValues("charley.bogisich@mobiletrashmail.com", "Password1!");
        cred.readFromFile();

    }
}
