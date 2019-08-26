
package models;
import java.io.Serializable;


public class Objetos implements Serializable{
    private String descricao;
    private String imagem;
    private String audio;

    public Objetos(String descricao,String imagem, String audio) {
        this.descricao = descricao;
        this.imagem = imagem;
        this.audio = audio;        
    }
    
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString() {
        return "Objetos:" + "\nDescricao:" + descricao;
    }
    
    
}
