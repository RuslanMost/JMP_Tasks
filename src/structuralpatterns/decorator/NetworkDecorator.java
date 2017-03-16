package structuralpatterns.decorator;

import structuralpatterns.composite.NetworkComponent;


public class NetworkDecorator implements NetworkComponent {

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

    @Override
    public void addComponent(final NetworkComponent component) {
        networkComponent.addComponent(component);
    }
}
