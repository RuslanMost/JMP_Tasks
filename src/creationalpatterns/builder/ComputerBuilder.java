package creationalpatterns.builder;

import creationalpatterns.abstractparts.Computer;
import creationalpatterns.cheaparts.CheapKeyboard;
import creationalpatterns.cheaparts.CheapMonitor;
import creationalpatterns.cheaparts.CheapMouse;
import creationalpatterns.cheaparts.CheapSystemBlock;
import creationalpatterns.expensiveparts.ExpensiveKeyboard;
import creationalpatterns.expensiveparts.ExpensiveMonitor;
import creationalpatterns.expensiveparts.ExpensiveMouse;
import creationalpatterns.expensiveparts.ExpensiveSystemBlock;

public class ComputerBuilder extends Builder<ComputerBuilder, Computer> {
    public ComputerBuilder() {
        super.computer = new Computer("box");
    }

    @Override
    public ComputerBuilder build(final String part) {
        if ("expensive system block".equals(part)) {
            buildExpensiveSystemBlock();
        } else if ("expensive monitor".equals(part)) {
            buildExpensiveMonitor();
        } else if ("expensive keyboard".equals(part)) {
            buildExpensiveKeyboard();
        } else if ("expensive mouse".equals(part)) {
            buildExpensiveMouse();
        } else if ("cheap system block".equals(part)) {
            buildCheapSystemBlock();
        } else if ("cheap monitor".equals(part)) {
            buildCheapMonitor();
        } else if ("cheap keyboard".equals(part)) {
            buildCheapKeyboard();
        } else if ("cheap mouse".equals(part)) {
            buildCheapMouse();
        }
        return this;
    }

    @Override
    public Computer getProduct() {
        return computer;
    }

    public ComputerBuilder buildExpensiveSystemBlock() {
        computer.setSystemBlock(new ExpensiveSystemBlock());
        return this;
    }

    public ComputerBuilder buildExpensiveMonitor() {
        computer.setMonitor(new ExpensiveMonitor());
        return this;
    }

    public ComputerBuilder buildExpensiveKeyboard() {
        computer.setKeyboard(new ExpensiveKeyboard());
        return this;
    }

    public ComputerBuilder buildExpensiveMouse() {
        computer.setMouse(new ExpensiveMouse());
        return this;
    }

    public ComputerBuilder buildCheapSystemBlock() {
        computer.setSystemBlock(new CheapSystemBlock());
        return this;
    }

    public ComputerBuilder buildCheapMonitor() {
        computer.setMonitor(new CheapMonitor());
        return this;
    }

    public ComputerBuilder buildCheapKeyboard() {
        computer.setKeyboard(new CheapKeyboard());
        return this;
    }

    public ComputerBuilder buildCheapMouse() {
        computer.setMouse(new CheapMouse());
        return this;
    }

}
