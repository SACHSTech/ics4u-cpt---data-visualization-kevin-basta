package basic;

import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application {
    // Main method that launches the Javafx gui
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Japan Company Dataset");
        
        // Creating a grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // Adding a title to the page
        Text scenetitle = new Text("Largest Companies Dataset");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        // Adding a button that links to the bubble chart gui
        Button bubbleButton = new Button("See BUBBLE Graph");
        HBox bblbBtn = new HBox(10);
        bblbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        bblbBtn.getChildren().add(bubbleButton);
        grid.add(bblbBtn, 1, 4);
        bubbleButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                ChartAppBubble bubbleChart  = new ChartAppBubble();
                Scene BubbleChartScene = bubbleChart.getScene();
                primaryStage.setScene(BubbleChartScene);
            }
        });

        // Adding a button that links to the Bar chart gui
        Button barButton = new Button("See BAR Graph");
        HBox barBtn = new HBox(10);
        barBtn.setAlignment(Pos.BOTTOM_RIGHT);
        barBtn.getChildren().add(barButton);
        grid.add(barBtn, 2, 8);
        barButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                ChartAppBar barChart  = new ChartAppBar();
                Scene BarChartScene = barChart.getScene();
                primaryStage.setScene(BarChartScene);
            }
        });

        // Adding a button that links to the PIE chart gui
        Button pieButton = new Button("See PIE Graph");
        HBox pieBtn = new HBox(10);
        pieBtn.setAlignment(Pos.BOTTOM_RIGHT);
        pieBtn.getChildren().add(pieButton);
        grid.add(pieBtn, 4, 18);
        pieButton.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                ChartAppPie pieChart  = new ChartAppPie();
                Scene PieChartScene = pieChart.getScene();
                primaryStage.setScene(PieChartScene);
            }
        });

        //String[][] testArray = loadData.getData();
        //System.out.println(testArray[248][1]);

        // The Main Page Scene
        Scene mianScene = new Scene(grid, 800, 500);
        primaryStage.setScene(mianScene);
        primaryStage.show();
    }

}