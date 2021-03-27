package bubbles.vessel;

import bubbles.stuff.Transformable;
import bubbles.material.Material;


public class Can extends Vessel implements Containable {

    public Can() {
        this(1, 10.0, Material.METAL);

    }

    public Can(double volume, double diameter, Material material) {
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
}
