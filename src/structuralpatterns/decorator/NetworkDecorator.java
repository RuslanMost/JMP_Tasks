package structuralpatterns.decorator;

import structuralpatterns.composite.NetworkComponent;


public abstract class NetworkDecorator implements NetworkComponent {

    NetworkComponent networkComponent;

    public NetworkDecorator(final NetworkComponent networkComponent) {
        this.networkComponent = networkComponent;
    }

    @Override
    public void doWork() {
        networkComponent.doWork();
    }

    @Override
    public int getWorkload() {
        return networkComponent.getWorkload();
    }
}
