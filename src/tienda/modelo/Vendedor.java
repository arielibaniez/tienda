package tienda.modelo;

public class Vendedor {
	private Integer id;
	private String nombre;
	private Integer sueldo;
	
	public Vendedor(Integer id, String nombre, Integer sueldo) {
		this.id = id;
		this.nombre = nombre;
		this.sueldo = sueldo;	
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
