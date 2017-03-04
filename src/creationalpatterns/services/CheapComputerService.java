package creationalpatterns.services;

import creationalpatterns.abstractparts.Computer;
import creationalpatterns.cheaparts.CheapKeyboard;
import creationalpatterns.cheaparts.CheapMonitor;
import creationalpatterns.cheaparts.CheapMouse;
import creationalpatterns.cheaparts.CheapSystemBlock;

public class CheapComputerService extends ComputerService {
    @Override
    protected Computer buildComputer(final String type) {
        Computer cheapComputer = new Computer(type, new CheapSystemBlock());
        cheapComputer.setKeyboard(new CheapKeyboard());
        cheapComputer.setMonitor(new CheapMonitor());
        cheapComputer.setMouse(new CheapMouse());
        return cheapComputer;
    }
}
