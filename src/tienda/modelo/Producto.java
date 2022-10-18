package tienda.modelo;

import java.util.ArrayList;

public class Producto {
	private Integer id;
    private String nombre;
	private Double precio;
    private String categoria;
    
    public Producto(Integer id, String nombre, Double precio, String categoria) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria= categoria;
	}
    
    public void mostrarProductos(ArrayList<Producto> productos) { 
        for (int i = 0; i < productos.size(); i++) {
          System.out.print(productos.get(i)+"n-------n");
        }
    }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
