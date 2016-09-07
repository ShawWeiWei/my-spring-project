package me.shaw.test.concurrent.philosopher;

/**
 * Created by yes on 17/6/16.
 */
public class Chopstick {
    private volatile boolean available = true;
    private int id;

    public Chopstick(){}

    public Chopstick(int id) {
        this.id = id;
    }

    public boolean isAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available=available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chopstick{");
        sb.append("available=").append(available);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
