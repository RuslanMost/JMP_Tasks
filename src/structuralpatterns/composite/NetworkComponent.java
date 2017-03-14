package structuralpatterns.composite;

public interface NetworkComponent {
    void doWork();
    int getWorkload();
    void addComponent(final NetworkComponent component);
}
