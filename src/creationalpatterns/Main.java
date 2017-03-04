package creationalpatterns;

import creationalpatterns.abstractparts.Computer;
import creationalpatterns.services.CheapComputerService;
import creationalpatterns.services.ComputerService;
import creationalpatterns.services.ExpensiveComputerService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String typeOfComputer;
        if (args.length != 1) {
            typeOfComputer = "expensive";
        } else {
            typeOfComputer = args[0];
        }

        ComputerService service;
        Computer computer = null;

        if (typeOfComputer.equals("cheap")) {
            service = new CheapComputerService();
            computer = service.process(typeOfComputer);
        } else if (typeOfComputer.equals("expensive")) {
            service = new ExpensiveComputerService();
            computer = service.process(typeOfComputer);
        }
        Optional<Object> o = Optional.ofNullable(computer);

        System.out.println(o.orElse(new Computer("box")));
    }
}
