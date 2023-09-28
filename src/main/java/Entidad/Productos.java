package Entidad;

public class Productos {
	// Campos o atributos
	private String IdProducto;
    private String Descripcion;
    private double PrecioUnidad;
    private int Stock;
    private char Estado;
    
    // Métodos Constructores
	public Productos() {
	}

	public Productos(String idProducto, String descripcion, double precioUnidad, int stock, char estado) {
		IdProducto = idProducto;
		Descripcion = descripcion;
		PrecioUnidad = precioUnidad;
		Stock = stock;
		Estado = estado;
	}

	// Propiedades de Lectura y Escritura
	public String getIdProducto() {
		return IdProducto;
	}

	public void setIdProducto(String idProducto) {
		IdProducto = idProducto;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public double getPrecioUnidad() {
		return PrecioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		PrecioUnidad = precioUnidad;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	public char getEstado() {
		return Estado;
	}

	public void setEstado(char estado) {
		Estado = estado;
	}    
}
