/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package farmaciapers;

/**
 *
 * @author Renzo
 */
public class Principal {
     public static void main(String[] args) throws Exception {
        ArchFarmacia archivo = new ArchFarmacia("farmacias.txt");

        Farmacia f1 = new Farmacia("MiSalud", 1, "Calle A");
        f1.agregarMedicamento(new Medicamento("Golpex", 101, "tos", 12.5));
        f1.agregarMedicamento(new Medicamento("Paracetamol", 102, "fiebre", 5.5));

        Farmacia f2 = new Farmacia("VitaPlus", 2, "Avenida B");
        f2.agregarMedicamento(new Medicamento("Ibuprofeno", 201, "tos", 6.0));
        f2.agregarMedicamento(new Medicamento("Golpex", 202, "tos", 10.0));

        archivo.adicionar(f1);
        archivo.adicionar(f2);

        archivo.leerArchivo();
        archivo.listar();

        System.out.println("\nMedicamentos para la tos en sucursal 2:");
        archivo.mostrarMedicamentosTos(2);

        System.out.println("\nFarmacias con Golpex:");
        archivo.mostrarMedicamentosGolpex();
    }
}
