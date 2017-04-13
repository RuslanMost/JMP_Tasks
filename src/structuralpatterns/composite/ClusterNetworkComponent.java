package structuralpatterns.composite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClusterNetworkComponent implements NetworkComponent {
    private String id;
    private int workloadCount;
    private List<NetworkComponent> components = new ArrayList<>();

    public ClusterNetworkComponent() {
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public void doWork() {
        final int normalWorkLoadThreshold = 12;
        components.sort(Comparator.comparing(NetworkComponent::getWorkload));
        components.stream()
                .filter(component -> component.getWorkload() < normalWorkLoadThreshold)
                .forEach(component -> {
                    component.doWork();
                    workloadCount += component.getWorkload();
                });
    }

    @Override
    public int getWorkload() {
        return workloadCount;
    }

    @Override
    public void addComponent(final NetworkComponent component) {
        components.add(component);
    }


}
