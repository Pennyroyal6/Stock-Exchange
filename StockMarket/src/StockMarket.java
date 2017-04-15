/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JoeThompson
 */
public class StockMarket {
    
    int marketID;
    int index;
    MarketType status;
    
    
    public StockMarket (int marketID) {
        status = MarketType.Stable;
        index = 0;
        this.marketID = marketID;
    }
    
    public int getMarketID() {
        return this.marketID;
    }
    
    public int setIndex() {
        return 0; //needs to be implemented
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public MarketType getMarketStatus() {
        return this.status;
    }
    
    public void setMarketStatus(MarketType status) {
        this.status = status;
    }
    
}
