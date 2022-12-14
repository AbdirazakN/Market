import market.service.impl.BuyerServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BuyerServiceImpl buyerService = new BuyerServiceImpl();

        while (true) {
            System.out.println("""
                    ~~~~~~~~~  Commands  ~~~~~~~~~~
                    ***  1 - Create buyer
                    ***  2 - Create market
                    ***  3 - Get all buyer
                    ***  4 - Get all market
                    ***  5 - Search Product By Name
                    ***  6 - Get products
                    ***  7 - Find Market By Name
                    ***  8 - Buy products
                    ***  9 - Find market by website
                    ***  10 - Find buyer by name
                    ***  11 - Show buyer's money
                        <0> - Stop command.
                    Enter...""");
            int command = new Scanner(System.in).nextInt();
            switch (command) {
                case 1:
                    System.out.println(buyerService.createBuyer());
                    break;
                case 2:
                    System.out.println(buyerService.createMarket());
                    break;
                case 3:
                    System.out.println(buyerService.getAllBuyers());
                    break;
                case 4:
                    System.out.println(buyerService.getAllMarkets());
                    break;
                case 5:
                    System.out.println(buyerService.searchProductByName());
                    break;
                case 6:
                    System.out.println(buyerService.getProducts());
                    break;
                case 7:
                    System.out.println(buyerService.findMarketByName());
                    break;
                case 8:
                    System.out.println(buyerService.buyProducts());
                    break;
                case 9:
                    System.out.println(buyerService.findMarketByWebSite());
                    break;
                case 10:
                    System.out.println(buyerService.findBuyerByName());
                    break;
                case 11:
                    System.out.println(buyerService.showBuyerMoney());
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;
                case 0:
                    System.out.println("Program finished!");
                    return;

            }
        }
    }
}
