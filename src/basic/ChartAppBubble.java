package basic;

import java.io.*;
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
 
/**
 * An advanced bubble chart with a variety of actions and settable properties.
 */
public class ChartAppBubble extends Application {
 
    private BubbleChart<Number, Number> chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
 
    public Parent createContent() throws IOException {
        chart = createChart();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Adding a button that links to the home gui
        Button HomeButton = new Button("Go Back");
        HBox HomeBtn = new HBox(100);
        HomeBtn.setAlignment(Pos.BOTTOM_RIGHT);
        HomeBtn.getChildren().add(HomeButton);
        grid.add(HomeBtn, 5, 25);
        HomeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Main mainClass  = new Main();
                Scene mainScene = mainClass.getScene();
                //primaryStage.setScene(mainScene);
            }
        });
        return chart;
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
        String carsArray[][] = Search.getCatagoryArray(6, "Cars");
        XYChart.Series<Number, Number> Cars = new XYChart.Series<>();
        Cars.setName("Cars");
        for (int i = 0; i < carsArray.length; i++) {
            Cars.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(carsArray[i][5]), // x values
                Double.parseDouble(carsArray[i][3]), // y values
                1)); // how big the circle is
        }

        String bankArray[][] = Search.getCatagoryArray(6, "Bank");
        XYChart.Series<Number, Number> Banks = new XYChart.Series<>();
        Banks.setName("Banks");
        for (int i = 0; i < bankArray.length; i++) {
            Banks.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(bankArray[i][5]), // x values
                Double.parseDouble(bankArray[i][3]), // y values
                1)); // how big the circle is
        }

        
        String utilityArray[][] = Search.getCatagoryArray(6, "Utility");
        XYChart.Series<Number, Number> Utilitys = new XYChart.Series<>();
        Utilitys.setName("Utilities");
        for (int i = 0; i < utilityArray.length; i++) {
            Utilitys.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(utilityArray[i][5]), // x values
                Double.parseDouble(utilityArray[i][3]), // y values
                1)); // how big the circle is
        }

        
        String conglomerateArray[][] = Search.getCatagoryArray(6, "Conglomerate");
        XYChart.Series<Number, Number> Conglomerates = new XYChart.Series<>();
        Conglomerates.setName("Conglomerate");
        for (int i = 0; i < conglomerateArray.length; i++) {
            Conglomerates.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(conglomerateArray[i][5]), // x values
                Double.parseDouble(conglomerateArray[i][3]), // y values
                1)); // how big the circle is
        }


        String tradeArray[][] = Search.getCatagoryArray(6, "Trade");
        XYChart.Series<Number, Number> Trades = new XYChart.Series<>();
        Trades.setName("Trade");
        for (int i = 0; i < tradeArray.length; i++) {
            Trades.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(tradeArray[i][5]), // x values
                Double.parseDouble(tradeArray[i][3]), // y values
                1)); // how big the circle is
        }

        String technologyArray[][] = Search.getCatagoryArray(6, "Technology");
        XYChart.Series<Number, Number> Technologies = new XYChart.Series<>();
        Technologies.setName("Technology");
        for (int i = 0; i < technologyArray.length; i++) {
            Technologies.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(technologyArray[i][5]), // x values
                Double.parseDouble(technologyArray[i][3]), // y values
                1)); // how big the circle is
        }

        String foodAndDrinkArray[][] = Search.getCatagoryArray(6, "Food and drink");
        XYChart.Series<Number, Number> Foods = new XYChart.Series<>();
        Foods.setName("Food and drink");
        for (int i = 0; i < foodAndDrinkArray.length; i++) {
            Foods.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(foodAndDrinkArray[i][5]), // x values
                Double.parseDouble(foodAndDrinkArray[i][3]), // y values
                1)); // how big the circle is
        }

        String transportArray[][] = Search.getCatagoryArray(6, "Transport");
        XYChart.Series<Number, Number> Transports = new XYChart.Series<>();
        Transports.setName("Transport");
        for (int i = 0; i < transportArray.length; i++) {
            Transports.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(transportArray[i][5]), // x values
                Double.parseDouble(transportArray[i][3]), // y values
                1)); // how big the circle is
        }

        String retailArray[][] = Search.getCatagoryArray(6, "Retail");
        XYChart.Series<Number, Number> Retails = new XYChart.Series<>();
        Retails.setName("Retail");
        for (int i = 0; i < retailArray.length; i++) {
            Retails.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(retailArray[i][5]), // x values
                Double.parseDouble(retailArray[i][3]), // y values
                1)); // how big the circle is
        }

        String pharmacyArray[][] = Search.getCatagoryArray(6, "Pharmacy");
        XYChart.Series<Number, Number> Pharmacies = new XYChart.Series<>();
        Pharmacies.setName("Pharmacy");
        for (int i = 0; i < pharmacyArray.length; i++) {
            Pharmacies.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(pharmacyArray[i][5]), // x values
                Double.parseDouble(pharmacyArray[i][3]), // y values
                1)); // how big the circle is
        }

        String manufactureArray[][] = Search.getCatagoryArray(6, "Manufacture");
        XYChart.Series<Number, Number> Manufactures = new XYChart.Series<>();
        Manufactures.setName("Manufacture");
        for (int i = 0; i < manufactureArray.length; i++) {
            Manufactures.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(manufactureArray[i][5]), // x values
                Double.parseDouble(manufactureArray[i][3]), // y values
                1)); // how big the circle is
        }

        String realEstatesArray[][] = Search.getCatagoryArray(6, "Real Estate");
        XYChart.Series<Number, Number> RealEstates = new XYChart.Series<>();
        RealEstates.setName("Real Estate");
        for (int i = 0; i < realEstatesArray.length; i++) {
            RealEstates.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(realEstatesArray[i][5]), // x values
                Double.parseDouble(realEstatesArray[i][3]), // y values
                1)); // how big the circle is
        }

        String InsuranceArray[][] = Search.getCatagoryArray(6, "Insurance");
        XYChart.Series<Number, Number> Insurances = new XYChart.Series<>();
        Insurances.setName("Insurance");
        for (int i = 0; i < InsuranceArray.length; i++) {
            Insurances.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(InsuranceArray[i][5]), // x values
                Double.parseDouble(InsuranceArray[i][3]), // y values
                1)); // how big the circle is
        }

        String entertainmentArray[][] = Search.getCatagoryArray(6, "Entertainment");
        XYChart.Series<Number, Number> Entertainments = new XYChart.Series<>();
        Entertainments.setName("Entertainment");
        for (int i = 0; i < entertainmentArray.length; i++) {
            Entertainments.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(entertainmentArray[i][5]), // x values
                Double.parseDouble(entertainmentArray[i][3]), // y values
                1)); // how big the circle is
        }

        String constructionArray[][] = Search.getCatagoryArray(6, "Construction");
        XYChart.Series<Number, Number> Constructions = new XYChart.Series<>();
        Constructions.setName("Construction");
        for (int i = 0; i < constructionArray.length; i++) {
            Constructions.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(constructionArray[i][5]), // x values
                Double.parseDouble(constructionArray[i][3]), // y values
                1)); // how big the circle is
        }


        String mediaArray[][] = Search.getCatagoryArray(6, "Media");
        XYChart.Series<Number, Number> Medias = new XYChart.Series<>();
        Medias.setName("Media");
        for (int i = 0; i < mediaArray.length; i++) {
            Medias.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(mediaArray[i][5]), // x values
                Double.parseDouble(mediaArray[i][3]), // y values
                1)); // how big the circle is
        }

        String convenienceArray[][] = Search.getCatagoryArray(6, "Convenience");
        XYChart.Series<Number, Number> Conveniences = new XYChart.Series<>();
        Conveniences.setName("Convenience");
        for (int i = 0; i < convenienceArray.length; i++) {
            Conveniences.getData().add(new XYChart.Data<Number, Number>(
                Double.parseDouble(convenienceArray[i][5]), // x values
                Double.parseDouble(convenienceArray[i][3]), // y values
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
    public Scene getScene() throws IOException {
        return new Scene(createContent(), 800, 500);
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}