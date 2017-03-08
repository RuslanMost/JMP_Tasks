package creationalpatterns.cheapparts;

import creationalpatterns.abstractparts.Keyboard;

public class CheapKeyboard implements Keyboard {
    @Override
    public String toString() {
        return "I'm cheap keyboard.";
    }
}
