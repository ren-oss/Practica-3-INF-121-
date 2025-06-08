/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmaciapers;

/**
 *
 * @author Renzo
 */
public class Medicamento {
       String nombre;
    int codMedicamento;
    String tipo;
    double precio;

    public Medicamento(String n, int c, String t, double p) {
        nombre = n;
        codMedicamento = c;
        tipo = t;
        precio = p;
    }

    public String leer() {
        return nombre + "," + codMedicamento + "," + tipo + "," + precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public static Medicamento fromLine(String l) {
        String[] p = l.split(",");
        return new Medicamento(p[0], Integer.parseInt(p[1]), p[2], Double.parseDouble(p[3]));
    }
}
