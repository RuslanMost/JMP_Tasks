package creationalpatterns.abstractparts;

import java.io.Serializable;

public class Computer implements Serializable {
    private String type;
    private Mouse mouse;
    private Keyboard keyboard;
    private SystemBlock systemBlock;
    private Monitor monitor;

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

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "type='" + type + '\'' +
                ", mouse=" + mouse +
                ", keyboard=" + keyboard +
                ", systemBlock=" + systemBlock +
                ", monitor=" + monitor +
                '}';
    }
}
