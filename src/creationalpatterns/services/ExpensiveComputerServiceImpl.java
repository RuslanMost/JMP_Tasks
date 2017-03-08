package creationalpatterns.services;

import creationalpatterns.mainpart.Computer;

public class ExpensiveComputerServiceImpl extends AbstractComputerService {
    @Override
    public Computer process() throws InterruptedException {
        System.out.println("Expensive computer is building... Wait for that...");
        Thread.sleep(1285);
        final Computer expensiveComputer = Computer.buildMainPart()
                .addExpensiveKeyboard()
                .addExpensiveMonitor()
                .addExpensiveSystemBlock()
                .addExpensiveMouse()
                .build();
        expensiveComputer.installOS();
        saveToFile(expensiveComputer);
        return expensiveComputer;
    }
}
