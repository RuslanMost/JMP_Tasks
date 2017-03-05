package creationalpatterns.expensiveparts;

import creationalpatterns.abstractparts.SystemBlock;

public class ExpensiveSystemBlock implements SystemBlock{
    @Override
    public String toString() {
        return "I'm expensive system block.";
    }
}
