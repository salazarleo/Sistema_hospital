package controller;

import model.Alerta;
import java.util.ArrayList;
import java.util.List;

public class AlertaController {
    private List<Alerta> alertas = new ArrayList<>();

    // Método para emitir um alerta
    public void emitirAlerta(Alerta alerta) {
        alertas.add(alerta);
        System.out.println("Alerta emitido: " + alerta.getMensagem());
        // Aqui, você pode adicionar mais lógica para enviar um alerta por e-mail, SMS, etc.
    }

    // Método para visualizar alertas
    public void visualizarAlertas() {
        if (alertas.isEmpty()) {
            System.out.println("Nenhum alerta registrado.");
        } else {
            for (Alerta alerta : alertas) {
                System.out.println("Tipo: " + alerta.getTipo() + ", Mensagem: " + alerta.getMensagem());
            }
        }
    }
}
