package java8;

import java.util.Random;

public class NewPoint {
    private Random random = new Random();
    private int a;
    private int b;

    public NewPoint(final int a, final int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(final int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(final int b) {
        this.b = b;
    }
}
