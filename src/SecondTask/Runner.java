package SecondTask;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) throws InterruptedException {

        double bottleVol = 0.5;
        double bottleVol2 = 1;
        double bottleVol3 = 1.5;

        Water water = new SparklingWater(bottleVol);
        Water water2 = new SparklingWater(bottleVol2);
        Water water3 = new SparklingWater(bottleVol3);

        Bottle bottle = new Bottle(water, bottleVol);
        Bottle bottle2 = new Bottle(water2, bottleVol2);
        Bottle bottle3 = new Bottle(water3, bottleVol3);


        bottle.open();
        bottle2.open();
        bottle3.open();

        water.isOpened();
        water2.isOpened();
        water3.isOpened();

    }

}
