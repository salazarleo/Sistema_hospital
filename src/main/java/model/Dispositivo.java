package model;

public class Dispositivo {
    private String tipo;
    private String marca;
    private String modelo;
    private String status;
    private String valoresReferencia;  // Supondo que seja uma lista de valores de referência

    // Construtor com os parâmetros que você mencionou
    public Dispositivo(String tipo, String marca, String modelo, String status, String valoresReferencia) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.status = status;
        this.valoresReferencia = valoresReferencia;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getStatus() {
        return status;
    }

    public String getValoresReferencia() {
        return valoresReferencia;
    }

    // Método que cria um nome para o dispositivo
    public String getNome() {
        return tipo + " " + marca + " " + modelo;  // Por exemplo, retorna uma combinação de tipo, marca e modelo
    }
    public void exibirDetalhes() {
        System.out.println("Detalhes do Dispositivo:");
        System.out.println("Tipo: " + tipo);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Status: " + status);
        System.out.println("Valores de Referência: " + valoresReferencia);
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "tipo='" + tipo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", status='" + status + '\'' +
                ", valoresReferencia='" + valoresReferencia + '\'' +
                '}';
    }
}
