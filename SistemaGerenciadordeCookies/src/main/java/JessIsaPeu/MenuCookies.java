package JessIsaPeu;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class MenuCookies extends JFrame{
    private JFrame frame;
    private  SistemaVendas sistema;

    public MenuCookies() {
        sistema = new SistemaVendasMap();
        frame = new JFrame("Sistema de vendas de cookies");
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
        JMenuItem itemExisteCookiesDoTipo = new JMenuItem("Existe cookie do tipo");
        JMenuItem itemExisteSabor = new JMenuItem("Existe cookies com sabor");

        menuCadastra.add(itemCadastraCookies);
        menuCadastra.add(itemCadastraCombos);

        menuPesquisa.add(itemPesquisaCookiesPorSabor);
        menuPesquisa.add(itemPesquisaValoresPorFaixa);
        menuPesquisa.add(itemPesquisaCombos);

        menuConta.add(itemContaCookiesDoTipo);

        menuRemove.add(itemRemoveSabor);

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
                String precoStr = JOptionPane.showInputDialog("Digite o preço do cookie:");
                String[] tipos = { "TORTA_COOKIE", "MARMITINHA", "MINI_COOKIES", "OVOS_COOKIES" };
                String tipoStr = (String) JOptionPane.showInputDialog(null, "Escolha o tipo do cookie:",
                        "Tipo do Cookie", JOptionPane.QUESTION_MESSAGE, null, tipos, tipos[0]);

            }
        });
        itemCadastraCombos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Cadastrar combos");
                String nome = JOptionPane.showInputDialog("Digite o nome do combo:");
                String precoStr = JOptionPane.showInputDialog("Digite o preço do combo:");
            }
        });

        itemPesquisaCookiesPorSabor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Pesquisar cookies por sabor");
                String sabor = JOptionPane.showInputDialog("Digite o sabor para pesquisar:");

            }
        });


        itemPesquisaValoresPorFaixa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Pesquisar por faixa de preço");
                String minimoStr = JOptionPane.showInputDialog("Digite o valor mínimo:");
                String maximoStr = JOptionPane.showInputDialog("Digite o valor máximo:");

            }
        });

        itemContaCookiesDoTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Contar cookies do tipo");
                String tipoStr = JOptionPane.showInputDialog("Digite o tipo de cookie:");
            }
        });

        itemRemoveSabor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Remover sabor");
                String sabor = JOptionPane.showInputDialog("Digite o sabor para remover:");

            }
        });

        itemExisteCookiesDoTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Exixte cookie do tipo");
                String tipoStr = JOptionPane.showInputDialog("Digite o tipo do cookie:");

            }
        });

        itemExisteSabor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Exixte cookie do sabor");
                String sabor = JOptionPane.showInputDialog("Digite o sabor do cookie:");


            }
        });

        itemPesquisaCombos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Você selecionou: Pesquisar combos");
                String combo = JOptionPane.showInputDialog("Digite o combo que deseja:");
            }
        });


        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SistemaVendasMap cardapio = new SistemaVendasMap();
        MenuCookies menu = new MenuCookies();
        menu.enable(true);
    }
}
