package JessIsaPeu;

import java.util.Objects;

public class Cookie {
    private String sabor;
    private double preco;
    private TipoCookie tipo;
    public Cookie(String sabor, double preco,TipoCookie tipo){
        this.sabor = sabor;
        this.preco = preco;
        this.tipo = tipo;
    }
    public boolean ehDoTipo(TipoCookie tipo){
        return this.tipo==tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookie cookie = (Cookie) o;
        return Double.compare(cookie.preco, preco) == 0 && Objects.equals(sabor, cookie.sabor) && tipo == cookie.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sabor, preco, tipo);
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "sabor='" + sabor + '\'' +
                ", preco=" + preco +
                ", tipo=" + tipo +
                '}';
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

    public TipoCookie getTipo() {
        return tipo;
    }

    public void setTipo(TipoCookie tipo) {
        this.tipo = tipo;
    }
}



