package creationalpatterns.expensiveparts;

import creationalpatterns.abstractparts.Mouse;

public class ExpensiveMouse implements Mouse {
    @Override
    public String toString() {
        return "I'm expensive mouse.";
    }
}
