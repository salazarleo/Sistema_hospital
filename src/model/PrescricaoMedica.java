package model;

public class PrescricaoMedica {
    private int crm;
    private String cpfPaciente;
    private Medicamento medicamento;
    private int duracao;
    private String dosagem;

    // Construtor para criar uma prescrição médica
    public PrescricaoMedica(int crm, String cpfPaciente, Medicamento medicamento, int duracao) {
        this.crm = crm;
        this.cpfPaciente = cpfPaciente;
        this.medicamento = medicamento;
        this.duracao = duracao;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    // Getters e Setters
    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
