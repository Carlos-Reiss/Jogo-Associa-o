/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {
    private MediaPlayer musica;
    private boolean ativar_desativar;  
    
    
    public Audio(boolean t){
        Media midia = new Media(new File("Sons\\Desc.mp3").toURI().toString());
        musica = new MediaPlayer(midia);
        ativar_desativar = t;
    }
    public void tocar(){
        if(ativar_desativar == true){
            musica.stop();
        }else{
            musica.setCycleCount(MediaPlayer.INDEFINITE);
            musica.setVolume(6.0);
            musica.play();
        }
    }
    public void setAtivar_desativar(boolean resp){
        this.ativar_desativar = resp;
    }
    public boolean isAtivar_desativar() {
        return ativar_desativar;
    }
    public void parar() {
        musica.stop();
        ativar_desativar = true;
    }
    public void ativar() {
        ativar_desativar = false;
    }
    public void somMouse(){
        Media midia = new Media(new File("Sons\\Click do Mouse.mp3").toURI().toString());
        musica = new MediaPlayer((midia));
        musica.setVolume(10.0);
        musica.play();      
    }
    
    public void somErrou(){
        Media midia = new Media(new File("Sons\\Som de Erro.2.mp3").toURI().toString());
        musica = new MediaPlayer((midia));
        musica.setVolume(10.0);
        musica.play();      
    }
    public void somAcertou(){
        Media midia = new Media(new File("Sons\\Som de acerto.mp3").toURI().toString());
        musica = new MediaPlayer((midia));
        musica.setVolume(10.0);
        musica.play();      
    }
    public void somDemo(){
        Media midia = new Media(new File("Sons\\Desc.mp3").toURI().toString());
        musica = new MediaPlayer(midia);
        musica.setVolume(10.0);     
    }
}
