package JessIsaPeu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaVendasMap implements SistemaVendas{
    private Map<String,Cookie> cookies;
    private Map<String,Combos> combos;
    public SistemaVendasMap(){
        this.cookies = new HashMap<String, Cookie>();
        this.combos = new HashMap<String,Combos>();
    }

    @Override
    public void cadastraCookies(String sabor, double preco, TipoCookie tipo) throws CookieJaExisteException {
        if (this.cookies.containsKey(sabor)){
            throw new CookieJaExisteException("Já existe este Cookie cadastrado");
        }else {
            this.cookies.put(sabor, new Cookie(sabor,preco, tipo));
            System.out.println("Cookie cadastrado com sucesso!");
        }
    }

    @Override
    public List<Cookie> pesquisaCookiesPorSabor(String sabor){
        List<Cookie> lista = new ArrayList<>();
        for (Cookie c: this.cookies.values()){
            if (c.getSabor().equals(sabor)) {
                lista.add(c);
            }
        }
        return lista;
    }

    @Override
    public boolean existeSabor(String sabor) {
        return this.cookies.containsKey(sabor);
    }

    @Override
    public int contaCookiesDoTipo(TipoCookie tipo) {
       int quantCookies = 0;
       for (Cookie c: this.cookies.values()){
           if (c.ehDoTipo(tipo)){
               quantCookies++;
           }
       }
       return quantCookies;
    }

    @Override
    public void removeSabor(String sabor) throws CookieNaoExisteException {
        if (this.cookies.containsKey(sabor)){
            this.cookies.remove(sabor);
            System.out.println("Cookie removido com sucesso!");
        } else {
            throw new CookieNaoExisteException("Não foi encontrado este cookie");
        }
    }

    @Override
    public List<Cookie> pesquisaValoresPorFaixa(double valorMinimo, double valorMaximo) {
        List<Cookie> listinha = new ArrayList<>();
        for (Cookie c: this.cookies.values()){
            if (c.getPreco()>=valorMinimo && c.getPreco()<=valorMaximo){
                listinha.add(c);
            }
        }
        return listinha;
    }

    @Override
    public boolean existeCookiesDoTipo(TipoCookie tipo) {
        return this.cookies.containsKey(tipo);
    }

    @Override
    public List<Combos> pesquisaCombos(String combo) {
       List<Combos> listaa = new ArrayList<>();
       for (Combos cb: this.combos.values()){
           if (cb.getNome().equals(combo)){
               listaa.add(cb);
           }
       }
       return listaa;
    }
}
