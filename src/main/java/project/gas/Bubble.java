package bubbles.gas;

public class Bubble {

    private double volume = 0.3;
    private String gas;

    public Bubble(String gas) {
        this.gas = gas;
    }

    public double getVolume() {
        return this.volume;
    }

    public void cramp() {
        System.out.println("Cramp!");
        System.out.println("bubble burst");
    }

}
