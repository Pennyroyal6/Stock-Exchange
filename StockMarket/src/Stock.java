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
    Client client;

    /**
     * Construct stock
     * @param companyName The company the stock belongs to.
     * @param price The price of the stock.
     */
    public Stock(String companyName, int price) {
        setStockID(++count);
        this.companyName = companyName;
        this.price = price;
        if(price > 0) {
            tradeable = true;
        }
    }
    
    /**
     * Sets the stockID
     * @param stockID The stockID.
     */
    public void setStockID(int stockID) {
        this.stockID = stockID;
    }

    /**
     * Increase value of the stock
     * @param value The value to increase the stock by.
     */
    public void increaseValue(int value) {
        if(checkPositiveValue(value)) {
            price += value;
        }     
    }

    /**
     * Decrease value of the stock
     * @param value The value to decrease the stock by.
     */
    public void decreaseValue(int value) {
        if(checkPositiveValue(value)) {
           price -= value; 
        }
        if(this.price <= 0) {
            makeStockUntradeable();
        }
    }
    
    /**
     * Retrieve the value of the stock
     * @return The value of the stock.
     */
    public double getValueOfStock(){
        return price;
    }

    /**
     * Retrieve the company the stock retrieves
     * @return The company name.
     */
    public String getCompanyStockRepresents() {
        return companyName;
    }
    
    /**
     * Sets company stock's name
     * @param companyName The company name of the stock.
     */
    public void setCompanyStockReperesents(String companyName) {
        this.companyName = companyName;
    }
    
    /**
     * Sets who owns the stock
     * @param client The client to own the stock.
     */
    public void setOwnedBy(Client client) {
        this.client = client;
    }

    /**
     * Returns who owns the stock
     * @return The client who owns the stock.
     */
    public String getOwnedBy() {
        return client.clientName;
    }
    
    /**
     * Checks if the value passed in is positive or not
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
}
