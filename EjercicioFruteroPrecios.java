import javax.swing.*;

public class EjercicioFruteroPrecios extends JFrame {

    public EjercicioFruteroPrecios() {
        setTitle("Ejercicio Frutero con Precios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Campos manzanas
        JTextField manzT1 = new JTextField(5);
        JTextField manzT2 = new JTextField(5);
        JTextField manzT3 = new JTextField(5);
        JTextField manzT4 = new JTextField(5);

        // Campos peras
        JTextField perasT1 = new JTextField(5);
        JTextField perasT2 = new JTextField(5);
        JTextField perasT3 = new JTextField(5);
        JTextField perasT4 = new JTextField(5);

        // Campos de precios
        JTextField precioManzanas = new JTextField(5);
        JTextField precioPeras = new JTextField(5);

        JButton calcularButton = new JButton("Calcular");
        JLabel resultado = new JLabel("Importe total anual: ");

        calcularButton.addActionListener(e -> {
            try {
                // Manzanas
                double m1 = Double.parseDouble(manzT1.getText());
                double m2 = Double.parseDouble(manzT2.getText());
                double m3 = Double.parseDouble(manzT3.getText());
                double m4 = Double.parseDouble(manzT4.getText());

                // Peras
                double p1 = Double.parseDouble(perasT1.getText());
                double p2 = Double.parseDouble(perasT2.getText());
                double p3 = Double.parseDouble(perasT3.getText());
                double p4 = Double.parseDouble(perasT4.getText());

                // Precios
                double precioM = Double.parseDouble(precioManzanas.getText());
                double precioP = Double.parseDouble(precioPeras.getText());

                double totalManzanas = m1 + m2 + m3 + m4;
                double totalPeras = p1 + p2 + p3 + p4;

                double importe = (totalManzanas * precioM) + (totalPeras * precioP);

                resultado.setText("Importe total anual: " + importe + " €");

            } catch (NumberFormatException ex) {
                resultado.setText("Error: introduce valores numéricos válidos.");
            }
        });

        JPanel panel = new JPanel();

        // Manzanas
        panel.add(new JLabel("Manzanas T1:"));
        panel.add(manzT1);
        panel.add(new JLabel("T2:"));
        panel.add(manzT2);
        panel.add(new JLabel("T3:"));
        panel.add(manzT3);
        panel.add(new JLabel("T4:"));
        panel.add(manzT4);

        // Peras
        panel.add(new JLabel("Peras T1:"));
        panel.add(perasT1);
        panel.add(new JLabel("T2:"));
        panel.add(perasT2);
        panel.add(new JLabel("T3:"));
        panel.add(perasT3);
        panel.add(new JLabel("T4:"));
        panel.add(perasT4);

        // Precios
        panel.add(new JLabel("Precio Manzanas (€/kg):"));
        panel.add(precioManzanas);
        panel.add(new JLabel("Precio Peras (€/kg):"));
        panel.add(precioPeras);

        panel.add(calcularButton);
        panel.add(resultado);

        add(panel);
        setSize(800, 220);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjercicioFruteroPrecios ejercicio = new EjercicioFruteroPrecios();
            ejercicio.setVisible(true);
        });
    }
}