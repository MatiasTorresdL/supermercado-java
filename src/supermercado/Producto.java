package supermercado;

public class Producto {
	
	private int idProducto;
	private String producto;
	private float precio;

	
	//constructor
	
		public Producto(int idProducto, String producto, float precio) {
			
		this.idProducto = idProducto;
		this.producto = producto;
		this.precio = precio;
			
		}
		
	
	//setters y getters
	
   public int getIdProducto() {
		
		return idProducto;
		
	}
   
   
   public String getProducto() {
		
		return producto;
		
	}
   
   public float getPrecio() {
		
		return precio;
		
	}
   
   
   public void setIdProducto(int idProducto) {
		
 		this.idProducto = idProducto;
 		
 	}
    
    
    public void setProducto(String producto) {
 		
 		this.producto = producto;
 		
 	}
    
    public void setPrecio(float precio) {
 		
 		this.precio = precio;
 		
 	}
    
    @Override
    
    public String toString() {
    	
    	return ("\nProducto: "+ producto + "\nPrecio: "+precio+"\nid: "+idProducto);
    }
    
    public boolean equals(Producto producto) {
    	
    	return  this.idProducto == producto.getIdProducto();
    }
	
    
    
    
}




   





