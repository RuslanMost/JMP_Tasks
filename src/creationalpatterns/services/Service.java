package creationalpatterns.services;

public interface Service<T> {
    T process(final String type) throws InterruptedException;
}
