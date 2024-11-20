package model;

import model.PrescricaoMedica;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private int idade;
    private String cpf;
    private List<PrescricaoMedica> prescricoes;

    public Paciente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.prescricoes = new ArrayList<>();
    }

    public List<PrescricaoMedica> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(List<PrescricaoMedica> prescricoes) {
        this.prescricoes = prescricoes;
    }

    // Getters e Setters
    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", prescricoes=" + prescricoes +
                '}';
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionarPrescricao(PrescricaoMedica prescricao) {
        this.prescricoes.add(prescricao);  // Adiciona a prescrição à lista do paciente
    }

}
