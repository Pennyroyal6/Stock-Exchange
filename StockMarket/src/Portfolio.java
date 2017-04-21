
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JoeThompson
 */
public class Portfolio {

    private static int count = 0;
    int portfolioID;
    Client client;
    int money;
    ArrayList<Stock> stocks;

    /**
     * Constructs a portfolio
     *
     * @param client The client the portfolio belongs to.
     */
    public Portfolio(Client client) {
        setPortfolioID(++count);
        this.client = client;
        client.setPortfolio(this);
        money = 0;
        stocks = new ArrayList<Stock>();
    }

    /**
     * Sets the portfolioID
     *
     * @param portfolioID The portfolioID.
     */
    public void setPortfolioID(int portfolioID) {
        this.portfolioID = portfolioID;
    }

    /**
     * Checks the clientID
     *
     * @return The clientID.
     */
    public int checkClientID() {
        return client.clientID;
    }

    /**
     * Checks the client's name
     *
     * @return The client's name.
     */
    public String checkClientName() {
        return client.clientName;
    }

    /**
     * Adds stock the the portfolio
     *
     * @param stock The stock to be added to the portfolio.
     */
    public void addStock(Stock stock) {
        stocks.add(stock);
        stock.setOwnedBy(client);
    }

    /**
     * Removes stock from the portfolio
     *
     * @param stock The stock to be removed from the portfolio.
     */
    public void deleteStock(Stock stock) {
        stocks.remove(stock);
    }

    /**
     * Adds money to the portfolio
     *
     * @param money The money to be added to the portfolio.
     */
    public void addMoney(int money) {
        if (checkPositiveValue(money)) {
            this.money += money;
        }
    }

    /**
     * Removes money to the portfolio
     *
     * @param money The money to be removed from the portfolio.
     */
    public void removeMoney(int money) {
        if (checkPositiveValue(money)) {
            int oldMoneyValue = this.money;
            this.money -= money;
            if (this.money < 0) {
                this.money = oldMoneyValue;
                System.out.println("Cannot not have a negative money amount.");
            }
        }
    }

    /**
     * Retrieves the portfolio's money portion
     *
     * @return The portfolio's money.
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Checks if the value passed in is positive or not
     * @param value The value to check if it's positive.
     * @return If value is greater than zero.
     */
    public boolean checkPositiveValue(int value) {
        return value > 0;
    }

}
