package warehouse;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Stocktaking {

    private static final Path FILE = Path.of("file.txt");

    private Stocktaking() {
    }

    public static void registerBox(VesselBox<?> box) {
        try (FileWriter fileWriter = new FileWriter(FILE.toFile())) {
            fileWriter.write("#" + box.hashCode() + "#" + box.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void disposeBox(VesselBox<?> box) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(FILE.toFile()));
            List<String> temp = new ArrayList<>();
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String line2 = "#" + box.hashCode() + "#" + box.getName();
                if (!line.equals(line2)) {
                    temp.add(line);
                }
            }
            FileWriter fileWriter = new FileWriter(FILE.toFile());
            for (String line :
                    temp) {
                fileWriter.write(line + "\n");
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getInfo() {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(FILE.toFile()));
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
