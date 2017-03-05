package creationalpatterns.expensiveparts;

import creationalpatterns.abstractparts.Monitor;

public class ExpensiveMonitor implements Monitor {
    @Override
    public String toString() {
        return "I'm expensive monitor.";
    }
}
