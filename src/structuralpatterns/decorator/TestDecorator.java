package structuralpatterns.decorator;

import structuralpatterns.bridge.computers.AmdComputer;
import structuralpatterns.bridge.computers.AppleComputer;
import structuralpatterns.bridge.computers.GoogleComputer;
import structuralpatterns.bridge.computers.IntelComputer;
import structuralpatterns.bridge.threadchips.MultithreadChip;
import structuralpatterns.bridge.threadchips.SinglethreadChip;
import structuralpatterns.composite.ClusterNetworkComponent;
import structuralpatterns.composite.NetworkComponent;
import structuralpatterns.composite.SingleNetworkComponent;

public class TestDecorator {

    public static void main(String[] args) {
        NetworkComponent singleNetworkComponent1 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AmdComputer(new SinglethreadChip()), 22));
        NetworkComponent singleNetworkComponent2 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new GoogleComputer(new SinglethreadChip()), 12));
        NetworkComponent singleNetworkComponent3 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new GoogleComputer(new MultithreadChip()), 19));
        NetworkComponent singleNetworkComponent4 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new GoogleComputer(new MultithreadChip()), 11));

        NetworkComponent singleNetworkComponent5 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AmdComputer(new SinglethreadChip()), 1));
        NetworkComponent singleNetworkComponent6 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 12));
        NetworkComponent singleNetworkComponent7 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 18));
        NetworkComponent singleNetworkComponent8 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AppleComputer(new SinglethreadChip()), 4));

        NetworkComponent singleNetworkComponent9 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 3));
        NetworkComponent singleNetworkComponent10 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 5));
        NetworkComponent singleNetworkComponent11 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new IntelComputer(new SinglethreadChip()), 8));
        NetworkComponent singleNetworkComponent12 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new IntelComputer(new MultithreadChip()), 2));

        NetworkComponent singleNetworkComponent13 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new IntelComputer(new SinglethreadChip()), 9));
        NetworkComponent singleNetworkComponent14 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new IntelComputer(new MultithreadChip()), 15));
        NetworkComponent singleNetworkComponent15 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new GoogleComputer(new MultithreadChip()), 16));
        NetworkComponent singleNetworkComponent16 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AmdComputer(new SinglethreadChip()), 20));

        NetworkComponent singleNetworkComponent17 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new AppleComputer(new MultithreadChip()), 18));
        NetworkComponent singleNetworkComponent18 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new GoogleComputer(new SinglethreadChip()), 17));
        NetworkComponent singleNetworkComponent19 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new IntelComputer(new MultithreadChip()), 6));
        NetworkComponent singleNetworkComponent20 =
                new LoggerNetworkDecorator(new SingleNetworkComponent(new IntelComputer(new MultithreadChip()), 7));

        LoggerNetworkDecorator clusterNetworkComponent1 = new LoggerNetworkDecorator(new ClusterNetworkComponent(
                singleNetworkComponent1,
                singleNetworkComponent2,
                singleNetworkComponent3,
                singleNetworkComponent4));
        LoggerNetworkDecorator clusterNetworkComponent2 = new LoggerNetworkDecorator(new ClusterNetworkComponent(
                singleNetworkComponent5,
                singleNetworkComponent6,
                singleNetworkComponent7,
                singleNetworkComponent8));
        LoggerNetworkDecorator clusterNetworkComponent3 = new LoggerNetworkDecorator(new ClusterNetworkComponent(
                singleNetworkComponent9,
                singleNetworkComponent10,
                singleNetworkComponent11,
                singleNetworkComponent12));
        LoggerNetworkDecorator clusterNetworkComponent4 = new LoggerNetworkDecorator(new ClusterNetworkComponent(
                singleNetworkComponent13,
                singleNetworkComponent14,
                singleNetworkComponent15,
                singleNetworkComponent16));
        LoggerNetworkDecorator clusterNetworkComponent5 = new LoggerNetworkDecorator(new ClusterNetworkComponent(
                singleNetworkComponent17,
                singleNetworkComponent18,
                singleNetworkComponent19,
                singleNetworkComponent20));

        clusterNetworkComponent2.addComponent(clusterNetworkComponent3);
        clusterNetworkComponent1.addComponent(clusterNetworkComponent2);

        clusterNetworkComponent4.addComponent(clusterNetworkComponent5);

        NetworkComponent rootComponent = new LoggerNetworkDecorator(new ClusterNetworkComponent(
                clusterNetworkComponent1,
                clusterNetworkComponent4));

        for (int i = 0; i < 100; i++) {
            rootComponent.doWork();
        }
    }
}
