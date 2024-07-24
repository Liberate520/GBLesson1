package ru.gb.vending_machine.products;

public class HotDrinkWithTemp extends HotDrink {
    private int specificTemperature;

    public HotDrinkWithTemp(String name, double price, double volume, int specificTemperature) {
        super(name, price, volume);
        this.specificTemperature = specificTemperature;
    }

    public int getSpecificTemperature() {
        return specificTemperature;
    }

    @Override
    public String toString() {
        return super.toString() + ", temperature: " + specificTemperature + "°C";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName() + " at " + getSpecificTemperature() + " degrees.");
    }
}
