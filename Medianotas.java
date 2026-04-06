import javax.swing.*;

public class Medianotas extends JFrame {

    public Medianotas() {
        setTitle("Ejercicio 1.5 - Media de 4 Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nota1Field = new JTextField(5);
        JTextField nota2Field = new JTextField(5);
        JTextField nota3Field = new JTextField(5);
        JTextField nota4Field = new JTextField(5);

        JButton calcularButton = new JButton("Calcular Media");
        JLabel resultadoLabel = new JLabel("Media: ");

        calcularButton.addActionListener(e -> {
            try {
                int nota1 = Integer.parseInt(nota1Field.getText());
                int nota2 = Integer.parseInt(nota2Field.getText());
                int nota3 = Integer.parseInt(nota3Field.getText());
                int nota4 = Integer.parseInt(nota4Field.getText());

                double media = (nota1 + nota2 + nota3 + nota4) / 4.0; // división decimal

                resultadoLabel.setText("Media: " + media);
            } catch (NumberFormatException ex) {
                resultadoLabel.setText("Entrada inválida. Introduce números enteros.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Nota 1: "));
        panel.add(nota1Field);
        panel.add(new JLabel("Nota 2: "));
        panel.add(nota2Field);
        panel.add(new JLabel("Nota 3: "));
        panel.add(nota3Field);
        panel.add(new JLabel("Nota 4: "));
        panel.add(nota4Field);
        panel.add(calcularButton);
        panel.add(resultadoLabel);

        add(panel);
        setSize(700, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Medianotas ejercicio = new Medianotas();
            ejercicio.setVisible(true);
        });
    }
}