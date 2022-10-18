package tienda.modelo;

import java.util.List;

public class Venta {
	
	private Integer idVenta;
	private List<Producto> productos;
	private Vendedor vendedor;
	
	public Venta(Integer idVenta, List<Producto> productos, Vendedor vendedor) {
		this.idVenta = idVenta;
		this.productos = productos;
		this.vendedor = vendedor;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

}
