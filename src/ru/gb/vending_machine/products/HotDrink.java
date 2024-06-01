package ru.gb.vending_machine.products;

public class HotDrink extends Product {
    private double volume;
    private int temperature;


    public HotDrink(String name, double price, double volume, int temperature) {
        super(name, price);
        this.volume = volume;
        this.temperature = temperature;
    }

    public double getVolume() {
        return volume;
    }

    public double getTem() {
        return temperature;
    }

    @Override
    public String toString() {
        return super.toString() + ", volume: " + volume + "л."+ ", temperature: " + temperature + "C°";
    }
}
