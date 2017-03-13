package structuralpatterns.bridge.computers;

import structuralpatterns.bridge.threadchips.ThreadChipForm;

public class AppleComputer extends VendorComputer{
    public AppleComputer(final ThreadChipForm threadChipForm) {
        super(threadChipForm);
    }

    @Override
    protected String getDescription() {
        return "Apple chipset processing with " + threadChipForm.calculate();
    }
}
