package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastAndFurious {
    public static final long MAX_DISTANCE = 3000;
    private ArrayList<Car> cars = new ArrayList<>();
    private static FastAndFurious race;

    public static void main(String[] args) throws InterruptedException {
        race = new FastAndFurious();
        race.getCars().add(new Car("BMW", 300, 100));
        race.getCars().add(new Car("Ferrari", 160, 243));
        race.getCars().add(new Car("Kopeyka", 356, 330));
        race.begin();
        race.printWinner();
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
        List<Thread> threads = Arrays.asList(car1, car2, car3);
        Thread.sleep(5000);
        car1.interrupt();
    }

    private Car getWinner() {
        while (true) {
            for (Car car : getCars()) {
                if (car.getDistance() >= MAX_DISTANCE) {
                    return car;
                }
            }
        }
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "! The distance is: " + getWinner().getDistance());
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
