/*
Ромашов Максим Евгеньевич 2024
 */

package ru.gb.vending_machine;

import ru.gb.vending_machine.products.Bottle;
import ru.gb.vending_machine.products.Product;
import ru.gb.vending_machine.products.HotDrink;
import ru.gb.vending_machine.vending.VendingMachine;
import ru.gb.vending_machine.vending.VendingMachineHotDrinks;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(123);
        VendingMachineHotDrinks vendingMachineHotDrinks =  new VendingMachineHotDrinks(1001);

        Product product1 = new Bottle("coca-cola", 150, 1.5);
        Product product2 = new Product("milko", 100);
        Product product3 = new Bottle("Buratino", 100, 0.5);

        Product product5 = new HotDrink("Coffee", 100, 0.3, 50);
        Product product6 = new HotDrink("Americano", 150, 0.3, 60);
        Product product7 = new HotDrink("Latte", 200, 0.25, 70);


        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);
        vendingMachine.addProduct(product3);

        vendingMachineHotDrinks.addProduct(product5);
        vendingMachineHotDrinks.addProduct(product6);
        vendingMachineHotDrinks.addProduct(product7);

        System.out.println(vendingMachine.getProductsInfo());
        System.out.println(vendingMachineHotDrinks.getProductsInfo());
    }
}
