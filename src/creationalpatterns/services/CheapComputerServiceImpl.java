package creationalpatterns.services;

import creationalpatterns.abstractparts.Computer;
import creationalpatterns.cheaparts.*;

public class CheapComputerServiceImpl extends AbstractComputerService {
    @Override
    public Computer process() throws InterruptedException {
        System.out.println("Cheap computer is building... Wait for that...");
        Thread.sleep(964);
        final Computer cheapComputer = new Computer("cheap", new CheapSystemBlock());
        cheapComputer.setKeyboard(new CheapKeyboard());
        cheapComputer.setMouse(new CheapMouse());
        cheapComputer.setMonitor(new CheapMonitor());
        cheapComputer.installOS();
        saveToFile(cheapComputer);
        return cheapComputer;
    }
}
