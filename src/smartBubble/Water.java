package smartBubble;

public abstract class Water {

    String color;
    String clarity;
    String smell;
    int temperature;


    abstract void setOpen(boolean isOpen);

    abstract void isOpened() throws InterruptedException;

    int temperatureTable(int temperature) {
        int[] amountOfBubbles = new int[41];
        int j = 5;
        for (int i = 0; i < 41; i++) {
            amountOfBubbles[i] = j += 5;
        }
        return amountOfBubbles[temperature];
    }
}
