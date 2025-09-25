package supermercado;

import java.time.*;

import java.util.List;
import java.util.ArrayList;


public class Carrito {
	
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> isItem;
	
	private Cliente cliente;
	
	//constructor
	
			public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
				
			this.idCarrito = idCarrito;
			this.fecha = fecha;
			this.hora = hora;
			this.isItem = new ArrayList<ItemCarrito>();
			
			this.cliente = cliente;
				
			}
	
//getters y setters
	
	public int getIdCarrito() {
		
		return idCarrito;
	}
	
    public LocalDate getFecha() {
		
		return fecha;
	}
    
    
    public LocalTime getHora() {
		
		return hora;
	}
    
    public List<ItemCarrito> getIsItem() {
		
		return isItem;
	}
    
    
    public void setIdCarrito(int idCarrito) {
    	
    	this.idCarrito = idCarrito;
    }
	
    public void setFecha(LocalDate fecha) {
    	
    	this.fecha = fecha;
    }
    
    
    public void setHora(LocalTime hora) {
		
		this.hora = hora;
	}
    
    public Cliente getCliente() {
    	
    	return cliente;
    }
    
 public void setCliente(Cliente cliente) {
    	
    	this.cliente = cliente;
    }
    
    
    @Override
    
    public String toString() {
    	
    	return "\nFecha: "+fecha+" Hora:"+hora+
    			"\n"+ cliente+
    			"\nCarrito ID: " + idCarrito +"\n"+
    			"\n\n item "+isItem+"\n";
    	
    }
    
    public boolean equals(Carrito carrito) {
    	
    	return this.idCarrito == carrito.getIdCarrito();
    	
    }
    
    
  //METODOS PEDIDOS
    
    public boolean agregarItem(Producto producto, int cantidad) {
        // 1. Validamos parámetros
        if (producto == null || cantidad <= 0) {
            return false;
        }
        
        // 2. Inicializamos variables para la búsqueda
        int i = 0;
        boolean encontrado = false;
        
        // 3. Buscamos si ya existe un item con este producto usando bucle while
        while (i < isItem.size() && !encontrado) {
            ItemCarrito item = isItem.get(i);
            
            // Verificamos si el item contiene el producto buscado
            if (item.getProducto().getIdProducto() == producto.getIdProducto()) {
                encontrado = true; // Marcamos que encontramos el item
                
                // Si existe, incrementamos la cantidad
                item.setCantidad(item.getCantidad() + cantidad);
            }
            i++;
        }
        
        // 4. Si no encontramos el item, lo creamos y agregamos
        if (!encontrado) {
            int nuevoId = isItem.size() + 1;
            ItemCarrito nuevoItem = new ItemCarrito(nuevoId, producto, cantidad);
            return isItem.add(nuevoItem);
        }
        
        return true; // Retornamos true si ya existía y lo incrementamos
    }
    
    
    
    public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
    	
        // Validación inicial
        if (producto == null || cantidad <= 0) {
            return false;
        }
        
        // Inicialización de variables para búsqueda
        int i = 0;
        boolean encontrado = false;
        ItemCarrito itemEncontrado = null;
        
        // Bucle de búsqueda 
        while (i < isItem.size() && !encontrado) {
            ItemCarrito item = isItem.get(i);
            
            if (item.getProducto().getIdProducto() == producto.getIdProducto()) {
                encontrado = true;
                itemEncontrado = item;
            }
            i++;
        }
        
        // Manejo de excepción si no se encontró
        
        if (!encontrado) {
            throw new Exception("No existe un ítem con el producto: " + producto.getProducto());
        }
        
        // Operaciones con el item encontrado 
        
        int cantidadActual = itemEncontrado.getCantidad();
        
        if (cantidadActual == cantidad) {
            isItem.remove(itemEncontrado);
            return true;
        } else if (cantidadActual > cantidad) {
            itemEncontrado.setCantidad(cantidadActual - cantidad);
            return true;
        } else {
            return false;
        }
    }
    
    public float calcularSubTotal() {
        float subtotal = 0;
        
        for (ItemCarrito item : isItem) {
            subtotal += item.getProducto().getPrecio() * item.getCantidad();
        }
        
        return subtotal;
    }
    
    
    public float calcularTotal() {
        return calcularSubTotal();
    }
	
	
}
