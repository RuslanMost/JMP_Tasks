package structuralpatterns.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import structuralpatterns.composite.ClusterNetworkComponent;
import structuralpatterns.composite.NetworkComponent;

public class LoggerNetworkDecorator extends NetworkDecorator {
    public static final Logger LOGGER = LogManager.getLogger(LoggerNetworkDecorator.class);

    public LoggerNetworkDecorator(final NetworkComponent networkComponent) {
        super(networkComponent);
    }

    @Override
    public void doWork() {
        LOGGER.info("Starting to do work of " + networkComponent + " component..");
        networkComponent.doWork();
        LOGGER.info("Work of " + networkComponent + " component is finished.");
    }

    @Override
    public int getWorkload() {
        return networkComponent.getWorkload();
    }

    public void addComponent(final NetworkComponent component) {
        LOGGER.info("Adding " + component + " component.");
        if (networkComponent instanceof ClusterNetworkComponent) {
            ((ClusterNetworkComponent) networkComponent).addComponent(component);
        }
        LOGGER.info("Adding of " + component + " component is done.");
    }
}
