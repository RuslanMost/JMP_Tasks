package creationalpatterns;

import creationalpatterns.services.AbstractComputerService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String typeOfComputer;
        if (args.length != 1) {
            typeOfComputer = "cheap";
        } else {
            typeOfComputer = args[0];
        }

        Optional<AbstractComputerService> optionalService = AbstractComputerService.getService(typeOfComputer);
        if (optionalService.isPresent()) {
            System.out.println(optionalService.get().process());
        }
    }
}
