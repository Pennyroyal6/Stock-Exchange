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
    
    private static int count = 0;
    int marketID;
    int index;
    MarketType status;
    
    /**
     * Construct a stock market
     */
    public StockMarket() {
        setMarketID(++count);
        status = MarketType.Stable;
        index = 0;
    }
    
    /**
     * Sets marketID
     * @param marketID The marketID. 
     */
    public void setMarketID(int marketID) {
        this.marketID = marketID;
    }
    
    /**
     * Returns the stockmarket ID.
     * @return The stockmarket ID.
     */
    public int getMarketID() {
        return this.marketID;
    }
    
    /**
     * Sets the stock market index
     * @return Stock market index.
     */
    public int setIndex() {
        return 0; //needs to be implemented
    }
    
    /**
     * Returns stock market index
     * @return The stock market index.
     */
    public int getIndex() {
        return this.index;
    }
    
    /**
     * Retrieve the status of the stock market
     * @return The status of the stock market.
     */
    public MarketType getMarketStatus() {
        return this.status;
    }
    
    /**
     * Sets the market status 
     * @param status The status of the market
     */
    public void setMarketStatus(MarketType status) {
        this.status = status;
    }
    
}
