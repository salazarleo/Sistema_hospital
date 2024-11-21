package model;

public class Consulta {
    private String data;
    private String hora;
    private String diagnostico;
    private String prescricaomed;
    private Medico medico;
    private Paciente paciente;

    // Construtor que recebe os parâmetros necessários
    public Consulta(String data, String hora, String diagnostico, String prescricaomed, Medico medico, Paciente paciente) {
        this.data = data;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.prescricaomed = prescricaomed;
        this.medico = medico;
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", prescricaomed='" + prescricaomed + '\'' +
                ", medico=" + medico +
                ", paciente=" + paciente +
                '}';
    }

    // Getters e setters
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricaomed() {
        return prescricaomed;
    }

    public void setPrescricaomed(String prescricaomed) {
        this.prescricaomed = prescricaomed;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
