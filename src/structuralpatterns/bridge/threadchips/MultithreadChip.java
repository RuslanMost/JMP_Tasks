package structuralpatterns.bridge.threadchips;

public class MultithreadChip implements ThreadChipForm {
    @Override
    public String calculate() {
        return "multithread power";
    }
}
