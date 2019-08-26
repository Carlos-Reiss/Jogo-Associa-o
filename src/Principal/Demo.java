
package Principal;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Demo extends Application {
    private static Stage stage;    
        
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;    
        AnchorPane jogar = FXMLLoader.load(getClass().getResource("/View/Demo.fxml"));
        Scene scene = new Scene(jogar);
        
        stage.setTitle("Demo");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();   
        setStage(stage);
    }   

    public static Stage getStage() {
        return stage;
    }
    public static void setStage(Stage stage) {
        stage = stage;
    }   
}
