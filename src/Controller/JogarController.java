 
package Controller;

import Principal.Jogo;
import Principal.Login;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Audio;
import models.Carregar_jogo;


public class JogarController implements Initializable {
    @FXML private Label gerarLetra;
    @FXML private Label acerto;
    @FXML private Label erro;
    double x=0,y=0;
    @FXML private AnchorPane painel_jogo;
    @FXML private Label respostas;
    @FXML private Button btnVoltar;
    @FXML private Button btVerificarImg;
    @FXML private Label lbl01;
    @FXML private Label lbl02;
    @FXML private Label lbl03;
    @FXML private Label lbl04;
    @FXML private Button btJogarDnv;
    @FXML private Button btAudio;
    String buffer1,buffer2,buffer3,buffer4,descricao1,descricao2,descricao3,descricao4;
    Carregar_jogo jogo = new Carregar_jogo();
    public static boolean flag;
    Audio midia = new Audio(flag);
    int contE =0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gerarLetra();
        cria_figuras();
        jogo.load();
        
        if(midia.isAtivar_desativar() == false){
            btAudio.setText("Áudio:ON");
        }
        else{
            btAudio.setText("Áudio:OFF");
        }
        btAudio.setOnMousePressed(e ->{
          if(midia.isAtivar_desativar() == false){
                midia.parar();
                flag = true;
                btAudio.setText("Áudio:OFF");
            }else{
                midia.ativar();
                flag = false;
                btAudio.setText("Áudio:ON");
          }
        });            
        
        btJogarDnv.setOnMousePressed( e -> {
           jogardnv();
        }
        );
        btnVoltar.setOnMousePressed( e -> {
            System.out.println("voltar");
            Login login = new Login();
            try {
                login.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(JogarController.class.getName()).log(Level.SEVERE, null, ex);
            }
            midia.parar();
            Jogo.getStage().close();
        }
        );
        
        btVerificarImg.setOnMousePressed( e -> {
            if(lbl01.getLayoutX() >= 0 && lbl01.getLayoutX() <= 286 && lbl01.getLayoutY() >= 119 && lbl01.getLayoutY() <= 334){
                verificarImg(lbl01,buffer1);
            }
            if(lbl02.getLayoutX() >= 0 && lbl02.getLayoutX() <= 286 && lbl02.getLayoutY() >= 119 && lbl02.getLayoutY() <= 334){
                verificarImg(lbl02,buffer2);
            }
            if(lbl03.getLayoutX() >= 0 && lbl03.getLayoutX() <= 286 && lbl03.getLayoutY() >= 119 && lbl03.getLayoutY() <= 334){
                verificarImg(lbl03,buffer3);
            }
            if(lbl04.getLayoutX() >= 0 && lbl04.getLayoutX() <= 286 && lbl04.getLayoutY() >= 119 && lbl04.getLayoutY() <= 334){
                verificarImg(lbl04,buffer4);
            }
 
        }
        );
        
