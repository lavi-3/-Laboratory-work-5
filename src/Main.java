import entity.*;
import market.Barista;
import market.Company;
import market.Employee;
import market.Manager;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Americano americano = new Americano(150, "Americano", 60, false);
        Espresso espresso = new Espresso(50, "Espresso", 75, false);
        Cappuccino cappuccino = new Cappuccino(200, "Cappuccino", 95, true);
        Latte latte = new Latte(250, "Latte", 100, true);
        List<Coffee> coffees = new ArrayList<>(List.of(americano, espresso, cappuccino, latte));
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Employee manager = new Manager(true, random.nextInt(500, 600), random.nextInt(3, 10));
        Employee barista = new Barista(true, random.nextInt(350, 400), random.nextInt(3, 5));
        Map<Coffee, Integer> companyCoffee = new HashMap<>();
        companyCoffee.put(americano, 100);
        companyCoffee.put(espresso, 100);
        companyCoffee.put(cappuccino, 80);
        companyCoffee.put(latte, 80);
        Company company = new Company(companyCoffee, barista, manager, 0);
        List<Boolean> booleans = new ArrayList<>(List.of(true, true, false, true, true));
        int totalSum = 0, monthSum = 0, daySum = 0;
        double income = 0, clearIncome = 0;
        int nrOfClients = 0, nrOfProducts = 0;
        int es = 0, am = 0, cap = 0, lat = 0, veg = 0;
        String stop;
        boolean a = true;

        for (int i = 1; a; i++) {
            System.out.println("---------------");
            daySum = 0;
            System.out.println("Day " + i);
            nrOfClients = random.nextInt(6, 10);
            for (int j = 0; j < nrOfClients; j++) {
                System.out.println();
                Client client = new Client(random.nextInt(100, 200), booleans.get(random.nextInt(booleans.size())));
                nrOfProducts = random.nextInt(1, 4);
                if (client.isLactoseTolerant()) {
                    System.out.println("A client comes and has " + client.getMoney() + " coins and likes Milk");
                } else {
                    System.out.println("A client comes and has " + client.getMoney() + " coins and hates Milk");
                }
                System.out.println("  Order: ");
                for (int k = 0; k < nrOfProducts; k++) {
                    Coffee coffee = coffees.get(random.nextInt(coffees.size()));
                    System.out.print(coffee.getName() + " which costs " + coffee.getPrice());
                    if (client.getMoney() > coffee.getPrice()) {
                        if (companyCoffee.get(coffee) > 0){
                        companyCoffee.put(coffee, companyCoffee.get(coffee) - 1);
                        if ((coffee.isDairyMilk() == true) && (client.isLactoseTolerant() == false)) {
                            System.out.println(" and client cannot buy it but it will have vegan milk for an additional price");
                            client.setMoney(client.getMoney() - coffee.getPrice());
                            if (barista.getExperience() > 10) {
                                daySum += (coffee.getPrice() + 5) + random.nextInt(5, 10);
                            } else {
                                daySum += coffee.getPrice() + 5;
                            }
                            veg += 1;
                        } else {
                            System.out.println(" and client buys it");
                            client.setMoney(client.getMoney() - coffee.getPrice());

                            if (barista.getExperience() > 10) {
                                daySum += coffee.getPrice() + random.nextInt(5, 10);
                            } else {
                                daySum += coffee.getPrice();
                            }
                        }
                        switch (coffee.getName()) {
                            case "Americano" -> am += 1;
                            case "Cappuccino" -> cap += 1;
                            case "Espresso" -> es += 1;
                            default -> lat += 1;
                        }
                    }else{
                            System.out.println(" It is not in stock ");
                        }
                    } else {
                        System.out.println(" Client doesn't have enough coins");
                    }
                }
            }
            monthSum += daySum;
            System.out.println("---------------");
            if (i % 30 == 0) {
                System.out.println();
                company.setTotalEarn(company.getTotalEarn() + monthSum);
                System.out.println("++++++++++++++++++++++++++");
                System.out.println(i / 30 + ". Month");
                System.out.println("The monthly gross income: " + monthSum);
                float med = monthSum / 30.f;
                double expendCoffee = (es + cap + am + lat) * espresso.getPrice() * 0.3;
                double expendMilk = (cap + lat) * latte.getPrice() * 0.3;
                double expendVegMilk = veg * 5 * 0.3;
                double sum1 = expendMilk + expendCoffee + expendVegMilk;
                double sum2 = barista.getSalary() + manager.getSalary();
                System.out.println("The daily average income: " + med);
                Map<Integer, String> stringIntegerMap = new HashMap<>();
                stringIntegerMap.put(am, "Americano");
                stringIntegerMap.put(cap, "Cappuccino");
                stringIntegerMap.put(es, "Espresso");
                stringIntegerMap.put(lat, "Latte");

                System.out.println("Coffee price: " + expendCoffee);
                System.out.println("Milk price: " + expendMilk);
                System.out.println("Veg milk: " + expendVegMilk);
                System.out.println("Total expenses: " + sum1);
                System.out.println("Staff salary: " + sum2);
                income = monthSum - (sum1 + sum2);
                clearIncome += income;
                System.out.println("Monthly net income: " + income);
                System.out.println("Espresso " + es);
                System.out.println("Americano " + am);
                System.out.println("Cappuccino " + cap);
                System.out.println("Latte " + lat);
                companyCoffee.put(americano, 100);
                companyCoffee.put(espresso, 100);
                companyCoffee.put(cappuccino, 80);
                companyCoffee.put(latte, 80);
                company.setCompanyCoffee(companyCoffee);

                List<Integer> integers = new ArrayList<>(List.of(es, am, cap, lat));
                Integer max = integers.stream().max(Integer::compareTo).orElseThrow();
                Integer min = integers.stream().min(Integer::compareTo).orElseThrow();
                String s1 = stringIntegerMap.get(max);
                String s2 = stringIntegerMap.get(min);
                barista.setExperience(barista.getExperience() + 1);
                manager.setExperience(barista.getExperience() + 1);
                System.out.println("Max: " + s1);
                System.out.println("Min: " + s2);
                switch (s1) {
                    case "Americano" -> americano.setPrice(americano.getPrice() + 5);
                    case "Cappuccino" -> cappuccino.setPrice(cappuccino.getPrice() + 5);
                    case "Espresso" -> espresso.setPrice(espresso.getPrice() + 5);
                    default -> latte.setPrice(latte.getPrice() + 5);
                }
                switch (s2) {
                    case "Americano" -> americano.setPrice(americano.getPrice() - 5);
                    case "Cappuccino" -> cappuccino.setPrice(cappuccino.getPrice() - 5);
                    case "Espresso" -> espresso.setPrice(espresso.getPrice() - 5);
                    default -> latte.setPrice(latte.getPrice() - 5);
                }
                System.out.println("Americano price: " + americano.getPrice());
                System.out.println("Espresso price: " + espresso.getPrice());
                System.out.println("Cappuccino price: " + cappuccino.getPrice());
                System.out.println("Latte price: " + latte.getPrice());
                totalSum += monthSum;
                monthSum = 0;
                es = 0;
                am = 0;
                cap = 0;
                lat = 0;
                veg = 0;
                System.out.println("++++++++++++++++++++++++++");

                //Stop & Final Function
                System.out.print("Tap \"end\" to finish: ");
                stop = scanner.next();
                if (stop.equals("end")) {
                    System.out.println("*************************************************");
                    System.out.println("The total income: " + totalSum);
                    System.out.println("The month income: " + totalSum / (i / 30));
                    System.out.println("The Company income: " + clearIncome);

                    System.out.println("*************************************************");
                    a = false;
                }
            }
        }
    }
}