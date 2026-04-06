import javax.swing.*;

public class MediaTresNotas extends JFrame {

    public MediaTresNotas() {
        setTitle("Ejercicio 1.6 - Parte entera de la media");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nota1Field = new JTextField(5);
        JTextField nota2Field = new JTextField(5);
        JTextField nota3Field = new JTextField(5);

        JButton calcularButton = new JButton("Calcular Media Entera");
        JLabel resultadoLabel = new JLabel("Media entera: ");

        calcularButton.addActionListener(e -> {
            try {
                double nota1 = Double.parseDouble(nota1Field.getText());
                double nota2 = Double.parseDouble(nota2Field.getText());
                double nota3 = Double.parseDouble(nota3Field.getText());

                double media = (nota1 + nota2 + nota3) / 3.0;

                int mediaEntera = (int) media; // obtenemos solo la parte entera

                resultadoLabel.setText("Media entera: " + mediaEntera);
            } catch (NumberFormatException ex) {
                resultadoLabel.setText("Entrada inválida. Introduce números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nota 1: "));
        panel.add(nota1Field);
        panel.add(new JLabel("Nota 2: "));
        panel.add(nota2Field);
        panel.add(new JLabel("Nota 3: "));
        panel.add(nota3Field);
        panel.add(calcularButton);
        panel.add(resultadoLabel);

        add(panel);
        setSize(600, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MediaTresNotas ejercicio = new MediaTresNotas();
            ejercicio.setVisible(true);
        });
    }
}