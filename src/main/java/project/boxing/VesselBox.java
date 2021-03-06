package bubbles.boxing;

import java.util.Arrays;

public class VesselBox<T extends Vessel> {

    private T[] ts;

    public VesselBox(int capacity) {
        ts = (T[]) new Vessel[capacity];
    }

    public void add(T vessel) {

        for (int i = 0; i < ts.length; i++) {
            if (ts[i] == null) {
                ts[i] = vessel;
            }
        }
    }

    @Override
    public String toString() {
        return "VesselBox{" +
                "ts=" + Arrays.toString(ts).length() +
                '}';
    }
    
}
