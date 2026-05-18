
import javax.swing.*;

public class n2_15 extends JFrame {

    public n2_15() {
        setTitle("Ejercicio 2.15 - Días de la Semana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField = new JTextField(5);
        JButton submitButton = new JButton("Mostrar Día");
        JLabel resultLabel = new JLabel("El día es: ");

        submitButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(inputField.getText());
                String diaSemana;

                switch (num) {
                    case 1:
                        diaSemana = "Lunes";
                        break;
                    case 2:
                        diaSemana = "Martes";
                        break;
                    case 3:
                        diaSemana = "Miércoles";
                        break;
                    case 4:
                        diaSemana = "Jueves";
                        break;
                    case 5:
                        diaSemana = "Viernes";
                        break;
                    case 6:
                        diaSemana = "Sábado";
                        break;
                    case 7:
                        diaSemana = "Domingo";
                        break;
                    default:
                        diaSemana = "inválido. Debe ser un número del 1 al 7";
                        break;
                }

                resultLabel.setText("El día es: " + diaSemana);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce un número válido.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escriba un número (1-7): "));
        panel.add(inputField);
        panel.add(submitButton);
        panel.add(resultLabel);

        add(panel);
        setSize(600, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            n2_15 ejercicio = new n2_15();
            ejercicio.setVisible(true);
        });
    }
}