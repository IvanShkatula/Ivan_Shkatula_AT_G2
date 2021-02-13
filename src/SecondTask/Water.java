package SecondTask;

public abstract class Water {

    String color;
    String clarity;
    String smell;
    int temperature;


    abstract void setOpen(boolean isOpen);

    abstract void isOpened() throws InterruptedException;

}
