package test.java.controller;

import model.Medicamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class MedicamentoControllerTest {

    private controller.MedicamentoController medicamentoController;
    private List<Medicamento> medicamentos;

    @BeforeEach
    public void setUp() {
        medicamentos = new ArrayList<>();
        medicamentoController = new controller.MedicamentoController(medicamentos);
    }

    @Test
    public void testRegistrarMedicamentoComSucesso() {
        // Simulando entrada do Scanner
        Scanner scanner = new Scanner("Paracetamol\n500mg\n2x por dia\nPara dor e febre\n2024-11-20\n");

        medicamentoController.registrarMedicamento(scanner);

        // Verifica se o medicamento foi adicionado com sucesso
        assertEquals(1, medicamentos.size(), "Deve haver 1 medicamento registrado.");
        assertEquals("Paracetamol", medicamentos.get(0).getNome(), "O nome do medicamento deve ser 'Paracetamol'.");
    }

    @Test
    public void testListarMedicamentosComMedicamentosRegistrados() {
        Scanner scanner = new Scanner("Paracetamol\n500mg\n2x por dia\nPara dor e febre\n2024-11-20\n");
        medicamentoController.registrarMedicamento(scanner);

        scanner = new Scanner("Ibuprofeno\n400mg\n3x por dia\nPara dor\n2024-11-21\n");
        medicamentoController.registrarMedicamento(scanner);

        // Verifica se a listagem contém 2 medicamentos
        assertEquals(2, medicamentos.size(), "Deve haver 2 medicamentos registrados.");
    }

    @Test
    public void testListarMedicamentosSemMedicamentosRegistrados() {
        // Verifica que a lista de medicamentos está vazia
        assertTrue(medicamentos.isEmpty(), "A lista de medicamentos deve estar vazia.");
    }
}
