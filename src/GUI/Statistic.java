package GUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Date;

public class Statistic extends Application {
    Stage Window;
    @Override
    public void start(Stage stageStatistic ) throws Exception {
        //buttons and labels
        Label values = new Label("List of products");
        //Pie chart
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();
        PieChart pieChart = new PieChart(pieData);

        // Choice box
        ChoiceBox<String> titleOfPie = new ChoiceBox<>();
        titleOfPie.getItems().addAll();
        titleOfPie.getSelectionModel().selectedItemProperty().addListener( (v,oldValue,NewValue)-> GetData(NewValue));


        //Main layout
        BorderPane StatisticsView = new BorderPane();
        //Left layout
        GridPane leftpart = new GridPane();
        leftpart.setPadding(new Insets(10,10,10,10));
        leftpart.setHgap(5);
        GridPane.setConstraints(values,0,0);
        GridPane.setConstraints(titleOfPie,0,1);
        leftpart.getChildren().addAll(values,titleOfPie);
        StatisticsView.setLeft(leftpart);
        //Center layout
        StatisticsView.setCenter(pieChart);
        //Scene and Stage
        Scene sceneStatistics = new Scene(StatisticsView,450,400);
        Window= stageStatistic;
        Window.setScene(sceneStatistics);
        Window.setTitle("Statistic");
        Window.show();
            }

            private void GetData(String title){

            }
}
