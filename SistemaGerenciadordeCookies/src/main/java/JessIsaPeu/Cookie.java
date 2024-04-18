package JessIsaPeu;

public class Cookie {
    private String sabor;
    private double preco;
    private String combos;
    private TipoCookie tipo;
    public Cookie(String sabor, double preco, String combos,TipoCookie tipo){
        this.sabor = sabor;
        this.preco = preco;
        this.combos = combos;
        this.tipo = tipo;
    }
    public boolean ehDoTipo(TipoCookie tipo){
        return this.tipo==tipo;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCombos() {
        return combos;
    }

    public void setCombos(String combos) {
        this.combos = combos;
    }

    public TipoCookie getTipo() {
        return tipo;
    }

    public void setTipo(TipoCookie tipo) {
        this.tipo = tipo;
    }
}

