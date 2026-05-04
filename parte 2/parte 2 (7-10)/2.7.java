package ejercicio2_7swing;

import javax.swing.*;

public class Ejercicio2_7Swing extends JFrame {

    public Ejercicio2_7Swing() {
        setTitle("Ejercicio 2.7 - Tres números ordenados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField inputField1 = new JTextField(8);
        JTextField inputField2 = new JTextField(8);
        JTextField inputField3 = new JTextField(8);
        JButton orderButton = new JButton("Ordenar");
        JLabel resultLabel = new JLabel("Introduce tres números");

        orderButton.addActionListener(e -> {
            try {
                int num1 = Integer.parseInt(inputField1.getText());
                int num2 = Integer.parseInt(inputField2.getText());
                int num3 = Integer.parseInt(inputField3.getText());

                int mayor, medio, menor;

                if (num1 >= num2 && num1 >= num3) {
                    mayor = num1;
                    if (num2 >= num3) {
                        medio = num2;
                        menor = num3;
                    } else {
                        medio = num3;
                        menor = num2;
                    }
                } else if (num2 >= num1 && num2 >= num3) {
                    mayor = num2;
                    if (num1 >= num3) {
                        medio = num1;
                        menor = num3;
                    } else {
                        medio = num3;
                        menor = num1;
                    }
                } else {
                    mayor = num3;
                    if (num1 >= num2) {
                        medio = num1;
                        menor = num2;
                    } else {
                        medio = num2;
                        menor = num1;
                    }
                }

                resultLabel.setText("Orden decreciente: " + mayor + " , " + medio + " , " + menor);

            } catch (NumberFormatException ex) {
                resultLabel.setText("Entrada inválida. Introduce números válidos.");
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Número 1: "));
        panel.add(inputField1);
        panel.add(new JLabel("Número 2: "));
        panel.add(inputField2);
        panel.add(new JLabel("Número 3: "));
        panel.add(inputField3);
        panel.add(orderButton);
        panel.add(resultLabel);

        add(panel);
        setSize(650, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ejercicio2_7Swing app = new Ejercicio2_7Swing();
            app.setVisible(true);
        });
    }
}