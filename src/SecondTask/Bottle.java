package SecondTask;

public class Bottle {

    double bottleVolume;
    Water water;


    public Bottle(Water water, double bottleVolume) {
        this.bottleVolume = bottleVolume;
        this.water = water;
    }



    public void open() {
       water.setOpen(true);
    }
}
