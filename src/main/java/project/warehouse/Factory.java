package warehouse;

import material.Material;
import stuff.SparklingWater;
import stuff.Transformable;
import stuff.Water;
import vessel.*;

import java.util.ArrayList;
import java.util.List;

public class Factory {

    private Warehouse warehouse = new Warehouse();

    public static void main(String[] args) {
        Factory factory = new Factory();
        Water water = new SparklingWater(2);
        factory.createVesselBox(9, 2.0, Material.GLASS, water, Bottle.class);
    }

    public void createVesselBox(int capacity, double volume, Material material, Transformable stuff, Class<?> clazz) {
        if (capacity != 9 && capacity != 25 && capacity != 36) {
            System.out.println("capacity must be 9, 25 or 36");
        }

        List<Containable> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            list.add(createVessel(volume, material, stuff, clazz));
        }

        VesselBox<?> box = new VesselBox<>(clazz.getSimpleName(), list);
        warehouse.addBox(box);
    }

    private Containable createVessel(double volume, Material material, Transformable stuff, Class<?> clazz) {
        if (clazz.isAssignableFrom(Bottle.class)) {
            Bottle bottle = new Bottle(volume, 2.0, material);
            bottle.addStuff(stuff);
            return bottle;
        } else if (clazz.isAssignableFrom(Cup.class)) {
            Cup cup = new Cup(volume, 8.0, material);
            cup.addStuff(stuff);
            return cup;
        } else if (clazz.isAssignableFrom(Can.class)) {
            Can can = new Can(volume, 10, material);
            can.addStuff(stuff);
            return can;
        }
        return null;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
