package test;

import supermercado.*;
import java.time.*;

public class Testsupermercado {

	public static void main(String[] args) {
		
		Supermercado jumbo = new Supermercado();
		
		try {
			
	// agregar productos
			
			
		System.out.println("--- agregando productos ---");
		jumbo.agregarProducto("leche", 50.5f);
		jumbo.agregarProducto("Pan", 30.0f);
        jumbo.agregarProducto("Huevos", 60.0f);
        jumbo.agregarProducto("cebolla",10.0f);
        jumbo.agregarProducto("naranja",25.0f);
        
        
    // listar productos
        
        System.out.println("\n--- Productos en gondola ---\n");
        for (Producto p : jumbo.getGondola()) {
        	
        	System.out.println(p);
  }
        
        
      // traer productos
        
        System.out.println("\n--- Buscando producto ID=2 ---");
        Producto p = jumbo.traerProducto(2);
        System.out.println(p);
        
        
    // modificar producto
        
        System.out.println("\n---modificar producto---");
        boolean modificado = jumbo.modificarProducto(2, "panceta", 80.0f);
        System.out.println("\n Modificado = "+ modificado);
        System.out.println(jumbo.traerProducto(2));
        
        
      //eliminar producto
        
  System.out.println("\n--- eliminar producto con id 3");
        boolean eliminado = jumbo.eliminarProducto(4);
        System.out.println("\nEliminado = "+ eliminado);
        
        System.out.println("\n--- Productos en gondola (despues de eliminar)---\n");
        for (Producto elim : jumbo.getGondola()) {
        	
        	System.out.println(elim);
        }
        
        
        
        // CARRITO PRUEBA
        
        System.out.println("\nProbando Carrito");
        Cliente cliente1 = new Cliente(1, "Matias", 45834364, "micasa 123" );
        Carrito carrito1 = new Carrito(1, LocalDate.now(), LocalTime.now(), cliente1);
        System.out.println("\n Carrito vacio");
        System.out.println(carrito1);
        
        //agregar item al carrito
        
        
        carrito1.agregarItem(jumbo.traerProducto(1),2);
        carrito1.agregarItem(jumbo.traerProducto(2),3);
        
        System.out.println("\n Carrito con items");
        System.out.println(carrito1);
        
        
        System.out.println("\n borrando items del carrito");
        
        Producto queso = jumbo.traerProducto(5);

        boolean itemEliminado = carrito1.eliminarItem(queso, 2);
        System.out.println("\nEliminado = "+ itemEliminado);
        
        System.out.println("\n Carrito con items borrados");
        
        System.out.println(carrito1);
        
        
        
        System.out.println("\n Subtotal: "+ carrito1.calcularSubTotal());
        System.out.println("\n Subtotal: "+ carrito1.calcularTotal());
        
		
		}catch (Exception e) {
			
			System.out.println("Error inesperado: " + e.getMessage());
		}
	}

}
