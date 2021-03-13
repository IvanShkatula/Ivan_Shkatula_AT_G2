package bubbles.boxing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VesselBox<T extends Vessel> implements Serializable {

    List<T> ts;

    public VesselBox(int capacity) {
        ts = new ArrayList<>(capacity);
    }

    public void add(T vessel) {
        ts.add(vessel);
    }

    @Override
    public String toString() {
        return "VesselBox{" +
                "ts=" + ts +
                '}';
    }
}
