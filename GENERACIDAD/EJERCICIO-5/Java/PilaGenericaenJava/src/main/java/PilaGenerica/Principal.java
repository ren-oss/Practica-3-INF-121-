/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PilaGenerica;
/**
 *
 * @author Renzo
 */
public class Principal {
    public static void main(String[] args) {
        // Pila de enteros
        Pila<Integer> pilaEnteros = new Pila<>();
        pilaEnteros.apilar(10);
        pilaEnteros.apilar(20);
        System.out.println("Pila de enteros: " + pilaEnteros.mostrar());
        System.out.println("Desapilando: " + pilaEnteros.desapilar());

        // Pila de cadenas
        Pila<String> pilaCadenas = new Pila<>();
        pilaCadenas.apilar("uno");
        pilaCadenas.apilar("dos");
        System.out.println("Pila de cadenas: " + pilaCadenas.mostrar());
        System.out.println("Desapilando: " + pilaCadenas.desapilar());
    }
}
