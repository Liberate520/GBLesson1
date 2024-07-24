package ru.gb.vending_machine;

import ru.gb.vending_machine.products.Bottle;
import ru.gb.vending_machine.products.HotDrinkWithTemp;
import ru.gb.vending_machine.products.Product;
import ru.gb.vending_machine.vending.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(123);

        System.out.println("Vending Machine ID: " + vendingMachine.getId());

        Product product1 = new Bottle("coca-cola", 150, 1.5);
        Product product2 = new Product("milko", 100);
        HotDrinkWithTemp hotDrink1 = new HotDrinkWithTemp("Green Tea", 200, 0.25, 75);
        HotDrinkWithTemp hotDrink2 = new HotDrinkWithTemp("Coffee", 300, 0.30, 85);

        vendingMachine.addProduct(product1);
        vendingMachine.addProduct(product2);
        vendingMachine.addProduct(hotDrink1);
        vendingMachine.addProduct(hotDrink2);

        System.out.println(vendingMachine.getProductsInfo());

        Product requestedDrink = vendingMachine.getProduct("Green Tea", 0.25, 75);
        if (requestedDrink != null) {
            System.out.println("Dispensing: " + requestedDrink);
        } else {
            System.out.println("Product not found.");
        }
    }
}
