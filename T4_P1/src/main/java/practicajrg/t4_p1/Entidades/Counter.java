package practicajrg.t4_p1.Entidades;

import java.io.Serializable;

public class Counter implements Serializable {

    private int count;
    public int getCount() {
        return count;
    }
    public void increment() {
        count++;
    }
}
