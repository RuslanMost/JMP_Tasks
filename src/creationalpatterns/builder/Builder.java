package creationalpatterns.builder;

public abstract class Builder<T extends Builder, R>{
    protected R computer;
    public abstract T build(final String part);
    public abstract R getProduct();
}
