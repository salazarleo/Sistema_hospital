package model;

public class Medicamento {
    private String nome;
    private String frequencia;
    private String descricao;
    private String data;

    // Construtor
    public Medicamento(String nome) {
        this.nome = nome;
        this.frequencia = frequencia;
        this.descricao = descricao;
        this.data = data;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
