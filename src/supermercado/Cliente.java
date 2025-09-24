package supermercado;


public class Cliente {
	
	private int idCliente;
	private String cliente;
	private long dni;
	private String direccion;
	
	
	//constructor
	
	public Cliente(int idCliente,String cliente, long dni, String direccion) {
		
		 if (dni <= 0) {
		        throw new IllegalArgumentException("DNI invalido");
		    }
		
		this.idCliente = idCliente;
		this.cliente = cliente;
		this.dni = dni;
		this.direccion = direccion;
		
		
	}
	
	
	//get y set
	
	public int getIdCliente() {
		
		return idCliente;
		
	}
	
     public String getCliente() {
		
		return cliente;
		
	}
	
	
	public long getDni() {
		
		return dni;
		
	}
	
     public String getDireccion() {
		
		return direccion;
		
	}
	
     
     
     public void setIdCliente(int idCliente) {
 		
 		this.idCliente = idCliente;
 		
 	}
 	
     public void setCliente(String cliente) {
  		
  		this.cliente = cliente;
  		
  	}
 	
 	
 	public void setDni(long dni) {
 		
 		this.dni = dni;
 		
 	}
 	
      public void setDireccion(String direccion) {
    	  
    	  this.direccion = direccion;
    	  
 	}
      

      
      
      @Override 
      public String toString() {
    	  
    	  return ("\n CLiente: "+ cliente + 
    			  "\n Dni: "+ dni + 
    			  "\n Direccion: "+direccion+ 
    			  "\n Id Cliente: "+idCliente);
    	  
      }
      
      
      public boolean equals(Cliente cliente) {
    	  
    	  return this.dni == cliente.getDni();
    	  
      }
      
	

}
