package Interface;

import Exceptions.ComboJaExisteException;
import Exceptions.ComboNaoExisteException;
import Exceptions.CookieJaExisteException;
import Exceptions.CookieNaoExisteException;
import JessIsaPeu.Combos;
import JessIsaPeu.Cookie;
import JessIsaPeu.TipoCookie;

import java.util.List;

public interface SistemaVendas {
    void cadastraCookies(String sabor, double preco, TipoCookie tipo) throws CookieJaExisteException;
    void cadastraCombos(String nome, double preco) throws ComboJaExisteException;
    List<Cookie> pesquisaCookiesPorSabor(String sabor) throws CookieNaoExisteException;
    boolean existeSabor(String sabor);
    int contaCookiesDoTipo(TipoCookie tipo);
    void removeSabor(String sabor) throws CookieNaoExisteException;
    void removeCombo(String nome) throws ComboNaoExisteException;
    List<Cookie> pesquisaValoresPorFaixa(double valorMinimo, double valorMaximo);
    boolean existeCookiesDoTipo(TipoCookie tipo);
    List<Combos> pesquisaCombos(String combo);
    void recuperarDadosCookies();
    void recuperarDadosCombos();
}
