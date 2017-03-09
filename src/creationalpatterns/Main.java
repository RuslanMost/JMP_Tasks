package creationalpatterns;

import creationalpatterns.mainpart.Computer;
import creationalpatterns.services.CheapComputerFactoryImpl;
import creationalpatterns.services.ComputerService;
import creationalpatterns.services.ExpensiveComputerFactoryImpl;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String typeOfComputer;
        if (args.length != 1) {
            typeOfComputer = "cheap";
        } else {
            typeOfComputer = args[0];
        }

        ComputerService service = new ComputerService();

        if ("cheap".equals(typeOfComputer)) {
            service.setComputerFactory(new CheapComputerFactoryImpl());
        } else if ("expensive".equals(typeOfComputer)) {
            service.setComputerFactory(new ExpensiveComputerFactoryImpl());
        }

        Computer computer = service.process();
        System.out.println(computer);

    }
}
