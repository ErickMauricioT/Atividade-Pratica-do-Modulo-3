package principal;

public class Cliente {
    private String cpf;
    private String nome_clien;
    private String end_clien;
    private String telefone_clien;
    private String email_clien;
    private Passagem id_compra;
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String setNome_clien() {
        return nome_clien;
    }

    public void setNome_clien(String nome_clien) {
        this.nome_clien = nome_clien;
    }

    public String getEnd_clien() {
        return end_clien;
    }

    public void setEnd_clien(String end_clien) {
        this.end_clien = end_clien;
    }

    public String getTelefone_clien() {
        return telefone_clien;
    }

    public void setTelefone_clien(String telefone_clien) {
        this.telefone_clien = telefone_clien;
    }

    public String getEmail_clien() {
        return email_clien;
    }

    public void setEmail_clien(String email_clien) {
        this.email_clien = email_clien;
    }

    public Passagem getId_compra() {
        return id_compra;
    }

    public void setId_compra(Passagem id_compra) {
        this.id_compra = id_compra;
    }
}