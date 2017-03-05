package creationalpatterns.expensiveparts;

import creationalpatterns.abstractparts.Keyboard;

public class ExpensiveKeyboard implements Keyboard {
    @Override
    public String toString() {
        return "I'm expensive keyboard.";
    }
}
