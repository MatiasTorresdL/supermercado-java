package supermercado;

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
 
 

}