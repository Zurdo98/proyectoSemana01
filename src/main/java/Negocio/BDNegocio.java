package Negocio;
import Entidad.Productos;
import Datos.BDProductos;
import java.util.ArrayList;

public class BDNegocio {
	BDProductos ObjBD;
	
	public BDNegocio() {
		ObjBD = new BDProductos();
	}
	
	public ArrayList<Productos> Listar(){
		return ObjBD.ListarProductos();
	}
	
	public Productos Buscar(String Id) {
		return ObjBD.BuscarProducto(Id);
	}
	
	public void Insertar(Productos ObjP) {
		ObjBD.InsertaProducto(ObjP);
	}
	
	public void Modificar(Productos ObjP) {
		ObjBD.ModificaProducto(ObjP);
	}
	
	public void Suprimir(String Id) {
		ObjBD.SuprimirProducto(Id);
	}
}
