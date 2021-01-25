/* ....Show License.... */
package basic;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * A chart that displays rectangular bars with heights indicating data values
 * for categories. Used for displaying information when at least one axis has
 * discontinuous or discrete data.
 */
public class ChartAppBar extends Application {
 
    private StackedBarChart chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private Stage importedStage;
    private static ArrayList<Company> companyList = new ArrayList<Company>();
 
    public Parent createContent() throws IOException {
        CategoryAxis namesXAxis = new CategoryAxis();
        namesXAxis.setLabel("Company Type");

        yAxis = new NumberAxis();
        yAxis.setLabel("Sales ($Billion)");

        chart = new StackedBarChart<>(namesXAxis, yAxis);
        for (int i = 0; i < companyList.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
              barChartSeries.getData().add(new XYChart.Data(String.valueOf(companyList.get(i).getCompanyType()), companyList.get(i).getCompanySales()));
              chart.getData().add(barChartSeries);
        }
        chart.setTitle("Total Sales By Category");
        chart.setLegendVisible(false);
        
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
      companyList = CompanyList.selectionSortDouble(2);
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