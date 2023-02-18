package LaptopTask6;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<LaptopTask6.Laptop> set = new HashSet<>();
        set.add(new LaptopTask6.Laptop("Laptop 1", 8, "Windows11", 80000, "HP"));
        set.add(new LaptopTask6.Laptop("Laptop 2", 16, "Windows10", 87000, "Asus"));
        set.add(new LaptopTask6.Laptop("Laptop 3", 32, "linux", 150000, "MSI"));
        set.add(new LaptopTask6.Laptop("Laptop 4", 32, "linux", 90000, "Lenovo"));

        LaptopTask6.OperationWithLaptop operation = new LaptopTask6.OperationWithLaptop(set);
        operation.start();
    }
}