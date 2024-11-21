package controller;

import model.Dispositivo;
import model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class DispositivoController {
    private List<Dispositivo> dispositivos; // Lista para armazenar dispositivos cadastrados
    private List<Paciente> pacientes; // Lista de pacientes para vinculação de dispositivos

    // Construtor
    public DispositivoController(List<Paciente> pacientes) {
        this.dispositivos = new ArrayList<>();
        this.pacientes = pacientes; // Lista de pacientes para vinculação
    }

    // Método para cadastrar dispositivo
    public void cadastrarDispositivo(String tipo, String marca, String modelo, String status, String valoresReferencia) {
        Dispositivo dispositivo = new Dispositivo(tipo, marca, modelo, status, valoresReferencia);
        dispositivos.add(dispositivo);
        System.out.println("Dispositivo cadastrado com sucesso!");
    }

    // Método para visualizar dispositivos
    public void visualizarDispositivos() {
        if (dispositivos.isEmpty()) {
            System.out.println("Nenhum dispositivo cadastrado.");
            return;
        }

        System.out.println("Lista de Dispositivos:");
        for (int i = 0; i < dispositivos.size(); i++) {
            Dispositivo dispositivo = dispositivos.get(i);
            System.out.println("ID: " + (i + 1));
            dispositivo.exibirDetalhes();  // Certifique-se de que este método está implementado corretamente em Dispositivo
            System.out.println("---------------------------");
        }
    }

    // Método para remover dispositivo
    public void removerDispositivo(int id) {
        if (id <= 0 || id > dispositivos.size()) {
            System.out.println("ID inválido. Tente novamente.");
            return;
        }

        Dispositivo dispositivoRemovido = dispositivos.remove(id - 1);
        System.out.println("Dispositivo do tipo " + dispositivoRemovido.getTipo() + " removido com sucesso.");
    }

    // Método para vincular dispositivo a um paciente
    public void vincularDispositivo(String cpfPaciente, int idDispositivo) {
        // Procurar paciente pelo CPF
        Paciente paciente = null;
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpfPaciente)) {
                paciente = p;
                break;
            }
        }

        if (paciente == null) {
            System.out.println("Paciente com CPF " + cpfPaciente + " não encontrado.");
            return;
        }

        // Validar ID do dispositivo
        if (idDispositivo <= 0 || idDispositivo > dispositivos.size()) {
            System.out.println("ID do dispositivo inválido.");
            return;
        }

        // Vincular dispositivo ao paciente
        Dispositivo dispositivo = dispositivos.get(idDispositivo - 1);
        paciente.adicionarDispositivo(dispositivo); // Método deve existir no modelo Paciente
        System.out.println("Dispositivo do tipo " + dispositivo.getTipo() + " vinculado ao paciente " + paciente.getNome() + " com sucesso.");
    }

    // Método para buscar dispositivo pelo nome
    public Dispositivo buscarDispositivo(String nome) {
        for (Dispositivo dispositivo : dispositivos) {
            if (dispositivo.getNome().equalsIgnoreCase(nome)) {
                return dispositivo;
            }
        }
        return null; // Retorna null se não encontrar
    }
}
