package bubbles.boxing;


import bubbles.content.Transformable;
import bubbles.material.Glass;
import bubbles.material.Material;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Bottle extends Vessel implements Containable {

    public Bottle() {
        this(1, 0.3, 1, new Glass(1, "light", 0.5));

    }

    //   private SparklingWater water = new SparklingWater();
    private List<Transformable> stuff = new ArrayList<>();

    public Bottle(double volume, double diameter, int weight, Material material) {
        super(volume, diameter, weight, material);
    }

//    public SparklingWater getWater() {
//        return water;
//    }
//
//    public void setWater(SparklingWater water) {
//        this.water = water;
//    }

    @Override
    public void addStuff(Transformable stuff) {
        this.stuff.add(stuff);
    }

    @Override
    public void removeStuff() {
        this.stuff.clear();
    }

    @Override
    public boolean isEmpty() {
       return stuff.isEmpty();
    }

    @Override
    public int getFreeSpace() {
        return  (int) getVolume() * 1000 - stuff.size();
    }

    @Override
    public void open() {
        for (Transformable t : stuff) {
            t.setOpened(true);
        }
        System.out.println("Now bottle is open");
    }

    @Override
    public void close() {
        for (Transformable t : stuff) {
            t.setOpened(false);
        }
        System.out.println("Now bottle is closed");
    }

    public void warm(int temperature) {
        for (Transformable t : stuff) {
            t.setTemperature(temperature);
        }
        System.out.println("Warming water to: " + temperature);
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "stuff= " + stuff +
                '}';
    }
}
