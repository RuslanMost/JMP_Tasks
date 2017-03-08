package creationalpatterns.mainpart;

import creationalpatterns.abstractparts.Keyboard;
import creationalpatterns.abstractparts.Monitor;
import creationalpatterns.abstractparts.Mouse;
import creationalpatterns.abstractparts.SystemBlock;
import creationalpatterns.cheapparts.CheapKeyboard;
import creationalpatterns.cheapparts.CheapMonitor;
import creationalpatterns.cheapparts.CheapMouse;
import creationalpatterns.cheapparts.CheapSystemBlock;
import creationalpatterns.expensiveparts.ExpensiveKeyboard;
import creationalpatterns.expensiveparts.ExpensiveMonitor;
import creationalpatterns.expensiveparts.ExpensiveMouse;
import creationalpatterns.expensiveparts.ExpensiveSystemBlock;

import java.io.Serializable;

public class Computer implements Serializable {
    private Mouse mouse;
    private Keyboard keyboard;
    private SystemBlock systemBlock;
    private Monitor monitor;

    public Computer() {
    }

    public Computer(final Mouse mouse, final Keyboard keyboard, final SystemBlock systemBlock, final Monitor monitor) {
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.systemBlock = systemBlock;
        this.monitor = monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public SystemBlock getSystemBlock() {
        return systemBlock;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public static ComputerBuilder buildMainPart() {
        return new Computer().new ComputerBuilder();
    }

    public void installOS() throws InterruptedException {
        System.out.println("Installing Windows 10");
        Thread.sleep(1362);
        System.out.println("Windows 10 is installed.");
    }


    public class ComputerBuilder {

        private ComputerBuilder() {
            // private constructor
        }

        public Computer build() {
            return new Computer(mouse, keyboard, systemBlock, monitor);
        }

        public ComputerBuilder addExpensiveSystemBlock() {
            systemBlock = new ExpensiveSystemBlock();
            return this;
        }

        public ComputerBuilder addExpensiveMonitor() {
            monitor = new ExpensiveMonitor();
            return this;
        }

        public ComputerBuilder addExpensiveKeyboard() {
            keyboard = new ExpensiveKeyboard();
            return this;
        }

        public ComputerBuilder addExpensiveMouse() {
            mouse = new ExpensiveMouse();
            return this;
        }

        public ComputerBuilder addCheapSystemBlock() {
            systemBlock = new CheapSystemBlock();
            return this;
        }

        public ComputerBuilder addCheapMonitor() {
            monitor = new CheapMonitor();
            return this;
        }

        public ComputerBuilder addCheapKeyboard() {
            keyboard = new CheapKeyboard();
            return this;
        }

        public ComputerBuilder addCheapMouse() {
            mouse = new CheapMouse();
            return this;
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                ", mouse=" + mouse +
                ", keyboard=" + keyboard +
                ", systemBlock=" + systemBlock +
                ", monitor=" + monitor +
                '}';
    }
}
