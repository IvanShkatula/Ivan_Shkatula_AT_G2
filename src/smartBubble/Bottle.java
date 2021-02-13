package smartBubble;

public class Bottle {

    double bottleVolume;
    Water water;


    public Bottle(Water water, double bottleVolume) {
        this.bottleVolume = bottleVolume;
        this.water = water;
    }

    public Bottle(Water water, double bottleVolume, int temperature) {
        this.bottleVolume = bottleVolume;
        this.water = water;
        water.temperature = temperature;
    }



    public void open() {
       water.setOpen(true);
    }
}
