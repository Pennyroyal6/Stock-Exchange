/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

    RunSimulation simulation;

    @Override
    public void start(Stage stage) {
        simulation = new RunSimulation();

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
                Stage stage = new Stage();
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(50, 50, 50, 100));
                grid.setHgap(50);
                grid.setVgap(50);
                Scene scene = new Scene(grid, 500, 600, Color.WHITE);

                Label title = new Label("Add Stock");
                title.getStyleClass().add("title");
                title.setTranslateX(100);
                grid.add(title, 0, 0);

                Label traderIDLabel = new Label("StockID");
                grid.add(traderIDLabel, 0, 1);

                Label companyLabel = new Label("Company");
                grid.add(companyLabel, 0, 2);

                Label typeLabel = new Label("Type");
                grid.add(typeLabel, 0, 3);

                Label priceLabel = new Label("Price");
                grid.add(priceLabel, 0, 4);

                Label quantityLabel = new Label("Quantity");
                grid.add(quantityLabel, 0, 5);

                TextField stockIDTextField = new TextField();
                stockIDTextField.setText("" + (1 + simulation.stocks.get(simulation.stocks.size() - 1).getStockID()));
                stockIDTextField.setEditable(false);
                grid.add(stockIDTextField, 1, 1);

                TextField companyTextField = new TextField();
                grid.add(companyTextField, 1, 2);

                ObservableList<String> stockOptions = FXCollections.observableArrayList("Hitech", "Property", "Food", "Hard");
                ComboBox typeComboBox = new ComboBox(stockOptions);
                grid.add(typeComboBox, 1, 3);

                TextField priceTextField = new TextField();
                grid.add(priceTextField, 1, 4);

                TextField quantityTextField = new TextField();
                grid.add(quantityTextField, 1, 5);

                Button okButton = new Button("Ok");
                okButton.getStyleClass().add("okButton");
                grid.add(okButton, 0, 6);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        StockType type = StockType.Hard;
                        if (typeComboBox.getValue().equals("Hitech")) {
                            type = StockType.Hitech;
                        } else if (typeComboBox.getValue().equals("Property")) {
                            type = StockType.Property;
                        } else if (typeComboBox.getValue().equals("Food")) {
                            type = StockType.Food;
                        }
                        double price = Double.parseDouble(priceTextField.getText());
                        int quantity = Integer.parseInt(quantityTextField.getText());

                        simulation.stocks.add(new Stock(companyTextField.getText(), type, price, quantity));
                        stage.close();
                        Alert confirm = new Alert(AlertType.INFORMATION);
                        confirm.setTitle("Confirmation");
                        confirm.setHeaderText(null);
                        confirm.setContentText(quantity + " shares from " + companyTextField.getText() + " have been added.");
                        confirm.showAndWait();
                    }

                });
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
        MenuItem editStockMenuItem = new MenuItem("Edit Stock");
        editStockMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(50, 50, 50, 100));
                grid.setHgap(50);
                grid.setVgap(50);
                Scene scene = new Scene(grid, 600, 250, Color.WHITE);

                Label stockIDLabel = new Label("StockID");
                grid.add(stockIDLabel, 0, 0);

                TextField stockIDTextField = new TextField();
                grid.add(stockIDTextField, 1, 0);

                Button okButton = new Button("Ok");
                okButton.getStyleClass().add("okButton");
                okButton.setTranslateX(50);
                grid.add(okButton, 0, 1);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        int stockID = Integer.parseInt(stockIDTextField.getText());
                        for (int i = 0; i < simulation.stocks.size(); i++) {
                            if (stockID == simulation.stocks.get(i).getStockID()) {
                                Stock stock = simulation.stocks.get(i);
                                stage.close();
                                Stage stage = new Stage();
                                GridPane grid = new GridPane();
                                grid.setPadding(new Insets(50, 50, 50, 100));
                                grid.setHgap(50);
                                grid.setVgap(50);
                                Scene scene = new Scene(grid, 500, 600, Color.WHITE);

                                Label title = new Label("Add Stock");
                                title.getStyleClass().add("title");
                                title.setTranslateX(100);
                                grid.add(title, 0, 0);

                                Label traderIDLabel = new Label("StockID");
                                grid.add(traderIDLabel, 0, 1);

                                Label companyLabel = new Label("Company");
                                grid.add(companyLabel, 0, 2);

                                Label typeLabel = new Label("Type");
                                grid.add(typeLabel, 0, 3);

                                Label priceLabel = new Label("Price");
                                grid.add(priceLabel, 0, 4);

                                Label quantityLabel = new Label("Quantity");
                                grid.add(quantityLabel, 0, 5);

                                TextField stockIDTextField = new TextField();
                                stockIDTextField.setText("" + stock.getStockID());
                                stockIDTextField.setEditable(false);
                                grid.add(stockIDTextField, 1, 1);

                                TextField companyTextField = new TextField();
                                companyTextField.setText(stock.companyName);
                                grid.add(companyTextField, 1, 2);

                                ObservableList<String> stockOptions = FXCollections.observableArrayList("Hitech", "Property", "Food", "Hard");
                                ComboBox typeComboBox = new ComboBox(stockOptions);
                                if (stock.type == StockType.Hitech) {
                                    typeComboBox.getSelectionModel().select("Hitech");
                                } else if (stock.type == StockType.Property) {
                                    typeComboBox.getSelectionModel().select("Property");
                                } else if (stock.type == StockType.Food) {
                                    typeComboBox.getSelectionModel().select("Hitech");
                                } else if (stock.type == StockType.Hard) {
                                    typeComboBox.getSelectionModel().select("Hard");
                                }
                                grid.add(typeComboBox, 1, 3);

                                TextField priceTextField = new TextField();
                                priceTextField.setText("" + String.format("%.2f", stock.price));
                                grid.add(priceTextField, 1, 4);

                                TextField quantityTextField = new TextField();
                                quantityTextField.setText("" + stock.sharesOffered);
                                grid.add(quantityTextField, 1, 5);

                                Button okButton = new Button("Ok");
                                okButton.getStyleClass().add("okButton");
                                grid.add(okButton, 0, 6);
                                okButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent t) {
                                        StockType type = StockType.Hard;
                                        if (typeComboBox.getValue().equals("Hitech")) {
                                            type = StockType.Hitech;
                                        } else if (typeComboBox.getValue().equals("Property")) {
                                            type = StockType.Property;
                                        } else if (typeComboBox.getValue().equals("Food")) {
                                            type = StockType.Food;
                                        }
                                        double price = Double.parseDouble(priceTextField.getText());
                                        int quantity = Integer.parseInt(quantityTextField.getText());
                                        stock.setCompanyStockReperesents(companyTextField.getText());
                                        stock.setType(type);
                                        stock.setPrice(price);
                                        stock.setSharesOffered(quantity);
                                        stage.close();
                                        Alert confirm = new Alert(AlertType.INFORMATION);
                                        confirm.setTitle("Confirmation");
                                        confirm.setHeaderText(null);
                                        confirm.setContentText("Stock " + companyTextField.getText() + " has been edited.");
                                        confirm.showAndWait();
                                    }
                                });
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
                        }
                    }

                });
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

                Label title = new Label("Add Trader");
                title.getStyleClass().add("title");
                title.setTranslateX(100);
                grid.add(title, 0, 0);

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
                traderIDTextField.setText("" + (1 + simulation.traders.get(simulation.traders.size() - 1).getTraderID()));
                traderIDTextField.setEditable(false);
                grid.add(traderIDTextField, 1, 1);

                TextField nameTextField = new TextField();
                grid.add(nameTextField, 1, 2);

                ObservableList<String> licenceOptions = FXCollections.observableArrayList("True", "False");
                ComboBox licenceComboBox = new ComboBox(licenceOptions);
                grid.add(licenceComboBox, 1, 3);

                TextField companyTextField = new TextField();
                grid.add(companyTextField, 1, 4);

                ObservableList<String> typeOptions = FXCollections.observableArrayList("Intelligent", "Random");
                ComboBox typeComboBox = new ComboBox(typeOptions);
                grid.add(typeComboBox, 1, 5);

                Button okButton = new Button("Ok");
                okButton.getStyleClass().add("okButton");
                grid.add(okButton, 0, 6);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        boolean licence = false;
                        TraderType type = TraderType.Random;
                        if (licenceComboBox.getValue().equals("True")) {
                            licence = true;
                        }
                        if (typeComboBox.getValue().equals("Intelligent")) {
                            type = TraderType.Intelligent;
                        }
                        simulation.traders.add(new Trader(nameTextField.getText(), licence, companyTextField.getText(), type));
                        stage.close();
                        Alert confirm = new Alert(AlertType.INFORMATION);
                        confirm.setTitle("Confirmation");
                        confirm.setHeaderText(null);
                        confirm.setContentText("Trader " + nameTextField.getText() + " has been added.");
                        confirm.showAndWait();
                    }
                });

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
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        int traderID = Integer.parseInt(traderIDTextField.getText());
                        for (int i = 0; i < simulation.traders.size(); i++) {
                            if (traderID == simulation.traders.get(i).getTraderID()) {
                                Trader trader = simulation.traders.get(i);
                                stage.close();
                                Stage stage = new Stage();
                                GridPane grid = new GridPane();
                                grid.setPadding(new Insets(50, 50, 50, 100));
                                grid.setHgap(50);
                                grid.setVgap(50);
                                Scene scene = new Scene(grid, 500, 600, Color.WHITE);

                                Label title = new Label("Edit Trader");
                                title.getStyleClass().add("title");
                                title.setTranslateX(100);
                                grid.add(title, 0, 0);

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
                                traderIDTextField.setText("" + trader.getTraderID());
                                traderIDTextField.setEditable(false);
                                grid.add(traderIDTextField, 1, 1);

                                TextField nameTextField = new TextField();
                                nameTextField.setText(trader.name);
                                grid.add(nameTextField, 1, 2);

                                ObservableList<String> licenceOptions = FXCollections.observableArrayList("True", "False");
                                ComboBox licenceComboBox = new ComboBox(licenceOptions);
                                if (trader.licence) {
                                    licenceComboBox.getSelectionModel().select("True");
                                } else {
                                    licenceComboBox.getSelectionModel().select("False");
                                }
                                grid.add(licenceComboBox, 1, 3);

                                TextField companyTextField = new TextField();
                                companyTextField.setText(trader.company);
                                grid.add(companyTextField, 1, 4);

                                ObservableList<String> typeOptions = FXCollections.observableArrayList("Intelligent", "Random");
                                ComboBox typeComboBox = new ComboBox(typeOptions);
                                if (trader.type == TraderType.Intelligent) {
                                    typeComboBox.getSelectionModel().select("Intelligent");
                                } else {
                                    typeComboBox.getSelectionModel().select("Random");
                                }
                                grid.add(typeComboBox, 1, 5);

                                Button okButton = new Button("Ok");
                                okButton.getStyleClass().add("okButton");
                                grid.add(okButton, 0, 6);
                                okButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent t) {
                                        boolean licence = false;
                                        TraderType type = TraderType.Random;
                                        if (licenceComboBox.getValue().equals("True")) {
                                            licence = true;
                                        }
                                        if (typeComboBox.getValue().equals("Intelligent")) {
                                            type = TraderType.Intelligent;
                                        }
                                        trader.setName(nameTextField.getText());
                                        trader.setLicence(licence);
                                        trader.setCompany(companyTextField.getText());
                                        trader.setType(type);
                                        stage.close();
                                        Alert confirm = new Alert(AlertType.INFORMATION);
                                        confirm.setTitle("Confirmation");
                                        confirm.setHeaderText(null);
                                        confirm.setContentText("Trader " + nameTextField.getText() + " has been edited.");
                                        confirm.showAndWait();
                                    }
                                });

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
                        }
                    }

                });

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
        removeTraderMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
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
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        int traderID = Integer.parseInt(traderIDTextField.getText());
                        for (int i = 0; i < simulation.traders.size(); i++) {
                            if (traderID == simulation.traders.get(i).getTraderID()) {
                                Trader removedTrader = simulation.traders.get(i);
                                simulation.traders.remove(i);
                                stage.close();
                                Alert confirm = new Alert(AlertType.INFORMATION);
                                confirm.setTitle("Confirmation");
                                confirm.setHeaderText(null);
                                confirm.setContentText("Trader " + removedTrader.name + " has been removed.");
                                confirm.showAndWait();
                            }
                        }
                    }

                });
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

        traderMenu.getItems().addAll(addTraderMenuItem, new SeparatorMenuItem(), editTraderMenuItem, new SeparatorMenuItem(), removeTraderMenuItem);

        //Create Client menu - Add Client, Edit Client, Remove Client
        Menu clientMenu = new Menu("Client");
        MenuItem addClientMenuItem = new MenuItem("Add Client");
        addClientMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(50, 50, 50, 100));
                grid.setHgap(50);
                grid.setVgap(50);
                Scene scene = new Scene(grid, 500, 600, Color.WHITE);

                Label title = new Label("Add Client");
                title.getStyleClass().add("title");
                title.setTranslateX(100);
                grid.add(title, 0, 0);

                Label clientIDLabel = new Label("ClientID");
                grid.add(clientIDLabel, 0, 1);

                Label nameLabel = new Label("Name");
                grid.add(nameLabel, 0, 2);

                Label riskLabel = new Label("Risk");
                grid.add(riskLabel, 0, 3);

                Label returnLabel = new Label("Return");
                grid.add(returnLabel, 0, 4);

                TextField clientIDTextField = new TextField();
                clientIDTextField.setText("" + (1 + simulation.clients.get(simulation.clients.size() - 1).getClientID()));
                clientIDTextField.setEditable(false);
                grid.add(clientIDTextField, 1, 1);

                TextField nameTextField = new TextField();
                grid.add(nameTextField, 1, 2);

                TextField riskTextField = new TextField();
                grid.add(riskTextField, 1, 3);

                TextField returnTextField = new TextField();
                grid.add(returnTextField, 1, 4);

                Button okButton = new Button("Ok");
                okButton.getStyleClass().add("okButton");
                grid.add(okButton, 0, 5);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        int risk = Integer.parseInt(riskTextField.getText());
                        int returnVal = Integer.parseInt(returnTextField.getText());
                        simulation.clients.add(new Client(nameTextField.getText(), risk, returnVal));
                        stage.close();
                        Alert confirm = new Alert(AlertType.INFORMATION);
                        confirm.setTitle("Confirmation");
                        confirm.setHeaderText(null);
                        confirm.setContentText("Client " + nameTextField.getText() + " has been added.");
                        confirm.showAndWait();
                    }
                });
                Button cancelButton = new Button("Cancel");
                cancelButton.getStyleClass().add("cancelButton");
                cancelButton.setTranslateX(30);
                cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        stage.close();
                    }
                });
                grid.add(cancelButton, 1, 5);

                stage.setScene(scene);
                stage.centerOnScreen();
                scene.getStylesheets().add("MenuCascadeStyleSheet.css");
                stage.show();
            }

        });
        MenuItem editClientMenuItem = new MenuItem("Edit Client");
        editClientMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(50, 50, 50, 100));
                grid.setHgap(50);
                grid.setVgap(50);
                Scene scene = new Scene(grid, 600, 250, Color.WHITE);

                Label clientIDLabel = new Label("ClientID");
                grid.add(clientIDLabel, 0, 0);

                TextField clientIDTextField = new TextField();
                grid.add(clientIDTextField, 1, 0);

                Button okButton = new Button("Ok");
                okButton.getStyleClass().add("okButton");
                okButton.setTranslateX(50);
                grid.add(okButton, 0, 1);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        int clientID = Integer.parseInt(clientIDTextField.getText());
                        for (int i = 0; i < simulation.clients.size(); i++) {
                            if (clientID == simulation.clients.get(i).getClientID()) {
                                Client client = simulation.clients.get(i);
                                stage.close();
                                Stage stage = new Stage();
                                GridPane grid = new GridPane();
                                grid.setPadding(new Insets(50, 50, 50, 100));
                                grid.setHgap(50);
                                grid.setVgap(50);
                                Scene scene = new Scene(grid, 500, 600, Color.WHITE);

                                Label title = new Label("Edit Client");
                                title.getStyleClass().add("title");
                                title.setTranslateX(100);
                                grid.add(title, 0, 0);

                                Label clientIDLabel = new Label("ClientID");
                                grid.add(clientIDLabel, 0, 1);

                                Label nameLabel = new Label("Name");
                                grid.add(nameLabel, 0, 2);

                                Label riskLabel = new Label("Risk");
                                grid.add(riskLabel, 0, 3);

                                Label returnLabel = new Label("Return");
                                grid.add(returnLabel, 0, 4);

                                TextField clientIDTextField = new TextField();
                                clientIDTextField.setText("" + client.clientID);
                                clientIDTextField.setEditable(false);
                                grid.add(clientIDTextField, 1, 1);

                                TextField nameTextField = new TextField();
                                nameTextField.setText(client.clientName);
                                grid.add(nameTextField, 1, 2);

                                TextField riskTextField = new TextField();
                                riskTextField.setText("" + client.getRisk());
                                grid.add(riskTextField, 1, 3);

                                TextField returnTextField = new TextField();
                                returnTextField.setText("" + client.expectedReturn);
                                grid.add(returnTextField, 1, 4);

                                Button okButton = new Button("Ok");
                                okButton.getStyleClass().add("okButton");
                                grid.add(okButton, 0, 5);
                                okButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent t) {
                                        int risk = Integer.parseInt(riskTextField.getText());
                                        int returnVal = Integer.parseInt(returnTextField.getText());
                                        client.setName(nameTextField.getText());
                                        client.setRisk(risk);
                                        client.setReturn(returnVal);
                                        stage.close();
                                        Alert confirm = new Alert(AlertType.INFORMATION);
                                        confirm.setTitle("Confirmation");
                                        confirm.setHeaderText(null);
                                        confirm.setContentText("Client " + nameTextField.getText() + " has been edited.");
                                        confirm.showAndWait();
                                    }
                                });
                                Button cancelButton = new Button("Cancel");
                                cancelButton.getStyleClass().add("cancelButton");
                                cancelButton.setTranslateX(30);
                                cancelButton.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent e) {
                                        stage.close();
                                    }
                                });
                                grid.add(cancelButton, 1, 5);

                                stage.setScene(scene);
                                stage.centerOnScreen();
                                scene.getStylesheets().add("MenuCascadeStyleSheet.css");
                                stage.show();
                            }
                        }
                    }

                });
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
        MenuItem removeClientMenuItem = new MenuItem("Remove Client");
        removeClientMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Stage stage = new Stage();
                GridPane grid = new GridPane();
                grid.setPadding(new Insets(50, 50, 50, 100));
                grid.setHgap(50);
                grid.setVgap(50);
                Scene scene = new Scene(grid, 600, 250, Color.WHITE);

                Label clientIDLabel = new Label("ClientID");
                grid.add(clientIDLabel, 0, 0);

                TextField clientIDTextField = new TextField();
                grid.add(clientIDTextField, 1, 0);

                Button okButton = new Button("Ok");
                okButton.getStyleClass().add("okButton");
                okButton.setTranslateX(50);
                grid.add(okButton, 0, 1);
                okButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        int traderID = Integer.parseInt(clientIDTextField.getText());
                        for (int i = 0; i < simulation.clients.size(); i++) {
                            if (traderID == simulation.clients.get(i).getClientID()) {
                                Client removedClient = simulation.clients.get(i);
                                simulation.clients.remove(i);
                                stage.close();
                                Alert confirm = new Alert(AlertType.INFORMATION);
                                confirm.setTitle("Confirmation");
                                confirm.setHeaderText(null);
                                confirm.setContentText("Client " + removedClient.clientName + " has been removed.");
                                confirm.showAndWait();
                            }
                        }
                    }

                });
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
        clientMenu.getItems().addAll(addClientMenuItem, new SeparatorMenuItem(), editClientMenuItem, new SeparatorMenuItem(), removeClientMenuItem);

        menuBar.getMenus().addAll(fileMenu, stockMenu, traderMenu, clientMenu);

        Label indexLabel = new Label("Market Index: " + simulation.stockMarket.index);
        indexLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        indexLabel.setTranslateX(200);
        indexLabel.setMinWidth(200);

        Label marketLabel = new Label("Market Type: " + simulation.stockMarket.getMarketStatus());
        marketLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        marketLabel.setTranslateX(650);
        marketLabel.setMinWidth(200);
        
        Button runButton = new Button("Run");
        runButton.setTranslateX(150);
        runButton.setTranslateY(500);
        runButton.setMinSize(100, 40);

        HBox hbox = new HBox();
        hbox.setTranslateX(0);
        hbox.setTranslateY(100);
        hbox.getChildren().addAll(indexLabel, marketLabel, runButton);

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
