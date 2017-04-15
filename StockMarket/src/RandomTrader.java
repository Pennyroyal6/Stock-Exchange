/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JoeThompson
 */
public class RandomTrader implements Trader {
    
    int traderID;
    String name;
    boolean licence;
    String company;
    //think we may need a variable for mode - confirm
    
    public RandomTrader(int traderID, String name, boolean licence, String company) {
        this.traderID = traderID;
        this.name = name;
        this.licence = licence;
        this.company = company;
    }

    @Override
    public int getTraderID() {
        return this.traderID;
    }

    @Override
    public boolean checkLicence() {
        return this.licence;
    }

    @Override
    public void changePortfolio(Portfolio portfolio) {
        
    }

    @Override
    public void sellOnExchange(Stock stock) {
        
    }

    @Override
    public void buyOnExchange(Stock stock) {
        
    }

    @Override
    public void setMode() {
        
    }

    @Override
    public void getMode() {
        
    }
    
}
