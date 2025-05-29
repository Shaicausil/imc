package IMC.vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

import IMC.controlador.Coordinador;
import IMC.modelo.dto.PersonaDTO;

public class VentanaConsultarLista extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Coordinador miCoordinador;
    private JTextArea txtAreaResultado;

    public VentanaConsultarLista(VentanaPrincipal ventanaPrincipal, boolean modal) {
        super(ventanaPrincipal, modal);
        setTitle("Consulta Lista de Personas");
        setBounds(100, 100, 500, 327);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel lblTitulo = new JLabel("CONSULTA LISTA PERSONAS");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblTitulo.setBounds(33, 6, 388, 30);
        contentPane.add(lblTitulo);

        txtAreaResultado = new JTextArea();
        txtAreaResultado.setColumns(5);
        txtAreaResultado.setLineWrap(true);
        txtAreaResultado.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setBounds(21, 48, 440, 210);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane);
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    private void consultarListaPersonas() {
        ArrayList<PersonaDTO> listaPersonas = miCoordinador.consultarListaPersonas();
        StringBuilder msj = new StringBuilder();

        if (listaPersonas.size() > 0) {
            for (PersonaDTO personaDTO : listaPersonas) {
                msj.append("Documento: ").append(personaDTO.getDocumento())
                        .append("\nNombre: ").append(personaDTO.getNombre())
                        .append("\nEdad: ").append(personaDTO.getEdad())
                        .append("\n\n");
            }
        } else {
            msj.append("NO HAY PERSONAS REGISTRADAS");
        }

        txtAreaResultado.setText(msj.toString());
    }


    @Override
    public void setVisible(boolean visible) {
        if (visible) {
            consultarListaPersonas();
        }
        super.setVisible(visible);
    }
}
