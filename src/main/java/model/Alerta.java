package model;

import java.util.Date;

public class Alerta {
    private String tipo; // Tipo de alerta (Emergência, Anormalidade)
    private String mensagem; // Mensagem do alerta
    private Paciente paciente; // Referência ao paciente
    private Medico medico; // Referência ao médico
    private Date dataGeracao; // Data do alerta

    // Construtor
    public Alerta(String tipo, String mensagem, Paciente paciente, Medico medico) {
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.paciente = paciente;
        this.medico = medico;
        this.dataGeracao = new Date();
    }

    // Getters e setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }
}
