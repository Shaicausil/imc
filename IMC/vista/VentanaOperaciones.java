package IMC.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import IMC.controlador.Coordinador;

public class VentanaOperaciones extends JDialog implements ActionListener {

    private JTextField txtPeso, txtEstatura;
    private JButton btnCalcular, btnCerrar;
    private JLabel lblResultado;
    private Coordinador coordinador;

    public VentanaOperaciones(VentanaPrincipal ventanaPrincipal, boolean modal) {
        super(ventanaPrincipal, modal);
        setTitle("Cálculo de IMC");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 5, 5));

        add(new JLabel("Peso (kg):"));
        txtPeso = new JTextField();
        add(txtPeso);

        add(new JLabel("Estatura (m):"));
        txtEstatura = new JTextField();
        add(txtEstatura);

        btnCalcular = new JButton("Calcular IMC");
        btnCerrar = new JButton("Cerrar");
        add(btnCalcular);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblResultado);

        add(btnCerrar);

        btnCalcular.addActionListener(this);
        btnCerrar.addActionListener(this);
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            String pesoStr = txtPeso.getText().trim();
            String estaturaStr = txtEstatura.getText().trim();

            if (pesoStr.isEmpty() || estaturaStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa peso y estatura.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!coordinador.validarNumero(pesoStr) || !coordinador.validarNumero(estaturaStr)) {
                JOptionPane.showMessageDialog(this, "Ingresa valores numéricos válidos y positivos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double peso = Double.parseDouble(pesoStr);
            double estatura = Double.parseDouble(estaturaStr);
            String resultado = coordinador.calcularIMC(peso, estatura);

            lblResultado.setText("Resultado: " + resultado);

        } else if (e.getSource() == btnCerrar) {
            dispose();
        }
    }
}
