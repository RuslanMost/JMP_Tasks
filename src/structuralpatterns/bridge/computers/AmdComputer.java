package structuralpatterns.bridge.computers;

import structuralpatterns.bridge.threadchips.ThreadChipForm;

public class AmdComputer extends VendorComputer {

    public AmdComputer(final ThreadChipForm threadChipForm) {
        super(threadChipForm);
    }

    @Override
    public String getDescription() {
        return "AMD chipset processing with " + threadChipForm.calculate();
    }
}
