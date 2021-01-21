package basic;

import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
//import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
    // Main method that launches the Javafx gui
    public static void main(String[] args) throws IOException {
        CompanyList Japan = new CompanyList("Japan_largest_companies_edited.csv");
        launch(args);
    }

    public static Scene mianScene;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Japan Company Dataset");

        // Creating a grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Adding a title to the page
        Text scenetitle = new Text("Japan's Largest Companies");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 45));
        grid.add(scenetitle, 0, 5, 15, 15);

        // Adding a button that links to the bubble chart gui
        Button bubbleButton = new Button("See Bubble Graph");
        HBox bblbBtn = new HBox(10);
        bblbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        bblbBtn.getChildren().add(bubbleButton);
        grid.add(bblbBtn, 1, 25);
        bubbleButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ChartAppBubble bubbleChart = new ChartAppBubble();
                Scene BubbleChartScene;
                try {
                    BubbleChartScene = bubbleChart.getScene(primaryStage);
                    primaryStage.setScene(BubbleChartScene);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        // Adding a button that links to the Bar chart gui
        Button barButton = new Button("See Bar Graph");
        HBox barBtn = new HBox(10);
        barBtn.setAlignment(Pos.BOTTOM_RIGHT);
        barBtn.getChildren().add(barButton);
        grid.add(barBtn, 5, 25);
        barButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ChartAppBar barChart = new ChartAppBar();
                Scene BarChartScene;
                try {
                    BarChartScene = barChart.getScene(primaryStage);
                    primaryStage.setScene(BarChartScene);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        // Adding a button that links to the PIE chart gui
        /*
         * Button pieButton = new Button("See Pie Graph"); HBox pieBtn = new HBox(10);
         * pieBtn.setAlignment(Pos.BOTTOM_RIGHT); pieBtn.getChildren().add(pieButton);
         * grid.add(pieBtn, 9, 25); pieButton.setOnAction(new
         * EventHandler<ActionEvent>() {
         * 
         * @Override public void handle(ActionEvent event) { ChartAppPie pieChart = new
         * ChartAppPie(); Scene PieChartScene = pieChart.getScene(primaryStage);
         * primaryStage.setScene(PieChartScene); } });
         */

        Button tableView = new Button("See Pie Graph");
        HBox tblBtn = new HBox(10);
        tblBtn.setAlignment(Pos.BOTTOM_RIGHT);
        tblBtn.getChildren().add(tableView);
        grid.add(tblBtn, 9, 25);
        tableView.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                TableAppView tableApp = new TableAppView();
                Scene tableAppScene;
                try {
                    tableAppScene = tableApp.getScene(primaryStage);
                    primaryStage.setScene(tableAppScene);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        

        // The Main Page Scene
        mianScene = new Scene(grid, 800, 500);
        primaryStage.setScene(mianScene);
        primaryStage.show();
    }

    // Setting the Scene back to main scene
    public static void setOwnStage(Stage primaryStageImport) {
        primaryStageImport.setScene(mianScene);
    }

}