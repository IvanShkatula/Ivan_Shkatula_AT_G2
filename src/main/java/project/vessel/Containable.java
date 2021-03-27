package bubbles.vessel;

import bubbles.stuff.Transformable;

public interface Containable {

    void addStuff(Transformable stuff);

    void removeStuff();

    boolean isEmpty();

    void open();

    void close();

}
