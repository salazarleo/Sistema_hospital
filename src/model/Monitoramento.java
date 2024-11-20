package model;

import java.util.Date;

public class Monitoramento {
    private Dispositivo dispositivo;
    private String dados;
    private Date data;

    public Monitoramento(Dispositivo dispositivo, String dados, Date data) {
        this.dispositivo = dispositivo;
        this.dados = dados;
        this.data = data;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public String getDados() {
        return dados;
    }

    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Monitoramento{" +
                "dispositivo=" + dispositivo.getNome() +
                ", dados='" + dados + '\'' +
                ", data=" + data +
                '}';
    }
}
