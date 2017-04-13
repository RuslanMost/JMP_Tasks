package structuralpatterns.composite;

import structuralpatterns.bridge.computers.VendorComputer;

public class SingleNetworkComponent implements NetworkComponent {
    private String id;
    private int workloadCount = 0;
    private VendorComputer computer;

    public SingleNetworkComponent(final String id, final VendorComputer vendorComputer) {
        this.id = id;
        this.workloadCount = 1;
        this.workloadCount = workloadCount;
    }

    public SingleNetworkComponent(final VendorComputer computer, final int workloadCount) {
        this.computer = computer;
        this.workloadCount = workloadCount;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
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

    @Override
    public void addComponent(final NetworkComponent component) {
        throw new UnsupportedOperationException();
    }
}
