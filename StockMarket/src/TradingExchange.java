/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JoeThompson
 */
public class TradingExchange {

    int exchangeID;
    ExchangeType type;
    int stockMarketID;

    public TradingExchange(int exchangeID, ExchangeType type, int stockMarketID) {
        this.type = type;
        this.exchangeID = exchangeID;
        this.stockMarketID = stockMarketID;
    }

    public int getExchangeId() {
        return this.exchangeID;
    }

    public ExchangeType getType() {
        return this.type;
    }

    public void setType(ExchangeType type) {
        this.type = type;
    }

    public int getStockMarketID() {
        return this.stockMarketID;
    }
    
    public void setStockMarketID (int stockMarketID) {
        this.stockMarketID = stockMarketID;
    }

}
