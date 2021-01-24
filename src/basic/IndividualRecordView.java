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
//import javafx.scene.paint.Color;
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

public class IndividualRecordView extends Application {
    private Stage importedStage;

    private ArrayList<Company> companyDataList = new ArrayList<Company>();

    public Parent createContent() throws IOException { 

        // MAIN MENUE
        Button button = new Button("<< Go Back To Main Menue");
        button.setOnMouseClicked((event)->{
            Main.setOwnStage(importedStage);
        });
        StackPane spButton = new StackPane();
        spButton.getChildren().add(button);

        // MAIN MENUE
        Button buttonSearch = new Button("<< Go Back To Search");
        buttonSearch.setOnMouseClicked((event)->{
            Main.setOwnStage(importedStage);
        });
        StackPane spButtonSearch = new StackPane();
        spButtonSearch.getChildren().add(buttonSearch);

        // Vertical Wrapper
        VBox vbox = new VBox();

        // Horizontal Wrapper #1
        Text companyName = new Text("COMPANY NAME");
        companyName.setFont(Font.font("Tahoma", FontWeight.BLACK, 50));
        HBox hbox = new HBox(30);
        hbox.getChildren().addAll(companyName);
        hbox.setPadding(new Insets(15, 25, 50, 25));
        hbox.setAlignment(Pos.BASELINE_LEFT);

        // Horizontal Wrapper #2 SMALL TTITLES
        Text type = new Text("TYPE");
        type.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text sales = new Text("SALES");
        sales.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text profits = new Text("PROFT");
        profits.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));

        HBox hbox2 = new HBox(8);
        hbox2.getChildren().addAll(type, sales, profits);
        hbox2.setMargin(type, new Insets(0, 172, 5, 20));
        hbox2.setMargin(sales, new Insets(0, 185, 5, 0));
        hbox2.setMargin(profits, new Insets(0, 180, 5, 0));
        hbox2.setPadding(new Insets(0, 100, 5, 100));
        hbox2.setAlignment(Pos.BASELINE_LEFT);

        // Horizontal Wrapper #3 VALUES
        Text typeValue = new Text("CARS");
        typeValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text salesValue = new Text("2032");
        salesValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text profitsValue = new Text("121");
        profitsValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

        HBox hbox3 = new HBox(8);
        hbox3.getChildren().addAll(typeValue, salesValue, profitsValue);
        hbox3.setMargin(typeValue, new Insets(5, 150, 5, 0));
        hbox3.setMargin(salesValue, new Insets(5, 150, 5, 0));
        hbox3.setMargin(profitsValue, new Insets(5, 150, 5, 0));
        hbox3.setPadding(new Insets(0, 100, 50, 100));
        hbox3.setAlignment(Pos.BASELINE_LEFT);


        // Horizontal Wrapper #5 SMALL TTITLES
        Text globalRank = new Text("GLOBAL RANK");
        globalRank.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text assets = new Text("ASSETS");
        assets.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));
        Text marketValue = new Text("MARKET VALUE");
        marketValue.setFont(Font.font("Tahoma", FontWeight.LIGHT, 10));

        HBox hbox5 = new HBox(8);
        hbox5.getChildren().addAll(globalRank, assets, marketValue);
        hbox5.setMargin(globalRank, new Insets(0, 172, 5, 5));
        hbox5.setMargin(assets, new Insets(0, 185, 5, 0));
        hbox5.setMargin(marketValue, new Insets(0, 180, 5, 0));
        hbox5.setPadding(new Insets(0, 100, 5, 100));
        hbox5.setAlignment(Pos.BASELINE_LEFT);

        // Horizontal Wrapper #6 VALUES
        Text globalRankValue = new Text("11");
        globalRankValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text assetsValue = new Text("234123");
        assetsValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));
        Text marketValueValue = new Text("1231");
        marketValueValue.setFont(Font.font("Tahoma", FontWeight.BOLD, 25));

        HBox hbox6 = new HBox(8);
        hbox6.getChildren().addAll(globalRankValue, assetsValue, marketValueValue);
        hbox6.setMargin(globalRankValue, new Insets(5, 160, 5, 0));
        hbox6.setMargin(assetsValue, new Insets(5, 160, 5, 0));
        hbox6.setMargin(marketValueValue, new Insets(5, 150, 5, 0));
        hbox6.setPadding(new Insets(0, 100, 5, 120));
        hbox6.setAlignment(Pos.BASELINE_LEFT);

        // Horizontal Wrapper #7 VALUES
        String description = "longlongongajafjlaksdlfjaskdfafsdfadfadfasdfasdfasdfasdfa asdfa sdf adfadsfasdf asdfas dfafsd fasdf asdfas dfa sdf asdf asdf asdfasdfasdf";
        
        Label label = new Label(description);
        label.setFont(Font.font("Tahoma", FontWeight.BOLD, 15));
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        label.setMaxWidth(545);
        label.setMaxHeight(400);

        HBox hbox7 = new HBox(8);
        hbox7.getChildren().addAll(label);
        hbox7.setMargin(label, new Insets(5, 0, 5, 0));
        hbox7.setPadding(new Insets(15, 50, 10, 110));
        hbox7.setAlignment(Pos.BASELINE_LEFT);

       // Horizontal Wrapper #4 RETURN BUTTONS
       HBox hbox4 = new HBox(8);
       hbox4.getChildren().addAll(buttonSearch, spButton);
       hbox4.setMargin(spButton, new Insets(0, 30, 0, 75));
       hbox4.setPadding(new Insets(5, 5, 5, 5));
       hbox4.setAlignment(Pos.BASELINE_RIGHT);
        
        vbox.getChildren().addAll(hbox, hbox2, hbox3, hbox5, hbox6, hbox7, hbox4);
        return vbox;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent(), 800, 500));
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
