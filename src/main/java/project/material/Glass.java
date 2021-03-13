package bubbles.material;

import java.io.Serializable;

public class Glass extends Material implements Serializable {
    public Glass(double thermalConductivity, String color, double density) {
        super(thermalConductivity, color, density);
    }
}
