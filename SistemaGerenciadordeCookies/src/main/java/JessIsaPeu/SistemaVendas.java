package JessIsaPeu;

import java.util.List;

public interface SistemaVendas {
    void cadastraCookies(Cookie cookie) throws CookieJaExisteException;
    List<Cookie> pesquisaCookiesPorSabor(String sabor) throws CookieNaoExisteException;
    boolean existeSabor(String sabor);
    int contaCookiesDoTipo(TipoCookie tipo);
    void removeSabor(Cookie cookie) throws CookieNaoExisteException;
    List<Cookie> pesquisaPorPreco(double preco);
    boolean existeCookiesDoTipo(TipoCookie tipo);
    List<Cookie> pesquisaCombos(String combo);
}
