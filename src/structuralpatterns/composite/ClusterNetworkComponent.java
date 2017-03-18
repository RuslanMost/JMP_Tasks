package structuralpatterns.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClusterNetworkComponent implements NetworkComponent {
    private int workloadCount;
    private List<NetworkComponent> components = new ArrayList<>();

    public ClusterNetworkComponent(NetworkComponent... networkComponents) {
        Collections.addAll(components, networkComponents);
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

    public void addComponent(final NetworkComponent component) {
        components.add(component);
    }

    public NetworkComponent getLeafComponent(final int index) {
        return components.get(index);
    }
}
