package com.example.javafxcontrols;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        //Give the application a grid by instantiating a grid object from the GridPane class
        GridPane grid = new GridPane();
        grid.setMinWidth(600);
        grid.setMinHeight(400);

        //Set the space between grid cells
        grid.setHgap(20);
        grid.setVgap(5);

        //Makes grid lines invisible
        grid.setGridLinesVisible(false);



        TableView table = new TableView();
        table.setMinHeight(350);
        double tableWidth = 600;
        double tableHeight = 500;
        table.setMinWidth(tableWidth);
        table.setMinHeight(500);
        //tableArea.setMinHeight(500);

        TableColumn column1 = new TableColumn("Priority");
        TableColumn column2 = new TableColumn("Description");
        TableColumn column3 = new TableColumn("Progress");
        table.getColumns().addAll(column1,column2,column3);

        GridPane.setConstraints(table,1,1,3,1);

        //Creating text fields
        TextField taskName = new TextField();
        taskName.setPromptText("Enter task name");
        taskName.setMinWidth(100);
        GridPane.setConstraints(taskName,2,2);

        TextField another = new TextField();
        GridPane.setConstraints(another, 2,3);
        another.setPromptText("Another");

        ComboBox priority = new ComboBox();
        priority.getItems().addAll("High","Low","Medium");
        priority.setPromptText("Enter priority");
        GridPane.setConstraints(priority,1, 2);

        Button button1 = new Button("Add");
        button1.setPrefWidth(150);
        GridPane.setConstraints(button1,3, 2);

        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefWidth(150);
        GridPane.setConstraints(cancelButton,3, 3);

        Button clearButton = new Button("Clear");
        clearButton.setPrefWidth(150);
        GridPane.setConstraints(clearButton,3,4);

        HBox progressArea = new HBox();
        progressArea.getChildren().addAll(
                new Label("Progress"),
                new Spinner<Integer>(0, 100, 0),
                new CheckBox("Completed")
        );
        progressArea.setAlignment(Pos.CENTER_RIGHT);
        progressArea.setSpacing(10);
        GridPane.setConstraints(progressArea, 1,3,2,1); // Need to look at what the integers mean later

        grid.getChildren().addAll(table, another, taskName, priority, button1, cancelButton, clearButton, progressArea);

        Scene scene = new Scene(grid, 500,400);
        stage.setMinHeight(tableHeight+200);
        stage.setMinWidth(tableWidth+50);

        scene.setFill(Color.TURQUOISE);

        //Make the application always appear on top of all other windows that are open
        stage.setAlwaysOnTop(false);

        stage.setResizable(true);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}