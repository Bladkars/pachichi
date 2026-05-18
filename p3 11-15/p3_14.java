

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class p3_14 extends JFrame {

    public p3_14() {
        setTitle("Ejercicio 3.14 - Triángulo de Asteriscos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);

        // Componentes para la parte superior (Entrada de datos)
        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Dibujar");
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Número de elementos (n):"));
        panelSuperior.add(inputField);
        panelSuperior.add(submitButton);

        // Área de texto central para dibujar el triángulo (fuente monoespaciada clave para la alineación)
        JTextArea txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(txtResultado);

        submitButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(inputField.getText());

                if (n <= 0) {
                    txtResultado.setText("Por favor, ingrese un número entero mayor a 0.");
                    return;
                }

                StringBuilder triangulo = new StringBuilder();

                // Bucle externo para controlar las filas de forma decreciente
                for (int i = n; i >= 1; i--) {
                    // Bucle interno para pintar los asteriscos de la fila actual
                    for (int j = 1; j <= i; j++) {
                        triangulo.append("* ");
                    }
                    triangulo.append("\n"); // Salto de línea al terminar la fila
                }

                txtResultado.setText(triangulo.toString());

            } catch (NumberFormatException ex) {
                txtResultado.setText("Entrada inválida. Introduzca un número entero válido.");
            }
        });

        // Organizamos la ventana
        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_14 ejercicio = new p3_14();
            ejercicio.setVisible(true);
        });
    }
}