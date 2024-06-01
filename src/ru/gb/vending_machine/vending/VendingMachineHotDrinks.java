package ru.gb.vending_machine.vending;

import ru.gb.vending_machine.products.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineHotDrinks extends VendingMachine {
    public VendingMachineHotDrinks(int id) {
        super(id);
        productList = new ArrayList<>();
    }

    private int id;
    private int productId;
    private List<Product> productList;


    public void addProduct(Product product){
        product.setId(productId++);
        productList.add(product);
    }

    @Override
    public String getProductsInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список Горячих Напитков:\n");
        for (Product product: productList){
            stringBuilder.append(product);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
