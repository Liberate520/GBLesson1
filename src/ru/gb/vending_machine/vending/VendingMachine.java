package ru.gb.vending_machine.vending;

import java.util.ArrayList;
import java.util.List;

import ru.gb.vending_machine.products.HotDrinkWithTemp;
import ru.gb.vending_machine.products.Product;

public class VendingMachine {
    private int id;
    private int productId;
    private List<Product> productList;

    public VendingMachine(int id) {
        this.id = id;
        productList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProduct(Product product) {
        product.setId(productId++);
        productList.add(product);
    }

    public String getProductsInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список продуктов:\n");
        for (Product product : productList) {
            stringBuilder.append(product);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Product getProduct(String name, double volume, int temperature) {
        for (Product product : productList) {
            if (product instanceof HotDrinkWithTemp) {
                HotDrinkWithTemp hotDrink = (HotDrinkWithTemp) product;
                if (hotDrink.getName().equals(name) &&
                    hotDrink.getVolume() == volume &&
                    hotDrink.getSpecificTemperature() == temperature) {
                    return hotDrink;
                }
            }
        }
        return null;
    }
}
