package creationalpatterns.services;

import creationalpatterns.mainpart.Computer;

public class CheapComputerFactoryImpl extends AbstractComputerFactory {
    @Override
    public Computer getComputer() throws InterruptedException {
        System.out.println("Cheap computer is building... Wait for that...");
        Thread.sleep(964);
        return Computer.buildMainPart()
                .addCheapKeyboard()
                .addCheapMonitor()
                .addCheapMouse()
                .addCheapSystemBlock()
                .build();
    }
}
