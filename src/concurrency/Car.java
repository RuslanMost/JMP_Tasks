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
        try {
            while (distance < FastAndFurious.MAX_DISTANCE && !Thread.currentThread().isInterrupted()) {
                Thread.sleep(friction);
                distance += move();
                LOG.info(name + "; Distance " + distance + "; Speed " + speed);
            }
            setWinnerName(this.getName());
        } catch (InterruptedException e) {
            System.out.println(getName() + " was disqualified. What a bummer!");
            LOG.error("Exception is next: " + e);
        }
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
