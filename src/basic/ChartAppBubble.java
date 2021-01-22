package basic;

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
 * An advanced bubble chart with a variety of actions and settable properties.
 */
public class ChartAppBubble extends Application {
 
    private BubbleChart<Number, Number> chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    private Stage importedStage;
    
    public Parent createContent() throws IOException {
        chart = createChart();
        
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

        VBox vbox = new VBox();
        VBox.setVgrow(spLineChart, Priority.ALWAYS);
        vbox.getChildren().addAll(spLineChart, spButton);

        return vbox;
    }
 
    private BubbleChart<Number, Number> createChart() throws IOException {
        xAxis = new NumberAxis();
        yAxis = new NumberAxis();
        final BubbleChart<Number, Number> bc = new BubbleChart<>(xAxis, yAxis);
        
        // setup chart
        final String bubbleChartCss =
            getClass().getResource("ChartAppBubbleStyle.css").toExternalForm();
        bc.getStylesheets().add(bubbleChartCss);
        bc.setTitle("Profits vs. Market Value BubbleChart");
        xAxis.setLabel("Market Value ($billion)");
        yAxis.setLabel("Profits ($billion)");

        // add starting data
        ArrayList<Company> carsArray = CompanyList.sortByCatagory(6, "Cars");
        XYChart.Series<Number, Number> Cars = new XYChart.Series<>();
        Cars.setName("Cars");
        for (int i = 0; i < carsArray.size(); i++) {
            Cars.getData().add(new XYChart.Data<Number, Number>(
                carsArray.get(i).getCompanyMarketValue(), // x values
                carsArray.get(i).getCompanyProfit(),// y values
                1)); // how big the circle is
        }

        ArrayList<Company> bankArray = CompanyList.sortByCatagory(6, "Bank");
        XYChart.Series<Number, Number> Banks = new XYChart.Series<>();
        Banks.setName("Banks");
        for (int i = 0; i < bankArray.size(); i++) {
            Banks.getData().add(new XYChart.Data<Number, Number>(
                bankArray.get(i).getCompanyMarketValue(), // x values
                bankArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> utilityArray = CompanyList.sortByCatagory(6, "Utility");
        XYChart.Series<Number, Number> Utilitys = new XYChart.Series<>();
        Utilitys.setName("Utilities");
        for (int i = 0; i < utilityArray.size(); i++) {
            Utilitys.getData().add(new XYChart.Data<Number, Number>(
                utilityArray.get(i).getCompanyMarketValue(), // x values
                utilityArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> conglomerateArray = CompanyList.sortByCatagory(6, "Conglomerate");        
        XYChart.Series<Number, Number> Conglomerates = new XYChart.Series<>();
        Conglomerates.setName("Conglomerate");
        for (int i = 0; i < conglomerateArray.size(); i++) {
            Conglomerates.getData().add(new XYChart.Data<Number, Number>(
                conglomerateArray.get(i).getCompanyMarketValue(), // x values
                conglomerateArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> tradeArray = CompanyList.sortByCatagory(6, "Trade");
        XYChart.Series<Number, Number> Trades = new XYChart.Series<>();
        Trades.setName("Trade");
        for (int i = 0; i < tradeArray.size(); i++) {
            Trades.getData().add(new XYChart.Data<Number, Number>(
                tradeArray.get(i).getCompanyMarketValue(), // x values
                tradeArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> technologyArray = CompanyList.sortByCatagory(6, "Technology");
        XYChart.Series<Number, Number> Technologies = new XYChart.Series<>();
        Technologies.setName("Technology");
        for (int i = 0; i < technologyArray.size(); i++) {
            Technologies.getData().add(new XYChart.Data<Number, Number>(
                technologyArray.get(i).getCompanyMarketValue(), // x values
                technologyArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> foodAndDrinkArray = CompanyList.sortByCatagory(6, "Food and drink");
        XYChart.Series<Number, Number> Foods = new XYChart.Series<>();
        Foods.setName("Food and drink");
        for (int i = 0; i < foodAndDrinkArray.size(); i++) {
            Foods.getData().add(new XYChart.Data<Number, Number>(
                foodAndDrinkArray.get(i).getCompanyMarketValue(), // x values
                foodAndDrinkArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> transportArray = CompanyList.sortByCatagory(6, "Transport");
        XYChart.Series<Number, Number> Transports = new XYChart.Series<>();
        Transports.setName("Transport");
        for (int i = 0; i < transportArray.size(); i++) {
            Transports.getData().add(new XYChart.Data<Number, Number>(
                transportArray.get(i).getCompanyMarketValue(), // x values
                transportArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> retailArray = CompanyList.sortByCatagory(6, "Retail");
        XYChart.Series<Number, Number> Retails = new XYChart.Series<>();
        Retails.setName("Retail");
        for (int i = 0; i < retailArray.size(); i++) {
            Retails.getData().add(new XYChart.Data<Number, Number>(
                retailArray.get(i).getCompanyMarketValue(), // x values
                retailArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> pharmacyArray = CompanyList.sortByCatagory(6, "Pharmacy");
        XYChart.Series<Number, Number> Pharmacies = new XYChart.Series<>();
        Pharmacies.setName("Pharmacy");
        for (int i = 0; i < pharmacyArray.size(); i++) {
            Pharmacies.getData().add(new XYChart.Data<Number, Number>(
                pharmacyArray.get(i).getCompanyMarketValue(), // x values
                pharmacyArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> manufactureArray = CompanyList.sortByCatagory(6, "Manufacture");
        XYChart.Series<Number, Number> Manufactures = new XYChart.Series<>();
        Manufactures.setName("Manufacture");
        for (int i = 0; i < manufactureArray.size(); i++) {
            Manufactures.getData().add(new XYChart.Data<Number, Number>(
                manufactureArray.get(i).getCompanyMarketValue(), // x values
                manufactureArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> realEstatesArray = CompanyList.sortByCatagory(6, "Real Estate");
        XYChart.Series<Number, Number> RealEstates = new XYChart.Series<>();
        RealEstates.setName("Real Estate");
        for (int i = 0; i < realEstatesArray.size(); i++) {
            RealEstates.getData().add(new XYChart.Data<Number, Number>(
                realEstatesArray.get(i).getCompanyMarketValue(), // x values
                realEstatesArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> InsuranceArray = CompanyList.sortByCatagory(6, "Insurance");
        XYChart.Series<Number, Number> Insurances = new XYChart.Series<>();
        Insurances.setName("Insurance");
        for (int i = 0; i < InsuranceArray.size(); i++) {
            Insurances.getData().add(new XYChart.Data<Number, Number>(
                InsuranceArray.get(i).getCompanyMarketValue(), // x values
                InsuranceArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> entertainmentArray = CompanyList.sortByCatagory(6, "Entertainment");
        XYChart.Series<Number, Number> Entertainments = new XYChart.Series<>();
        Entertainments.setName("Entertainment");
        for (int i = 0; i < entertainmentArray.size(); i++) {
            Entertainments.getData().add(new XYChart.Data<Number, Number>(
                entertainmentArray.get(i).getCompanyMarketValue(), // x values
                entertainmentArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> constructionArray = CompanyList.sortByCatagory(6, "Construction");
        XYChart.Series<Number, Number> Constructions = new XYChart.Series<>();
        Constructions.setName("Construction");
        for (int i = 0; i < constructionArray.size(); i++) {
            Constructions.getData().add(new XYChart.Data<Number, Number>(
                constructionArray.get(i).getCompanyMarketValue(), // x values
                constructionArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> mediaArray = CompanyList.sortByCatagory(6, "Media");
        XYChart.Series<Number, Number> Medias = new XYChart.Series<>();
        Medias.setName("Media");
        for (int i = 0; i < mediaArray.size(); i++) {
            Medias.getData().add(new XYChart.Data<Number, Number>(
                mediaArray.get(i).getCompanyMarketValue(), // x values
                mediaArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        ArrayList<Company> convenienceArray = CompanyList.sortByCatagory(6, "Convenience ");
        XYChart.Series<Number, Number> Conveniences = new XYChart.Series<>();
        Conveniences.setName("Convenience");
        for (int i = 0; i < convenienceArray.size(); i++) {
            Conveniences.getData().add(new XYChart.Data<Number, Number>(
                convenienceArray.get(i).getCompanyMarketValue(), // x values
                convenienceArray.get(i).getCompanyProfit(), // y values
                1)); // how big the circle is
        }

        bc.getData().addAll(Cars, Banks, Utilitys, Conglomerates, Trades, Technologies, Foods, Transports, Retails, Pharmacies, Manufactures, RealEstates, Insurances, Entertainments, Constructions, Medias, Conveniences);
        
        return bc;
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
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