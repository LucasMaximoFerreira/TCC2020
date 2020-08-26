package model;

public class produto {
    private int id_prod;
    private int id_tipoProd;
    private String tam_prod;
    private double preco_prod;

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_tipoProd() {
        return id_tipoProd;
    }

    public void setId_tipoProd(int id_tipoProd) {
        this.id_tipoProd = id_tipoProd;
    }

    public String getTam_prod() {
        return tam_prod;
    }

    public void setTam_prod(String tam_prod) {
        this.tam_prod = tam_prod;
    }

    public double getPreco_prod() {
        return preco_prod;
    }

    public void setPreco_prod(double preco_prod) {
        this.preco_prod = preco_prod;
    }
}
