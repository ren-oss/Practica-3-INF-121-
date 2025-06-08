/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cajagenerado;

/**
 *
 * @author Renzo
 */
public class Principal {
    public static void main(String[] args) {
        // Crear una caja que guarda un String
        Caja<String> caja1 = new Caja<>();
        caja1.guardar("Hola mundo");

        // Crear una caja que guarda un Integer
        Caja<Integer> caja2 = new Caja<>();
        caja2.guardar(12345);

        // Mostrar el contenido de las cajas
        System.out.println("Contenido de la caja1: " + caja1.obtener());
        System.out.println("Contenido de la caja2: " + caja2.obtener());
    }
}
