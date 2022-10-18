package tienda.modelo;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

	private List<Producto> productos;
	private List<Vendedor> vendedores;
	private List<Venta> ventas;

	public Inventario() {
		this.vendedores = new ArrayList<Vendedor>();
		this.productos = new ArrayList<Producto>();
		this.ventas = new ArrayList<Venta>();
		productos.add(new Producto(1, "Arroz", 60.00, "Comestible"));
		productos.add(new Producto(2, "Fideos", 60.00, "Comestible"));
		productos.add(new Producto(3, "Coca-cola", 50.00, "Bebidas"));
		productos.add(new Producto(4, "Agua Villa del sur", 50.00, "Bebidas"));
		productos.add(new Producto(5, "Sprite", 50.00, "Bebidas"));
		productos.add(new Producto(6, "Yogurth", 50.00, "Lacteos"));
		productos.add(new Producto(7, "Leche", 50.00, "Lacteos"));
		productos.add(new Producto(8, "Leche de almendras", 50.00, "Lacteos"));
		vendedores.add(new Vendedor(1, "Anibal", 50000));
		vendedores.add(new Vendedor(2, "Ariel", 100000));
		vendedores.add(new Vendedor(3, "Juan", 150000));

	}

	public void agregarProducto(String nombre, Double precio, String categoria) {
		final Integer id = productos.size() + 1;
		final Producto producto = new Producto(id, nombre, precio, categoria);
		productos.add(producto);
	}

	public void agregarVendedor(String nombre, Integer sueldo) {
		final Integer id = vendedores.size() + 1;
		final Vendedor vendedor = new Vendedor(id, nombre, sueldo);
		vendedores.add(vendedor);
	}

	public void agregarVenta(Integer idProducto, Integer idVendedor) {
		List<Producto> productosVenta = new ArrayList<Producto>();
		if (ventas.size() >= 1) {
			Integer idVentas = ventas.size() + 1;
			for (int i = 0; i < productos.size(); i++) {
				productosVenta.add(productos.get(idProducto-1));
			}
			for (int i = 0; i < vendedores.size(); i++) {
				if(vendedores.get(i).getId().equals(idVendedor)) {
				   Vendedor vendedor = vendedores.get(i);
				   Venta venta = new Venta(idVentas, productosVenta, vendedor);
				   ventas.add(venta);
				}
			}
		} else {
			Integer idVentas = 1;
			for (int i = 0; i < productos.size(); i++) {
				productosVenta.add(productos.get(idProducto-1));
			}
			for (int i = 0; i < vendedores.size(); i++) {
				if(vendedores.get(i).getId().equals(idVendedor)) {
				   Vendedor vendedor = vendedores.get(i);
				   Venta venta = new Venta(idVentas, productosVenta, vendedor);
				   ventas.add(venta);
				}
			}
		}
		System.out.println("Venta exitosa, ¡Gracias por su compra!");
	}

	public void listarVendedores() {
		try {
			System.out.println("Estos son los vendedores disponibles: \n");
			for (int i = 0; i < vendedores.size(); i++) {
				String id = String.valueOf(vendedores.get(i).getId());
				String nombre = vendedores.get(i).getNombre();
				System.out.print("\n_________________\n"
								+"\n VENDEDOR: " + id + 
								 "\n NOMBRE: " + nombre);
			}
			System.out.println("\n_________________\n");
		} catch (Exception e) {
			System.out.println("El error es el siguiente: " + e);
		}
	}

	public void listarProductos() {
		try {
			for (int i = 0; i < productos.size(); i++) {
				String id = String.valueOf(productos.get(i).getId());
				String producto = productos.get(i).getNombre();
				String precio = String.valueOf(productos.get(i).getPrecio());
				System.out.print("\n_________________\n"+
								 "\n NUMERO DE PRODUCTO: " + id + 
								 "\n PRODUCTO: " + producto + 
								 "\n PRECIO: " + precio);
			}
			System.out.println("\n_________________\n");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void listarVentas() {
		Double ganancias = 0.00;
		System.out.println("\n Estas son las ventas realizadas hasta el momento: \n");
		if (ventas.size() != 0) {
			for (int i = 0; i < ventas.size(); i++) {
				String nombreVendedor = ventas.get(i).getVendedor().getNombre();
				String id_venta = String.valueOf(ventas.get(i).getIdVenta());
				System.out.println("\n____________\n "
								  + "Nro de venta: " + id_venta);
				String nombreProducto = ventas.get(i).getProductos().get(i).getNombre();
				String precioProducto = String.valueOf(ventas.get(i).getProductos().get(i).getPrecio());
				ganancias += ventas.get(i).getProductos().get(i).getPrecio();
				System.out.println("\n Nombre del vendedor: "+nombreVendedor+
								   "\n Nombre de producto: "+nombreProducto+ 
						           "\n Precio de "+nombreProducto+": $"+precioProducto);
			}
			System.out.println("\n____________\n");
		}
		System.out.println("Ganancias totales: $" + ganancias);
	}

	public void buscarPorCategoria(Integer idCategoria) {
		String categoria = "";
		if(idCategoria == 1) {
		  categoria = "Comestible";
		}
		if(idCategoria == 2) {
		  categoria = "Bebidas";
		}
		if(idCategoria == 3) {
		  categoria = "Lacteos";
		}
		System.out.println("Estos son los productos de la categoria "+categoria+"\n");
		for (int i = 0; i < productos.size(); i++) {
			Producto pro = productos.get(i);
			if (pro.getCategoria().equals(categoria)) {
				String id = String.valueOf(productos.get(i).getId());
				String producto = productos.get(i).getNombre();
				String precio = String.valueOf(productos.get(i).getPrecio());
				System.out.print("\n____________\n"+
								 "\n NÚMERO DEL PRODUCTO: " + id + 
						         "\n NOMBRE DEL PRODUCTO: " + producto + 
						         "\n PRECIO: " + precio);
			}
		}
		System.out.println("\n____________\n");
	}

	public void calcularComision(String vendedor) {
		Double comision = 0.00;
		Double totalVentas = 0.00;

		if (ventas != null) {
			for (int i = 0; i < ventas.size(); i++) {
				if (ventas.get(i).getVendedor().getNombre().equals(vendedor)) {
					if (ventas.get(i).getProductos().size() <= 2) {
						for (int j = 0; j < ventas.get(i).getProductos().size(); j++) {
							totalVentas += ventas.get(i).getProductos().get(j).getPrecio();
							comision += (ventas.get(i).getProductos().get(j).getPrecio() * 0.05);
						}
					}
					if (ventas.get(i).getProductos().size() > 2) {
						for (int j = 0; j < ventas.get(i).getProductos().size(); j++) {
							totalVentas += ventas.get(i).getProductos().get(j).getPrecio();
							comision += (ventas.get(i).getProductos().get(j).getPrecio() * 0.1);
						}
					}
				}
			}
		}
		System.out.println("El total de ventas de "+vendedor+" es de: $" + totalVentas);
		System.out.println("La comision de " + vendedor + " es de: $" + comision);
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
}
