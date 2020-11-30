import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Window extends Application{

    public void keyPressed(TextField upperLimit, TextField randomNumber, Generator Alpha)
    {
            for(int i=0; i < upperLimit.getLength(); i++)
            {
                try{
                    Integer.parseInt(String.valueOf(upperLimit.getText().charAt(i)));
                    randomNumber.setText(Integer.toString(Alpha.generateNum(upperLimit)));
                    randomNumber.setVisible(true);

                }catch(NumberFormatException a) {
                    upperLimit.setText("");
                    randomNumber.setText("Please enter a valid positive integer value.");
                }
            }
    }


    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Generator Alpha = new Generator();
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        TextField randomNumber = new TextField();
        TextField upperLimit = new TextField("Enter the upper limit for your number.");
        Button generate = new Button("Generate");

        randomNumber.setEditable(false);
        randomNumber.setVisible(false);

        FlowPane shapes = new FlowPane();
        shapes.setVgap(5);
        shapes.setHgap(20);
        shapes.getChildren().add(randomNumber);
        shapes.getChildren().add(upperLimit);
        shapes.getChildren().add(generate);






        Scene scene = new Scene(shapes, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random Number Generator");
        primaryStage.show();

        randomNumber.setPrefWidth(300);
        upperLimit.setPrefWidth(75);
        generate.setPrefWidth(450);
        generate.setPrefHeight(350);



        generate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if(upperLimit.getLength()>0) {
                    keyPressed(upperLimit, randomNumber, Alpha);
                }
            }
        });
    }

}
