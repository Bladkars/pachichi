
import javax.swing.*;

public class n2_11 extends JFrame {

    public n2_11() {
        setTitle("Ejercicio 2.11");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Enviar");
        JLabel resultLabel = new JLabel("Calificación: esperando nota...");

        submitButton.addActionListener(e -> {
            try {
                int nota = Integer.parseInt(inputField.getText().trim());

                if (nota >= 0 && nota <= 4) {
                    resultLabel.setText("Calificación: Insuficiente");
                } else if (nota == 5) {
                    resultLabel.setText("Calificación: Suficiente");
                } else if (nota == 6) {
                    resultLabel.setText("Calificación: Bien");
                } else if (nota == 7 || nota == 8) {
                    resultLabel.setText("Calificación: Notable");
                } else if (nota == 9 || nota == 10) {
                    resultLabel.setText("Calificación: Sobresaliente");
                } else {
                    resultLabel.setText("Error: La nota debe estar entre 0 y 10.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número entero válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba una nota (0-10): "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new n2_11().setVisible(true);
        });
    }
}