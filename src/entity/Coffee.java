package entity;

public abstract class Coffee {
    private int quantity;
    private String name;
    private int price;
    private boolean dairyMilk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coffee(int quantity, String name, int price, boolean dairyMilk) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.dairyMilk = dairyMilk;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDairyMilk() {
        return dairyMilk;
    }

    public void setDairyMilk(boolean dairyMilk) {
        this.dairyMilk = dairyMilk;
    }
}
