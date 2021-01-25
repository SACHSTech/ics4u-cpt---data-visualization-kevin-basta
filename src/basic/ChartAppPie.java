package basic;

import java.io.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
 
/**
 * A circular chart divided into segments. The value of each segment represents
 * a proportion of the total.
 */
public class ChartAppPie extends Application {
    private static ArrayList<Company> companyList = new ArrayList<Company>();
    private Stage importedStage;
    private PieChart chart;

    private void generateData() {
        chart = new PieChart();
        for (int i = 0; i < 50; i++) {
            PieChart.Data pieChartData= new PieChart.Data(companyList.get(i).getCompanyName(), companyList.get(i).getCompanyAssets());
            chart.getData().add(pieChartData);
        }
        chart.setTitle("Top 50 Company Assets In Billions");
        chart.setClockwise(false);
    }
 
    public Parent createContent() {
        generateData();
        
        // SETTING UP BUTTONS
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().add(chart);

        Button button = new Button("<< Go Back");
        button.setOnMouseClicked((event)->{
            
            Main.setOwnStage(importedStage);
            //System.out.println("You just clicked me");
        });
        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);
        spButton.setPadding(new Insets(5, 5, 5, 5));
        spButton.setAlignment(Pos.BASELINE_RIGHT);
         
        VBox vbox = new VBox();
        VBox.setVgrow(spLineChart, Priority.ALWAYS);
        vbox.setMargin(spButton, new Insets(0, 30, 0, 75));
        vbox.getChildren().addAll(spLineChart, spButton);

        return vbox;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
 
    // Sending the scene to the main javafx file
    public Scene getScene(Stage theStage) throws IOException {
        companyList = CompanyList.selectionSortDouble(4);
        importedStage = theStage;
        return new Scene(createContent(), 800, 500);
    }

    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}