package market.service;

import market.classes.Buyer;
import market.classes.Market;
import market.enums.Products;

import java.util.List;
import java.util.Set;

public interface BuyerService {
    String createBuyer();

    String createMarket();

    List<Buyer> getAllBuyers();

    List<Market> getAllMarkets();

    List<Products> searchProductByName();

    List<Products> getProducts();

    Market findMarketByName();

    List<Products> getMarketProducts();

    Market findMarketByWebSite();

    Buyer findBuyerByName();

    String buyProducts();

    double showBuyerMoney();
}
