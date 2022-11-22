package entity;

public class Client implements ClientInterface {
    private int money;
    private boolean lactoseTolerant;

    public Client(int money, boolean lactoseTolerant) {
        this.money = money;
        this.lactoseTolerant = lactoseTolerant;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isLactoseTolerant() {
        return lactoseTolerant;
    }

    public void setLactoseTolerant(boolean lactoseTolerant) {
        this.lactoseTolerant = lactoseTolerant;
    }

    @Override
    public void milkDis(boolean b) {
        if (b) {
            System.out.println("Client Can drink milk");
        } else {
            System.out.println("Client cannot drink milk");
        }
    }
}
