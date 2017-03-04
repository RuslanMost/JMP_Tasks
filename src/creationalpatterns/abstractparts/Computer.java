package creationalpatterns.abstractparts;

import java.io.Serializable;

public class Computer implements Serializable {
    private String type;
    private Mouse mouse;
    private Keyboard keyboard;
    private SystemBlock systemBlock;
    private Monitor monitor;

    public Computer(final String type, final SystemBlock systemBlock, final Monitor monitor, final Mouse mouse, final Keyboard keyboard) {
        this.type = type;
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.systemBlock = systemBlock;
        this.monitor = monitor;
    }

    public Computer(final String type, final SystemBlock systemBlock, final Monitor monitor) {
        this.type = type;
        this.monitor = monitor;
        this.systemBlock = systemBlock;
    }

    public Computer(final String type, final SystemBlock systemBlock, final Monitor monitor, final Mouse mouse) {
        this.type = type;
        this.systemBlock = systemBlock;
        this.monitor = monitor;
        this.mouse = mouse;
    }

    public Computer(final String type, final SystemBlock systemBlock, final Monitor monitor, final Keyboard keyboard) {
        this.type = type;
        this.systemBlock = systemBlock;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public Computer(final String type, final SystemBlock systemBlock, final Mouse mouse) {
        this.type = type;
        this.systemBlock = systemBlock;
        this.mouse = mouse;
    }

    public Computer(final String type, final SystemBlock systemBlock, final Keyboard keyboard) {
        this.type = type;
        this.systemBlock = systemBlock;
        this.keyboard = keyboard;
    }

    public Computer(final String type, final SystemBlock systemBlock, final Keyboard keyboard, final Mouse mouse) {
        this.type = type;
        this.systemBlock = systemBlock;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public Computer(final String type, final SystemBlock systemBlock) {
        this.type = type;
        this.systemBlock = systemBlock;
    }

    public Computer(final String type) {
        this.type = type;
    }

    public void installOS() throws InterruptedException {
        System.out.println("Installing Windows 10");
        Thread.sleep(1362);
        System.out.println("Windows 10 is installed.");
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(final Mouse mouse) {
        this.mouse = mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(final Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public SystemBlock getSystemBlock() {
        return systemBlock;
    }

    public void setSystemBlock(final SystemBlock systemBlock) {
        this.systemBlock = systemBlock;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(final Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        if (!type.equals("box")) {
            return "I'm " + type + ", and ready to serve you my Lord.";
        } else return "I'm just a " + type + ", sorry about that.";
    }
}
