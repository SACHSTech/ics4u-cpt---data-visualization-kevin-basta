/* ....Show License.... */
package basic;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
 
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
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */
public class ChartAppBar extends Application {
 
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    private Stage importedStage;
 
    public Parent createContent() {
        String[] years = {"2007", "2008", "2009"};
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("Units Sold", 0.0d, 3000.0d, 1000.0d);
        ObservableList<BarChart.Series> barChartData =
            FXCollections.observableArrayList(
              new BarChart.Series("Apples", FXCollections.observableArrayList(
                new BarChart.Data(years[0], 567d),
                new BarChart.Data(years[1], 1292d),
                new BarChart.Data(years[2], 1292d))),
              new BarChart.Series("Lemons", FXCollections.observableArrayList(
                new BarChart.Data(years[0], 956),
                new BarChart.Data(years[1], 1665),
                new BarChart.Data(years[2], 2559))),
              new BarChart.Series("Oranges", FXCollections.observableArrayList(
                new BarChart.Data(years[0], 1154),
                new BarChart.Data(years[1], 1927),
                new BarChart.Data(years[2], 2774)))
            );
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0d);
        
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