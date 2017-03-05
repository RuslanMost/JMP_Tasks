package creationalpatterns.cheaparts;

import creationalpatterns.abstractparts.SystemBlock;

public class CheapSystemBlock implements SystemBlock{
    @Override
    public String toString() {
        return "I'm cheap system block.";
    }
}
