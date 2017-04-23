/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Client {

    private static int count = 0;
    int clientID;
    String clientName;
    int risk;
    Trader contractedTrader;
    int expectedReturn;
    Portfolio portfolio;
    
    /**
     * Construct a Client
     * @param name The name of the client.
     * @param risk
     * @param expectedReturn
     */
    public Client(String name, int risk, int expectedReturn){
        setClientID(++count);
        this.clientID = clientID;
        clientName = name;
        this.risk = risk;
        this.expectedReturn = expectedReturn;
    }
    
    /**
     * Sets clientID
     * @param clientID The clientID. 
     */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /**
     * Returns client's risk
     * @return The client's risk.
     */
    public int getRisk() {
        return risk;
    }

    /**
     * Set's the client's risk
     * @param risk The client's risk.
     */
    public void setRisk(int risk) {
        if(checkPositiveValue(risk)){
            this.risk = risk;  
        }
    }

    /**
     * Returns the client's trader
     * @return The client's trader.
     */
    public Trader getContractedTrader() {
        return contractedTrader;
    }

    /**
     * Sets the client's trader
     * @param trader The client's trader.
     */
    public void setContractedTrader(Trader trader) {
        this.contractedTrader = trader;
    }
    
    /**
     * Sets the client's portfolio
     * @param portfolio The portfolio of the client.
     */
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
    
    /**
     * Deposits money into client's portfolio
     * @param value The client's money.
     */
    public void depositInitialMoney(int value) {
        if(checkPositiveValue(value)){
            portfolio.addMoney(value); 
        } 
    }  
    
    /**
     * Demands liquidation
     */
    public void demandLiquidation(){
        
    }
    
    /**
     * Checks portfolio's value
     */
    public int checkValue(){
        int value = 0;
        for (int i = 0; i < portfolio.stocks.size(); i++) {
            value  += portfolio.stocks.get(i).price;
        }
        return value + portfolio.money;
    }
    
    /**
     * Checks if the value passed in is positive or not
     * @param value The value to check if it's positive.
     * @return If value is greater than zero.
     */
    public boolean checkPositiveValue(int value) {
        return value > 0;
    }
}
