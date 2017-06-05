package java8;

import java.util.Random;

public class Point {
    private Random random = new Random();
    private int x;
    private int y;

    public Point(final int maxX, final int maxY) {
        this.x = random.nextInt(maxX);
        this.y = random.nextInt(maxY);
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }
}
