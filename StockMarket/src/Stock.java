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
    int stockID;
    String companyName;
    int price;
    Client c;

    public Stock(int stockID, String companyName, int price) {
        this.stockID = stockID;
        this.companyName = companyName;
        this.price = price;
    }

    public void increaseValue(int value) {
        price += value;
    }

    public void decreaseValue(int value) {
        price -= value;
    }
    
    public int getValueOfStock(){
        return price;
    }

    public String getCompanyStockRepresents() {
        return companyName;
    }
    
    public void setCompanyStockReperesents(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnedBy() {
        return c.clientName;
    }
}
