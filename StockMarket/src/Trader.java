/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JoeThompson
 */
public interface Trader {
    
    public int getTraderID();
    
    public boolean checkLicence();
    
    public void changePortfolio(Portfolio portfolio);
    
    public void sellOnExchange(Stock stock);
    
    public void buyOnExchange(Stock stock);
    
    public void setMode();
    
    public void getMode();
    
}
