package model;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private int idade;
    private String cpf;
    private List<PrescricaoMedica> prescricoes;
    private List<Dispositivo> dispositivos; // Adicionando a lista de dispositivos

    public Paciente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.prescricoes = new ArrayList<>();
        this.dispositivos = new ArrayList<>(); // Inicializando a lista de dispositivos
    }

    // Getters e Setters
    public List<PrescricaoMedica> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(List<PrescricaoMedica> prescricoes) {
        this.prescricoes = prescricoes;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void adicionarDispositivo(Dispositivo dispositivo) {
        this.dispositivos.add(dispositivo);
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionarPrescricao(PrescricaoMedica prescricao) {
        this.prescricoes.add(prescricao); // Adiciona a prescrição à lista do paciente
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", prescricoes=" + prescricoes +
                ", dispositivos=" + dispositivos + // Incluindo dispositivos no toString
                '}';
    }
}
