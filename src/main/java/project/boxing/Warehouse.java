package bubbles.boxing;

import java.io.*;

public class Warehouse{


    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

warehouse.createCup(2);

    }


    public void createCup(int capacity) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("cup.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            FileInputStream fileInputStream = new FileInputStream("cup.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            VesselBox<Cup> cupBox = new VesselBox<>(capacity);
            Cup cup = new Cup(1, 1, 2, null);

            cupBox.add(cup);
            System.out.println(cupBox);

            objectOutputStream.writeObject(cup);
            Cup cupFromFile = (Cup) objectInputStream.readObject();

            System.out.println(cupFromFile);

            fileOutputStream.close();
            objectOutputStream.close();
            fileInputStream.close();
            objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
