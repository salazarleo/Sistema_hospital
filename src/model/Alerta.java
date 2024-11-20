package model;

public class Alerta {
    private String tipo;
    private String mensagem;

    public Alerta(String tipo, String mensagem) {
        this.tipo = tipo;
        this.mensagem = mensagem;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "Alerta{" +
                "tipo='" + tipo + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
