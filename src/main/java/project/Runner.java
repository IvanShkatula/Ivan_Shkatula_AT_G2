package bubbles;


import bubbles.boxing.Bottle;
import bubbles.content.SparklingWater;
import bubbles.material.Glass;
import bubbles.material.Material;

public class Runner {

    public static void main(String[] args) {

        double volume = 0.5;

        SparklingWater sparklingWater = new SparklingWater(volume);
        Material glass = new Glass(0.5, "blue", 1);

        Bottle smallBottle = new Bottle(volume, 1, 1, glass);
        smallBottle.addStuff(sparklingWater);
//        Bottle middleBottle = new Bottle(1);
//        Bottle largeBottle = new Bottle(1.5);

        smallBottle.open();
//        middleBottle.open();
//        largeBottle.open();

    }

}
