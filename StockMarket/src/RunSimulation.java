
import java.util.ArrayList;
import javafx.application.Application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JoeThompson
 */
public class RunSimulation {

    ArrayList<Stock> stocks;
    ArrayList<Client> clients;
    ArrayList<Portfolio> portfolios;
    ArrayList<Trader> traders;
    Clock clock;
    TradingExchange tradingExchange;
    StockMarket stockMarket;

    public RunSimulation() {
        stocks = new ArrayList<Stock>();
        clients = new ArrayList<Client>();
        portfolios = new ArrayList<Portfolio>();
        traders = new ArrayList<Trader>();
        stockMarket = new StockMarket();
        tradingExchange = new TradingExchange(ExchangeType.General, stockMarket.marketID);
        initialization();
    }

    public static void main(String[] args) {
        Application.launch(SimulationGUI.class, args);
    }

    public void initialization() {
        //Initialise stocks
        stocks.add(new Stock("Pear Computing", StockType.Hitech, 6.50, 50000));
        stocks.add(new Stock("Wong Holdings", StockType.Property, 1.26, 10000));
        stocks.add(new Stock("Williams Leisure", StockType.Hard, 0.82, 20000));
        stocks.add(new Stock("The Lovely Pie Co", StockType.Food, 0.24, 6000));
        stocks.add(new Stock("Q1Q Tech", StockType.Hitech, 1.30, 48900));
        stocks.add(new Stock("Texas Crisps", StockType.Food, 1.80, 32900));
        stocks.add(new Stock("Swann Holdings", StockType.Property, 0.45, 23600));
        stocks.add(new Stock("Patels Sauces", StockType.Food, 1.00, 55000));
        stocks.add(new Stock("Gardens 'R' Us", StockType.Hard, 0.19, 19288));
        stocks.add(new Stock("Sussex Flats", StockType.Property, 5.70, 23000));
        stocks.add(new Stock("Dawn Technology", StockType.Hitech, 0.12, 18000));
        stocks.add(new Stock("Excelsior Foods", StockType.Food, 5.40, 50000));
        stocks.add(new Stock("Supreme Sk8", StockType.Hard, 3.45, 25000));
        stocks.add(new Stock("Luxury Caravans", StockType.Property, 2.68, 42000));
        stocks.add(new Stock("WyreCraft", StockType.Hitech, 6.37, 32000));
        stocks.add(new Stock("Upduff and Co", StockType.Food, 3.40, 36700));
        stocks.add(new Stock("Downe and Co", StockType.Hard, 0.99, 40000));
        stocks.add(new Stock("Skinners", StockType.Property, 3.68, 57000));
        stocks.add(new Stock("Wazoolt", StockType.Hitech, 0.45, 9800));
        stocks.add(new Stock("Whizzer and Chipps", StockType.Food, 2.10, 31000));

        //Initialise clients
        clients.add(new Client("Norbert DaVinci", 1, 1));
        clients.add(new Client("Ellen Fotheringay-Smythe", 1, 1));
        clients.add(new Client("Donald Shrek", 1, 1));
        clients.add(new Client("Sir Melvin Codd", 1, 1));
        clients.add(new Client("A&G investments", 1, 1));
        clients.add(new Client("Trinity Investments", 1, 1));
        clients.add(new Client("Ivor Lott", 1, 1));
        clients.add(new Client("Justine Thyme", 1, 1));
        clients.add(new Client("Saeed Pune", 1, 1));
        clients.add(new Client("Xi Xian", 1, 1));

        //Initialise portfolios
        for (int i = 0; i < clients.size(); i++) {
            portfolios.add(new Portfolio(clients.get(i)));
            clients.get(i).setPortfolio(portfolios.get(i));
        }
        //Assign initial stocks and cash to portfolio
        for (int i = 0; i < portfolios.size(); i++) {
            Portfolio currentPortfolio = portfolios.get(i);
            for (int j = 0; j < stocks.size(); j++) {
                Stock currentStock = stocks.get(i);
                switch (i) {
                    case 0://Initialise Norbert DaVinci portfolio
                        currentPortfolio.addMoney(100000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 1505);
                                break;
                            case 1:
                                break;
                            case 2:
                                currentPortfolio.addStock(currentStock, 1456);
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 8464);
                                break;
                            case 5:
                                currentPortfolio.addStock(currentStock, 4336);
                                break;
                            case 6:
                                currentPortfolio.addStock(currentStock, 6424);
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 6479);
                                break;
                            case 8:
                                break;
                            case 9:
                                currentPortfolio.addStock(currentStock, 4827);
                                break;
                            case 10:
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 4551);
                                break;
                            case 12:
                                break;
                            case 13:
                                currentPortfolio.addStock(currentStock, 7774);
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 109);
                                break;
                            case 15:
                                currentPortfolio.addStock(currentStock, 4656);
                                break;
                            case 16:
                                currentPortfolio.addStock(currentStock, 5344);
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 5576);
                                break;
                            case 18:
                                currentPortfolio.addStock(currentStock, 3181);
                                break;
                            case 19:
                                currentPortfolio.addStock(currentStock, 9496);
                                break;
                        }
                    case 1: //Initialise Ellen Fortheringat-Smythe portfolio
                        currentPortfolio.addMoney(100000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 1672);
                                break;
                            case 1:
                                break;
                            case 2:
                                currentPortfolio.addStock(currentStock, 4816);
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 701);
                                break;
                            case 5:
                                currentPortfolio.addStock(currentStock, 9571);
                                break;
                            case 6:
                                currentPortfolio.addStock(currentStock, 498);
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 6345);
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                            case 10:
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 2538);
                                break;
                            case 12:
                                break;
                            case 13:
                                currentPortfolio.addStock(currentStock, 9872);
                                break;
                            case 14:
                                break;
                            case 15:
                                currentPortfolio.addStock(currentStock, 3907);
                                break;
                            case 16:
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 7793);
                                break;
                            case 18:
                                break;
                            case 19:
                                currentPortfolio.addStock(currentStock, 5022);
                                break;
                        }
                    case 2: //Initialise Donald Shrek portfolio
                        currentPortfolio.addMoney(100000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 9746);
                                break;
                            case 1:
                                currentPortfolio.addStock(currentStock, 8107);
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 8917);
                                break;
                            case 5:
                                break;
                            case 6:
                                currentPortfolio.addStock(currentStock, 8152);
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 8437);
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                            case 10:
                                currentPortfolio.addStock(currentStock, 6957);
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 5059);
                                break;
                            case 12:
                                break;
                            case 13:
                                currentPortfolio.addStock(currentStock, 6348);
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 3987);
                                break;
                            case 15:
                                break;
                            case 16:
                                currentPortfolio.addStock(currentStock, 7542);
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 9015);
                                break;
                            case 18:
                                break;
                            case 19:
                                break;
                        }
                    case 3: //Initialise Sir Melvin Codd portfolio
                        currentPortfolio.addMoney(100000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 330);
                                break;
                            case 1:
                                currentPortfolio.addStock(currentStock, 1893);
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 7714);
                                break;
                            case 5:
                                break;
                            case 6:
                                currentPortfolio.addStock(currentStock, 8526);
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 1385);
                                break;
                            case 8:
                                currentPortfolio.addStock(currentStock, 1319);
                                break;
                            case 9:
                                break;
                            case 10:
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 636);
                                break;
                            case 12:
                                break;
                            case 13:
                                currentPortfolio.addStock(currentStock, 842);
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 9042);
                                break;
                            case 15:
                                break;
                            case 16:
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 4514);
                                break;
                            case 18:
                                currentPortfolio.addStock(currentStock, 6619);
                                break;
                            case 19:
                                break;
                        }
                    case 4: //Intialise A&G Investments portfolio
                        currentPortfolio.addMoney(100000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 4077);
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 4707);
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 4272);
                                break;
                            case 8:
                                currentPortfolio.addStock(currentStock, 8119);
                                break;
                            case 9:
                                break;
                            case 10:
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 4535);
                                break;
                            case 12:
                                break;
                            case 13:
                                currentPortfolio.addStock(currentStock, 5757);
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 9088);
                                break;
                            case 15:
                                break;
                            case 16:
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 1307);
                                break;
                            case 18:
                                break;
                            case 19:
                                break;
                        }
                    case 5: //Initialise Trinity Investments portfolio
                        currentPortfolio.addMoney(50000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 8054);
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 3238);
                                break;
                            case 5:
                                currentPortfolio.addStock(currentStock, 8593);
                                break;
                            case 6:
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 9841);
                                break;
                            case 8:
                                break;
                            case 9:
                                currentPortfolio.addStock(currentStock, 3073);
                                break;
                            case 10:
                                currentPortfolio.addStock(currentStock, 8438);
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 5244);
                                break;
                            case 12:
                                break;
                            case 13:
                                currentPortfolio.addStock(currentStock, 1828);
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 337);
                                break;
                            case 15:
                                break;
                            case 16:
                                currentPortfolio.addStock(currentStock, 5857);
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 7529);
                                break;
                            case 18:
                                break;
                            case 19:
                                break;
                        }
                    case 6: //Initialse Ivor Lott portfolio
                        currentPortfolio.addMoney(50000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 7841);
                                break;
                            case 1:
                                break;
                            case 2:
                                currentPortfolio.addStock(currentStock, 6380);
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 3701);
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 2774);
                                break;
                            case 8:
                                break;
                            case 9:
                                currentPortfolio.addStock(currentStock, 1354);
                                break;
                            case 10:
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 9874);
                                break;
                            case 12:
                                currentPortfolio.addStock(currentStock, 9837);
                                break;
                            case 13:
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 452);
                                break;
                            case 15:
                                currentPortfolio.addStock(currentStock, 8371);
                                break;
                            case 16:
                                currentPortfolio.addStock(currentStock, 4400);
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 4553);
                                break;
                            case 18:
                                break;
                            case 19:
                                break;
                        }
                    case 7: //Initialise Justine Thyme portfolio
                        currentPortfolio.addMoney(50000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 6187);
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 3276);
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 1833);
                                break;
                            case 8:
                                currentPortfolio.addStock(currentStock, 8644);
                                break;
                            case 9:
                                currentPortfolio.addStock(currentStock, 180);
                                break;
                            case 10:
                                currentPortfolio.addStock(currentStock, 1563);
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 5309);
                                break;
                            case 12:
                                currentPortfolio.addStock(currentStock, 4283);
                                break;
                            case 13:
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 5229);
                                break;
                            case 15:
                                currentPortfolio.addStock(currentStock, 7946);
                                break;
                            case 16:
                                currentPortfolio.addStock(currentStock, 8235);
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 2337);
                                break;
                            case 18:
                                break;
                            case 19:
                                break;
                        }
                    case 8: //Initialise Saeed Pune portfolio
                        currentPortfolio.addMoney(50000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 2304);
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 2447);
                                break;
                            case 5:
                                currentPortfolio.addStock(currentStock, 1611);
                                break;
                            case 6:
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 4188);
                                break;
                            case 8:
                                currentPortfolio.addStock(currentStock, 1206);
                                break;
                            case 9:
                                currentPortfolio.addStock(currentStock, 6464);
                                break;
                            case 10:
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 6772);
                                break;
                            case 12:
                                currentPortfolio.addStock(currentStock, 6332);
                                break;
                            case 13:
                                currentPortfolio.addStock(currentStock, 9579);
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 8402);
                                break;
                            case 15:
                                currentPortfolio.addStock(currentStock, 4216);
                                break;
                            case 16:
                                currentPortfolio.addStock(currentStock, 8622);
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 6728);
                                break;
                            case 18:
                                break;
                            case 19:
                                currentPortfolio.addStock(currentStock, 8969);
                                break;
                        }
                    case 9: //Initialise Xi Xian portfolio
                        currentPortfolio.addMoney(50000);
                        switch (j) {
                            case 0:
                                currentPortfolio.addStock(currentStock, 8284);
                                break;
                            case 1:
                                break;
                            case 2:
                                currentPortfolio.addStock(currentStock, 7348);
                                break;
                            case 3:
                                currentPortfolio.addStock(currentStock, 6000);
                                break;
                            case 4:
                                currentPortfolio.addStock(currentStock, 5735);
                                break;
                            case 5:
                                currentPortfolio.addStock(currentStock, 8789);
                                break;
                            case 6:
                                break;
                            case 7:
                                currentPortfolio.addStock(currentStock, 9446);
                                break;
                            case 8:
                                break;
                            case 9:
                                currentPortfolio.addStock(currentStock, 7102);
                                break;
                            case 10:
                                currentPortfolio.addStock(currentStock, 1042);
                                break;
                            case 11:
                                currentPortfolio.addStock(currentStock, 5482);
                                break;
                            case 12:
                                currentPortfolio.addStock(currentStock, 4548);
                                break;
                            case 13:
                                break;
                            case 14:
                                currentPortfolio.addStock(currentStock, 4646); //in spreadsheet it says -4646?
                                break;
                            case 15:
                                currentPortfolio.addStock(currentStock, 7604);
                                break;
                            case 16:
                                break;
                            case 17:
                                currentPortfolio.addStock(currentStock, 7648);
                                break;
                            case 18:
                                break;
                            case 19:
                                currentPortfolio.addStock(currentStock, 7513);
                                break;
                        }
                }
            }

        }
        //Initialise traders
        traders.add(new Trader("Wolf Gecko", true, "Wolf & Gecko LTD", TraderType.Intelligent));
        traders.add(new Trader("Random 1", true, "Random Traders LTD", TraderType.Random));
        traders.add(new Trader("Random 2", true, "Random Traders LTD", TraderType.Random));
        traders.add(new Trader("Random 3", true, "Random Traders LTD", TraderType.Random));
        traders.add(new Trader("Random 4", true, "Random Traders LTD", TraderType.Random));
        traders.add(new Trader("Random 5", true, "Random Traders LTD", TraderType.Random));
        traders.add(new Trader("Random 6", true, "Random Traders LTD", TraderType.Random));
        traders.add(new Trader("Random 7", true, "Random Traders LTD", TraderType.Random));
        traders.add(new Trader("Random 8", true, "Random Traders LTD", TraderType.Random));

        //Assign Wolf & Gecko trader to Norbert & Justine
        traders.get(0).addClient(clients.get(0));
        traders.get(0).addPortfolio(portfolios.get(0));
        traders.get(0).addClient(clients.get(7));
        traders.get(0).addPortfolio(portfolios.get(0));

        //Assign random traders to their clients & portfolios
        for (int i = 1; i < traders.size(); i++) {
            if (i != 7) {
                traders.get(i).addClient(clients.get(i));
                traders.get(i).addPortfolio(portfolios.get(i));
            }
        }
    }
}
