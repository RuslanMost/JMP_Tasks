package structuralpatterns.bridge.computers;

import structuralpatterns.bridge.threadchips.ThreadChipForm;

public abstract class VendorComputer {
    protected ThreadChipForm threadChipForm;

    public VendorComputer(final ThreadChipForm threadChipForm) {
        this.threadChipForm = threadChipForm;
    }

    protected abstract String getDescription();

    public String calculate() {
        return threadChipForm.calculate();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
