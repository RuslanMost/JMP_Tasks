package structuralpatterns.bridge.threadchips;

public class SinglethreadChip implements ThreadChipForm {
    @Override
    public String calculate() {
        return "singlethread work";
    }
}
