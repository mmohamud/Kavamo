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
import mytips.database.Database;
import mytips.dao.BookTipDao;
import java.sql.*;

// import spark.ModelAndView;
// import static spark.Spark.*;
// import spark.template.thymeleaf.ThymeleafTemplateEngine;
// import spark.Spark;

public class Main extends Application {

// This method is not yet in use - was originally cerated for javafx & graphical interphase purposes
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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //launch(args);

// Seuraavat toiminnot ovat nyt Database.javassa
//        Connection connection = DriverManager.getConnection("jdbc:sqlite:readingtips.db");
//        PreparedStatement statement = connection.prepareStatement("SELECT 1");
//        ResultSet resultSet = statement.executeQuery();

        Database db = new Database("jdbc:sqlite:readingtips.db");
//        BookTipDao kysymys = new KysymysDao(db);

//        if (resultSet.next()) {
//            System.out.println("Hei tietokantamaailma!");
//        } else {
//            System.out.println("Yhteyden muodostaminen epäonnistui.");
//        }
    
        ReadingTipManager readingTipManager = new ReadingTipManager();
        TextualUI ui = new TextualUI(readingTipManager);
        ui.start();
        System.out.println("Lopetetaan");
        
    }

    
    
}

