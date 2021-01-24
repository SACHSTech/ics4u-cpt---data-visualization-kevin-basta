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
 
    private PieChart chart;
    private Stage importedStage;
 
    public static ObservableList<PieChart.Data> generateData() {
        return FXCollections.observableArrayList(
                new PieChart.Data("Sun", 20),
                new PieChart.Data("IBM", 12),
                new PieChart.Data("HP", 25),
                new PieChart.Data("Dell", 22),
                new PieChart.Data("Apple", 30));
    }
 
    public Parent createContent() {
        chart = new PieChart(generateData());
        chart.setClockwise(false);
        
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