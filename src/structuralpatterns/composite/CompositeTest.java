package structuralpatterns.composite;

import structuralpatterns.bridge.computers.AmdComputer;
import structuralpatterns.bridge.computers.AppleComputer;
import structuralpatterns.bridge.computers.GoogleComputer;
import structuralpatterns.bridge.computers.IntelComputer;
import structuralpatterns.bridge.threadchips.MultithreadChip;
import structuralpatterns.bridge.threadchips.SinglethreadChip;

public class CompositeTest {
    public static void main(String[] args) {

        NetworkComponent singleNetworkComponent1 = new SingleNetworkComponent(new AmdComputer(new SinglethreadChip()), 22);
        NetworkComponent singleNetworkComponent2 = new SingleNetworkComponent(new GoogleComputer(new SinglethreadChip()), 12);
        NetworkComponent singleNetworkComponent3 = new SingleNetworkComponent(new GoogleComputer(new MultithreadChip()), 19);
        NetworkComponent singleNetworkComponent4 = new SingleNetworkComponent(new GoogleComputer(new MultithreadChip()), 11);

        NetworkComponent singleNetworkComponent5 = new SingleNetworkComponent(new AmdComputer(new SinglethreadChip()), 1);
        NetworkComponent singleNetworkComponent6 = new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 12);
        NetworkComponent singleNetworkComponent7= new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 18);
        NetworkComponent singleNetworkComponent8 = new SingleNetworkComponent(new AppleComputer(new SinglethreadChip()), 4);

        NetworkComponent singleNetworkComponent9 = new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 3);
        NetworkComponent singleNetworkComponent10 = new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 5);
        NetworkComponent singleNetworkComponent11 = new SingleNetworkComponent(new IntelComputer(new SinglethreadChip()), 8);
        NetworkComponent singleNetworkComponent12 = new SingleNetworkComponent(new IntelComputer(new MultithreadChip()), 2);

        NetworkComponent singleNetworkComponent13 = new SingleNetworkComponent(new IntelComputer(new SinglethreadChip()), 9);
        NetworkComponent singleNetworkComponent14 = new SingleNetworkComponent(new IntelComputer(new MultithreadChip()), 15);
        NetworkComponent singleNetworkComponent15 = new SingleNetworkComponent(new GoogleComputer(new MultithreadChip()), 16);
        NetworkComponent singleNetworkComponent16 = new SingleNetworkComponent(new AmdComputer(new SinglethreadChip()), 20);

        NetworkComponent singleNetworkComponent17 = new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 18);
        NetworkComponent singleNetworkComponent18 = new SingleNetworkComponent(new GoogleComputer(new SinglethreadChip()), 17);
        NetworkComponent singleNetworkComponent19 = new SingleNetworkComponent(new IntelComputer(new MultithreadChip()), 6);
        NetworkComponent singleNetworkComponent20 = new SingleNetworkComponent(new IntelComputer(new MultithreadChip()), 7);

        NetworkComponent clusterNetworkComponent1 = new ClusterNetworkComponent();
        NetworkComponent clusterNetworkComponent2 = new ClusterNetworkComponent();
        NetworkComponent clusterNetworkComponent3 = new ClusterNetworkComponent();
        NetworkComponent clusterNetworkComponent4 = new ClusterNetworkComponent();
        NetworkComponent clusterNetworkComponent5 = new ClusterNetworkComponent();

        clusterNetworkComponent1.addComponent(singleNetworkComponent1);
        clusterNetworkComponent1.addComponent(singleNetworkComponent2);
        clusterNetworkComponent1.addComponent(singleNetworkComponent3);
        clusterNetworkComponent1.addComponent(singleNetworkComponent4);

        clusterNetworkComponent2.addComponent(singleNetworkComponent5);
        clusterNetworkComponent2.addComponent(singleNetworkComponent6);
        clusterNetworkComponent2.addComponent(singleNetworkComponent7);
        clusterNetworkComponent2.addComponent(singleNetworkComponent8);

        clusterNetworkComponent3.addComponent(singleNetworkComponent9);
        clusterNetworkComponent3.addComponent(singleNetworkComponent10);
        clusterNetworkComponent3.addComponent(singleNetworkComponent11);
        clusterNetworkComponent3.addComponent(singleNetworkComponent12);

        clusterNetworkComponent4.addComponent(singleNetworkComponent13);
        clusterNetworkComponent4.addComponent(singleNetworkComponent14);
        clusterNetworkComponent4.addComponent(singleNetworkComponent15);
        clusterNetworkComponent4.addComponent(singleNetworkComponent16);

        clusterNetworkComponent5.addComponent(singleNetworkComponent17);
        clusterNetworkComponent5.addComponent(singleNetworkComponent18);
        clusterNetworkComponent5.addComponent(singleNetworkComponent19);
        clusterNetworkComponent5.addComponent(singleNetworkComponent20);

        clusterNetworkComponent2.addComponent(clusterNetworkComponent3);
        clusterNetworkComponent1.addComponent(clusterNetworkComponent2);

        clusterNetworkComponent4.addComponent(clusterNetworkComponent5);

        NetworkComponent rootComponent = new ClusterNetworkComponent();
        rootComponent.addComponent(clusterNetworkComponent1);
        rootComponent.addComponent(clusterNetworkComponent4);

        for (int i = 0; i < 100; i++) {
            rootComponent.doWork();
        }
    }
}
