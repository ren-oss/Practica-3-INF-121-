/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientepers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Renzo
 */
public class ArchivoCliente {
   private String nomA;
    private ArrayList<Cliente> clientes;

    public ArchivoCliente(String nomA) {
        this.nomA = nomA;
        this.clientes = new ArrayList<>();
        cargarArchivo();
    }

    public void crearArchivo() {
        clientes.clear();
        guardarArchivo();
    }

    public void guardaCliente(Cliente c) {
        clientes.add(c);
        guardarArchivo();
    }

    private void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nomA))) {
            for (Cliente c : clientes) {
                pw.println(c.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarArchivo() {
        File archivo = new File(nomA);
        if (!archivo.exists()) {
            crearArchivo();
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                clientes.add(Cliente.fromFileString(linea));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarCliente(int c) {
        for (Cliente cliente : clientes) {
            if (cliente.id == c) {
                return cliente;
            }
        }
        return null;
    }

    public String buscarCelularCliente(int c) {
        Cliente cliente = buscarCliente(c);
        if (cliente != null) {
            return cliente.nombre + " - Teléfono: " + cliente.telefono;
        }
        return "Cliente no encontrado";
    }
}
