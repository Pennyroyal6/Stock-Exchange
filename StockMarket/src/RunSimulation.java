
import java.util.ArrayList;

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
    
    public RunSimulation() {
        initialization();
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
    }
    
}
