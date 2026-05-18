
import javax.swing.*;

public class p3_15 extends JFrame {

    public p3_15() {
        setTitle("Ejercicio 3.15 - Contador de Primos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Contar Primos");
        JLabel resultLabel = new JLabel("Ingrese un número n para evaluar:");

        submitButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(inputField.getText());

                if (n < 1) {
                    resultLabel.setText("Por favor, ingrese un número mayor o igual a 1.");
                    return;
                }

                int contadorPrimos = 0;

                // Evaluamos todos los números desde 1 hasta n
                for (int i = 1; i <= n; i++) {
                    if (esPrimo(i)) {
                        contadorPrimos++;
                    }
                }

                resultLabel.setText("Entre 1 y " + n + " hay un total de " + contadorPrimos + " números primos.");

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduzca un número entero válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número n:"));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(550, 110);
        setLocationRelativeTo(null);
    }

    /**
     * Método auxiliar para comprobar si un número es primo.
     * Adaptado para contemplar el 1 como primo según el ejemplo del enunciado.
     */
    private boolean esPrimo(int numero) {
        if (numero == 1) {
            return true; // Forzado para coincidir con el ejemplo provisto
        }
        if (numero <= 0) {
            return false;
        }
        
        // Buscamos si tiene algún divisor entre 2 y la raíz cuadrada del número
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false; // Si se puede dividir, no es primo
            }
        }
        return true; // Si no se encontraron divisores, es primo
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_15 ejercicio = new p3_15();
            ejercicio.setVisible(true);
        });
    }
}