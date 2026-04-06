import javax.swing.*;

public class calcularEdad extends JFrame {

    public calcularEdad() {
        setTitle("Ejercicio 1.3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField anioActualField = new JTextField(5);
        JTextField anioNacimientoField = new JTextField(5);
        JButton calcularButton = new JButton("Calcular");
        JLabel resultadoLabel = new JLabel("Tu edad es: ");

        calcularButton.addActionListener(e -> {
            try {
                int anioActual = Integer.parseInt(anioActualField.getText());
                int anioNacimiento = Integer.parseInt(anioNacimientoField.getText());

                int edad = anioActual - anioNacimiento;

                resultadoLabel.setText("Tu edad es: " + edad);
            } catch (NumberFormatException ex) {
                resultadoLabel.setText("Entrada inválida. Introduce números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Año actual: "));
        panel.add(anioActualField);
        panel.add(new JLabel("Año de nacimiento: "));
        panel.add(anioNacimientoField);
        panel.add(calcularButton);
        panel.add(resultadoLabel);

        add(panel);
        setSize(650, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            calcularEdad ejercicio = new calcularEdad();
            ejercicio.setVisible(true);
        });
    }
}