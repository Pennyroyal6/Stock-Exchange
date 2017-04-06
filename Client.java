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

    int clientID;
    String clientName;
    int risk;
    int contractedTrader;
    Portfolio p;
    
    public Client(String name){
        clientName = name;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public int getContractedTrader() {
        return contractedTrader;
    }

    public void setContractedTrader(int traderID) {
        this.contractedTrader = traderID;
    }
    
    public void depositInitialMoney(int value) {
        p.setMoney(value);
    }  
    
    public void demandLiquidation(){
        
    }
    
    public void checkValue(){
        p.getMoney();
    }
    
    public void assignToTrader(int traderID) {
        traderID = contractedTrader;
    }
}
