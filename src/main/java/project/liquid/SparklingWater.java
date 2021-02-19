package day4.homework.bubbles;

import java.util.Arrays;

public class SparklingWater extends Water {

    private boolean isOpened;
    private Bubble[] bubbles;

    public SparklingWater() {
        isOpened();
    }

    public void setOpened(boolean isOpened) {
        this.isOpened = isOpened;
    }

    public void isOpened() {
        if (isOpened) {
            degas();
        }
    }

    public void pump(Bubble[] bubbles) {
        this.bubbles = bubbles;
    }

    public void checkIsOpened() {
        new Thread(() -> {
            while (Thread.interrupted()) {
                if (isOpened) {
                    degas();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void degas() {
        int bubbleAmount = 10 + 5 * getTemperature();
        for (int i = bubbles.length - 1; i > 0; i--) {
            bubbles[i].cramp();
        }
        int lastBubble = bubbles.length - bubbleAmount;
        bubbles = Arrays.copyOf(bubbles, lastBubble);
    }

    public boolean isSparkle() {
        return bubbles.length != 0;
    }

}



