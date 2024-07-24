package ru.gb.vending_machine.products;

public abstract class HotDrink extends Product {
    private double volume;

    public HotDrink(String name, double price, double volume) {
        super(name, price);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public abstract void prepare();
}
