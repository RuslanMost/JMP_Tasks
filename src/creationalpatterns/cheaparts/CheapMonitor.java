package creationalpatterns.cheaparts;

import creationalpatterns.abstractparts.Monitor;

public class CheapMonitor implements Monitor {
    @Override
    public String toString() {
        return "I'm cheap monitor.";
    }
}
