package market.service.impl;

import market.classes.Buyer;
import market.classes.Market;
import market.enums.Gender;
import market.enums.Products;
import market.service.BuyerService;

import java.util.*;

public class BuyerServiceImpl implements BuyerService {

    List<Market> marketList = new ArrayList<>();
    List<Buyer> buyerList = new ArrayList<>();

    @Override
    public String createBuyer() {
        try {
            System.out.print("Buyer Name : ");
            String buyerName = new Scanner(System.in).nextLine();
            if (buyerName.isEmpty()) throw new Exception("Buyer name can't be Empty.");

            System.out.print("Buyer gender : ");
            String gender = new Scanner(System.in).nextLine().toUpperCase();
            if (gender.isEmpty()) throw new Exception("Buyer gender can't be Empty.");

            System.out.print("Buyer phone number : ");
            String phoneNumber = new Scanner(System.in).nextLine();
            if (phoneNumber.isEmpty()) throw new Exception("Buyer phone number can't be Empty.");

            System.out.print("Buyer Money : ");
            int money = new Scanner(System.in).nextInt();
            if (money <= 0) throw new Exception("Buyer money can't be 0 and minus.");

            Set<String> buyerSet = new TreeSet<>();
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a products that you want to buy: ");
                String pro = scanner.nextLine();
                buyerSet.add(pro);
                if (pro.length() == 0) {
                    break;
                }
            }

            Buyer buyer = new Buyer(buyerName, Gender.valueOf(gender), phoneNumber, money, buyerSet);

            buyerList.add(buyer);

        } catch (Exception e) {
            System.err.println("Wrong input!");
        }
        return "Created successfully!!!";
    }

    @Override
    public String createMarket() {
        try {
            System.out.print("Market Name : ");
            String marketName = new Scanner(System.in).nextLine();
            if (marketName.isEmpty()) throw new Exception("Market name can't be Empty.");

            System.out.print("Enter market's address : ");
            String address = new Scanner(System.in).nextLine();
            if (address.isEmpty()) throw new Exception("Address can't be Empty.");

            System.out.print("Enter E-mail: ");
            String eMail = new Scanner(System.in).nextLine();
            if (eMail.isEmpty()) throw new Exception("E-mail can't be Empty.");

            System.out.print("Enter phone number: ");
            String phoneNumber = new Scanner(System.in).nextLine();

            System.out.print("Enter INN  of market's: ");
            long inn = new Scanner(System.in).nextLong();
            if (inn < 13) throw new Exception("Invalid INN ");

            System.out.print("Enter Web-Site: ");
            String webSite = new Scanner(System.in).nextLine();
            if (webSite.isEmpty()) throw new Exception("Website Empty.");

            List<Products> productsList = new ArrayList<>(List.of(Products.values()));
            List<Products> check = new ArrayList<>();
            int budget = 0;

            Market market1 = new Market(marketName, address, eMail, phoneNumber, inn, webSite, productsList, check, budget);

            marketList.add(market1);

            return "Market created successfully!";

        } catch (Exception e) {
            System.err.println("Wrong input!");
        }
        return "Market not created!";
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerList;
    }

    @Override
    public List<Market> getAllMarkets() {
        return marketList;
    }

    @Override
    public List<Products> searchProductByName() {
        List<Products> results = new ArrayList<>();
        try {
            System.out.print("Enter a market name : ");
            String marketName = new Scanner(System.in).nextLine().toLowerCase();
            if (marketName.isEmpty()) throw new Exception("Market name can't be Empty.");

            for (Market market : marketList) {
                if (market.getName().toLowerCase().equals(marketName)) {
                    System.out.print("Enter a product name : ");
                    String productName = new Scanner(System.in).nextLine().toLowerCase();
                    if (productName.isEmpty()) throw new Exception("Product name can't be Empty.");

                    for (Products product : market.getProducts()) {
                        if (product.name().toLowerCase().contains(productName)) results.add(product);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong input!");
        }
        return results;
    }

    @Override
    public List<Products> getProducts() {
        return List.of(Products.values());
    }

    @Override
    public Market findMarketByName() {
        try {
            System.out.print("Enter a market name : ");
            String marketName = new Scanner(System.in).nextLine().toUpperCase();
            if (marketName.isEmpty()) throw new Exception("Market name can't be Empty.");

            for (Market market : marketList) {
                if (market.getName().toUpperCase().equals(marketName)) {
                    return market;
                }
            }
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        return null;
    }

    @Override
    public List<Products> getMarketProducts() {
        try {
            System.out.print("Enter a Market name : ");
            String marketName = new Scanner(System.in).nextLine().toLowerCase();
            if (marketName.isEmpty()) throw new Exception("Market name can't be Empty.");

            for (Market market : marketList) {
                if (market.getName().toLowerCase().equals(marketName)) return market.getProducts();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Market findMarketByWebSite() {
        try {
            System.out.print("Enter a market website : ");
            String website = new Scanner(System.in).nextLine().toUpperCase();

            for (Market market : marketList) {
                if (market.getWebSite().toUpperCase().equals(website)) {
                    return market;
                }
            }
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        return null;
    }

    @Override
    public Buyer findBuyerByName() {
        try {
            System.out.print("Enter a name : ");
            String name = new Scanner(System.in).nextLine().toUpperCase();

            for (Buyer buyer : buyerList) {
                if (buyer.getName().toUpperCase().equals(name)) {
                    return buyer;
                }
            }
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        return null;
    }


    public String PrinterCheck(String buyerName, String marketName, List<Products> products, double totalPrice) {
        return ">>>>>>>>>>   Check   <<<<<<<<<< \n" +
                " *** Customer : " + buyerName + "\n" +
                " *** Market : " + marketName + "\n" +
                " *** Product List : " + products + "\n" +
                "\n *** Total Price :       " + totalPrice + " SOM\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "<<<<<<           THANK YOU!        >>>>>>\n\n";

    }


    @Override
    public String buyProducts() {
        String check;
        try {
            System.out.print("Enter your name : ");
            String name = new Scanner(System.in).nextLine().toLowerCase();
            if (name.isEmpty()) throw new Exception("Username can't be Empty.");

            System.out.print("Enter your phone number : ");
            String phoneNumber = new Scanner(System.in).nextLine();
            if (phoneNumber.isEmpty()) throw new Exception("Phone number can't be Empty.");

            for (Buyer buyer : buyerList) {
                if (buyer.getName().toLowerCase().equals(name) && buyer.getPhoneNumber().equals(phoneNumber)) {
                    System.out.print("Enter a market name : ");
                    String marketName = new Scanner(System.in).nextLine().toLowerCase();
                    if (marketName.isEmpty()) throw new Exception("Market name can't be empty.");

                    for (Market market : marketList) {
                        if (market.getName().toLowerCase().equals(marketName)) {
                            List<String> discounted = new ArrayList<>();

                            morewhile:
                            while (true) {
                                for (Products product : market.getProducts()) {
                                    System.out.println(product.name() + " : " + product.getPrice() + " SOM.");
                                }
                                System.out.print("Choose your product : ");
                                String productName = new Scanner(System.in).nextLine().toUpperCase();
                                System.out.print("How much? : ");
                                Scanner scanner = new Scanner(System.in);
                                byte howMuch = scanner.nextByte();
                                if (howMuch <= 0) {
                                    throw new Exception("Choose 1 or more!");
                                }
//                                byte howMuch = new Scanner(System.in).nextByte();

                                for (Products product : market.getProducts()) {
                                    if (product.name().toUpperCase().equals(productName)) {
                                        market.getCheck().add(product);
                                    }
                                }
                                if (productName.isEmpty()) throw new Exception("Product name Empty.");
                                if (productName.equals("END")) break morewhile;
                                if (productName.equals("CHECK")) {
                                    System.out.println("  Your chek : ");
                                    double totalPrice = 0;
                                    for (Products product : market.getCheck()) {
                                        double price = product.getPrice();
                                        totalPrice += price * howMuch;
                                    }

                                    buyer.setMoney(buyer.getMoney() - totalPrice);
                                    market.setBudget((int) totalPrice);
                                    check = PrinterCheck(buyer.getName(), market.getName(), market.getCheck(), totalPrice);

                                    return check;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Not found, Shopping failed!");
        }
        return null;
    }

    @Override
    public double showBuyerMoney() {
        try {
            System.out.print("Enter a name : ");
            String name = new Scanner(System.in).nextLine().toUpperCase();

            for (Buyer buyer : buyerList) {
                if (buyer.getName().toUpperCase().equals(name)) {
                    System.out.println("  " + buyer.getName() + "'s Money is :");
                    return buyer.getMoney();
                }
            }
        } catch (Exception e) {
            System.out.println("Not found!");
        }
        return 0;
    }
}
