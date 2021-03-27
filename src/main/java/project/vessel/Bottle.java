package bubbles.vessel;


import bubbles.stuff.Transformable;
import bubbles.material.Material;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bottle extends Vessel implements Containable {

    public Bottle() {
        this(1, 2.0, Material.GLASS);

    }

    private List<Transformable> stuff = new ArrayList<>();

    public Bottle(double volume, double diameter, Material material) {
        super(volume, diameter, material);
    }

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
    public void open() {
        stuff = stuff.stream()
                .peek(t -> t.setOpened(true))
                .collect(Collectors.toList());

//        for (Transformable t : stuff) {
//            t.setOpened(true);
//        }

        System.out.println("Now bottle is open");
    }

    @Override
    public void close() {
        stuff = stuff.stream()
                .peek(t -> t.setOpened(false))
                .collect(Collectors.toList());

//        for (Transformable t : stuff) {
//            t.setOpened(false);
//        }

        System.out.println("Now bottle is closed");
    }

    public void warm(int temperature) {
        stuff = stuff.stream().peek(t -> t.setTemperature(temperature)).collect(Collectors.toList());
//        for (Transformable t : stuff) {
//            t.setTemperature(temperature);
//        }
        System.out.println("Warming water to: " + temperature);
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "stuff= " + stuff +
                '}';
    }
}
