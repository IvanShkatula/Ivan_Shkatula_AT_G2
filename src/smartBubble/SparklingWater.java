package smartBubble;

import java.util.Arrays;

public class SparklingWater extends Water {


    boolean isOpen = false;
    Bubble[] bubbles;
//    Bubble[] newBubbles;


    public SparklingWater(double volume) {
        bubbles = new Bubble[(int) (volume * 10000)];
        pump();
    }

    @Override
    void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void isOpened() throws InterruptedException {
        int count = 0;
        while (bubbles.length != 0) {
            if (isOpen) {
                degas();
                count++;
                               Thread.sleep(1000);
            } else {
                Thread.sleep(2000);
            }

        }
        System.out.println("Газ вышел за " + count + " секунд");
    }


    void pump() {
        for (int i = 0; i < bubbles.length; i++) {
            bubbles[i] = new Bubble();
        }
    }

    void degas() {
        int lastBubble = 0;
        if (temperature < 10 && temperature >= 0) {
//            for (int i = 0; i < bubbles.length; i++) {
//                if (i == 600) {
//                    temperature++;
                    if (bubbles.length > temperatureTable(temperature) - 1) {
                        lastBubble = bubbles.length - temperatureTable(temperature);
                    }
//                }
//            }

        } else if (temperature >= 10 && temperature <= 40) {
            if (bubbles.length > temperatureTable(temperature) - 1) {
                lastBubble = bubbles.length - temperatureTable(temperature);
            }
        } else if (temperature < 0) {
            System.out.println("Бутылка замерзла и взорвалась");
        } else {
            System.out.println("Температура не может быть выше 40 градусов");
        }
        bubbles[lastBubble].cramp();
        bubbles = Arrays.copyOf(bubbles, lastBubble);
    }


}



