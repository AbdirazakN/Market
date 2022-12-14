package market.enums;

public enum Products {
    BREAD("Bread", 25.00),
    MILK("Milk", 50.90),
    EGG("Egg", 10.20),
    SAUSAGE("Sausage", 120.50),
    WATER("Water", 45.10),
    SULTAN_CHAI("Sultan chai", 45.00),
    MOLOKO("Moloko", 70.23),
    KEFIR("Kefir", 80.30),
    SALT("Salt", 15.40),
    SUGAR("Suger", 85.12),
    BUTTER("Butter", 40.20),
    HONEY("Honey", 150.60),
    ICECREAM("Icecream", 15.00),
    POTATOES("Potatoes", 23.80),
    ONION("Onion", 30.60),
    CARROT("Carrot", 26.46);

    private final String product;
    private final double price;

    private Products(String product, double price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return String.format("\n-- Product:  " + product + " --> Price: " + price + " --");
    }
}
