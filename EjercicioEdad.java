import javax.swing.*;

public class EjercicioEdad extends JFrame {

    public EjercicioEdad() {
        setTitle("Ejercicio Edad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(10);
        JButton submitButton = new JButton("Calcular");
        JLabel resultLabel = new JLabel("Tu edad el próximo año será: ");

        submitButton.addActionListener(e -> {
            try {
                int edad = Integer.parseInt(inputField.getText());
                int proximaEdad = edad + 1;
                resultLabel.setText("Tu edad el próximo año será: " + proximaEdad);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce una edad válida.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escribe tu edad: "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjercicioEdad ejercicio = new EjercicioEdad();
            ejercicio.setVisible(true);
        });
    }
}