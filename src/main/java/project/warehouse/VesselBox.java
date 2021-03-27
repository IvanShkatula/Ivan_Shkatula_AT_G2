package bubbles.warehouse;

import bubbles.material.Material;
import bubbles.vessel.Containable;
import bubbles.vessel.Vessel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class VesselBox<T extends Vessel> implements Serializable {

    private int capacity;
    private String name;
    private List<Containable> box;
    private long id;

    public VesselBox(String name, List<Containable> box) {
        this.name = "I am box with <" + capacity + ">" + "<" + name + ">";
        this.box = box;
        id = new Random().nextLong();
        capacity = box.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public List<Containable> getBox() {
        return box;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VesselBox<?> vesselBox = (VesselBox<?>) o;
        return capacity == vesselBox.capacity &&
                id == vesselBox.id &&
                Objects.equals(name, vesselBox.name) &&
                Objects.equals(box, vesselBox.box);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, name, box, id);
    }

}
