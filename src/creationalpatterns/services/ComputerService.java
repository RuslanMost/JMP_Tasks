package creationalpatterns.services;

import creationalpatterns.abstractparts.Computer;

import java.io.*;

public abstract class ComputerService {
    public Computer process(final String type) throws InterruptedException {
        Computer computer = buildComputer(type);
        System.out.println(type + " computer is building... Wait for that...");
        Thread.sleep(964);
        computer.installOS();
        saveToFile(computer);
        return computer;
    }

    private void saveToFile(final Computer computer) {
        try(OutputStream file = new FileOutputStream("computer.ser");
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer)
        ) {
            output.writeObject(computer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract Computer buildComputer(final String type);
}
