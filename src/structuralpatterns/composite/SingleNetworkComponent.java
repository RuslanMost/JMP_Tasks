package structuralpatterns.composite;

import structuralpatterns.bridge.computers.VendorComputer;

public class SingleNetworkComponent implements NetworkComponent {
    private int workloadCount = 0;
    private VendorComputer computer;

    public SingleNetworkComponent(final VendorComputer computer, final int workloadCount) {
        this.computer = computer;
        this.workloadCount = workloadCount;
    }

    @Override
    public void doWork() {
        ++workloadCount;
        System.out.println(computer.toString() + computer.calculate() + " with workload of " + workloadCount + " points");
    }

    @Override
    public int getWorkload() {
        return workloadCount;
    }
}
