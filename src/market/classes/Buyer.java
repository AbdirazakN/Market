package market.classes;

import market.enums.Gender;

import java.util.Set;

public class Buyer {
    private String name;
    private Gender gender;
    private String phoneNumber;
    private double money;
    private Set<String> products;

    public Buyer(String name, Gender gender, String phoneNumber, double money, Set<String> products) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.money = money;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<String> getProducts() {
        return products;
    }

    public void setProducts(Set<String> products) {
        this.products = products;
    }


    @Override
    public String toString() {
        return "\n>>>> Buyer            " +
                "\nName:                " + name +
                "\nPhone Number:        " + phoneNumber +
                "\nGender:              " + gender +
                "\nMoney:               " + money +
                "\nProducts that I buy: " + products;

    }
}
