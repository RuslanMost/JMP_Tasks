package creationalpatterns.builder;

import creationalpatterns.mainpart.Computer;

import java.util.List;

public class Director {
    Computer.ComputerBuilder computerBuilder;

    public Director() {
        computerBuilder = Computer.buildMainPart();
    }

    public Computer buildComputer(final List<String> parts) {
        parts.stream()
                .forEach(part -> {
                    if ("expensive system block".equals(part)) {
                        computerBuilder.addExpensiveSystemBlock();
                    } else if ("expensive monitor".equals(part)) {
                        computerBuilder.addExpensiveMonitor();
                    } else if ("expensive keyboard".equals(part)) {
                        computerBuilder.addExpensiveKeyboard();
                    } else if ("expensive mouse".equals(part)) {
                        computerBuilder.addExpensiveMouse();
                    } else if ("cheap system block".equals(part)) {
                        computerBuilder.addCheapSystemBlock();
                    } else if ("cheap monitor".equals(part)) {
                        computerBuilder.addCheapMonitor();
                    } else if ("cheap keyboard".equals(part)) {
                        computerBuilder.addCheapKeyboard();
                    } else if ("cheap mouse".equals(part)) {
                        computerBuilder.addCheapMouse();
                    }
                });
        return computerBuilder.build();
    }
}
