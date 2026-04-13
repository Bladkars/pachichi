import javax.swing.*;

public class EjercicioCircunferencia extends JFrame {

    public EjercicioCircunferencia() {
        setTitle("Ejercicio Circunferencia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputRadio = new JTextField(10);
        JButton calcularButton = new JButton("Calcular");
        JLabel resultado = new JLabel("Resultado: ");

        calcularButton.addActionListener(e -> {
            try {
                double radio = Double.parseDouble(inputRadio.getText());

                double longitud = 2 * Math.PI * radio;
                double area = Math.PI * radio * radio;

                resultado.setText("Longitud: " + longitud + " | Área: " + area);

            } catch (NumberFormatException ex) {
                resultado.setText("Error: introduce un número válido.");
            }
        });

        JPanel panel = new JPanel();

        panel.add(new JLabel("Introduce el radio: "));
        panel.add(inputRadio);
        panel.add(calcularButton);
        panel.add(resultado);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjercicioCircunferencia ejercicio = new EjercicioCircunferencia();
            ejercicio.setVisible(true);
        });
    }
}