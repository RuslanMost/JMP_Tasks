package creationalpatterns.services;

import creationalpatterns.abstractparts.Computer;
import creationalpatterns.expensiveparts.*;

public class ExpensiveComputerServiceImpl extends AbstractComputerService {
    @Override
    public Computer process() throws InterruptedException {
        System.out.println("Expensive computer is building... Wait for that...");
        Thread.sleep(1285);
        final Computer expensiveComputer = new Computer("expensive", new ExpensiveSystemBlock());
        expensiveComputer.setKeyboard(new ExpensiveKeyboard());
        expensiveComputer.setMouse(new ExpensiveMouse());
        expensiveComputer.setMonitor(new ExpensiveMonitor());
        expensiveComputer.installOS();
        saveToFile(expensiveComputer);
        return expensiveComputer;
    }
}
