package bubbles.boxing;

import bubbles.content.Transformable;
import bubbles.material.Glass;
import bubbles.material.Material;
import bubbles.material.Metal;

public class Can extends Vessel implements Containable{

    public Can() {
        this(1, 0.3, 1, new Metal(3, "green", 3));

    }

    public Can(double volume, double diameter, int weight, Material material) {
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
}