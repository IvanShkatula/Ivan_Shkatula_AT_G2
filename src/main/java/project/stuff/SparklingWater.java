package bubbles.stuff;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SparklingWater extends Water {

    private boolean isOpened;
    List<Bubble> bubbles = new ArrayList<>();
    //  private Bubble[] bubbles;

    public SparklingWater(double volume) {

        bubbles = IntStream.rangeClosed(0, (int) (volume * 10000))
                .boxed()
                .map(i -> new Bubble("CO2"))
                .collect(Collectors.toList());
//
//        for (int i = 0; i < volume * 10000; i++) {
//            bubbles.set(i, new Bubble("CO2"));
//        }
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

    public void pump(List<Bubble> bubbles) {
        this.bubbles = bubbles;
        System.out.println();
    }

    private void degas() {
        new Thread(() -> {
            System.out.print("gases come out of the bottle\n");
            while (bubbles.size() != 0) {
                int bubbleAmount = 10 + 5 * getTemperature();
                bubbleAmount = Math.min(bubbles.size(), bubbleAmount);

                bubbles.stream().limit(bubbleAmount).forEach(Bubble::cramp);
//                IntStream.rangeClosed(0, bubbleAmount).boxed().peek(i -> bubbles.get(i).cramp()).close();
//                for (int i = 0; i < bubbleAmount; i++) {
//                    bubbles.get(i).cramp();
//                }
                bubbles.subList(0, bubbleAmount).clear();
                System.out.println(bubbles.size());
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
        if (bubbles.size() != 0) {
            System.out.print("There are still gases in the bottle\n");
        } else {
            System.out.println("There are no gases in the bottle\n");
        }
        return bubbles.size() != 0;
    }

    @Override
    public void mix() {

    }
}



