package model;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String nome;
    private int idade;
    private String cpf;
    private List<PrescricaoMedica> prescricoes;
    private List<Dispositivo> dispositivos; // Lista de dispositivos
    private Medico medico; // Referência ao médico associado ao paciente

    // Construtor
    public Paciente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.prescricoes = new ArrayList<>();
        this.dispositivos = new ArrayList<>();
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

    public Medico getMedico() {
        return this.medico; // Retorna o médico associado ao paciente
    }

    public void setMedico(Medico medico) {
        this.medico = medico; // Associa um médico ao paciente
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cpf='" + cpf + '\'' +
                ", prescricoes=" + prescricoes +
                ", dispositivos=" + dispositivos +
                ", medico=" + medico + // Incluindo o médico no toString
                '}';
    }
}
