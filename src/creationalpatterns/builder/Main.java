package creationalpatterns.builder;

import creationalpatterns.abstractparts.Computer;

public class Main {
    public static void main(String[] args) {
        String[] parts = new String[] {"expensive monitor", "expensive keyboard", "cheap mouse"};
        ComputerDirector computerDirector = new ComputerDirector();
        Computer computer = computerDirector.buildComputer(parts);
        System.out.println(computer);
    }
}
