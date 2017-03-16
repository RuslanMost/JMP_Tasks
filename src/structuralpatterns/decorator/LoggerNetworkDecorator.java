package structuralpatterns.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import structuralpatterns.composite.NetworkComponent;

public class LoggerNetworkDecorator extends NetworkDecorator {
    public static final Logger LOGGER = LogManager.getLogger(LoggerNetworkDecorator.class);

    public LoggerNetworkDecorator(final NetworkComponent networkComponent) {
        super(networkComponent);
    }

    @Override
    public void doWork() {
        LOGGER.info("Starting to do work....");
        networkComponent.doWork();
        LOGGER.info("Work is finished.");
    }

    @Override
    public int getWorkload() {
        int workload = networkComponent.getWorkload();
        LOGGER.info("workload is " + workload);
        return workload;
    }

    @Override
    public void addComponent(final NetworkComponent component) {
        LOGGER.info("Adding " + component + " component.");
        networkComponent.addComponent(component);
        LOGGER.info("Adding of " + component + " component is done.");
    }
}
