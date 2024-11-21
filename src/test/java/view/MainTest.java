package test.java.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import view.MenuView;

public class MainTest {

    private MenuView menuView;
    private Scanner scanner;

    @BeforeEach
    public void setup() {
        // Usando Scanner real para simular entrada de usuário
        scanner = new Scanner("4"); // Simula o usuário digitando a opção 4
        // Inicializar o MenuView com o Scanner real
        menuView = new MenuView(scanner);
    }

    @Test
    public void testExibirMenu() {
        // Chama o método que queremos testar
        menuView.exibirMenu();

        // O teste pode ser validado verificando o comportamento esperado
        // Como a saída do menu é para o console, você pode precisar verificar a saída no console
        // Se o MenuView printa alguma coisa no console, você pode capturar a saída do System.out,
        // ou se a lógica for interna, verificar o comportamento ou o estado da aplicação.
        // Como exemplo:
        // assertEquals(expectedOutput, capturedOutput);
    }
}
