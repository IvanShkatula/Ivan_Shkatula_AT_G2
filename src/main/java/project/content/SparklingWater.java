package bubbles.content;


import bubbles.gas.Bubble;

import java.util.Arrays;

public class SparklingWater extends Water {

    private boolean isOpened;
    private Bubble[] bubbles;

    public SparklingWater(double volume) {
        bubbles = new Bubble[(int) (volume * 10000)];
        for (int i = 0; i < bubbles.length; i++) {
            bubbles[i] = new Bubble("CO2");
        }
        isOpened();
    }

    @Override
    public void setOpened(boolean isOpened) {
        this.isOpened = isOpened;
    }

    public void isOpened() {
        new Thread(() -> {
            System.out.print("process degas started\n");
            while (!isOpened) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            degas();
        }).start();
    }

    public void pump(Bubble[] bubbles) {
        this.bubbles = bubbles;
        System.out.println();
    }

    private void degas() {
        new Thread(() -> {
            System.out.print("gases come out of the bottle\n");
            while (bubbles.length != 0) {
                int bubbleAmount = 10 + 5 * getTemperature();
                bubbleAmount = bubbles.length < bubbleAmount ? bubbles.length : bubbleAmount;
                for (int i = bubbles.length - 1; i > bubbles.length - bubbleAmount; i--) {
                    bubbles[i].cramp();
                }
                int lastBubble = bubbles.length - bubbleAmount;
                bubbles = Arrays.copyOf(bubbles, lastBubble);
                System.out.println(bubbles.length);
                isSparkle();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }).start();
    }

    public boolean isSparkle() {
        if (bubbles.length != 0) {
            System.out.print("There are still gases in the bottle\n");
        } else {
            System.out.println("There are no gases in the bottle\n");
        }
        return bubbles.length != 0;
    }

    @Override
    public void mix() {

    }
}



