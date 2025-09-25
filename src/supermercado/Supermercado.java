package supermercado;

import java.time.*;
import java.util.List;
import java.util.ArrayList;


public class Supermercado {
	
	private List<Producto> gondola;
	private List<Cliente> listaCliente;
	private List<Carrito> listaCarrito;


//constructor
	
	public Supermercado() {
		
	this.gondola = new ArrayList<Producto>();
	this.listaCliente = new ArrayList<Cliente>();
	this.listaCarrito = new ArrayList<Carrito>();
		
	}
	
	
//getters setters

public List<Producto> getGondola(){
	
	return gondola;

}

public void setGondola(List<Producto> gondola){
	
	this.gondola = gondola;

}

public List<Cliente> getListaCliente(){
	
	return listaCliente;

}

public void setListaCliente(List<Cliente> listaCliente){
	
	this.listaCliente = listaCliente;

}


public List<Carrito> getListaCarrito(){
	
	return listaCarrito;

}

public void setListaCarrito(List<Carrito> listaCarrito){
	
	this.listaCarrito = listaCarrito;

}


@Override

public String toString() {
	
	return(" Supermercado \n Gondola:  "+ gondola.size() + " productos \n"
			+ "Clientes: "+ listaCliente.size()+" clientes\n"+
			"Carritos: "+listaCarrito.size()+ "carritos\n");
}

public boolean equals(Supermercado supermercado) {
    if (supermercado == null) return false;
    
    return this.gondola.equals(supermercado.getGondola()) &&
           this.listaCliente.equals(supermercado.getListaCliente()) &&
           this.listaCarrito.equals(supermercado.getListaCarrito());
}
//METODOS PEDIDOS

public boolean agregarProducto(String producto, float precio) throws Exception {
	
	// Recorremos cada producto en la gondola
	
    for (Producto p : gondola) {
    	
        // compara nombres ignorando mayus y minus
    	
        if (p.getProducto().equalsIgnoreCase(producto)) {
            throw new Exception("El producto " + producto + " ya existe en la gondola");
        }
    }
    
    //  Si no existe, creamos y agregamos el nuevo producto
    
		int nuevoId = gondola.size()+1;
		Producto nuevo = new Producto(nuevoId,producto,precio);
		
		return gondola.add(nuevo);
		
}


 public Producto traerProducto(int idProducto)  {
	 
	 int i = 0;
	 boolean encontrado = false;
	 
	 Producto p = null;
	 
	 while (i < gondola.size() && !encontrado) {
		 if (gondola.get(i).getIdProducto() == idProducto) {
			 
			 encontrado = true;
			 p = gondola.get(i);
		 }
		 i++;
		 
	 }
		 
		 return p;
		 
	 
 }
 
 
    public boolean modificarProducto(int idProducto, String producto, double precio) throws Exception {
    	
    	// 1. Buscar el producto por ID usando el método traerProducto()
    	
        Producto p = traerProducto(idProducto);
        
        // 2. Si no existe, devolver exception
        if (p == null) {
            throw new Exception ("El producto con ID"+ idProducto + "no existe");
        }
        
        // 3. Si existe, modificar sus atributos
        p.setProducto(producto);
        p.setPrecio((float) precio); // Convertimos double a float
        
        return true;
    	
    	
    }
    
