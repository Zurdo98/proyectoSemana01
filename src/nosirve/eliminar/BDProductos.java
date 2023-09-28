package Datos;
import Entidad.Productos;
import java.util.ArrayList;
import java.sql.*;

public class BDProductos {
	private String Driver = "com.mysql.cj.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/cibertec2023";
	private String Usuario = "root";
	private String Password = "mysql";
	
	private Connection Cn;
	private Statement Cmd;
	private CallableStatement Stmt;
	private ResultSet Rs;
	
	// Método Constructor
	public BDProductos() {
		try {
				Class.forName(Driver);
				Cn = DriverManager.getConnection(URL, Usuario, Password);
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
	
	// Método ListarProductos
	public ArrayList<Productos> ListarProductos(){
		ArrayList<Productos> Lista = new ArrayList<>();
		String SQL = "call ListarProductos()";
		try {
				Stmt = Cn.prepareCall(SQL);
				Rs = Stmt.executeQuery();
				while(Rs.next()) {
					Lista.add(new Productos(Rs.getString("IdProducto"), Rs.getString("Descripcion"),
							Rs.getDouble("PrecioUnidad"), Rs.getInt("Stock"), Rs.getString("Estado").charAt(0)));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
		return Lista;
	}
	
	// Método BuscarProducto
	public Productos BuscarProducto(String Id) {
		String SQL = "call BuscarProducto(?)";
		Productos ObjP = null;
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Rs = Stmt.executeQuery();
				if(Rs.next()) {
					ObjP = new Productos(Rs.getString("IdProducto"), Rs.getString("Descripcion"),
							Rs.getDouble("PrecioUnidad"), Rs.getInt("Stock"), Rs.getString("Estado").charAt(0));
				}
				Rs.close();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
		return ObjP;
	}
	
	// Método InsertaProducto
	public void InsertaProducto(Productos ObjP) {
		String SQL = "call InsertaProducto(?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjP.getIdProducto());
				Stmt.setString(2, ObjP.getDescripcion());
				Stmt.setDouble(3, ObjP.getPrecioUnidad());
				Stmt.setInt(4, ObjP.getStock());
				Stmt.setString(5, ObjP.getEstado() + "");
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
	
	// Método ModificaProducto
	public void ModificaProducto(Productos ObjP) {
		String SQL = "call ModificaProducto(?,?,?,?,?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, ObjP.getIdProducto());
				Stmt.setString(2, ObjP.getDescripcion());
				Stmt.setDouble(3, ObjP.getPrecioUnidad());
				Stmt.setInt(4, ObjP.getStock());
				Stmt.setString(5, ObjP.getEstado() + "");
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
	
	// Método SuprimirProducto
	public void SuprimirProducto(String Id) {
		String SQL = "call SuprimirProducto(?)";
		try {
				Stmt = Cn.prepareCall(SQL);
				Stmt.setString(1, Id);
				Stmt.executeUpdate();
		} catch (Exception e) {
				System.out.println("ERROR:" + e.getMessage());
		}
	}
}
