package ejercicio2_8swing;

import javax.swing.*;

public class Ejercicio2_8Swing extends JFrame {

    public Ejercicio2_8Swing() {
        setTitle("Ejercicio 2.8 - Ecuación de 2º grado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField fieldA = new JTextField(5);
        JTextField fieldB = new JTextField(5);
        JTextField fieldC = new JTextField(5);
        JButton solveButton = new JButton("Calcular");
        JLabel resultLabel = new JLabel("Introduce los coeficientes a, b, c");

        solveButton.addActionListener(e -> {
            try {
                double a = Double.parseDouble(fieldA.getText());
                double b = Double.parseDouble(fieldB.getText());
                double c = Double.parseDouble(fieldC.getText());

                if (a == 0) {
                    resultLabel.setText("No es ecuación de segundo grado (a = 0).");
                    return;
                }

                double discriminante = b * b - 4 * a * c;

                if (discriminante > 0) {
                    double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                    double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                    resultLabel.setText(String.format("Dos soluciones reales: x1=%.3f , x2=%.3f", x1, x2));
                } else if (discriminante == 0) {
                    double x = -b / (2 * a);
                    resultLabel.setText(String.format("Una solución real doble: x=%.3f", x));
                } else {
                    resultLabel.setText("No existen soluciones reales.");
                }

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("a: "));
        panel.add(fieldA);
        panel.add(new JLabel("b: "));
        panel.add(fieldB);
        panel.add(new JLabel("c: "));
        panel.add(fieldC);
        panel.add(solveButton);
        panel.add(resultLabel);

        add(panel);
        setSize(650, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_8Swing app = new Ejercicio2_8Swing();
            app.setVisible(true);
        });
    }
}