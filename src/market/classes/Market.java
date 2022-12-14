package market.classes;

import market.enums.Products;

import java.util.List;

public class Market {
    private String name;
    private String address;
    private String eMail;
    private String phoneNumber;
    private long inn;
    private String webSite;
    private List<Products> products;
    private List<Products> check;
    private int budget;


    public Market(String name, String address, List<Products> products, List<Products> check, int budget) {
        this.name = name;
        this.address = address;
        this.products = products;
        this.check = check;
        this.budget = budget;
    }

    public Market(String name, String address, String eMail, String phoneNumber, long inn, String webSite, List<Products> products, List<Products> check, int budget) {
        this.name = name;
        this.address = address;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.inn = inn;
        this.webSite = webSite;
        this.products = products;
        this.check = check;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Products> getCheck() {
        return check;
    }

    public void setCheck(List<Products> check) {
        this.check = check;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "\n>>>>>> Market   " +
                "\nName:          " + name +
                "\nAddress:       " + address +
                "\nPhone Number:  " + phoneNumber +
                "\nE-mail:        " + eMail +
                "\nINN:           " + inn +
                "\nWeb-Site:      " + webSite +
                "\nProducts:      " + products +
                "\nBudget:        " + budget;
    }
}
