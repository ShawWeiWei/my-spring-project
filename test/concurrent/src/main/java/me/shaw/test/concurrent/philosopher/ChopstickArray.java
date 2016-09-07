package me.shaw.test.concurrent.philosopher;

/**
 * Created by yes on 17/6/16.
 */
public class ChopstickArray {
    private Chopstick[] chopsticks;

    public ChopstickArray() {
    }

    public ChopstickArray(int size) {
        chopsticks = new Chopstick[size];
        for (int i = 0; i < size; ++i) {
            chopsticks[i] = new Chopstick(i);
        }
    }

    public Chopstick getId(int id) {
        return chopsticks[id];
    }

    public Chopstick getLast(int id) {
        if(id==0){
            return chopsticks[chopsticks.length-1];
        } else {
            return chopsticks[id-1];
        }
    }
}
