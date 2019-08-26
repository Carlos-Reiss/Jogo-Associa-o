
package Principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Login extends Application {
    
    private static Stage stage;
    private static Scene login;
    
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setTitle("Jogo");
        AnchorPane painel = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        login = new Scene(painel);
        stage.setScene(login);
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
