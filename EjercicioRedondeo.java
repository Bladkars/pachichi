import javax.swing.*;

public class EjercicioRedondeo extends JFrame {

    public EjercicioRedondeo() {
        setTitle("Ejercicio Redondeo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Redondear");
        JLabel resultLabel = new JLabel("El número redondeado es: ");

        submitButton.addActionListener(e -> {
            try {
                double numero = Double.parseDouble(inputField.getText());
                long redondeado = Math.round(numero);
                resultLabel.setText("El número redondeado es: " + redondeado);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número decimal válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escribe un número decimal: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjercicioRedondeo ejercicio = new EjercicioRedondeo();
            ejercicio.setVisible(true);
        });
    }
}