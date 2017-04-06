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

    int companyStockRepresents;
    int valueOfStock;
    String ownedBy;
    Company c;

    public Stock(int value) {
        companyStockRepresents = c.getCompanyID();
        valueOfStock = value;
        ownedBy = null;         // verify     
    }

    public void increaseValue(int value) {
        valueOfStock += value;
    }

    public void decreaseValue(int value) {
        valueOfStock -= value;
    }
    
    public int getValueOfStock(){
        return valueOfStock;
    }

    public int getCompanyStockRepresents() {
        return companyStockRepresents;
    }

    public String getOwnedBy() {
        return ownedBy;
    }
}
