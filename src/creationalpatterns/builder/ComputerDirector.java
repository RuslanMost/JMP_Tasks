package creationalpatterns.builder;

import creationalpatterns.abstractparts.Computer;

import java.util.Arrays;

public class ComputerDirector {
    private Builder<ComputerBuilder, Computer> builder;

    public ComputerDirector() {
        builder = new ComputerBuilder();
    }

    public Computer buildComputer(final String[] parts) {
        Arrays.asList(parts).stream().forEach(builder::build);
        return builder.getProduct();
    }
}
