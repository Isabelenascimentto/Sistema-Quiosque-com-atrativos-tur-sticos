package Testando;

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
            List<Cookie> sabores = testa.pesquisaCookiesPorSabor("chocolate");
            assertTrue(sabores.size()==0);
            testa.cadastraCookies("chocolate", 10, TipoCookie.TORTA_COOKIE);
            sabores = testa.pesquisaCookiesPorSabor("chocolate");
            assertTrue(sabores.size()==1);
        } catch (CookieJaExisteException e){
            fail("Não deveria falhar");
        }
    }
    @Test
    public void testaCadastroCombo(){
        SistemaVendasMap testa = new SistemaVendasMap();
        try {
            List<Combos> combos = testa.pesquisaCombos("sonho doce");
            assertTrue(combos.size()==0);
            testa.cadastraCombos("sonho doce", 30);
            combos = testa.pesquisaCombos("sonho doce");
            assertTrue(combos.size()==1);
        } catch (ComboJaExisteException e) {
            fail("Não deveria falhar");
        }
    }
    @Test
    public void testaRemocaoDeCookies() throws CookieNaoExisteException, CookieJaExisteException {
        SistemaVendasMap testa = new SistemaVendasMap();
        List<Cookie> sabores = testa.pesquisaCookiesPorSabor("chocolate");
        assertTrue(sabores.size()==0);
        testa.cadastraCookies("chocolate", 10, TipoCookie.TORTA_COOKIE);
        sabores = testa.pesquisaCookiesPorSabor("chocolate");
        assertTrue(sabores.size()==1);
        testa.removeSabor("chocolate");
        sabores = testa.pesquisaCookiesPorSabor("chocolate");
        assertTrue(sabores.size()==0);
    }
    @Test
    public void testaRemocaoDeCombos() throws ComboJaExisteException, ComboNaoExisteException {
        SistemaVendasMap testa = new SistemaVendasMap();
        List<Combos> combos = testa.pesquisaCombos("sonho doce");
        assertTrue(combos.size()==0);
        testa.cadastraCombos("sonho doce", 30);
        combos = testa.pesquisaCombos("sonho doce");
        assertTrue(combos.size()==1);
        testa.removeCombo("sonho doce");
        combos = testa.pesquisaCombos("sonho doce");
        assertTrue(combos.size()==0);
    }
    @Test
    public void testaPesquisas() throws CookieJaExisteException {
        SistemaVendasMap testa = new SistemaVendasMap();
        List<Cookie> valores = testa.pesquisaValoresPorFaixa(10,20);
        assertTrue(valores.size()==0);
        testa.cadastraCookies("red velvet", 15, TipoCookie.MINI_COOKIES);
        valores = testa.pesquisaValoresPorFaixa(10,20);
        assertTrue(valores.size()==1);
        assertFalse(testa.existeCookiesDoTipo(TipoCookie.MARMITINHA));
    }
}
