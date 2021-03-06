/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Stock {

    private static int count = 0;
    int stockID;
    String companyName;
    double price;
    boolean tradeable = false;
    int quantity;
    public int sharesOffered;
    StockType type;

    /**
     * Construct stock
     *
     * @param companyName The company the stock belongs to.
     * @param price The price of the stock.
     */
    public Stock(String companyName, StockType type, double price, int sharesOffered) {
        if (companyName.length() > 0 && price > 0 && checkPositiveValue(sharesOffered)) {
            setStockID(++count);
            this.companyName = companyName;
            this.type = type;
            this.price = price;
            this.tradeable = true;
            this.sharesOffered = sharesOffered;
        }
    }

    /**
     * Sets the stockID
     *
     * @param stockID The stockID.
     */
    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    /**
     * Increase value of the stock
     *
     * @param value The value to increase the stock by.
     */
    public void increaseValue(int value) {
        if (tradeable) {
            if (checkPositiveValue(value)) {
                price += value;
            }
        }
    }

    /**
     * Decrease value of the stock
     *
     * @param value The value to decrease the stock by.
     */
    public void decreaseValue(int value) {
        if (tradeable) {
            if (checkPositiveValue(value)) {
                price -= value;
            }
            if (this.price <= 0) {
                makeStockUntradeable();
                this.price = 0;
            }
        }
    }

    /**
     * Retrieve the value of the stock
     *
     * @return The value of the stock.
     */
    public double getValueOfStock() {
        return price;
    }

    /**
     * Retrieve the company the stock retrieves
     *
     * @return The company name.
     */
    public String getCompanyStockRepresents() {
        return companyName;
    }

    /**
     * Sets company stock's name
     *
     * @param companyName The company name of the stock.
     */
    public void setCompanyStockReperesents(String companyName) {
        if (companyName.length() > 0) {
            this.companyName = companyName;
        }
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
     * Makes the stock untradeable
     */
    public void makeStockUntradeable() {
        this.tradeable = false;
    }

    /**
     * Changes the type of the stock
     *
     * @param type The type the stock will be changed to.
     */
    public void changeStockType(StockType type) {
        this.type = type;
    }

    /**
     * Returns the type of stock
     *
     * @return The type of the stock.
     */
    public StockType getStockType() {
        return this.type;
    }

    /**
     * Retrieves stockID
     *
     * @return The stockID.
     */
    public int getStockID() {
        return stockID;
    }

    /**
     * Sets the type of stock
     *
     * @param type The type of stock.
     */
    public void setType(StockType type) {
        this.type = type;
    }

    /**
     * Sets the price of the stock
     *
     * @param price The price of the stock.
     */
    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    /**
     * Sets the amount of stocks offered
     *
     * @param quantity The quantity of the stock offered.
     */
    public void setSharesOffered(int quantity) {
        if (checkPositiveValue(quantity)) {
            this.sharesOffered = quantity;
        }
    }

}
