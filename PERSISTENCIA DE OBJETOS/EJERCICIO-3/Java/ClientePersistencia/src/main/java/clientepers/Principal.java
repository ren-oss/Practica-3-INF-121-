/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientepers;

/**
 *
 * @author Renzo
 */
public class Principal {
    public static void main(String[] args) {
        ArchivoCliente archivo = new ArchivoCliente("clientes.txt");

        archivo.guardaCliente(new Cliente(101, "Carlos", 77712345));
        archivo.guardaCliente(new Cliente(102, "Elena", 76543210));

        System.out.println("Buscar Cliente 102: " + archivo.buscarCliente(102));
        System.out.println("Buscar Celular Cliente 101: " + archivo.buscarCelularCliente(101));
    }
}
