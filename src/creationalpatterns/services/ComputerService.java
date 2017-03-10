package creationalpatterns.services;

import creationalpatterns.mainpart.Computer;

import java.io.*;

public class ComputerService {
    private AbstractComputerFactory computerFactory;

    public void setComputerFactory(final AbstractComputerFactory computerFactory) {
        this.computerFactory = computerFactory;
    }

    public AbstractComputerFactory getComputerFactory() {
        return computerFactory;
    }

    public Computer process() throws InterruptedException {
        Computer computer = computerFactory.getComputer();
        computer.installOS();
        saveToFile(computer);
        return computer;
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
