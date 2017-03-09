package creationalpatterns.services;

import creationalpatterns.mainpart.Computer;

public class CheapComputerFactoryImpl extends AbstractComputerFactory {
    @Override
    public Computer getComputer() throws InterruptedException {
        System.out.println("Cheap computer is building... Wait for that...");
        Thread.sleep(964);
        final Computer cheapComputer = Computer.buildMainPart()
                .addCheapKeyboard()
                .addCheapMonitor()
                .addCheapMouse()
                .addCheapSystemBlock()
                .build();
        saveToFile(cheapComputer);
        return cheapComputer;
    }
}
