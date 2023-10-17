package principal;

import java.util.Date;

public class Passagem {
    private int passagem_id;
    private String id_clien;
    private String nome_clien;
    private Date data_compra;
    private int qtd_passagens;
    private double preco_passagem;
    private double preco_total;
    
    public int getPassagem_id() {
        return passagem_id;
    }

    public void setPassagem_id(int passagem_id) {
        this.passagem_id = passagem_id;
    }

    public String getId_clien() {
        return id_clien;
    }

    public void setId_clien(String id_clien) {
        this.id_clien = id_clien;
    }

    public String getNome_clien() {
        return nome_clien;
    }

    public void setNome_clien(String nome_clien) {
        this.nome_clien = nome_clien;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public int getQtd_passagens() {
        return qtd_passagens;
    }

    public void setQtd_passagens(int qtd_passagens) {
        this.qtd_passagens = qtd_passagens;
    }

    public double getPreco_passagem() {
        return preco_passagem;
    }

    public void setPreco_passagem(double preco_passagem) {
        this.preco_passagem = preco_passagem;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }
}