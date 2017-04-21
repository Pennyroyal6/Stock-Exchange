
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JoeThompson
 */
public class Trader {

    private static int count = 0;
    int traderID;
    String name;
    boolean licence;
    String company;
    ArrayList<Client> clients;
    TraderType type;

    ArrayList<Portfolio> portfolios;
    Stock s;
    double e;
    Portfolio p;
    Portfolio current;
    //think we may need a variable for mode - confirm

    /**
     * Constructs intelligent trader
     *
     * @param name The trader's name.
     * @param licence The trader's licence.
     * @param company The trader's company who they work for.
     * @param type The type of trader.
     */
    public Trader(String name, boolean licence, String company, TraderType type) {
        setTraderID(++count);
        this.name = name;
        this.licence = licence;
        this.company = company;
        this.type = type;
        clients = new ArrayList<Client>();
    }

    /**
     * Sets the traderID
     *
     * @param traderID the trader's traderID.
     */
    public void setTraderID(int traderID) {
        this.traderID = traderID;
    }

    /**
     * Returns traders traderID
     *
     * @return The trader's traderID.
     */
    public int getTraderID() {
        return this.traderID;
    }

    /**
     * Checks if trader has a licence
     *
     * @return If trader has licence.
     */
    public boolean checkLicence() {
        return this.licence;
    }

    /**
     * Changes trader's current portfolio
     *
     * @param portfolio The portfolio to change to.
     */
    public void changePortfolio(Portfolio portfolio) {
        current = portfolio;
    }

    /**
     * Sells stock on exchange
     *
     * @param stock The stock to be sold on the exchange.
     */
    public void sellOnExchange(Stock stock) {

    }

    /**
     * Buys stock on exchange
     *
     * @param stock The stock to be bought on the exchange.
     */
    public void buyOnExchange(Stock stock) {

    }

    /**
     * Sets trader's mode
     */
    public void setMode() {

    }

    /**
     * Retrieves the trader's mode
     */
    public void getMode() {

    }

    /**
     * Adds a client to the trader
     *
     * @param client The client to be added.
     */
    public void addClient(Client client) {
        clients.add(client);
    }

    /**
     * Removes client to the trader
     *
     * @param client The client to be removed
     */
    public void removeClient(Client client) {
        clients.remove(client);
    }

    public TraderType getType() {
        return this.type;
    }

    /**
     * Adds a portfolio to the trader
     *
     * @param portfolio The portfolio to be added
     */
    public void addPortfolio(Portfolio portfolio) {
        portfolios.add(portfolio);
    }

    /**
     * Removes a portfolio from the trader
     *
     * @param portfolio The portfolio to be removed
     */
    public void removePortfolio(Portfolio portfolio) {
        portfolios.remove(portfolio);
    }

    /**
     * Simulates the balanced random trader
     */
    public void balanced() {
        int total = getTotalAssets();
        double d = Math.random();               // generates value between 0 & 1
        e = total * d;                                       // holds % value of available assets
        // Selling stocks
        for (int i = 0; i < randInt(1, 10); i++) {               // picks random number of portfolios
            p = portfolios.get(randInt(1, 15));       // picks random portfolio
            for (int j = 0; j < randInt(1, 25); j++) {           // picks random number of stocks to sell
                s = p.stocks.get(randInt(1, 100));                      // picks random stock
                sellStock();
            }
        }
        // Buying stocks
        for (int i = 0; i < randInt(1, 10); i++) {               // picks random number of portfolios
            p = portfolios.get(randInt(1, 15));       // picks random portfolio
            for (int j = 0; j < randInt(1, 50); j++) {           // picks random number of stocks to buy
                s = p.stocks.get(randInt(1, 100));                      // picks random stock
                buyStock();
            }
        }
    }

    /**
     * Simulates the aggressive purchaser
     */
    public void aggressivePurchaser() {
        int total = getTotalAssets();
        double d = Math.random() * 0.5;               // generates value between 0 & 0.5
        e = total * d;                                       // holds % value of available assets
        // Selling stocks
        for (int i = 0; i < randInt(1, 10); i++) {               // picks random number of portfolios
            p = portfolios.get(randInt(1, 15));       // picks random portfolio
            for (int j = 0; j < randInt(1, 25); j++) {           // picks random number of stocks to sell
                s = p.stocks.get(randInt(1, 100));                      // picks random stock
                sellStock();
            }
        }
        // Buying stocks
        d = Math.random() * 2;               // generates value between 0 & 2
        e = total * d;                                       // holds % value of available assets
        for (int i = 0; i < randInt(1, 10); i++) {               // picks random number of portfolios
            p = portfolios.get(randInt(1, 15));       // picks random portfolio
            for (int j = 0; j < randInt(1, 50); j++) {           // picks random number of stocks to buy
                s = p.stocks.get(randInt(1, 100));                      // picks random stock
                buyStock();
            }
        }
    }

    /**
     * Simulates the aggressive seller
     */
    public void aggressiveSeller() {
        int total = getTotalAssets();
        double d = Math.random() * 2;               // generates value between 0 & 2
        e = total * d;                                       // holds % value of available assets
        // Selling stocks
        for (int i = 0; i < randInt(1, 10); i++) {               // picks random number of portfolios
            p = portfolios.get(randInt(1, 15));       // picks random portfolio
            for (int j = 0; j < randInt(1, 25); j++) {           // picks random number of stocks to sell
                s = p.stocks.get(randInt(1, 100));                      // picks random stock
                sellStock();
            }
        }
        // Buying stocks
        d = Math.random() * 0.5;               // generates value between 0 & 0.5
        e = total * d;                                       // holds % value of available assets
        for (int i = 0; i < randInt(1, 10); i++) {               // picks random number of portfolios
            p = portfolios.get(randInt(1, 15));       // picks random portfolio
            for (int j = 0; j < randInt(1, 50); j++) {           // picks random number of stocks to buy
                s = p.stocks.get(randInt(1, 100));                      // picks random stock
                buyStock();
            }
        }
    }

    /**
     * Recursive method for selling stocks
     */
    public void sellStock() {
        if (s.getValueOfStock() > e) {                         // checks if stock value is valid
            s = p.stocks.get((randInt(1, 100)));
            sellStock();
        } else {
            sellOnExchange(s);
        }
    }

    /**
     * Recursive method for buying stocks
     */
    public void buyStock() {
        if (s.getValueOfStock() > e) {                         // checks if stock value is valid
            s = p.stocks.get((randInt(1, 100)));
            buyStock();
        } else {
            buyOnExchange(s);
        }
    }

    /**
     * Generates a random integer between two bounds (the bounds can also be
     * output)
     *
     * @param min - the lowest possible value
     * @param max - the highest possible value
     * @return randomly generated number
     */
    public static int randInt(int min, int max) {
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     * Gets the total available assets to the trader across all portfolios that
     * the trader is listed as a part of
     *
     * @return - the total available assets
     */
    public int getTotalAssets() {
        int total = 0;
        for (Portfolio p : portfolios) {
            total += p.getTotalStockValue();
            total += p.getMoney();
        }
        return total;
    }

}
