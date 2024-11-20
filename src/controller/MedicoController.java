package controller;

import model.Medicamento;
import model.Medico;
import model.Paciente;
import model.PrescricaoMedica;

import java.util.ArrayList;
import java.util.List;

public class MedicoController {
    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<PrescricaoMedica> prescricoes;

    // Construtor
    public MedicoController() {
        this.medicos = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.prescricoes = new ArrayList<>();
    }

    // Método para registrar médico
    public void registrarMedico(String nome, int crm, String especialidade, String email, String telefone) {
        Medico medico = new Medico(nome, crm, especialidade, email, telefone);
        medicos.add(medico);
        System.out.println("Médico " + nome + " registrado com sucesso.");
    }

    // Método para registrar paciente
    public void registrarPaciente(String nome, int idade, String cpf) {
        Paciente paciente = new Paciente(nome, idade, cpf);
        pacientes.add(paciente);
        System.out.println("Paciente " + nome + " registrado com sucesso.");
    }

    // Método para consultar médico
    public Medico consultarMedico(int crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm() == crm) {
                return medico;
            }
        }
        return null;
    }

    // Método para consultar paciente
    public Paciente consultarPaciente(String cpfPaciente) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpfPaciente)) {
                return paciente;
            }
        }
        return null;
    }

    // Método para listar médicos
    public List<Medico> listarMedicos() {
        if (this.medicos.isEmpty()) {
            System.out.println("Não há médicos cadastrados.");
        } else {
            System.out.println("Lista de Médicos:");
            for (Medico medico : medicos) {
                System.out.println("Nome: " + medico.getNome() + " | CRM: " + medico.getCrm() + " | Especialidade: " + medico.getEspecialidade());
            }
        }
        return this.medicos;
    }

    // Método para adicionar prescrição médica
    public void adicionarPrescricao(int crm, String cpfPaciente, PrescricaoMedica prescricao) {
        Medico medico = consultarMedico(crm);
        Paciente paciente = consultarPaciente(cpfPaciente);

        if (medico != null && paciente != null) {
            // Adicionar prescrição à lista de prescrições do médico e paciente
            medico.adicionarPrescricao(prescricao);
            paciente.adicionarPrescricao(prescricao);

            // Armazenar a prescrição na lista de prescrições gerais
            prescricoes.add(prescricao);

            System.out.println("Prescrição de " + prescricao.getMedicamento() + " (Dosagem: " + prescricao.getDosagem() + ") para o paciente " + cpfPaciente + " foi realizada com sucesso pelo médico " + medico.getNome());
        } else {
            System.out.println("Médico ou paciente não encontrado.");
        }
    }

    // Método para listar pacientes prescritos por um médico
    public void listarPacientesPrescritos(String nomeMedico) {
        Medico medico = null;

        // Encontrar o médico pelo nome
        for (Medico m : medicos) {
            if (m.getNome().equals(nomeMedico)) {
                medico = m;
                break;
            }
        }

        if (medico != null) {
            // Listar os pacientes prescritos por esse médico
            List<PrescricaoMedica> prescricoesMedico = medico.getPrescricoes();
            if (prescricoesMedico.isEmpty()) {
                System.out.println("Nenhum paciente prescrito por " + nomeMedico + ".");
            } else {
                System.out.println("Pacientes prescritos pelo médico " + nomeMedico + ":");
                for (PrescricaoMedica prescricao : prescricoesMedico) {
                    System.out.println(" | Medicamento: " + prescricao.getMedicamento() + " | Dosagem: " + prescricao.getDosagem());
                }
            }
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    // Método para prescrever medicamento
    public void prescreverMedicamento(int crm, String cpfPaciente, String nomeMedicamento, String dosagem, String frequencia, String descricao, String data) {
        Medico medico = consultarMedico(crm);
        Paciente paciente = consultarPaciente(cpfPaciente);

        if (medico != null && paciente != null) {
            // Criar o objeto Medicamento
            Medicamento medicamento = new Medicamento(nomeMedicamento);

            // Criar a prescrição
            PrescricaoMedica prescricao = new PrescricaoMedica(crm, cpfPaciente, medicamento, 30); // Considerar a duração como 30, ou ajustar conforme necessário
            medico.adicionarPrescricao(prescricao);
            paciente.adicionarPrescricao(prescricao);
            prescricoes.add(prescricao);

            System.out.println("Medicamento " + nomeMedicamento + " prescrito para o paciente " + cpfPaciente);
        } else {
            System.out.println("Médico ou paciente não encontrado.");
        }
    }

    // Método para ajustar dosagem de medicamento
    public void ajustarDosagem(int crm, String cpfPaciente, String nomeMedicamento, String novaDosagem) {
        Medico medico = consultarMedico(crm);
        Paciente paciente = consultarPaciente(cpfPaciente);

        if (medico != null && paciente != null) {
            for (PrescricaoMedica prescricao : medico.getPrescricoes()) {
                if (prescricao.getMedicamento().equals(nomeMedicamento)) {
                    prescricao.setDosagem(novaDosagem);
                    System.out.println("Dosagem do medicamento " + nomeMedicamento + " ajustada para " + novaDosagem);
                    return;
                }
            }
            System.out.println("Medicamento não encontrado nas prescrições.");
        } else {
            System.out.println("Médico ou paciente não encontrado.");
        }
    }

    // Método para cancelar prescrição de medicamento
    public void cancelarPrescricao(int crm, String cpfPaciente, String nomeMedicamento) {
        Medico medico = consultarMedico(crm);
        Paciente paciente = consultarPaciente(cpfPaciente);

        if (medico != null && paciente != null) {
            for (PrescricaoMedica prescricao : medico.getPrescricoes()) {
                if (prescricao.getMedicamento().equals(nomeMedicamento)) {
                    medico.getPrescricoes().remove(prescricao);
                    paciente.getPrescricoes().remove(prescricao);
                    prescricoes.remove(prescricao);
                    System.out.println("Prescrição do medicamento " + nomeMedicamento + " cancelada.");
                    return;
                }
            }
            System.out.println("Medicamento não encontrado nas prescrições.");
        } else {
            System.out.println("Médico ou paciente não encontrado.");
        }
    }

    // Método para consultar medicamento
    public void consultarMedicamento(int crm, String cpfPaciente, String nomeMedicamento) {
        Medico medico = consultarMedico(crm);
        Paciente paciente = consultarPaciente(cpfPaciente);

        if (medico != null && paciente != null) {
            for (PrescricaoMedica prescricao : medico.getPrescricoes()) {
                if (prescricao.getMedicamento().equals(nomeMedicamento)) {
                    System.out.println("Medicamento: " + prescricao.getMedicamento() + " | Dosagem: " + prescricao.getDosagem());
                    return;
                }
            }
            System.out.println("Medicamento não encontrado nas prescrições.");
        } else {
            System.out.println("Médico ou paciente não encontrado.");
        }
    }
}
