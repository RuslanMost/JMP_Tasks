package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastAndFurious {
    public static final long MAX_DISTANCE = 999999999;
    private ArrayList<Car> cars = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        FastAndFurious race = new FastAndFurious();
        race.getCars().add(new Car("BMW", 300, 1));
        race.getCars().add(new Car("Ferrari", 160, 3));
        race.getCars().add(new Car("Kopeyka", 356, 6));
        race.begin();
    }

    private void begin() throws InterruptedException {
        Thread car1 = new Thread(getCars().get(0));
        car1.setName(getCars().get(0).getName());
        Thread car2 = new Thread(getCars().get(1));
        car1.setName(getCars().get(1).getName());
        Thread car3 = new Thread(getCars().get(2));
        car1.setName(getCars().get(2).getName());
        car1.start();
        car2.start();
        car3.start();
        Thread.sleep(5000);
        car1.interrupt();
        List<Thread> threads = Arrays.asList(car1, car2, car3);
        while (threads.stream().filter(Thread::isAlive).count() > 0) {
        }
        printWinner();
    }

    public void printWinner() {
        System.out.println("The winner is " + Car.getWinner() + "!");
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
