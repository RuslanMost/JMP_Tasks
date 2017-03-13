package structuralpatterns.bridge.computers;

import structuralpatterns.bridge.threadchips.ThreadChipForm;

public class GoogleComputer extends VendorComputer{

    public GoogleComputer(final ThreadChipForm threadChipForm) {
        super(threadChipForm);
    }

    @Override
    protected String getDescription() {
        return "Google chipset processing with " + threadChipForm.calculate();
    }
}
