package runner;


import material.Material;
import stuff.SparklingWater;
import vessel.Bottle;
import warehouse.Factory;

public class Runner {

    public static void main(String[] args) {

        double volume = 0.5;

        SparklingWater sparklingWater = new SparklingWater(volume);
        Factory factory = new Factory();


        factory.createVesselBox(9, volume, Material.GLASS, sparklingWater, Bottle.class);


//        Bottle smallBottle = new Bottle();
//        smallBottle.addStuff(sparklingWater);
//        Bottle middleBottle = new Bottle(1);
//        Bottle largeBottle = new Bottle(1.5);
//
//        smallBottle.open();
//        middleBottle.open();
//        largeBottle.open();



    }

}
