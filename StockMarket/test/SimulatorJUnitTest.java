/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JoeThompson
 */
public class SimulatorJUnitTest {
    
    static Client client;
    static Client client2;
    static Portfolio portfolio;
    static Portfolio portfolio2;
    static Stock stock1;
    static Stock stock2;
    static StockMarket stockMarket;
    static Trader iTrader;
    static Trader rTrader;
    static TradingExchange tradingExchange;
    
    public SimulatorJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        iTrader = new Trader("Intelli Trader", true, "Wolf & Gecko LTD", TraderType.Intelligent);
        rTrader = new Trader("Random Trader", false, "Cat & Lizard LTD", TraderType.Random);
        client = new Client("Kingsley Sage", 1, 100);
        client2 = new Client("Ian Wakeman", 1, 200);
        portfolio = new Portfolio(client);
        portfolio2 = new Portfolio(client2);
        stockMarket = new StockMarket();
        tradingExchange= new TradingExchange(ExchangeType.General, 1);
        stock1 = new Stock("Test Company", StockType.Hard, 5, 100);
        stock2 = new Stock("Pepsi", StockType.Food, 12, 50);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    @Test
    public void checkIncrementingID() {
        assertEquals(1, iTrader.getTraderID());
        assertEquals(2, rTrader.getTraderID());
        
        assertEquals(1, client.clientID);
        
        assertEquals(1, portfolio.portfolioID);
        
        assertEquals(1, stockMarket.getMarketID());
        
        assertEquals(1, tradingExchange.getExchangeId());
        
        assertEquals(1, stock1.stockID);
        assertEquals(2, stock2.stockID);
    }
    //Trading Exchange tests
    @Test
    public void assignExchangeToStockMarket() {
        assertEquals(1, stockMarket.marketID);
    }
    
    @Test
    public void tradingExchangeDefaultType() {
        assertEquals(ExchangeType.General, tradingExchange.getType());
    }
    
    @Test
    public void tradingExchangeFuturesType() {
        tradingExchange.setType(ExchangeType.Futures);
        assertEquals(ExchangeType.Futures, tradingExchange.getType());
        tradingExchange.setType(ExchangeType.General);
    }
    
    @Test
    public void tradingExchangeDerivativesType() {
        tradingExchange.setType(ExchangeType.Derivatives);
        assertEquals(ExchangeType.Derivatives, tradingExchange.getType());
        tradingExchange.setType(ExchangeType.General);
    }
    
    @Test
    public void tradingExchangeCommoditiesType() {
        tradingExchange.setType(ExchangeType.Commodities);
        assertEquals(ExchangeType.Commodities, tradingExchange.getType());
        tradingExchange.setType(ExchangeType.General);
    }
    
    //Stock Market tests
    @Test
    public void defaultStockMarketType() {
        assertEquals(MarketType.Stable, stockMarket.status);
    }
    
    //Portfolio tests
    @Test
    public void assignPortfolioToClient() {
        assertEquals(client.clientID, portfolio.checkClientID());
    }
    
    @Test
    public void checkPortfoliosClient() {
        assertEquals(1, portfolio.checkClientID());
    }
    
    @Test
    public void addStockToPortfolio() {
        portfolio.addStock(stock1, 100);
        assertEquals(1, portfolio.stocks.size());
    }
    
    @Test
    public void removeStockFromPortfolio() {
        portfolio.deleteStock(stock1, 100);
        assertEquals(0, portfolio.stocks.size());
    }
    
    @Test
    public void depositMoneyTest() {
        client.depositInitialMoney(5);
        assertEquals(5, portfolio.getMoney());
    }
    
    @Test
    public void removeMoneyTest() {
        portfolio.removeMoney(5);
        assertEquals(0, portfolio.getMoney());
    }
    
    @Test
    public void removeMoneyPreventNegativeAmountTest() {
        portfolio.removeMoney(20);
        assertEquals(0, portfolio.getMoney());
    }
    
    //Client tests
    @Test
    public void clientName() {
        assertEquals("Kingsley Sage", client.clientName);
    }
    
    @Test
    public void checkClientTrader() {
        client.setContractedTrader(iTrader);
        assertEquals("Intelli Trader", client.getContractedTrader().name);
    }
    
    @Test
    public void checkLicenceFalse() {
        assertEquals(false, rTrader.checkLicence());
    }
    
    @Test
    public void checkLicenceTrue() {
        assertEquals(true, iTrader.checkLicence());
    }
    
    @Test
    public void checkRisk() {
        assertEquals(1, client.getRisk());
    }
    
    @Test
    public void checkExpectedReturn() {
        assertEquals(100, client.expectedReturn);
    }
    
    @Test
    public void checkClientsPortfolioWorth() {
        client.depositInitialMoney(100);
        portfolio.addStock(stock1, 100);
        assertEquals(600, client.checkValue());
        portfolio.deleteStock(stock1, 100);
        portfolio.removeMoney(100);
    }
    
    //Stock tests
    @Test
    public void checkStockName() {
        assertEquals("Test Company", stock1.getCompanyStockRepresents());
    }
    
    @Test
    public void checkStockPrice() {
        assertEquals(9, stock1.price, 0.0);
    }
    
    @Test
    public void increaseStockPrice() {
        stock1.increaseValue(4);
        assertEquals(9, stock1.getValueOfStock(), 0.0);
    }
    
    @Test
    public void decreaseStockPrice() {
        stock2.decreaseValue(7);
        assertEquals(5, stock2.getValueOfStock(), 0.0);
    }
    
    @Test
    public void checkStockType() {
        assertEquals(StockType.Hard, stock1.getStockType());
    }
    
    @Test
    public void changeStockType() {
        stock1.changeStockType(StockType.Food);
        assertEquals(StockType.Food, stock1.getStockType());
        stock1.changeStockType(StockType.Hard);
    }
}
