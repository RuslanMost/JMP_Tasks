package concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Car implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Car.class);
    private long friction;
    private double distance;
    private String name;
    private double speed;
    private static String winner;

    public Car(String name, long friction, double speed) {
        this.name = name;
        this.friction = friction;
        this.speed = speed;
    }

    @Override
    public void run() {
        while (distance < FastAndFurious.MAX_DISTANCE) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println(this.getName() + " was killed");
                LOG.info(name + "; Distance " + distance + "; Speed " + speed);
                return;
            }
            distance += move();
        }
        setWinnerName(this.getName());

    }

    private static synchronized void setWinnerName(String winnerName) {
        if (winner == null) {
            winner = winnerName;
        }
    }

    public static String getWinner() {
        return winner;
    }

    private double move() {
        return speed * Math.random();
    }

    public long getFriction() {
        return friction;
    }

    public void setFriction(final long friction) {
        this.friction = friction;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(final double distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
