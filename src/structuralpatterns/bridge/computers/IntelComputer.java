package structuralpatterns.bridge.computers;

import structuralpatterns.bridge.threadchips.ThreadChipForm;

public class IntelComputer extends VendorComputer {
    public IntelComputer(final ThreadChipForm threadChipForm) {
        super(threadChipForm);
    }

    @Override
    protected String getDescription() {
        return "Intel chipset processing with " + threadChipForm.calculate();
    }
}
