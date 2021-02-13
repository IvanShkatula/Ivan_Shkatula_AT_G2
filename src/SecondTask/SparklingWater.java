package SecondTask;

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
        while (bubbles.length != 0) {
            if (isOpen) {
                degas();
            } else {
                Thread.sleep(2000);
            }
        }
    }

    void pump() {
        for (int i = 0; i < bubbles.length; i++) {
            bubbles[i] = new Bubble();
        }
    }

    void degas() {
        int lastBubble = bubbles.length - 1;
        bubbles[lastBubble].cramp();
//        for (int i = 0, j = 0; i < bubbles.length; i++) {
//            if (i != lastBubble) {
//                newBubbles[j++] = bubbles[i];
//            }
        bubbles = Arrays.copyOf(bubbles, lastBubble);
    }
}



