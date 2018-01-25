/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtokdb;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.lang.*;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


/**
 *
 * @author connor.knox
 */
public class JavaFxToKdb extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TextField textfield = new TextField();
        Button btn = new Button();
        btn.setText("Show me the last Trade Record");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(textfield,btn);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(40,40,40,40));
        Scene scene = new Scene(vbox, 600, 500);
        
        primaryStage.setTitle("KDB Connector");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*public String toString(Object n){
         return Arrays.toString(n);
    }*/
    /**
     * @param args the command line arguments
     * Baseport/Tickerplant = 6000
     * rdb = 6002
     * hdb = 6003
     */
    public static void main(String[] args) {
        launch(args);
        /*
        Instance of the class containing the method which connects to the KDB Process and queries the process table
        */
        ConnectionToKDB varConnect = new ConnectionToKDB();
        //varConnect.ConnectToKDB();
    }
    
    
    
}
