
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
        if (checkPositiveValue(portfolioID)) {
            this.portfolioID = portfolioID;
        }
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
     * @param quantity The quantity of stock added.
     */
    public void addStock(Stock stock, int quantity) {
        if (checkPositiveValue(quantity)) {
            stocks.add(stock);
            stock.quantity += quantity;
        }
    }

    /**
     * Removes stock from the portfolio
     *
     * @param stock The stock to be removed from the portfolio.
     * @param quantity The quantity of stock removed
     */
    public void deleteStock(Stock stock, int quantity) {
        if (checkPositiveValue(quantity)) {
            stocks.remove(stock);
            stock.quantity -= quantity;
        }
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
     *
     * @param value The value to check if it's positive.
     * @return If value is greater than zero.
     */
    public boolean checkPositiveValue(int value) {
        return value > 0;
    }

    /**
     * Gets the value of all of the stock held on the portfolio
     *
     * @return sum of the value of all stocks held
     */
    public int getTotalStockValue() {
        int total = 0;
        for (Stock s : stocks) {
            total += s.getValueOfStock();
        }
        return total;
    }

}
