
package Controller;

import Principal.Demo;
import Principal.Jogo;
import Principal.Login;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class LoginController implements Initializable {
    @FXML private Button btnJogar;
    @FXML private Button btnSair;
    @FXML private Button BtnIntrod;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnJogar.setOnMousePressed(e -> {
            System.out.println("clicou pressionar");
                Jogo jogo = new Jogo(); 
                try {
                    jogo.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(JogarController.class.getName()).log(Level.SEVERE, null, ex);
                }   
            fechar();
        }
        );
        btnSair.setOnMousePressed( e -> {
            System.out.println("Saindo...");
            fechar();
        }
        );
        BtnIntrod.setOnMousePressed(e -> {
            System.out.println("Clicou Demo");
            Demo in = new Demo(); 
                try {
                    in.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(JogarController.class.getName()).log(Level.SEVERE, null, ex);
                }   
            fechar();
        }
        );   
    }   
    private void fechar() {
        Login.getStage().close();
    }
   
}
