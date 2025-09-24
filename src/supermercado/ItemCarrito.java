package supermercado;

public class ItemCarrito {
	
	private int idItem;
	private Producto producto;
	private int cantidad;
	
	//constructor
	
			public ItemCarrito(int idItem, Producto producto, int cantidad) {
				
			this.idItem = idItem;
			this.producto = producto;
			this.cantidad = cantidad;
				
			}
			
			
	//setters y getters
	
	   public int getIdItem() {
			
			return idItem;
			
		}
	   
	   
	   public Producto getProducto() {
			
			return producto;
			
		}
	   
	   public int getCantidad() {
			
			return cantidad;
			
		}
	   
	   
	   public void setIdItem(int idItem) {
			
	 		this.idItem = idItem;
	 		
	 	}
	    
	    
	    public void setProducto(Producto producto) {
	 		
	 		this.producto = producto;
	 		
	 	}
	    
	    public void setCantidad(int cantidad) {
	 		
	 		this.cantidad = cantidad;
	 		
	 	}
	    
	    @Override
	    public String toString(){
	    	
	    	return "\n\n"+producto+"\nCantidad: "+cantidad+"\nId: "+idItem;
	    }
	    
	    public boolean equals(ItemCarrito itemCarrito) {
	    	
	    	return this.idItem == itemCarrito.getIdItem();
	    }
		
	  //METODOS PEDIDOS
	

}
