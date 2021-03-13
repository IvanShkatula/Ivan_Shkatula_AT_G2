package bubbles.boxing;

import bubbles.content.Transformable;
import bubbles.material.Glass;
import bubbles.material.Material;
import bubbles.material.Plastic;

import java.io.Serializable;

public class Cup extends Vessel implements Containable, Serializable{

    static final long serialVersionUID = 4647547;

    public Cup() {
        this(0.3, 0.2, 1, new Plastic(1, "wight", 0.5));

    }

    public Cup(double volume, double diameter, int weight, Material material) {
        super(volume, diameter, weight, material);
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
    public int getFreeSpace() {
        return 0;
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
