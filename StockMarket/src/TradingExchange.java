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

    private static int count = 0;
    int exchangeID;
    ExchangeType type;
    int stockMarketID;

    /**
     * Constructs the trading exchange
     * @param type The type of trading exchange.
     * @param stockMarketID The stockmarket ID.
     */
    public TradingExchange(ExchangeType type, int stockMarketID) {
        setExchangeID(++count);
        this.type = type;
        this.stockMarketID = stockMarketID;
    }
    
    /**
     * Sets the exchangeID
     * @param exchangeID The exchangeID
     */
    public void setExchangeID(int exchangeID) {
        this.exchangeID = exchangeID;
    }

    /**
     * Retrives the trading exchange ID.
     * @return The exchange ID.
     */
    public int getExchangeId() {
        return this.exchangeID;
    }

    /**
     * Retrieves the type of trading exchange
     * @return The type of trading exchange.
     */
    public ExchangeType getType() {
        return this.type;
    }

    /**
     * Sets the type of the exchange
     * @param type The type of exchange.
     */
    public void setType(ExchangeType type) {
        this.type = type;
    }

    /**
     * Gets the stockmarketID
     * @return The stock market ID.
     */
    public int getStockMarketID() {
        return this.stockMarketID;
    }
    
    /**
     * Sets the stockmarketID
     * @param stockMarketID The stock market ID.
     */
    public void setStockMarketID (int stockMarketID) {
        this.stockMarketID = stockMarketID;
    }

}
