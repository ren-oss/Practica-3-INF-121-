/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmaciapers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renzo
 */
public class Farmacia {
     String nombreFarmacia;
    int sucursal;
    String direccion;
    ArrayList<Medicamento> medicamentos;

    public Farmacia(String n, int s, String d) {
        nombreFarmacia = n;
        sucursal = s;
        direccion = d;
        medicamentos = new ArrayList<>();
    }

    public void agregarMedicamento(Medicamento m) {
        medicamentos.add(m);
    }

    public void mostrar() {
        System.out.println("Sucursal: " + sucursal + " - " + nombreFarmacia + ", Dirección: " + direccion);
        for (Medicamento m : medicamentos) {
            System.out.println("  " + m.leer());
        }
    }

    public List<Medicamento> medicamentosTos() {
        List<Medicamento> lista = new ArrayList<>();
        for (Medicamento m : medicamentos) {
            if (m.getTipo().equalsIgnoreCase("tos")) {
                lista.add(m);
            }
        }
        return lista;
    }

    public boolean buscaMedicamento(String nombreMed) {
        for (Medicamento m : medicamentos) {
            if (m.nombre.equalsIgnoreCase(nombreMed)) return true;
        }
        return false;
    }

    public List<String> toLines() {
        List<String> lines = new ArrayList<>();
        lines.add(nombreFarmacia + ";" + sucursal + ";" + direccion);
        for (Medicamento m : medicamentos) {
            lines.add(m.leer());
        }
        return lines;
    }

    public static Farmacia fromLines(List<String> lines) {
        String[] h = lines.get(0).split(";");
        Farmacia f = new Farmacia(h[0], Integer.parseInt(h[1]), h[2]);
        for (int i = 1; i < lines.size(); i++) {
            f.agregarMedicamento(Medicamento.fromLine(lines.get(i)));
        }
        return f;
    }
}
