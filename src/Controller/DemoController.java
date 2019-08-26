
package Controller;

import Principal.Demo;
import Principal.Login;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import models.Audio;
import models.Carregar_jogo;

public class DemoController implements Initializable {
    @FXML private Button btnVoltar;
    Audio midia = new Audio(false);
    Carregar_jogo jogo = new Carregar_jogo();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        midia.somDemo();
        midia.tocar();
        
        btnVoltar.setOnMouseClicked(e -> {
            System.out.println("voltar");
            Login login = new Login();
            try {
                login.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(JogarController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Demo.getStage().close();
            midia.parar();
        }
        );
    }       
}