        Arrastar_itens(lbl01);
        Arrastar_itens(lbl02);
        Arrastar_itens(lbl03);
        Arrastar_itens(lbl04);
        
    }    

    private void gerarLetra() {
        String letras = "BACDEFMLGOPRSVT";
        String codigo = "";
        SecureRandom gerador = new SecureRandom();
        codigo = codigo + letras.charAt((gerador.nextInt(letras.length())));
        this.gerarLetra.setText(codigo);
    }
    private void Arrastar_itens(Label lblObjeto){
        double eixoX = lblObjeto.getLayoutX();
        double eixoY = lblObjeto.getLayoutY();
        
        lblObjeto.setOnMousePressed(e -> {
            System.out.println("clicou pressionar");
            x =  lblObjeto.getLayoutX()-e.getSceneX();System.out.println("clicando eixo X:"+x);
            y =  lblObjeto.getLayoutY()-e.getSceneY();System.out.println("clicando eixo Y:"+y);
            lblObjeto.setCursor(Cursor.CLOSED_HAND);
            if(midia.isAtivar_desativar() == false){
                midia.somMouse();
            }
        }
        );
        lblObjeto.setOnMouseDragged(e -> {              
        if(lblObjeto.getLayoutX() < 0 || lblObjeto.getLayoutX() > 850 || lblObjeto.getLayoutY() < 0 || lblObjeto.getLayoutY() > 378){  
            lblObjeto.setCursor(Cursor.WAIT);
        }else{
            lblObjeto.setLayoutX(e.getSceneX()+ x);
            lblObjeto.setLayoutY(e.getSceneY()+ y);
        }       
        }
        );
        lblObjeto.setOnMouseReleased(e -> {
            System.out.println("soltar "); 
            System.out.println("solto eixo X:"+lblObjeto.getLayoutX());
            System.out.println("solto eixo Y:"+lblObjeto.getLayoutY());
            lblObjeto.setCursor(Cursor.OPEN_HAND);
            if(lblObjeto.getLayoutX() < 0 || lblObjeto.getLayoutX() > 850 || lblObjeto.getLayoutY() < 0 || lblObjeto.getLayoutY() > 378){  
                lblObjeto.setLayoutX(eixoX);System.out.println("X"+eixoX);
                lblObjeto.setLayoutY(eixoY);System.out.println("Y"+eixoY);
            }
        }
        );
    }
    public void cria_figuras ( ) {
         descricao1 = jogo.aleatorio();
         char letra1 = descricao1.charAt(0);
         buffer1 = letra1+"";
         System.out.println(descricao1);
         descricao2 = jogo.aleatorio();
         char letra2 = descricao2.charAt(0);
         buffer2 = letra2+"";
         System.out.println(descricao2);
         descricao3 = jogo.aleatorio();
         char letra3 = descricao3.charAt(0);
         buffer3 = letra3 +"";
         System.out.println(descricao3);
         descricao4 = jogo.aleatorio();
         char letra4 = descricao4.charAt(0);
         buffer4 = letra4 + "";
         System.out.println(descricao4);
         
        if(buffer1 != (gerarLetra.getText()) && buffer2 != (gerarLetra.getText()) && buffer3 != (gerarLetra.getText()) && buffer4 != (gerarLetra.getText())){
            descricao1 = jogo.consultar(gerarLetra.getText());
            System.out.println(descricao1);
            char letraresv = descricao1.charAt(0);
            buffer1 = letraresv+"";
        } 
        if(descricao1.compareToIgnoreCase(descricao2)==0 || descricao1.compareToIgnoreCase(descricao3)==0 || descricao1.compareToIgnoreCase(descricao4)==0 || descricao2.compareToIgnoreCase(descricao3)==0 || descricao2.compareToIgnoreCase(descricao4)==0 || descricao3.compareToIgnoreCase(descricao4)==0 ){
            descricao1 = null; descricao2 = null;descricao4 = null;descricao4 = null;           
            cria_figuras();
        }      
        else{
       // refinar objetos para evitar menas colisão       

        Image imagem = new Image(getClass().getResourceAsStream("Imagens_sons\\"+descricao1+".png"));
        Image imagem2 = new Image(getClass().getResourceAsStream("Imagens_sons\\"+descricao2+".png"));
        Image imagem3 = new Image(getClass().getResourceAsStream("Imagens_sons\\"+descricao3+".png"));
        Image imagem4 = new Image(getClass().getResourceAsStream("Imagens_sons\\"+descricao4+".png"));


        ImageView icone = new ImageView(imagem);
        lbl01.setAlignment(Pos.CENTER);
        lbl01.setGraphic(icone);



        ImageView icone2 = new ImageView(imagem2);
        lbl02.setAlignment(Pos.CENTER);
        lbl02.setGraphic(icone2);


        ImageView icone3 = new ImageView(imagem3);
        lbl03.setAlignment(Pos.CENTER);
        lbl03.setGraphic(icone3);


        ImageView icone4 = new ImageView(imagem4);
        lbl04.setAlignment(Pos.CENTER);
        lbl04.setGraphic(icone4);
       }      
    }
    public void verificarImg(Label lblteste,String desc){
        System.out.println(gerarLetra.getText()+"-__-"+desc);
        if(gerarLetra.getText().equals(desc) == true){
            lblteste.setStyle("-fx-background-color: green;");
            if(midia.isAtivar_desativar() == false && contE <= 0 ){       
                midia.somAcertou();
            }    
        }        
        else{ 
            contE = 1;
            lblteste.setStyle("-fx-background-color: red;");
            if(midia.isAtivar_desativar() == false && contE == 1){
                midia.somErrou();   
            }
        }
    }

    private void jogardnv() {
        System.out.println("JogarDnv");
        Jogo jogo = new Jogo();
        try {
            jogo.start(Jogo.getStage());
            ;
        } catch (Exception ex) {
            Logger.getLogger(JogarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
}



