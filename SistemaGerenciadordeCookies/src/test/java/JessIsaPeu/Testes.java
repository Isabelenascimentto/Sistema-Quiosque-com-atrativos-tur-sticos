package JessIsaPeu;

import Exceptions.ComboJaExisteException;
import Exceptions.ComboNaoExisteException;
import Exceptions.CookieJaExisteException;
import Exceptions.CookieNaoExisteException;
import Funcionalidade.SistemaVendasMap;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class Testes {
    @Test
    public void testaCadastroCookie() {
        SistemaVendasMap testa = new SistemaVendasMap();
        try {
            List<Cookie> sabores = testa.pesquisaCookiesPorSabor("nutella");
            assertTrue(sabores.size()==0);
            testa.cadastraCookies("nutella", 10, TipoCookie.TORTA_COOKIE);
            sabores = testa.pesquisaCookiesPorSabor("nutella");
            assertTrue(sabores.size()==1);
        } catch (CookieJaExisteException e){
            fail("Não deveria falhar");
        }
    }
    @Test
    public void testaCadastroCombo(){
        SistemaVendasMap testa = new SistemaVendasMap();
        try {
            List<Combos> combos = testa.pesquisaCombos("chá da tarde");
            assertTrue(combos.size()==0);
            testa.cadastraCombos("chá da tarde", 30);
            combos = testa.pesquisaCombos("chá da tarde");
            assertTrue(combos.size()==1);
        } catch (ComboJaExisteException e) {
            fail("Não deveria falhar");
        }
    }
    @Test
    public void testaRemocaoDeCookies() throws CookieNaoExisteException, CookieJaExisteException {
        SistemaVendasMap testa = new SistemaVendasMap();
        List<Cookie> sabores = testa.pesquisaCookiesPorSabor("nutella com ninho");
        assertTrue(sabores.size()==0);
        testa.cadastraCookies("nutella com ninho", 10, TipoCookie.TORTA_COOKIE);
        sabores = testa.pesquisaCookiesPorSabor("nutella com ninho");
        assertTrue(sabores.size()==1);
        testa.removeSabor("nutella com ninho");
        sabores = testa.pesquisaCookiesPorSabor("nutella com ninho");
        assertTrue(sabores.size()==0);
    }
    @Test
    public void testaRemocaoDeCombos() throws ComboJaExisteException, ComboNaoExisteException {
        SistemaVendasMap testa = new SistemaVendasMap();
        List<Combos> combos = testa.pesquisaCombos("amor adocicado");
        assertTrue(combos.size()==0);
        testa.cadastraCombos("amor adocicado", 30);
        combos = testa.pesquisaCombos("amor adocicado");
        assertTrue(combos.size()==1);
        testa.removeCombo("amor adocicado");
        combos = testa.pesquisaCombos("amor adocicado");
        assertTrue(combos.size()==0);
    }
    @Test
    public void testaPesquisas() throws CookieJaExisteException {
        SistemaVendasMap testa = new SistemaVendasMap();
        List<Cookie> valores = testa.pesquisaValoresPorFaixa(6,9);
        assertTrue(valores.size()==0);
        testa.cadastraCookies("ninho", 6, TipoCookie.MINI_COOKIES);
        valores = testa.pesquisaValoresPorFaixa(6,9);
        assertTrue(valores.size()==1);
        assertFalse(testa.existeCookiesDoTipo(TipoCookie.MARMITINHA));
    }
}