    public boolean productoEnAlgunCarrito(int idProducto) {
        for (Carrito carrito : listaCarrito) {
            for (ItemCarrito item : carrito.getIsItem()) {
                if (item.getProducto().getIdProducto() == idProducto) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean eliminarProducto(int idProducto) throws Exception {
    	
        // 1. Buscar el producto por ID
    	
        Producto p = traerProducto(idProducto);
        
        // 2. Si no existe, devolver false
        
        if (p == null) {
            throw new Exception ("No existe el producto con id: "+idProducto);
        }
        
        if(productoEnAlgunCarrito(idProducto)) {
        	
        	throw new Exception ("El producto con id "+ idProducto +" está en algun carrito ");
        }
        
        
        // 3. Eliminar el producto de la lista
        
        return gondola.remove(p);
    }
 
    
    //clientes
    
    public boolean agregarCliente(String cliente,long dni, String direccion) throws Exception {
    	
    	// Verificar si ya existe un cliente con ese dni
    	
        for (Cliente c : listaCliente) {
            if (c.getDni() == dni) {
            	
              throw new Exception ("Ya existe un cliente con ese DNI: "+dni);
            }
        }
        
        // Si no existe, crearlo y agregarlo
        int nuevoId = listaCliente.size() + 1;
        Cliente nuevoCliente = new Cliente(nuevoId, cliente, dni, direccion);
        return listaCliente.add(nuevoCliente);

    	
    }
    
    public Cliente traerCliente(int idCliente) {
    	
    	int i= 0;
    	boolean encontrado = false;
    	
    	Cliente c = null;
    	
    	while(i<listaCliente.size() && !encontrado) {
    		
    		if(listaCliente.get(i).getIdCliente() == idCliente) {
    			
    			encontrado = true;
    			c = listaCliente.get(i);
    		}
    		
    		i++;
    	}
    	
    	return c;
    	
    }
    
    
    public boolean eliminarCliente(int idCliente) throws Exception {
        Cliente cliente = traerCliente(idCliente);
        
        if (cliente == null) {
           throw new Exception("No se encontro cliente con id: "+idCliente);
        }
        
        return listaCliente.remove(cliente);
    }
    
    
    //Carritos
    
    public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente)throws Exception {
    	
    	 // Verificar si ya existe un carrito con las mismas características
        for (Carrito c : listaCarrito) {
            if (c.getFecha().equals(fecha) && 
                c.getHora().equals(hora) && 
                c.getCliente().equals(cliente)) {
                throw new Exception("Ya existe un carrito para este cliente en la misma fecha y hora");
            }
        }
    
    	
        int nuevoId = listaCarrito.size() + 1;
        Carrito nuevoCarrito = new Carrito(nuevoId, fecha, hora, cliente);
        return listaCarrito.add(nuevoCarrito);
        
    }
    
    public Carrito traerCarrito(int idCarrito) {
    	
    	int i= 0;
    	boolean encontrado = false;
    	
    	Carrito c = null;
    	
    	while(i<listaCarrito.size() && !encontrado) {
    		
    		if(listaCarrito.get(i).getIdCarrito() == idCarrito) {
    			
    			encontrado = true;
    			c = listaCarrito.get(i);
    		}
    		
    		i++;
    	}
    	
    	return c;
    	
    }
    
    
    public boolean eliminarCarrito(int idCarrito) throws Exception {
    	
    Carrito carrito = traerCarrito(idCarrito);
        
        if (carrito == null) {
           throw new Exception("No se encontro el carrito con id: "+idCarrito);
        }
        
        return listaCarrito.remove(carrito);
    	
    }
    
    
    
    //Calcular Total
    
    /**
     * Calcula el total de todos los carritos de un cliente específico
     * @param cliente El cliente del cual se quiere calcular el total
     * @return El total acumulado de todos los carritos del cliente
     * @throws Exception Si el cliente no existe en el sistema
     */
    public float calcularTotal(Cliente cliente) throws Exception {
        float total = 0.0f;  // Acumulador para el total
        boolean clienteEncontrado = false;  // Bandera para verificar si encontramos el cliente
        int i = 0;  // Índice para recorrer la lista de carritos
        
        // Recorremos todos los carritos buscando los del cliente especificado
        while (i < listaCarrito.size() && !clienteEncontrado) {
            if (listaCarrito.get(i).getCliente().equals(cliente)) {
                // Si encontramos un carrito del cliente, sumamos su total
                total += listaCarrito.get(i).calcularTotal();
                clienteEncontrado = true;
            }
            i++;
        }
        
        // Si no encontramos ningún carrito del cliente, lanzamos excepción
        
        if (!clienteEncontrado) {
            throw new Exception("No se encontró el cliente");
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
    
    
    
    
    /**
     * Calcula el total de todos los carritos de un cliente buscándolo por su DNI
     * @param dniCliente El DNI del cliente del cual se quiere calcular el total
     * @return El total acumulado de todos los carritos del cliente
     * @throws Exception Si no se encuentra un cliente con ese DNI
     */
    public float calcularTotal(int dniCliente) throws Exception {
        float total = 0.0f;  // Acumulador para el total
        boolean clienteEncontrado = false;  // Bandera para verificar si encontramos el cliente
        int i = 0;  // Índice para recorrer la lista de carritos
        
        // Recorremos todos los carritos buscando los del cliente con el DNI especificado
        while (i < listaCarrito.size() && !clienteEncontrado) {
            if (listaCarrito.get(i).getCliente().getDni() == dniCliente) {
                // Si encontramos un carrito del cliente, sumamos su total
                total += listaCarrito.get(i).calcularTotal();
                clienteEncontrado = true;
            }
            i++;
        }
        
        // Si no encontramos ningún carrito del cliente, lanzamos excepción
        if (!clienteEncontrado) {
            throw new Exception("No se encontró el cliente con DNI: " + dniCliente);
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
    
    
    /**
     * Calcula el total de todos los carritos en un rango de fechas determinado
     * @param fechaInicio Fecha inicial del rango (inclusive)
     * @param fechaFin Fecha final del rango (inclusive)
     * @return El total acumulado de todos los carritos en el rango de fechas
     */
    public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
        float total = 0.0f;  // Acumulador para el total
        
        // Recorremos todos los carritos
        for (Carrito carrito : listaCarrito) {
            // Verificamos si la fecha del carrito está dentro del rango (inclusive)
            if ((carrito.getFecha().isAfter(fechaInicio) || carrito.getFecha().equals(fechaInicio)) &&
                (carrito.getFecha().isBefore(fechaFin) || carrito.getFecha().equals(fechaFin))) {
                // Si está en el rango, sumamos su total
                total += carrito.calcularTotal();
            }
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
    
    /**
     * Calcula el total de todos los carritos de una fecha específica
     * @param fecha La fecha de la cual se quiere calcular el total
     * @return El total acumulado de todos los carritos de esa fecha
     */
    public float calcularTotal(LocalDate fecha) {
        float total = 0.0f;  // Acumulador para el total
        
        // Recorremos todos los carritos
        for (Carrito carrito : listaCarrito) {
            // Verificamos si la fecha del carrito coincide con la fecha buscada
            if (carrito.getFecha().equals(fecha)) {
                // Si coincide, sumamos su total
                total += carrito.calcularTotal();
            }
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
    
    /**
     * Calcula el total de todos los carritos de un mes y año específicos
     * @param mes El mes del cual se quiere calcular el total (1-12)
     * @param anio El año del cual se quiere calcular el total
     * @return El total acumulado de todos los carritos de ese mes y año
     * @throws Exception Si el mes no es válido (fuera del rango 1-12)
     */
    public float calcularTotal(int mes, int anio) throws Exception {
        // Validamos que el mes esté en el rango correcto
        if (mes < 1 || mes > 12) {
            throw new Exception("El mes no es válido");
        }
        
        float total = 0.0f;  // Acumulador para el total
        
        // Recorremos todos los carritos
        for (Carrito carrito : listaCarrito) {
            // Verificamos si el carrito es del mes y año buscados
            if (carrito.getFecha().getMonthValue() == mes && 
                carrito.getFecha().getYear() == anio) {
                // Si coincide, sumamos su total
                total += carrito.calcularTotal();
            }
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
    
    /**
     * Calcula el total de todos los carritos de un cliente en un rango de fechas
     * @param fechaInicio Fecha inicial del rango (inclusive)
     * @param fechaFin Fecha final del rango (inclusive)
     * @param cliente El cliente del cual se quiere calcular el total
     * @return El total acumulado de los carritos del cliente en el rango de fechas
     * @throws Exception Si el cliente no existe en el sistema
     */
    public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {
        boolean clienteExiste = false;  // Bandera para verificar si el cliente existe
        
        // Primero verificamos si el cliente existe en nuestro sistema
        for (Cliente c : listaCliente) {
            if (c.equals(cliente)) {
                clienteExiste = true;
                break;  // Encontramos el cliente, salimos del bucle
            }
        }
        
        // Si el cliente no existe, lanzamos excepción
        if (!clienteExiste) {
            throw new Exception("El cliente no existe");
        }
        
        float total = 0.0f;  // Acumulador para el total
        
        // Recorremos todos los carritos
        for (Carrito carrito : listaCarrito) {
            // Verificamos si el carrito pertenece al cliente y está en el rango de fechas
            if (carrito.getCliente().equals(cliente)) {
                if ((carrito.getFecha().isAfter(fechaInicio) || carrito.getFecha().equals(fechaInicio)) &&
                    (carrito.getFecha().isBefore(fechaFin) || carrito.getFecha().equals(fechaFin))) {
                    // Si cumple ambas condiciones, sumamos su total
                    total += carrito.calcularTotal();
                }
            }
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
    
    
    
    /**
     * Calcula el total de todos los carritos de un cliente en una fecha específica
     * @param fecha La fecha de la cual se quiere calcular el total
     * @param cliente El cliente del cual se quiere calcular el total
     * @return El total acumulado de los carritos del cliente en esa fecha
     * @throws Exception Si el cliente no existe en el sistema
     */
    public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception {
        boolean clienteExiste = false;  // Bandera para verificar si el cliente existe
        
        // Primero verificamos si el cliente existe en nuestro sistema
        for (Cliente c : listaCliente) {
            if (c.equals(cliente)) {
                clienteExiste = true;
                break;  // Encontramos el cliente, salimos del bucle
            }
        }
        
        // Si el cliente no existe, lanzamos excepción
        if (!clienteExiste) {
            throw new Exception("El cliente no existe");
        }
        
        float total = 0.0f;  // Acumulador para el total
        
        // Recorremos todos los carritos
        for (Carrito carrito : listaCarrito) {
            // Verificamos si el carrito pertenece al cliente y es de la fecha buscada
            if (carrito.getCliente().equals(cliente) && 
                carrito.getFecha().equals(fecha)) {
                // Si cumple ambas condiciones, sumamos su total
                total += carrito.calcularTotal();
            }
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
    
    
    
    /**
     * Calcula el total de todos los carritos de un cliente en un mes y año específicos
     * @param mes El mes del cual se quiere calcular el total (1-12)
     * @param anio El año del cual se quiere calcular el total
     * @param cliente El cliente del cual se quiere calcular el total
     * @return El total acumulado de los carritos del cliente en ese mes y año
     * @throws Exception Si el mes no es válido o el cliente no existe
     */
    public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception {
        // Validamos que el mes esté en el rango correcto
        if (mes < 1 || mes > 12) {
            throw new Exception("El mes no es válido");
        }
        
        boolean clienteExiste = false;  // Bandera para verificar si el cliente existe
        
        // Primero verificamos si el cliente existe en nuestro sistema
        for (Cliente c : listaCliente) {
            if (c.equals(cliente)) {
                clienteExiste = true;
                break;  // Encontramos el cliente, salimos del bucle
            }
        }
        
        // Si el cliente no existe, lanzamos excepción
        if (!clienteExiste) {
            throw new Exception("El cliente no existe");
        }
        
        float total = 0.0f;  // Acumulador para el total
        
        // Recorremos todos los carritos
        for (Carrito carrito : listaCarrito) {
            // Verificamos si el carrito pertenece al cliente y es del mes y año buscados
            if (carrito.getCliente().equals(cliente) && 
                carrito.getFecha().getMonthValue() == mes && 
                carrito.getFecha().getYear() == anio) {
                // Si cumple todas las condiciones, sumamos su total
                total += carrito.calcularTotal();
            }
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
    
    
    
    /**
     * Calcula el total de todos los carritos de un cliente (buscado por DNI) en un mes y año específicos
     * @param mes El mes del cual se quiere calcular el total (1-12)
     * @param anio El año del cual se quiere calcular el total
     * @param dniCliente El DNI del cliente del cual se quiere calcular el total
     * @return El total acumulado de los carritos del cliente en ese mes y año
     * @throws Exception Si el mes no es válido o no se encuentra el cliente
     */
    public float calcularTotal(int mes, int anio, int dniCliente) throws Exception {
        // Validamos que el mes esté en el rango correcto
        if (mes < 1 || mes > 12) {
            throw new Exception("El mes no es válido");
        }
        
        float total = 0.0f;  // Acumulador para el total
        boolean clienteEncontrado = false;  // Bandera para verificar si encontramos el cliente
        
        // Recorremos todos los carritos
        for (Carrito carrito : listaCarrito) {
            // Verificamos si el carrito pertenece al cliente con el DNI buscado
            if (carrito.getCliente().getDni() == dniCliente) {
                clienteEncontrado = true;  // Marcamos que encontramos al cliente
                
                // Verificamos si además es del mes y año buscados
                if (carrito.getFecha().getMonthValue() == mes && 
                    carrito.getFecha().getYear() == anio) {
                    // Si cumple todas las condiciones, sumamos su total
                    total += carrito.calcularTotal();
                }
            }
        }
        
        // Si no encontramos ningún carrito del cliente, lanzamos excepción
        if (!clienteEncontrado) {
            throw new Exception("No se encontró el cliente con DNI: " + dniCliente);
        }
        
        return total;  // Devolvemos el total acumulado
    }
    
 

}