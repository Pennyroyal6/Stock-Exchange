/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
        addStockMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

            }
        });
        MenuItem editStockMenuItem = new MenuItem("Edit Stock");
        MenuItem removeStockMenuItem = new MenuItem("Remove Stock");
        stockMenu.getItems().addAll(addStockMenuItem, new SeparatorMenuItem(), editStockMenuItem, new SeparatorMenuItem(), removeStockMenuItem);

        //Create Trader menu - Add Trader, Edit Trader, Remove Trader
        Menu traderMenu = new Menu("Trader");
        MenuItem addTraderMenuItem = new MenuItem("Add Trader");
        addTraderMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(50, 50, 50, 100));
                grid.setHgap(50);
                grid.setVgap(50);
                Scene scene = new Scene(grid, 500, 600, Color.WHITE);

                Label traderIDLabel = new Label("TraderID");
                grid.add(traderIDLabel, 0, 1);

                Label nameLabel = new Label("Name");
                grid.add(nameLabel, 0, 2);

                Label licenceLabel = new Label("Licence");
                grid.add(licenceLabel, 0, 3);

                Label companyLabel = new Label("Company");
                grid.add(companyLabel, 0, 4);

                Label typeLabel = new Label("Type");
                grid.add(typeLabel, 0, 5);

                TextField traderIDTextField = new TextField();
                grid.add(traderIDTextField, 1, 1);

                TextField nameTextField = new TextField();
                grid.add(nameTextField, 1, 2);

                TextField licenceTextField = new TextField();
                grid.add(licenceTextField, 1, 3);

                TextField companyTextField = new TextField();
                grid.add(companyTextField, 1, 4);

                TextField typeTextField = new TextField();
                grid.add(typeTextField, 1, 5);

                Button okButton = new Button("Ok");
                okButton.getStyleClass().add("okButton");
                grid.add(okButton, 0, 6);

                Button cancelButton = new Button("Cancel");
                cancelButton.getStyleClass().add("cancelButton");
                cancelButton.setTranslateX(30);
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        stage.close();
                    }
                });
                grid.add(cancelButton, 1, 6);

                stage.setScene(scene);
                stage.centerOnScreen();
                scene.getStylesheets().add("MenuCascadeStyleSheet.css");
                stage.show();
            }
        });
        MenuItem editTraderMenuItem = new MenuItem("Edit Trader");
        editTraderMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = new Stage();
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(50, 50, 50, 100));
                grid.setHgap(50);
                grid.setVgap(50);
                Scene scene = new Scene(grid, 600, 250, Color.WHITE);
                
                Label traderIDLabel = new Label("TraderID");
                grid.add(traderIDLabel, 0, 0);
                
                TextField traderIDTextField = new TextField();
                grid.add(traderIDTextField, 1, 0);
                
                Button okButton = new Button("Ok");
                okButton.getStyleClass().add("okButton");
                okButton.setTranslateX(50);
                grid.add(okButton, 0, 1);

                Button cancelButton = new Button("Cancel");
                cancelButton.getStyleClass().add("cancelButton");
                cancelButton.setTranslateX(80);
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        stage.close();
                    }
                });
                grid.add(cancelButton, 1, 1);
                
                stage.setScene(scene);
                stage.centerOnScreen();
                scene.getStylesheets().add("MenuCascadeStyleSheet.css");
                stage.show();
            }
        });
        MenuItem removeTraderMenuItem = new MenuItem("Remove Trader");
        traderMenu.getItems().addAll(addTraderMenuItem, new SeparatorMenuItem(), editTraderMenuItem, new SeparatorMenuItem(), removeTraderMenuItem);

        //Create Client menu - Add Client, Edit Client, Remove Client
        Menu clientMenu = new Menu("Client");
        MenuItem addClientMenuItem = new MenuItem("Add Client");
        MenuItem editClientMenuItem = new MenuItem("Edit Client");
        MenuItem removeClientMenuItem = new MenuItem("Remove Client");
        clientMenu.getItems().addAll(addClientMenuItem, new SeparatorMenuItem(), editClientMenuItem, new SeparatorMenuItem(), removeClientMenuItem);

        //Create Exchange menu - Add Exchange, Edit Exchange, Remove Exchange
        Menu exchangeMenu = new Menu("Exchange");
        MenuItem addExchangeMenuItem = new MenuItem("Add Exchange");
        MenuItem editExchangeMenuItem = new MenuItem("Edit Exchange");
        MenuItem removeExchangeMenuItem = new MenuItem("Remove Exchange");
        exchangeMenu.getItems().addAll(addExchangeMenuItem, new SeparatorMenuItem(), editExchangeMenuItem, new SeparatorMenuItem(), removeExchangeMenuItem);

        menuBar.getMenus().addAll(fileMenu, stockMenu, traderMenu, clientMenu, exchangeMenu);

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
