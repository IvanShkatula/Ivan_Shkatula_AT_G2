package bubbles.vessel;

import bubbles.material.Material;

import java.io.Serializable;

public abstract class Vessel implements Serializable {

    private double volume;
    private double diameter;
    private int weight;
    private Material material;

    public Vessel(double volume, double diameter, Material material) {
        this.volume = volume;
        this.diameter = diameter;
        this.weight = (int) (material.getDensity() * volume / 4);
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Vessel{" +
                "volume=" + volume +
                ", diameter=" + diameter +
                ", weight=" + weight +
                ", material=" + material +
                '}';
    }
}
