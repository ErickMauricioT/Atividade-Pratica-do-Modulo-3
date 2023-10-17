package principal;

import java.util.Date;

public class Destino {
    private String local_destino;
    private Date data_viagem;
    private int cod_destino;
    private Passagem id_compra;
    
    public String getLocal_destino() {
        return local_destino;
    }

    public void setLocal_destino(String local_destino) {
        this.local_destino = local_destino;
    }

    public Date getData_viagem() {
        return data_viagem;
    }

    public void setData_viagem(Date data_viagem) {
        this.data_viagem = data_viagem;
    }

    public int getCod_destino() {
        return cod_destino;
    }

    public void setCod_destino(int cod_destino) {
        this.cod_destino = cod_destino;
    }

    public Passagem getId_compra() {
        return id_compra;
    }

    public void setId_compra(Passagem id_compra) {
        this.id_compra = id_compra;
    }
}