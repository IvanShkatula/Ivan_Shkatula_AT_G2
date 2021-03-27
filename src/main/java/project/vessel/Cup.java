package bubbles.vessel;

import bubbles.stuff.Transformable;
import bubbles.material.Material;


import java.io.Serializable;

public class Cup extends Vessel implements Containable, Serializable {

    public Cup() {
        this(0.3, 8.0, Material.PLASTIC);

    }

    public Cup(double volume, double diameter, Material material) {
        super(volume, diameter, material);
    }

    @Override
    public void addStuff(Transformable stuff) {

    }

    @Override
    public void removeStuff() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {
    }

    @Override
    public String toString() {
        return "Cup{}, " + super.toString();
    }
}
