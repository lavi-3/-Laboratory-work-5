package market;

import entity.Coffee;

import java.util.List;
import java.util.Map;

public class Company {
    Map<Coffee, Integer> companyCoffee;

    Employee barista;
    Employee manager;
    private int totalEarn;

    public Company(Map<Coffee, Integer> companyCoffee, Employee barista, Employee manager, int totalEarn) {
        this.companyCoffee = companyCoffee;
        this.barista = barista;
        this.manager = manager;
        this.totalEarn = totalEarn;
    }

    public Map<Coffee, Integer> getCompanyCoffee() {
        return companyCoffee;
    }

    public void setCompanyCoffee(Map<Coffee, Integer> companyCoffee) {
        this.companyCoffee = companyCoffee;
    }

    public Employee getBarista() {
        return barista;
    }

    public void setBarista(Barista barista) {
        this.barista = barista;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public int getTotalEarn() {
        return totalEarn;
    }

    public void setTotalEarn(int totalEarn) {
        this.totalEarn = totalEarn;
    }
}
