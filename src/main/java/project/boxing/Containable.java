package bubbles.boxing;

import bubbles.content.Transformable;

public interface Containable {

    void addStuff (Transformable stuff);

    void removeStuff();

    boolean isEmpty();

    int getFreeSpace();

    void open();

    void close();

}
