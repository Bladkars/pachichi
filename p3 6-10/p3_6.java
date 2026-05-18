

import javax.swing.*;

public class p3_6 extends JFrame {

    public p3_6() {
        setTitle("Ejercicio 3.6 - Múltiplos de 7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton submitButton = new JButton("Mostrar Múltiplos");
        JLabel resultLabel = new JLabel("Presione el botón para calcular.");

        submitButton.addActionListener(e -> {
            StringBuilder resultado = new StringBuilder("Múltiplos de 7 (< 100): ");
            
            // Recorremos los números de 7 en 7 mientras sean menores que 100
            for (int i = 7; i < 100; i += 7) {
                resultado.append(i);
                // Ponemos una coma si el siguiente múltiplo también va a ser menor que 100
                if (i + 7 < 100) {
                    resultado.append(", ");
                }
            }

            resultLabel.setText(resultado.toString());
        });

        JPanel panel = new JPanel();
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            p3_6 ejercicio = new p3_6();
            ejercicio.setVisible(true);
        });
    }
}