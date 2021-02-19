package day4.homework.bubbles;

public class Bottle {

   private double volume;
   private SparklingWater water;

    public Bottle(double volume) {
        this.volume = volume;
        Bubble[] bubbles = new Bubble[(int) (volume * 10000)];
        for (int i = 0; i < bubbles.length; i++) {
            bubbles[i] = new Bubble("anyGas");
        }
        //TODO
    }

    public SparklingWater getWater() {
        return water;
    }

    public void setWater(SparklingWater water) {
        this.water = water;
    }

     public void open() {
       this.water.setOpened(true);
    }

    public void warm(int temperature) {
        water.setTemperature(temperature);
    }

}
