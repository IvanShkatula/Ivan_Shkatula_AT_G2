package smartBubble;

public class Runner {

    public static void main(String[] args) throws InterruptedException {

        double bottleVol = 1.5;

        Water water = new SparklingWater(bottleVol);
        Water water2 = new SparklingWater(bottleVol);

        Bottle bottle = new Bottle(water, bottleVol, 22);
        Bottle bottle2 = new Bottle(water2, bottleVol, 5);
        sou

        bottle.open();
        bottle2.open();

        water.isOpened();
        water2.isOpened();

    }

}
