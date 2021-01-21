package basic;

import java.io.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
 * A simple table with a header row.
 */
public class TableAppView extends Application {
    private Stage importedStage;

    public Parent createContent() throws IOException {
        ArrayList<Company> companyDataList = new ArrayList<Company>();
        companyDataList = CompanyList.getArrayList(); 
                            
        final ObservableList<Company> data = FXCollections.observableArrayList();

        for (int i = 0; i < companyDataList.size(); i++) {
            String[] singleCompanyDataValue = {String.valueOf(companyDataList.get(i).getCompanyRank())
                , companyDataList.get(i).getCompanyName()
                , String.valueOf(companyDataList.get(i).getCompanySales())
                , String.valueOf(companyDataList.get(i).getCompanyProfit())
                , String.valueOf(companyDataList.get(i).getCompanyAssets())
                , String.valueOf(companyDataList.get(i).getCompanyMarketValue())
                , companyDataList.get(i).getCompanyType()
                , companyDataList.get(i).getCompanyDescription()};

            data.add(new Company(singleCompanyDataValue));
        }
        
        TableColumn globalRank = new TableColumn();
        globalRank.setText("Global Rank");
        globalRank.setCellValueFactory(new PropertyValueFactory("getCompanyRank"));

        TableColumn companyName = new TableColumn();
        companyName.setText("Company");
        companyName.setCellValueFactory(new PropertyValueFactory("getCompanyName"));

        TableColumn companySales = new TableColumn();
        companySales.setText("Sales");
        companySales.setCellValueFactory(new PropertyValueFactory("getCompanySales"));

        TableColumn companyProfits = new TableColumn();
        companyProfits.setText("Profits");
        companyProfits.setCellValueFactory(new PropertyValueFactory("getCompanyProfit"));

        TableColumn companyAssets = new TableColumn();
        companyAssets.setText("Assets");
        companyAssets.setCellValueFactory(new PropertyValueFactory("getCompanyAssets"));

        TableColumn companyMarketValue = new TableColumn();
        companyMarketValue.setText("Market Value");
        companyMarketValue.setCellValueFactory(new PropertyValueFactory("getCompanyMarketValue"));

        TableColumn companyType = new TableColumn();
        companyType.setText("Type");
        companyType.setCellValueFactory(new PropertyValueFactory("getCompanyType"));

        TableColumn companyDescription = new TableColumn();
        companyDescription.setText("Description");
        companyDescription.setMinWidth(3000);
        companyDescription.setCellValueFactory(new PropertyValueFactory("getCompanyDescription"));

        final TableView tableView = new TableView();
        tableView.setItems(data);
        tableView.getColumns().addAll(globalRank, companyName, companySales, companyProfits, companyAssets, companyMarketValue, companyType, companyDescription);

        // SETTING UP BUTTONS
        StackPane spLineChart = new StackPane();
        spLineChart.getChildren().add(tableView);

        Button button = new Button("<< Go Back");
        button.setOnMouseClicked((event)->{
            
            Main.setOwnStage(importedStage);
            //System.out.println("You just clicked me");
        });
        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);

        VBox vbox = new VBox();
        VBox.setVgrow(spLineChart, Priority.ALWAYS);//Make line chart always grow vertically
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
    public static void main(String[] args) throws IOException {
        CompanyList Japan = new CompanyList("Japan_largest_companies_edited.csv");
        launch(args);
    }
}