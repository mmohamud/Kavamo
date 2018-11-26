package mytips;

import java.util.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mytips.model.ReadingTip;
import mytips.model.ReadingTipManager;
import mytips.model.TipManager;
import java.sql.*;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        //launch(args);
        Connection connection = DriverManager.getConnection("jdbc:sqlite:testi.db");

        PreparedStatement statement = connection.prepareStatement("SELECT 1");

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Hei tietokantamaailma!");
        } else {
            System.out.println("Yhteyden muodostaminen epäonnistui.");
        }
    
        ReadingTipManager readingTipManager = new ReadingTipManager();
        TextualUI ui = new TextualUI(readingTipManager);
        ui.start();
        System.out.println("Lopetetaan");
        
    }

    
    
}
