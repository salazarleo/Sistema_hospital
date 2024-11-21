package model;

import java.util.ArrayList;
import java.util.List;

public class Medico {
    private int crm;
    private String nome;
    private String especialidade;
    private String email;
    private String telefone;
    private List<PrescricaoMedica> prescricoes;

    public Medico(String nome, int crm, String especialidade, String email, String telefone) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.email = email;
        this.telefone = telefone;
        this.prescricoes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public List<PrescricaoMedica> getPrescricoes() {
        return prescricoes;
    }

    public void adicionarPrescricao(PrescricaoMedica prescricao) {
        this.prescricoes.add(prescricao);  // Adiciona a prescrição à lista do médico
    }

    @Override
    public String toString() {
        return "Medico{" +
                "crm=" + crm +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", prescricoes=" + prescricoes +
                '}';
    }
}
