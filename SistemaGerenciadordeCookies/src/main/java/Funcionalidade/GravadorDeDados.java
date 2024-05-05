package Funcionalidade;

import JessIsaPeu.Combos;
import JessIsaPeu.Cookie;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GravadorDeDados {
    public static final String ARQUIVO_DE_COOKIES = "cookies.dat";
    public static final String ARQUIVO_DE_COMBOS = "combos.dat";
    public HashMap<String, Cookie> recuperarCookies() throws IOException{
        ObjectInputStream in = null;
        try{
            in = new ObjectInputStream(new FileInputStream(ARQUIVO_DE_COOKIES));
            return (HashMap<String, Cookie>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os dados dos cookies");
            throw new IOException("Não foi possível recuperar os dados do arquivo " + ARQUIVO_DE_COOKIES);
        } finally {
            if (in!=null){
                in.close();
            }
        }
    }
    public HashMap<String, Combos> recuperarCombos() throws IOException{
        ObjectInputStream in = null;
        try{
           in = new ObjectInputStream(new FileInputStream(ARQUIVO_DE_COMBOS));
           return (HashMap<String, Combos>) in.readObject();
        } catch (Exception e){
            System.out.println("Não foi possível recuperar os dados dos combos");
            throw new IOException("Não foi possível recuperar os dados do arquivo " + ARQUIVO_DE_COMBOS);
        } finally {
            if (in!=null){
                in.close();
            }
        }
    }
    public void salvarCookies(Map<String, Cookie> cookies) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DE_COOKIES));
            out.writeObject(cookies);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os cookies no arquivo " + ARQUIVO_DE_COOKIES);
        }
    }
    public void salvarCombos(Map<String, Combos> combos) throws IOException{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_DE_COMBOS));
            out.writeObject(combos);
        } catch (Exception e){
            e.printStackTrace();
            throw new IOException("Erro ao salvar os combos no arquivo " + ARQUIVO_DE_COMBOS);
        }
    }
}
