package creationalpatterns.services;

import creationalpatterns.abstractparts.Computer;

import java.io.*;
import java.util.Optional;

public abstract class AbstractComputerService {

    public abstract Computer process() throws InterruptedException;

    public static Optional<AbstractComputerService> getService(final String type) {
        if ("cheap".equals(type)) {
            return Optional.of(new CheapComputerServiceImpl());
        } else if ("expensive".equals(type)) {
            return Optional.of(new ExpensiveComputerServiceImpl());
        }
        return Optional.empty();
    }

    protected void saveToFile(final Computer computer) {
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
