package IMC.modelo;

import IMC.controlador.Coordinador;

public class Procesos {
    private Coordinador coordinador;

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String obtenerDatos(String nombre) {
        return "Bienvenido " + nombre.toUpperCase();
    }

    public boolean validarNombre(String valor) {
        try {
            Integer.parseInt(valor.trim());
            return false;
        } catch (Exception e) {
            return !valor.trim().equals("");
        }
    }

    public boolean validarNumero(String valor) {
        try {
            double num = Double.parseDouble(valor);
            return num >= 0;
        } catch (Exception e) {
            return false;
        }
    }

    public String calcularIMC(double peso, double talla) {
        if (talla <= 0) {
            return "Talla inválida";
        }
        double imc = peso / (talla * talla);
        String clasificacion = "";
        if (imc < 18.5) {
            clasificacion = "Bajo peso";
        } else if (imc < 25) {
            clasificacion = "Normal";
        } else if (imc < 30) {
            clasificacion = "Sobrepeso";
        } else {
            clasificacion = "Obesidad";
        }
        return String.format("IMC: %.2f - %s", imc, clasificacion);
    }
}
