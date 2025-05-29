package IMC.controlador;

import IMC.modelo.Procesos;
import IMC.modelo.dao.PersonaDAO;
import IMC.modelo.dto.PersonaDTO;
import IMC.vista.*;

import java.util.ArrayList;

public class Coordinador {

    private VentanaPrincipal ventanaPrincipal;
    private VentanaRegistro ventanaRegistro;
    private VentanaConsultaIndividual ventanaConsultaIndividual;
    private VentanaConsultarLista ventanaConsultarLista;
    private VentanaOperaciones ventanaOperaciones;

    private Procesos procesos;
    private PersonaDAO miPersonaDAO;


    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
        this.ventanaRegistro = ventanaRegistro;
    }

    public void setVentanaConsultaIndividual(VentanaConsultaIndividual ventanaConsultaIndividual) {
        this.ventanaConsultaIndividual = ventanaConsultaIndividual;
    }

    public void setVentanaConsultarLista(VentanaConsultarLista ventanaConsultarLista) {
        this.ventanaConsultarLista = ventanaConsultarLista;
    }

    public void setVentanaOperaciones(VentanaOperaciones ventanaOperaciones) {
        this.ventanaOperaciones = ventanaOperaciones;
    }

    public void setProcesos(Procesos procesos) {
        this.procesos = procesos;
    }

    public void setMiPersonaDAO(PersonaDAO miPersonaDAO) {
        this.miPersonaDAO = miPersonaDAO;
    }


    public boolean validarNumero(String valor) {
        return procesos.validarNumero(valor);
    }

    public boolean validarDatoTexto(String valor) {
        return procesos.validarNombre(valor);
    }

    public String calcularIMC(double peso, double estatura) {
        return procesos.calcularIMC(peso, estatura);
    }

    public String consultarDatos(String nombre) {
        return procesos.obtenerDatos(nombre);
    }


    public String registrarPersona(PersonaDTO persona) {
        return miPersonaDAO.registrarPersona(persona);
    }

    public PersonaDTO consultarPersona(String documento) {
        return miPersonaDAO.consultarPersonaPorDocumento(documento);
    }

    public String actualizarPersona(PersonaDTO persona) {
        return miPersonaDAO.actualizarPersona(persona);
    }

    public String eliminarPersona(String documento) {
        return miPersonaDAO.eliminarPersona(documento);
    }

    public ArrayList<PersonaDTO> consultarListaPersonas() {
        return miPersonaDAO.consultarListaPersonas();
    }


    public void mostrarVentanaPrincipal() {
        if (ventanaPrincipal != null) {
            ventanaPrincipal.setVisible(true);
        } else {
            System.err.println("Error: ventanaPrincipal no ha sido inicializada.");
        }
    }

    public void mostrarVentanaRegistro() {
        if (ventanaRegistro != null) {
            ventanaRegistro.setVisible(true);
        } else {
            System.err.println("Error: ventanaRegistro no ha sido inicializada.");
        }
    }

    public void mostrarVentanaConsultarLista() {
        if (ventanaConsultarLista != null) {
            ventanaConsultarLista.setVisible(true);
        } else {
            System.err.println("Error: ventanaConsultarLista no ha sido inicializada.");
        }
    }

    public void mostrarVentanaOperaciones() {
        if (ventanaOperaciones != null) {
            ventanaOperaciones.setVisible(true);
        } else {
            System.err.println("Error: ventanaOperaciones no ha sido inicializada.");
        }
    }

    public void mostrarVentanaConsultaIndividual() {
        if (ventanaConsultaIndividual != null) {
            ventanaConsultaIndividual.setVisible(true);
        } else {
            System.err.println("Error: ventanaConsultaIndividual no ha sido inicializada.");
        }
    }
}

