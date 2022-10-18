package tienda;

import java.util.Scanner;

import tienda.modelo.Inventario;

public class Main {

	public static void main(String[] args) {

		Inventario inventario = new Inventario();
		final Scanner teclado = new Scanner(System.in);
		Integer sueldo;
		Double precio;
		String nombre;
		String categoria = null;
		Integer idCategoria;
		Integer idVendedor;
		Integer idProducto;
		int opcion;
		boolean salir = false;
		
		try {
			while (salir != true) {	
	
				System.out.println("\n¡Bienvenido/a! \n" 
								  + "¿Que desea realizar? \n" 
						          + "\n" 
								  + "1. Ver productos disponibles\n"
						          + "2. Agregar producto\n"
								  + "3. Ver vendedores dosponibles\n"
						          + "4. Agregar vendedor\n" 
						          + "5. Registrar venta\n"
						          + "6. Ver las ventas realizadas\n"
								  + "7. Buscar producto por categoria\n"
								  + "8. Mostrar comisiones totales\n"
								  + "9. Salir\n" 
								  + "\n"
								  + "Elija la opción:  \n");
	
				opcion = Integer.parseInt(teclado.nextLine());
	
				switch (opcion) {
				case 1:
					System.out.println("Estos son los productos disponibles: \n");
					inventario.listarProductos();
					break;
				case 2:
					System.out.println("Ingrese nombre del producto:");
					nombre = teclado.nextLine();
					System.out.println("Ingrese precio del producto:");
					precio = teclado.nextDouble();
					System.out.println("Ingrese la categoria del producto:");
					categoria = teclado.nextLine();
					inventario.agregarProducto(nombre, precio, categoria);
					System.out.println("\n El producto '"+nombre+"' se ha guardado correctamente.\n");
					break;
				case 3:
					inventario.listarVendedores();
					break;
				case 4:
					System.out.println("Ingrese nombre del vendedor:");
					nombre = teclado.nextLine();
					System.out.println("Ingrese sueldo del vendedor:");
					sueldo = Integer.parseInt(teclado.nextLine());
					inventario.agregarVendedor(nombre, sueldo);
					System.out.println("\n El vendedor '"+nombre+"' se ha guardado correctamente.\n");
					break;
				case 5:
					System.out.println("Elija el vendedor: \n");
					inventario.listarVendedores();
					idVendedor = Integer.parseInt(teclado.nextLine());
					System.out.println("Elija el producto: \n");
					inventario.listarProductos();
					idProducto = Integer.parseInt(teclado.nextLine());
					inventario.agregarVenta(idProducto, idVendedor);
					System.out.println("¡La venta se realizo con éxito!");
					break;
				case 6:
					inventario.listarVentas();
					break;
				case 7:
					System.out.println("Elija la categoria que desea buscar: \n"
							          + "1. Comestible\n"
							          + "2. Bebidas\n"
							          + "3. Lacteos\n");
					idCategoria = Integer.parseInt(teclado.nextLine());
					inventario.buscarPorCategoria(idCategoria);
					break;
				case 8:
					inventario.calcularComision("Anibal");
					break;
				case 9:
					System.out.println("\n Muchas gracias por su visita.");
					salir = true;
					break;
				}
			}
		}catch(Exception e) {
			System.out.println("El error es el siguiente: "+e);
		}
		teclado.close();

	}
	
}