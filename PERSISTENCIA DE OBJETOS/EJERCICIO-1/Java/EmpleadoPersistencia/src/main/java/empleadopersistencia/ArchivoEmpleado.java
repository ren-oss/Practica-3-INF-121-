

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleadopersistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author Renzo
 */
public class ArchivoEmpleado {
    private String nomA;
    
    public ArchivoEmpleado(String n) {
        this.nomA = n;
        File file = new File(nomA);
        if (!file.exists()) {
            crearArchivo();
        }
    }
    
    public void crearArchivo() {
        try (FileWriter file = new FileWriter(nomA)) {
            // Archivo vacío inicialmente
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void guardarEmpleado(Empleado e) {
        try (FileWriter fw = new FileWriter(nomA, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(e.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public Empleado buscaEmpleado(String n) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Empleado emp = Empleado.fromString(linea);
                if (emp.getNombre().equals(n)) {
                    return emp;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Empleado mayorSalario(float s) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Empleado emp = Empleado.fromString(linea);
                if (emp.getSalario() > s) {
                    return emp;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}