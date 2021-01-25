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
 
    public Parent createContent() throws IOException {
        CategoryAxis namesXAxis = new CategoryAxis();
        namesXAxis.setLabel("Company Type");

        xAxis = new NumberAxis();
        xAxis.setLabel("x");

        yAxis = new NumberAxis();
        yAxis.setLabel("Sales ($Billion)");

        chart = new StackedBarChart<>(namesXAxis, yAxis);

        ArrayList<Company> carsArray = CompanyList.sortByCatagory(6, "Cars");
        carsArray = CompanyList.selectionSortDoubleNewArray(2, carsArray);
        for (int i = 0; i < carsArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(carsArray.get(i).getCompanyType()), carsArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> ConglomerateArray = CompanyList.sortByCatagory(6, "Conglomerate");
        ConglomerateArray = CompanyList.selectionSortDoubleNewArray(2, ConglomerateArray);
        for (int i = 0; i < ConglomerateArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(ConglomerateArray.get(i).getCompanyType()), ConglomerateArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> TechnologyArray = CompanyList.sortByCatagory(6, "Technology");
        TechnologyArray = CompanyList.selectionSortDoubleNewArray(2, TechnologyArray);
        for (int i = 0; i < TechnologyArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(TechnologyArray.get(i).getCompanyType()), TechnologyArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> UtilityArray = CompanyList.sortByCatagory(6, "Utility");
        UtilityArray = CompanyList.selectionSortDoubleNewArray(2, UtilityArray);
        for (int i = 0; i < UtilityArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(UtilityArray.get(i).getCompanyType()), UtilityArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> RetailArray = CompanyList.sortByCatagory(6, "Retail");
        RetailArray = CompanyList.selectionSortDoubleNewArray(2, RetailArray);
        for (int i = 0; i < RetailArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(RetailArray.get(i).getCompanyType()), RetailArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> BankArray = CompanyList.sortByCatagory(6, "Bank");
        BankArray = CompanyList.selectionSortDoubleNewArray(2, BankArray);
        for (int i = 0; i < BankArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(BankArray.get(i).getCompanyType()), BankArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> ManufactureArray = CompanyList.sortByCatagory(6, "Manufacture");
        ManufactureArray = CompanyList.selectionSortDoubleNewArray(2, ManufactureArray);
        for (int i = 0; i < ManufactureArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(ManufactureArray.get(i).getCompanyType()), ManufactureArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> TransportArray = CompanyList.sortByCatagory(6, "Transport");
        TransportArray = CompanyList.selectionSortDoubleNewArray(2, TransportArray);
        for (int i = 0; i < TransportArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(TransportArray.get(i).getCompanyType()), TransportArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> PharmacyArray = CompanyList.sortByCatagory(6, "Pharmacy");
        PharmacyArray = CompanyList.selectionSortDoubleNewArray(2, PharmacyArray);
        for (int i = 0; i < PharmacyArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(PharmacyArray.get(i).getCompanyType()), PharmacyArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        ArrayList<Company> RealEstateArray = CompanyList.sortByCatagory(6, "Real Estate");
        RealEstateArray = CompanyList.selectionSortDoubleNewArray(2, RealEstateArray);
        for (int i = 0; i < RealEstateArray.size(); i++) {
          XYChart.Series barChartSeries = new XYChart.Series<>();
          barChartSeries.getData().add(new XYChart.Data(String.valueOf(RealEstateArray.get(i).getCompanyType()), RealEstateArray.get(i).getCompanySales()));
          chart.getData().add(barChartSeries);        
        }

        final String BarChartCss = getClass().getResource("ChartAppBubbleStyle.css").toExternalForm();
        chart.getStylesheets().add(BarChartCss);
        chart.setTitle("Total Sales By Catagory");
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