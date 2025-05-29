package IMC.modelo.conexion;

import java.util.HashMap;

import IMC.controlador.Coordinador;
import IMC.modelo.dto.PersonaDTO;

public class ConexionBD {


    public static HashMap<String, PersonaDTO> personasMap = new HashMap<>();

    private Coordinador miCoordinador;

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }
}
