package creationalpatterns.services;

import creationalpatterns.mainpart.Computer;

public class CheapComputerServiceImpl extends AbstractComputerService {
    @Override
    public Computer process() throws InterruptedException {
        System.out.println("Cheap computer is building... Wait for that...");
        Thread.sleep(964);
        final Computer cheapComputer = Computer.buildMainPart()
                .addCheapKeyboard()
                .addCheapMonitor()
                .addCheapMouse()
                .addCheapSystemBlock()
                .build();
        cheapComputer.installOS();
        saveToFile(cheapComputer);
        return cheapComputer;
    }
}
