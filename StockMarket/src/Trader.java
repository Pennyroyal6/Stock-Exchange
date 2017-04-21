import java.util.ArrayList;
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
    
}

