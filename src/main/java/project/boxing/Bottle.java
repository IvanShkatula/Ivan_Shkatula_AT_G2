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
    }

    public SparklingWater getWater() {
        return water;
    }

    public void setWater(SparklingWater water) {
        this.water = water;
    }

     public void open() {
       water.setOpened(true);
         System.out.println("Now bottle is open");
    }

    public void warm(int temperature) {
        water.setTemperature(temperature);
        System.out.println("Warming water to: " + temperature);
    }

}
