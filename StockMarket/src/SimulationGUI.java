/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author JoeThompson
 */
public class SimulationGUI extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1200, 800, Color.WHITE);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(stage.widthProperty());
        root.setTop(menuBar);

        //Create file menu - Quit
        Menu fileMenu = new Menu("File");
        MenuItem exitMenuItem = new MenuItem("Quit");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        fileMenu.getItems().addAll(exitMenuItem);

        //Create Stock menu - Add Stock, Edit Stock, Remove Stock
        Menu stockMenu = new Menu("Stock");
        MenuItem addStockMenuItem = new MenuItem("Add Stock");
        MenuItem editStockMenuItem = new MenuItem("Edit Stock");
        MenuItem removeStockMenuItem = new MenuItem("Remove Stock");
        stockMenu.getItems().addAll(addStockMenuItem, new SeparatorMenuItem(), editStockMenuItem, new SeparatorMenuItem(), removeStockMenuItem);

        //Create Trader menu - Add Trader, Edit Trader, Remove Trader
        Menu traderMenu = new Menu("Trader");
        MenuItem addTraderMenuItem = new MenuItem("Add Trader");
        MenuItem editTraderMenuItem = new MenuItem("Edit Trader");
        MenuItem removeTraderMenuItem = new MenuItem("Remove Trader");
        traderMenu.getItems().addAll(addTraderMenuItem,new SeparatorMenuItem(), editTraderMenuItem, new SeparatorMenuItem(), removeTraderMenuItem);
        
        //Create Client menu - Add Client, Edit Client, Remove Client
        Menu clientMenu = new Menu("Client");
        MenuItem addClientMenuItem = new MenuItem("Add Client");
        MenuItem editClientMenuItem = new MenuItem("Edit Client");
        MenuItem removeClientMenuItem = new MenuItem("Remove Client");
        clientMenu.getItems().addAll(addClientMenuItem,new SeparatorMenuItem(), editClientMenuItem, new SeparatorMenuItem(), removeClientMenuItem);
        
        //Create Exchange menu - Add Exchange, Edit Exchange, Remove Exchange
        Menu exchangeMenu = new Menu("Exchange");
        MenuItem addExchangeMenuItem = new MenuItem("Add Exchange");
        MenuItem editExchangeMenuItem = new MenuItem("Edit Exchange");
        MenuItem removeExchangeMenuItem = new MenuItem("Remove Exchange");
        exchangeMenu.getItems().addAll(addExchangeMenuItem,new SeparatorMenuItem(), editExchangeMenuItem, new SeparatorMenuItem(), removeExchangeMenuItem);
        
        //Create Portfolio menu - View Portfolio
        Menu portfolioMenu = new Menu("Portfolio");
        MenuItem viewPortfolioMenuItem = new MenuItem("View Portfolio");
        portfolioMenu.getItems().addAll(viewPortfolioMenuItem);

        menuBar.getMenus().addAll(fileMenu, stockMenu, traderMenu, exchangeMenu, portfolioMenu);
        
        Label indexLabel = new Label("Market Index:");
        indexLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        indexLabel.setTranslateX(200);
        indexLabel.setTranslateY(100);
        indexLabel.setMinWidth(200);
        
        Label marketLabel = new Label("Market Type:");
        marketLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        marketLabel.setTranslateX(650);
        marketLabel.setTranslateY(100);
        marketLabel.setMinWidth(200);
        
        HBox hbox = new HBox();
        hbox.setTranslateX(0);
        hbox.setTranslateY(100);
        hbox.getChildren().addAll(indexLabel, marketLabel);

        root.getChildren().add(hbox);
        stage.setScene(scene);
        stage.centerOnScreen();
        scene.getStylesheets().add("SimulationCascadeStyleSheet.css");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
