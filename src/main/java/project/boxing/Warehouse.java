package bubbles.boxing;

import java.io.*;
import java.util.List;

public class Warehouse {


    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

//        VesselBox<?> bottleBox = warehouse.initBox(Bottle.class, 9);
//        warehouse.writeToFile(bottleBox, "box.txt");
//        System.out.println(warehouse.readFromFile("box.txt"));

        VesselBox<?> cupBox = warehouse.initBox(Cup.class, 9);
        warehouse.writeToFile(cupBox, "cup.txt");
        System.out.println(warehouse.readFromFile("cup.txt"));

        VesselBox<?> canBox = warehouse.initBox(Can.class, 9);
        warehouse.writeToFile(canBox, "can.txt");
        System.out.println(warehouse.readFromFile("can.txt"));
    }


    public VesselBox<?> initBox(Class<? extends Vessel> targetClass, int capacity) {
        if (capacity != 9 && capacity != 25 && capacity != 36) {
            System.out.println("capacity must be 9, 25 or 36");
        }

        if (targetClass.getClass().isInstance(Bottle.class)) {
            VesselBox<Bottle> bottleBox = new VesselBox<>(capacity);
            createBottle(bottleBox, capacity);
            return bottleBox;
        } else if (targetClass.getClass().isInstance(Cup.class)) {
            VesselBox<Cup> cupBox = new VesselBox<>(capacity);
            createCup(cupBox, capacity);
            return cupBox;
        } else if (targetClass.getClass().isInstance(Can.class)) {
            VesselBox<Can> canBox = new VesselBox<>(capacity);
            createCan(canBox, capacity);
            return canBox;
        }

        return null;
    }

    private void createBottle(VesselBox<Bottle> bottle, int capacity) {

        for (int i = 0; i < capacity; i++) {
            bottle.add(new Bottle());
        }
    }

    private void createCup(VesselBox<Cup> cup, int capacity) {

        for (int i = 0; i < capacity; i++) {
            cup.add(new Cup());
        }
    }

    private void createCan(VesselBox<Can> can, int capacity) {

        for (int i = 0; i < capacity; i++) {
            can.add(new Can());
        }
    }


    public void writeToFile(VesselBox<?> box, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(box);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public VesselBox<?> readFromFile(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (VesselBox<?>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
