package bubbles.boxing;

import bubbles.content.Transformable;
import bubbles.material.Material;

public class Can extends Vessel implements Containable{


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
