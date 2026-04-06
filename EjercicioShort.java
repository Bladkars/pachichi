import javax.swing.*;

public class EjercicioShort extends JFrame {

    private short valor = 32767; // empezamos en el máximo

    public EjercicioShort() {
        setTitle("Ejercicio 1.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel valorLabel = new JLabel("Valor: " + valor);
        JButton sumarButton = new JButton("+1");
        JButton restarButton = new JButton("-1");

        sumarButton.addActionListener(e -> {
            valor = (short) (valor + 1); // overflow automático
            valorLabel.setText("Valor: " + valor);
        });

        restarButton.addActionListener(e -> {
            valor = (short) (valor - 1); // underflow automático
            valorLabel.setText("Valor: " + valor);
        });

        JPanel panel = new JPanel();
        panel.add(valorLabel);
        panel.add(sumarButton);
        panel.add(restarButton);

        add(panel);
        setSize(300, 120);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EjercicioShort ejercicio = new EjercicioShort();
            ejercicio.setVisible(true);
        });
    }
}