
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
    
    int portfolioID;
    Client client;
    int money;
    ArrayList<Stock> stocks;
    
    public Portfolio(int portfolioID, Client c) {
        this.portfolioID = portfolioID;
        this.client = client;
        money = 0;
        stocks = new ArrayList<Stock>();
    }
    
    public int checkClientID() {
        return client.clientID;
    }
    
    public String checkClientName() {
        return client.clientName;
    }
    
    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    
    public void deleteStock(Stock stock) {
        stocks.remove(stock);
    }
    
    public void addMoney(int money) {
        money += money;
    }
    
    public void removeMoney(int money) {
        money -= money;
    }
    
    public int getMoney() {
        return this.money;
    }

}
