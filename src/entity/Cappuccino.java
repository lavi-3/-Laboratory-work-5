package entity;

public class Cappuccino extends Coffee{

    public Cappuccino(int quantity, String name, int price, boolean dairyMilk) {
        super(quantity, name, price, dairyMilk);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public boolean isDairyMilk() {
        return super.isDairyMilk();
    }

    @Override
    public void setDairyMilk(boolean dairyMilk) {
        super.setDairyMilk(dairyMilk);
    }
}
