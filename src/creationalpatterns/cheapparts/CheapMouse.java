package creationalpatterns.cheapparts;

import creationalpatterns.abstractparts.Mouse;

public class CheapMouse implements Mouse {
    @Override
    public String toString() {
        return "I'm cheap mouse.";
    }
}
