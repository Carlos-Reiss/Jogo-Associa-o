
package models;

import java.security.SecureRandom;

public class Carregar_jogo {
    String [] objetos = {"AVIAO","BOLA","CACHORRO","DENTE","ELEFANTE","FOCA","GRILO","ARVORE","CARRO","MAO","LAPIS","OCULOS","PIZZA","RATO","SAPATO","TELEVISAO","VASSOURA","BARCO","ABELHA","BALEIA","CORACAO","DADO","DINOSSAURO","ESCOVA","ESPELHO","ESQUILO","ESTRELA","FLOR","FOGUEIRA","GATO","GIRAFA","LARANJA","LEAO","MACA","MACACO","OLHOS","OVELHA","PATO","PIAO","RADIO","RELOGIO","SOL","SORVETE","TARTARUGA","TESOURA","VACA","VIOLAO","CELULAR","DINHEIRO","GIRASSOL","ANEL","APITO","BOLO","BORBOLETA","CAVALO","GARRAFA","LAMPADA","LIVRO","MELANCIA","MILHO","OSSO","PEIXE","REGUA"};
    Arquivo arq = new Arquivo();
    private int qtd = 46;  // aumentar de acordo com meu vetor de objetos para referenciar  
    
    public void Projecao(){
        
    }    
        
    public void showAll(){
        for(int i = 0; i < objetos.length; i++){
            System.out.println(objetos[i]);
        }
    }
    public String aleatorio(){
        SecureRandom gerador = new SecureRandom();
        System.out.println(objetos.length);
        int i = gerador.nextInt(objetos.length);
        if(objetos[i] != null){
            return objetos[i];
        }else{
            return objetos[qtd];
        }
    }
    
    public String consultar(String nome){
        int pos = 0;
        
        SecureRandom gerar = new SecureRandom();
        do{
            pos = gerar.nextInt(objetos.length);
            if(objetos[pos].charAt(0) == nome.charAt(0)){
                return objetos[pos];
            }    
        }while(objetos[pos].charAt(0) != nome.charAt(0));
        
        return objetos[pos];
    }
    
    public void save(){
        arq = new Arquivo();
        arq.openToWrite("Jogo");
        arq.gravarDados(objetos, qtd);
        arq.closeWriteFile();        
    }
    public void load(){
        arq.openToRead("Jogo");
        String [] obj = new String[50];
        int n = arq.lerDados(obj);
        for(int i = 0; i < n; i++){
            //System.out.println(obj[i]);
        }
        arq.closeReadFile();
    }
}

