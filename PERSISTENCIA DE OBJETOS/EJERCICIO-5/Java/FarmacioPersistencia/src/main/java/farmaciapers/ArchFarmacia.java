/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmaciapers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renzo
 */
public class ArchFarmacia {
    String na;
    ArrayList<Farmacia> farmacias;

    public ArchFarmacia(String archivo) {
        na = archivo;
        farmacias = new ArrayList<>();
    }

    public void crearArchivo() throws IOException {
        new PrintWriter(na).close();
    }

    public void adicionar(Farmacia f) throws IOException {
        farmacias.add(f);
        guardarArchivo();
    }

    private void guardarArchivo() throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(na));
        for (Farmacia f : farmacias) {
            for (String line : f.toLines()) {
                pw.println(line);
            }
            pw.println("#");
        }
        pw.close();
    }

    public void leerArchivo() throws IOException {
        farmacias.clear();
        BufferedReader br = new BufferedReader(new FileReader(na));
        List<String> bloque = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.equals("#")) {
                farmacias.add(Farmacia.fromLines(bloque));
                bloque.clear();
            } else {
                bloque.add(linea);
            }
        }
        if (!bloque.isEmpty()) {
            farmacias.add(Farmacia.fromLines(bloque));
        }
        br.close();
    }

    public void listar() {
        for (Farmacia f : farmacias) {
            f.mostrar();
        }
    }

    public void mostrarMedicamentosTos(int sucursalX) {
        for (Farmacia f : farmacias) {
            if (f.sucursal == sucursalX) {
                System.out.println("TOS en Sucursal " + f.sucursal + " - " + f.direccion);
                for (Medicamento m : f.medicamentosTos()) {
                    System.out.println("  " + m.leer());
                }
            }
        }
    }

    public void mostrarMedicamentosGolpex() {
        for (Farmacia f : farmacias) {
            if (f.buscaMedicamento("Golpex")) {
                System.out.println("Sucursal: " + f.sucursal + ", Dirección: " + f.direccion);
            }
        }
    }
}
