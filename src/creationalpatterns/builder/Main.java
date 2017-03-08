package creationalpatterns.builder;

import creationalpatterns.mainpart.Computer;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> parts;
        if (args.length > 0) {
            parts = Arrays.asList(args);
        } else {
            parts = Arrays.asList("expensive monitor", "expensive keyboard", "cheap mouse");
        }

        Director computerDirector = new Director();
        System.out.println(computerDirector.buildComputer(parts));

        Computer justAnExpensiveComputer = Computer.buildMainPart()
                .addExpensiveKeyboard()
                .addExpensiveMonitor()
                .addExpensiveMouse()
                .addExpensiveSystemBlock()
                .build();
        System.out.println(justAnExpensiveComputer);
    }
}
