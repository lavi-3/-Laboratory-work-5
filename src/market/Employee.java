package market;

public abstract class Employee {
    private boolean works;
    private int salary;
    private int experience;

    public Employee(boolean works, int salary, int experience) {
        this.works = works;
        this.salary = salary;
        this.experience = experience;
    }

    public boolean isWorks() {
        return works;
    }

    public void setWorks(boolean works) {
        this.works = works;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
