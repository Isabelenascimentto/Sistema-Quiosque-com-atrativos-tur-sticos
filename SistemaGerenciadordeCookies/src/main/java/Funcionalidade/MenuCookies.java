package Funcionalidade;


import Exceptions.ComboJaExisteException;
import Exceptions.ComboNaoExisteException;
import Exceptions.CookieJaExisteException;
import Exceptions.CookieNaoExisteException;
import Interface.SistemaVendas;
import JessIsaPeu.Combos;
import JessIsaPeu.Cookie;
import JessIsaPeu.TipoCookie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


class MenuCookies extends Component {
    private JFrame frame;
    private SistemaVendas sistema;

    public MenuCookies() {
        sistema = new SistemaVendasMap();
        frame = new JFrame("Sistema gerenciador dos cookies");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastra = new JMenu("Cadastrar");
        JMenu menuPesquisa = new JMenu("Pesquisar");
        JMenu menuConta = new JMenu("Estoque");
        JMenu menuRemove = new JMenu("Remover");
        JMenu menuExiste = new JMenu("Existe");

        JMenuItem itemCadastraCookies = new JMenuItem("Cadastrar cookies");
        JMenuItem itemCadastraCombos = new JMenuItem("Cadastrar combos");
        JMenuItem itemPesquisaCookiesPorSabor = new JMenuItem("Pesquisar cookies por sabor");
        JMenuItem itemPesquisaValoresPorFaixa = new JMenuItem("Pesquisar por faixa de preço");
        JMenuItem itemPesquisaCombos = new JMenuItem("Listar combos");
        JMenuItem itemContaCookiesDoTipo = new JMenuItem("Quantidade de cookies do tipo");
        JMenuItem itemRemoveSabor = new JMenuItem("Remover sabor");
        JMenuItem itemRemoveCombo = new JMenuItem("Remover combo");
        JMenuItem itemExisteCookiesDoTipo = new JMenuItem("Existe cookie do tipo");
        JMenuItem itemExisteSabor = new JMenuItem("Existe cookies com sabor");

        menuCadastra.add(itemCadastraCookies);
        menuCadastra.add(itemCadastraCombos);

        menuPesquisa.add(itemPesquisaCookiesPorSabor);
        menuPesquisa.add(itemPesquisaValoresPorFaixa);
        menuPesquisa.add(itemPesquisaCombos);

        menuConta.add(itemContaCookiesDoTipo);

        menuRemove.add(itemRemoveSabor);
        menuRemove.add(itemRemoveCombo);

        menuExiste.add(itemExisteCookiesDoTipo);
        menuExiste.add(itemExisteSabor);

        menuBar.add(menuCadastra);
        menuBar.add(menuPesquisa);
        menuBar.add(menuConta);
        menuBar.add(menuRemove);
        menuBar.add(menuExiste);


        frame.setJMenuBar(menuBar);

        itemCadastraCookies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Cadastrar cookies");
                String sabor = JOptionPane.showInputDialog("Digite o sabor do cookie:");
                double precoStr = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do cookie:"));
                String[] tipos = { "TRADICIONAL", "TORTA_COOKIE", "MARMITINHA", "MINI_COOKIES"};
                String tipoStr = (String) JOptionPane.showInputDialog(null, "Escolha o tipo do cookie:",
                        "Tipo do Cookie", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
                try {
                    sistema.cadastraCookies(sabor, precoStr, TipoCookie.valueOf(tipoStr));
                    JOptionPane.showMessageDialog(frame,"Cookie cadastrado com sucesso");
                } catch (CookieJaExisteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        itemCadastraCombos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Cadastrar combos");
                String nome = JOptionPane.showInputDialog("Digite o nome do combo:");
                double precoStr = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do combo:"));
                try {
                    sistema.cadastraCombos(nome, precoStr);
                    JOptionPane.showMessageDialog(frame,"Combo cadastrado com sucesso");
                } catch (ComboJaExisteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        itemPesquisaCookiesPorSabor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Pesquisar cookies por sabor");
                String sabor = JOptionPane.showInputDialog("Digite o sabor para pesquisar:");
                try {
                    List<Cookie> lista = new ArrayList<>();
                    for (Cookie c: sistema.pesquisaCookiesPorSabor(sabor)){
                        lista.add(c);
                    }
                    for (Cookie c: lista){
                        JOptionPane.showMessageDialog(frame, c.toString());
                    }
                } catch (CookieNaoExisteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        itemPesquisaValoresPorFaixa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Pesquisar por faixa de preço");
                double minimoStr = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor mínimo:"));
                double maximoStr = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor máximo:"));
                List<Cookie> lista = new ArrayList<>();
                for (Cookie c: sistema.pesquisaValoresPorFaixa(minimoStr, maximoStr)){
                    lista.add(c);
                }
                for (Cookie c: lista){
                    JOptionPane.showMessageDialog(frame, c.toString());
                }
            }
        });

        itemContaCookiesDoTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Contar cookies do tipo");
                String[] tipos = { "TRADICIONAL", "TORTA_COOKIE", "MARMITINHA", "MINI_COOKIES"};
                String tipoStr = (String) JOptionPane.showInputDialog(null, "Escolha o tipo do cookie:",
                        "Tipo do Cookie", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
                JOptionPane.showMessageDialog(frame, sistema.contaCookiesDoTipo(TipoCookie.valueOf(tipoStr)));
            }
        });

        itemRemoveSabor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Remover sabor");
                String sabor = JOptionPane.showInputDialog("Digite o sabor para remover:");
                try {
                    sistema.removeSabor(sabor);
                    JOptionPane.showMessageDialog(frame,"Cookie removido com sucesso");
                } catch (CookieNaoExisteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        itemRemoveCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Remover combo");
                String combo = JOptionPane.showInputDialog("Digite o combo para remover:");
                try {
                    sistema.removeCombo(combo);
                    JOptionPane.showMessageDialog(frame,"Combo removido com sucesso");
                } catch (ComboNaoExisteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        itemExisteCookiesDoTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Existe cookie do tipo");
                String[] tipos = { "TRADICIONAL", "TORTA_COOKIE", "MARMITINHA", "MINI_COOKIES"};
                String tipoStr = (String) JOptionPane.showInputDialog(null, "Escolha o tipo do cookie:",
                        "Tipo do Cookie", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);
                JOptionPane.showMessageDialog(frame, sistema.existeCookiesDoTipo(TipoCookie.valueOf(tipoStr)));
            }
        });

        itemExisteSabor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Existe cookie do sabor");
                String sabor = JOptionPane.showInputDialog("Digite o sabor do cookie:");
                JOptionPane.showMessageDialog(frame, sistema.existeSabor(sabor));
            }
        });

        /**menuExisteSabor.addActionListener(
                (ae) -> {
                    JOptionPane.showMessageDialog(frame, "Você selecionou: Existe cookie do sabor");
                    String sabor = JOptionPane.showInputDialog(this, "Digite o sabor do cookie:");
                    JOptionPane.showMessageDialog(frame, sistema.existeSabor(sabor));
                }
        );*/

        itemPesquisaCombos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Pesquisar combos");
                String combo = JOptionPane.showInputDialog("Digite o combo que deseja:");
                List<Combos> lista = new ArrayList<>();
                for (Combos c: sistema.pesquisaCombos(combo)){
                    lista.add(c);
                }
                for (Combos c: lista){
                    JOptionPane.showMessageDialog(frame, c.toString());
                }
            }
        });


        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SistemaVendasMap cardapio = new SistemaVendasMap();
        MenuCookies menu = new MenuCookies();
    }
}
