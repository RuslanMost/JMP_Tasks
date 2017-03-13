package structuralpatterns.bridge;

import structuralpatterns.bridge.computers.AmdComputer;
import structuralpatterns.bridge.computers.GoogleComputer;
import structuralpatterns.bridge.computers.VendorComputer;
import structuralpatterns.bridge.threadchips.MultithreadChip;
import structuralpatterns.bridge.threadchips.SinglethreadChip;

public class BridgeTest {
    public static void main(final String[] args) {
        VendorComputer googleSingleThreadComputer = new GoogleComputer(new SinglethreadChip());
        VendorComputer googleMultiThreadComputer = new GoogleComputer(new MultithreadChip());
        VendorComputer amdSingleThreadComputer = new AmdComputer(new SinglethreadChip());
        VendorComputer amdMultiThreadComputer = new AmdComputer(new MultithreadChip());
        VendorComputer intelSingleThreadComputer = new GoogleComputer(new SinglethreadChip());
        VendorComputer intelMultiThreadComputer = new GoogleComputer(new MultithreadChip());
        VendorComputer appleSingleThreadComputer = new GoogleComputer(new SinglethreadChip());
        VendorComputer appleMultiThreadComputer = new GoogleComputer(new MultithreadChip());
        System.out.println(googleSingleThreadComputer);
        System.out.println(googleMultiThreadComputer);
        System.out.println(amdSingleThreadComputer);
        System.out.println(amdMultiThreadComputer);
        System.out.println(appleSingleThreadComputer);
        System.out.println(appleMultiThreadComputer);
        System.out.println(intelSingleThreadComputer);
        System.out.println(intelMultiThreadComputer);
    }
}
