package models;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class Arquivo {
    private BufferedReader input;
    private BufferedWriter output;
    
    public void openToWrite (String nomeArq) {
        try {
             File arq = new File(nomeArq);
             if (arq.exists() == false) {
                FileOutputStream fileOut = new FileOutputStream(arq);
                output = new BufferedWriter(new OutputStreamWriter(fileOut));
                System.out.println("Arquivo criado");
            } else {
                FileOutputStream fileOut = new FileOutputStream(arq, true);
                output = new BufferedWriter(new OutputStreamWriter(fileOut));
                System.out.println("Arquivo aberto para anexar");
            }
        }
        catch (IOException ioException){
            System.err.println("Erro ao tentar criar/abrir o arquivo para gravação");
            System.exit(1);
        }
    }
    
    public void openToRead (String nomeArq) {
        try {
             File arq = new File(nomeArq);
             if (arq.exists() == false) {
                System.out.println("Arquivo não existe");
                System.exit(1);
            } else {
                FileInputStream fileIn = new FileInputStream(arq);
                input = new BufferedReader(new InputStreamReader(fileIn));
                System.out.println("Arquivo aberto para leitura");
            }
        }
        catch (IOException ioException){
            System.err.println("Erro ao tentar abrir o arquivo para leitura");
            System.exit(1);
        }
    }
    
    public void closeWriteFile() {
        try {
            if (output != null) {
                output.flush();
                output.close();
                output = null;
                System.out.println("Arquivo fechado após gravação");
             }
        }
        catch (IOException ioException){
            System.err.println("Erro ao tentar fechar o arquivo após gravação");
            System.exit(1);
        } 
    }
    
    public void closeReadFile() {
        try {
            if (input != null) {
                input.close();
                input = null;
                System.out.println("Arquivo fechado após leitura");
             }
        }
        catch (IOException ioException){
            System.err.println("Erro ao tentar fechar o arquivo após leitura");
            System.exit(1);
        } 
    }
    
    public void gravarDados (String [] desc, int qtd) {
         try {
             for (int i = 0; i < qtd; i++) {
                output.write(desc[i]);
                output.newLine();
                output.flush();
             }
        }
        catch (IOException ioException){
            System.err.println("Erro de gravação");
            System.exit(1);
        }
    }
    
    public int lerDados (String [] desc){
        String linha;
        int i = 0;
        
        try {
          while((linha = input.readLine())!=null){
              desc[i] = linha;
              i++;
          }
        }
        catch (IOException ioException){
            System.err.println("Erro de leitura");
            System.exit(1);
        } 
      
        return i;
    }
}