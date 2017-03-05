package creationalpatterns;

import creationalpatterns.abstractparts.Computer;
import creationalpatterns.services.ComputerService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String typeOfComputer;
        if (args.length != 1) {
            typeOfComputer = "expensive";
        } else {
            typeOfComputer = args[0];
        }

        ComputerService service = new ComputerService();
        Computer computer = service.process(typeOfComputer);

        System.out.println(computer);
    }
}
