package test;

import supermercado.*;
import java.time.*;

public class test2 {

	public static void main(String[] args) {
		
		Supermercado jumbo = new Supermercado();
		
try {
		// Probando agregar cliente
		System.out.println("\n--- Probando agregar cliente ---");
		
		boolean agregado1 = jumbo.agregarCliente("Matias", 1222333, "micasa 123");
		
		System.out.println("Cliente agregado: " + agregado1);
		
 }catch (Exception e) {
			
			System.out.println("Error inesperado: "+ e.getMessage());
		}
		
		
try {

		// Intentar agregar el mismo cliente (mismo dni)
		boolean agregado2 = jumbo.agregarCliente("Matias", 1222333, "Otra dirección");
		System.out.println("Cliente agregado (debería ser false): " + agregado2);
		
}catch (Exception e) {
			
			System.out.println("Error inesperado: "+ e.getMessage());
		}
		
try {
		// Agregar otro cliente
		boolean agregado3 = jumbo.agregarCliente("Carlos López", 12345678, "Avenida Siempre Viva 742");
		System.out.println("Cliente agregado: " + agregado3);
}catch (Exception e) {
	
	System.out.println("Error inesperado: "+ e.getMessage());
}

		// Listar clientes
		System.out.println("\n--- Lista de clientes ---");
		for (Cliente c : jumbo.getListaCliente()) {
		    System.out.println(c);
		}
		
		
		
		// Probando traerCliente
		System.out.println("\n--- Probando traerCliente ---");
		Cliente cliente1 = jumbo.traerCliente(1);
		System.out.println("Cliente con ID 1: " + cliente1); // Si es null, mostrará "null"

		Cliente cliente2 = jumbo.traerCliente(2);
		System.out.println("Cliente con ID 2: " + cliente2);

		Cliente cliente3 = jumbo.traerCliente(99);
		System.out.println("Cliente con ID 99: " + cliente3);
		
		
		// Probando eliminarCliente
		System.out.println("\n--- Probando eliminarCliente ---");
		boolean eliminado1 = jumbo.eliminarCliente(1);
		System.out.println("Eliminar cliente ID 1: " + eliminado1);

		boolean eliminado2 = jumbo.eliminarCliente(99);
		System.out.println("Eliminar cliente ID 99: " + eliminado2);

		// Listar clientes después de eliminar
		System.out.println("\n--- Lista de clientes después de eliminar ---");
		for (Cliente c : jumbo.getListaCliente()) {
		    System.out.println(c);
		}

		
	}

}
