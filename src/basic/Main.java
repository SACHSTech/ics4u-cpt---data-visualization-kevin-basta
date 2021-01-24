package basic;

import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
    // Main method that launches the Javafx gui
    public static void main(String[] args) throws IOException {
        CompanyList Japan = new CompanyList("Japan_largest_companies_edited.csv");
        launch(args);
    }

    public static Scene mianScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Japan Company Dataset Program");

        // BUBBLE CHART BUTTON
        Button bubbleButton = new Button("Bubble Graph");
        bubbleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChartAppBubble bubbleChart = new ChartAppBubble();
                Scene BubbleChartScene;

                try {
                    BubbleChartScene = bubbleChart.getScene(primaryStage);
                    primaryStage.setScene(BubbleChartScene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        // BAR CHART BUTTON
        Button barButton = new Button("Bar Graph");
        barButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChartAppBar barChart = new ChartAppBar();
                Scene BarChartScene;

                try {
                    BarChartScene = barChart.getScene(primaryStage);
                    primaryStage.setScene(BarChartScene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        // PIE CHART BUTTON
        Button pieButton = new Button("Pie Chart");
        pieButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ChartAppPie pieChart = new ChartAppPie();
                Scene PieChartScene;

                try {
                    PieChartScene = pieChart.getScene(primaryStage);
                    primaryStage.setScene(PieChartScene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        // TABLE VIEW BUTTON
        Button tableView = new Button("Filter and Sort");
        tableView.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableAppView tableApp = new TableAppView();
                Scene tableAppScene;

                try {
                    tableAppScene = tableApp.getScene(primaryStage);
                    primaryStage.setScene(tableAppScene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        

        // SEARCH BUTTON
        Button searchView = new Button("Search and View Records");
        searchView.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableAppViewSearch tableAppSearch = new TableAppViewSearch();
                Scene tableAppSearchScene;

                try {
                    tableAppSearchScene = tableAppSearch.getScene(primaryStage);
                    primaryStage.setScene(tableAppSearchScene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


       // SUMMARY BUTTON
       Button summaryView = new Button("Data Summary");
       summaryView.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               TableAppViewSearch tableAppSearch = new TableAppViewSearch();
               Scene tableAppSearchScene;

               try {
                   tableAppSearchScene = tableAppSearch.getScene(primaryStage);
                   primaryStage.setScene(tableAppSearchScene);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       });

        // Making vertical Box
        VBox vbox = new VBox();

        // Adding a title to the page
        Text scenetitle = new Text("Japan's Largest Companies");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 50));
        HBox hbox = new HBox(30);
        hbox.getChildren().addAll(scenetitle);
        hbox.setPadding(new Insets(50, 25, 50, 25));
        hbox.setAlignment(Pos.BASELINE_LEFT);

        // Graphs Section
        Text graphsText = new Text("Visualizers - ");
        graphsText.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        HBox hbox2 = new HBox(8);
        hbox2.getChildren().addAll(graphsText, bubbleButton, barButton, pieButton);
        hbox2.setMargin(graphsText, new Insets(5, 40, 5, 0));
        hbox2.setMargin(bubbleButton, new Insets(5, 40, 5, 0));
        hbox2.setMargin(barButton, new Insets(5, 40, 5, 0));
        hbox2.setMargin(pieButton, new Insets(5, 0, 5, 0));
        hbox2.setPadding(new Insets(0, 100, 50, 100));
        hbox2.setAlignment(Pos.BASELINE_CENTER);

        // Search and Sort Section
        Text searchSortText = new Text("Utility - ");
        searchSortText.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        HBox hbox3 = new HBox(8);
        hbox3.getChildren().addAll(searchSortText, tableView, searchView);
        hbox3.setMargin(searchSortText, new Insets(5, 40, 5, 0));
        hbox3.setMargin(tableView, new Insets(5, 40, 5, 0));
        hbox3.setMargin(searchView, new Insets(5, 0, 5, 0));
        hbox3.setPadding(new Insets(0, 100, 50, 100));
        hbox3.setAlignment(Pos.BASELINE_CENTER);

        // View Summary
        Text summaryText = new Text("Summary - ");
        summaryText.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        HBox hbox4 = new HBox(8);
        hbox4.getChildren().addAll(summaryText, summaryView);
        hbox4.setMargin(summaryText, new Insets(5, 40, 5, 0));
        hbox4.setMargin(summaryView, new Insets(5, 0, 5, 0));
        hbox4.setPadding(new Insets(0, 100, 50, 100));
        hbox4.setAlignment(Pos.BASELINE_CENTER);

        // Putting all the Hboxes into the Vbox
        vbox.getChildren().addAll(hbox, hbox2, hbox3, hbox4);

        // The Main Page Scene
        mianScene = new Scene(vbox, 800, 500);
        primaryStage.setScene(mianScene);
        primaryStage.show();
    }

    // Setting the Scene back to main scene
    public static void setOwnStage(Stage primaryStageImport) {
        primaryStageImport.setScene(mianScene);
    }

    public static void setOwnScene(Stage primaryStageImport, Scene newScene) {
        primaryStageImport.setScene(newScene);
    }

}