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
		
		
		try {
		// Probando eliminarCliente
		System.out.println("\n--- Probando eliminarCliente ---");
		boolean eliminado1 = jumbo.eliminarCliente(1);
		System.out.println("Eliminar cliente ID 1: " + eliminado1);
		
		}catch (Exception e) {
			
			System.out.println("Error Inseperado: "+ e.getMessage());
		}
		
		try {

		boolean eliminado2 = jumbo.eliminarCliente(99);
		System.out.println("Eliminar cliente ID 99: " + eliminado2);
		
       }catch (Exception e) {
			
			System.out.println("Error Inseperado: "+ e.getMessage());
		}

		// Listar clientes después de eliminar
		System.out.println("\n--- Lista de clientes después de eliminar ---");
		for (Cliente c : jumbo.getListaCliente()) {
		    System.out.println(c);
		}
		
		
		
		// Probando agregarCarrito
		System.out.println("\n--- Probando agregarCarrito ---");

		// Creamos un cliente nuevo para el test
		Cliente clienteTest = new Cliente(99, "Cliente Test", 99999999, "Dirección Test");
		LocalDate fechaTest = LocalDate.now();
		LocalTime horaTest = LocalTime.now();

		// Agregamos un carrito
		try {
		    boolean agregado1 = jumbo.agregarCarrito(fechaTest, horaTest, clienteTest);
		    System.out.println("Carrito agregado: " + agregado1);
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}

		// Intentamos agregar el mismo carrito (mismo cliente, fecha y hora)
		try {
		    boolean agregado2 = jumbo.agregarCarrito(fechaTest, horaTest, clienteTest);
		    System.out.println("Carrito agregado: " + agregado2);
		} catch (Exception e) {
		    System.out.println("Error esperado: " + e.getMessage());
		}

		// Agregamos otro carrito con hora diferente
		try {
		    boolean agregado3 = jumbo.agregarCarrito(fechaTest, LocalTime.now().plusHours(1), clienteTest);
		    System.out.println("Carrito agregado: " + agregado3);
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}

		// Listar carritos
		System.out.println("\n--- Lista de carritos ---");
		for (Carrito c : jumbo.getListaCarrito()) {
		    System.out.println(c);
		}
		
		
		// Probando traerCarrito
		System.out.println("\n--- Probando traerCarrito ---");
		Carrito carrito1 = jumbo.traerCarrito(1);
		System.out.println("Carrito con ID 1: " + carrito1);

		Carrito carrito2 = jumbo.traerCarrito(2);
		System.out.println("Carrito con ID 2: " + carrito2);

		Carrito carrito3 = jumbo.traerCarrito(99);
		System.out.println("Carrito con ID 99: " + carrito3);
		
		
		// Probando eliminarCarrito
		System.out.println("\n--- Probando eliminarCarrito ---");

		try {
		    boolean eliminado1 = jumbo.eliminarCarrito(1);
		    System.out.println("Eliminar carrito ID 1: " + eliminado1);
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}

		try {
		    boolean eliminado2 = jumbo.eliminarCarrito(99);
		    System.out.println("Eliminar carrito ID 99: " + eliminado2);
		} catch (Exception e) {
		    System.out.println("Error: " + e.getMessage());
		}

		// Listar carritos después de eliminar
		System.out.println("\n--- Lista de carritos después de eliminar ---");
		for (Carrito c : jumbo.getListaCarrito()) {
		    System.out.println(c);
		}
		
		
		
	}

}
