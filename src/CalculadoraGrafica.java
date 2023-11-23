import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class CalculadoraGrafica extends JFrame {
    private JTextField textField;
    private Compilador comp;

    public CalculadoraGrafica() {
        // Configurar la ventana
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout());

        // Configurar el campo de texto
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setPreferredSize(new Dimension(0, 50));
        add(textField, BorderLayout.NORTH);

        // Configurar los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 4));

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "(", ")", "+",
                "s", "c", "t", "r",
                "Borrar", "=",  // Reorganizado para seguir el orden proporcionado
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            if (label.equals("=")) {
                // Ajustar el tamaño del botón "="
                button.setPreferredSize(new Dimension(0, 100));
            }
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        comp = new Compilador();
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("=")) {
                // Realizar la operación de cálculo
                String expression = textField.getText();
                try {
                    // Realizar la evaluación y mostrar el resultado en el campo de texto
                    double result = eval(expression);
                    textField.setText(Double.toString(result));
                } catch (Exception ex) {
                    textField.setText("Error");
                }
            } else if (command.equals("Borrar")) {
                // Borrar el último carácter del campo de texto
                String currentText = textField.getText();
                if (currentText.length() > 0) {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else {
                // Agregar el texto del botón al campo de texto
                textField.setText(textField.getText() + command);
            }
        }
    }

    private double eval(String expression) throws ErrorDeSintaxisException {
        // Realizar la evaluación utilizando tu lógica existente
        StringTokenizer lexemas = comp.analisisLexico(expression);
        CompositeEA nodo = comp.arbolDeAnalisisSintactico(lexemas);
        return nodo.evalua();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraGrafica calculator = new CalculadoraGrafica();
            calculator.setVisible(true);
        });
    }
}
