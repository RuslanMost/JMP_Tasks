package creationalpatterns.services;

import creationalpatterns.mainpart.Computer;

import java.io.*;

public abstract class AbstractComputerFactory {

    public abstract Computer getComputer() throws InterruptedException;


}
