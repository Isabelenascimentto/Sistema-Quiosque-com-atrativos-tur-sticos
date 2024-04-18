package JessIsaPeu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaVendasMap implements SistemaVendas{
    private Map<String,Cookie> cookies;
    public SistemaVendasMap(){
        this.cookies = new HashMap<String, Cookie>();
    }

    @Override
    public void cadastraCookies(Cookie cookie) throws CookieJaExisteException {
        if (this.cookies.containsKey(cookie.getSabor())){
            throw new CookieJaExisteException("Já existe este Cookie cadastrado");
        }else {
            this.cookies.put(cookie.getSabor(),cookie);
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
    public void removeSabor(Cookie cookie) throws CookieNaoExisteException {
        if (this.cookies.containsKey(cookie)){
            this.cookies.remove(cookie);
            System.out.println("Cookie removido com sucesso!");
        } else {
            throw new CookieNaoExisteException("Não foi encontrado este cookie");
        }
    }

    @Override
    public List<Cookie> pesquisaPorPreco(double preco) {
        List<Cookie> listinha = new ArrayList<>();
        for (Cookie c: this.cookies.values()){
            if (c.getPreco() == preco){
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
    public List<Cookie> pesquisaCombos(String combo) {
       List<Cookie> listaa = new ArrayList<>();
       for (Cookie c: this.cookies.values()){
           if (c.getCombos().equals(combo)){
               listaa.add(c);
           }
       }
       return listaa;
    }
}
