package creationalpatterns.services;

import creationalpatterns.abstractparts.Computer;
import creationalpatterns.expensiveparts.ExpensiveKeyboard;
import creationalpatterns.expensiveparts.ExpensiveMonitor;
import creationalpatterns.expensiveparts.ExpensiveMouse;
import creationalpatterns.expensiveparts.ExpensiveSystemBlock;

public class ExpensiveComputerService extends ComputerService {
    @Override
    protected Computer buildComputer(final String type) {
        Computer expensiveComputer = new Computer(type, new ExpensiveSystemBlock());
        expensiveComputer.setMouse(new ExpensiveMouse());
        expensiveComputer.setKeyboard(new ExpensiveKeyboard());
        expensiveComputer.setMonitor(new ExpensiveMonitor());
        return expensiveComputer;
    }
}
