package IMC.controlador;

import IMC.modelo.Procesos;
import IMC.modelo.dao.PersonaDAO;
import IMC.vista.*;

public class Relaciones {


    public void establecerRelaciones() {

        VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
        VentanaRegistro miVentanaRegistro = new VentanaRegistro(miVentanaPrincipal, true);
        VentanaConsultaIndividual miVentanaConsultaIndividual = new VentanaConsultaIndividual(miVentanaPrincipal, true);
        VentanaConsultarLista miVentanaConsultarLista = new VentanaConsultarLista(miVentanaPrincipal, true);
        VentanaOperaciones miVentanaOperaciones = new VentanaOperaciones(miVentanaPrincipal, true);


        Coordinador miCoordinador = new Coordinador();
        Procesos miProcesos = new Procesos();
        PersonaDAO miPersonaDAO = new PersonaDAO();


        miVentanaPrincipal.setCoordinador(miCoordinador);
        miVentanaRegistro.setCoordinador(miCoordinador);
        miVentanaConsultaIndividual.setCoordinador(miCoordinador);
        miVentanaConsultarLista.setCoordinador(miCoordinador);
        miVentanaOperaciones.setCoordinador(miCoordinador);

        miProcesos.setCoordinador(miCoordinador);
        miPersonaDAO.setCoordinador(miCoordinador);


        miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
        miCoordinador.setVentanaRegistro(miVentanaRegistro);
        miCoordinador.setVentanaConsultaIndividual(miVentanaConsultaIndividual);
        miCoordinador.setVentanaConsultarLista(miVentanaConsultarLista);
        miCoordinador.setVentanaOperaciones(miVentanaOperaciones);
        miCoordinador.setProcesos(miProcesos);
        miCoordinador.setMiPersonaDAO(miPersonaDAO);


        miCoordinador.mostrarVentanaPrincipal();
    }

}