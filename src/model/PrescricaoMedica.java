package model;

public class PrescricaoMedica {
    private String medicamento;
    private String dosagem;


    public PrescricaoMedica(String medicamento, String dosagem) {
        this.medicamento = medicamento;
        this.dosagem = dosagem;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    @Override
    public String toString() {
        return "PrescricaoMedica{" +
                "medicamento='" + medicamento + '\'' +
                ", dosagem='" + dosagem + '\'' +
                '}';
    }
}
