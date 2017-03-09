package creationalpatterns.services;

import creationalpatterns.mainpart.Computer;

public class ExpensiveComputerFactoryImpl extends AbstractComputerFactory {
    @Override
    public Computer getComputer() throws InterruptedException {
        System.out.println("Expensive computer is building... Wait for that...");
        Thread.sleep(1285);
        final Computer expensiveComputer = Computer.buildMainPart()
                .addExpensiveKeyboard()
                .addExpensiveMonitor()
                .addExpensiveSystemBlock()
                .addExpensiveMouse()
                .build();
        saveToFile(expensiveComputer);
        return expensiveComputer;
    }
}
