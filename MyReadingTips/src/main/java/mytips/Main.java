package mytips;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import mytips.controller.ManageBookTip;



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
    /*public static void main(String[] args) {
        System.out.println("Aloitus onnistuu!");
        //launch(args);
        TextualUI ui = new TextualUI();
        ui.start();
    }*/
    
    public static void main(String[] args) {

        ManageBookTip MBT = new ManageBookTip();

        /* Add few BookTip records in database */
        Integer btId1 = MBT.addBookTip("Charles Darwin", "The Origin Of Species", "9781515383284", "", "");
        Integer btId2 = MBT.addBookTip("Richard Dawkins", "The Selfish Gene", "9788932471112", "", "");
        MBT.listBookTips();
    }
    
}
