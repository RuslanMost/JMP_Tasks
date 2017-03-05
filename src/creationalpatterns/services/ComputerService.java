package creationalpatterns.services;

import creationalpatterns.abstractparts.Computer;
import creationalpatterns.cheaparts.CheapKeyboard;
import creationalpatterns.cheaparts.CheapMonitor;
import creationalpatterns.cheaparts.CheapMouse;
import creationalpatterns.cheaparts.CheapSystemBlock;
import creationalpatterns.expensiveparts.ExpensiveKeyboard;
import creationalpatterns.expensiveparts.ExpensiveMonitor;
import creationalpatterns.expensiveparts.ExpensiveMouse;
import creationalpatterns.expensiveparts.ExpensiveSystemBlock;

import java.io.*;
import java.util.Optional;

public class ComputerService implements Service<Computer> {

    public Computer process(final String type) throws InterruptedException {
        Computer computer = buildComputer(type);
        if ("box".equals(computer.getType())) {
            return computer;
        }
        System.out.println(type + " computer is building... Wait for that...");
        Thread.sleep(964);
        computer.installOS();
        saveToFile(computer);
        return computer;
    }

    private Computer buildExpensiveComputer(final String type) {
        Computer expensiveComputer = new Computer(type, new ExpensiveSystemBlock());
        expensiveComputer.setKeyboard(new ExpensiveKeyboard());
        expensiveComputer.setMouse(new ExpensiveMouse());
        expensiveComputer.setMonitor(new ExpensiveMonitor());
        return expensiveComputer;
    }

    public Computer buildCheapComputer(final String type) {
        Computer cheapComputer = new Computer(type, new CheapSystemBlock());
        cheapComputer.setKeyboard(new CheapKeyboard());
        cheapComputer.setMouse(new CheapMouse());
        cheapComputer.setMonitor(new CheapMonitor());
        return cheapComputer;
    }

    public Computer buildComputer(final String type) {
        Computer computer = null;
        if ("expensive".equals(type)) {
            computer = buildExpensiveComputer(type);
        } else if ("cheap".equals(type)) {
            computer = buildCheapComputer(type);
        }
        Optional<Computer> optionalComputer = Optional.ofNullable(computer);

        return optionalComputer.orElse(new Computer("box"));
    }

    private void saveToFile(final Computer computer) {
        try (OutputStream file = new FileOutputStream("computer.ser");
             OutputStream buffer = new BufferedOutputStream(file);
             ObjectOutput output = new ObjectOutputStream(buffer)
        ) {
            output.writeObject(computer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
