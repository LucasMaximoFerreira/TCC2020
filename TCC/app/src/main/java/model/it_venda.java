package model;

public class it_venda {
    private int id_it;
    private int id_vda;
    private int id_prod;
    private int qtd_it;
    private String tam_prod;
    private double total_ped;

    public int getId_it() {
        return id_it;
    }

    public void setId_it(int id_it) {
        this.id_it = id_it;
    }

    public int getId_vda() {
        return id_vda;
    }

    public void setId_vda(int id_vda) {
        this.id_vda = id_vda;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getQtd_it() {
        return qtd_it;
    }

    public void setQtd_it(int qtd_it) {
        this.qtd_it = qtd_it;
    }

    public String getTam_prod() {
        return tam_prod;
    }

    public void setTam_prod(String tam_prod) {
        this.tam_prod = tam_prod;
    }

    public double getTotal_ped() {
        return total_ped;
    }

    public void setTotal_ped(double total_ped) {
        this.total_ped = total_ped;
    }
}
