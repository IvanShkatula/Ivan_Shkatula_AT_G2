package bubbles.material;

import java.io.Serializable;

public class Metal extends Material implements Serializable {
    public Metal(double thermalConductivity, String color, double density) {
        super(thermalConductivity, color, density);
    }
}
