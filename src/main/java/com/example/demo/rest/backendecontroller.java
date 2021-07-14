package com.example.demo.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Greeting;

import gt.gob.banguat.variables.ws.ArrayOfVar;
import gt.gob.banguat.variables.ws.TipoCambio;
import gt.gob.banguat.variables.ws.TipoCambioSoap;
import gt.gob.banguat.variables.ws.Var;
import gt.gob.banguat.variables.ws.Variable;

@RestController
public class backendecontroller {

	@GetMapping("/tipocambio")
	public ArrayList<monedamodel> nombreSitio (@RequestParam(value = "first", defaultValue = "01/01/2020") String first ,@RequestParam(value = "second", defaultValue = "02/01/2020") String second) {
		try {
			createTable();
			tipoCambioRango(first, second);
			return select();
			//System.out.println(first+second);
			//insert(1, "01/01/2000", 15.7, 15.7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/consultatipocambio")
	public ArrayList<monedamodel> consulta () {
		try {			
			return select();
			//insert(1, "01/01/2000", 15.7, 15.7);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/descripcion")
	public String descipcionSitio () {
		return "CRUD SERVICES";
	}
	
	public static void insert(int var1in,String var2in,double var3in, double var4in) throws Exception{
		final int var1 = var1in;
		final String var2 = var2in;
		final double var3 = var3in;
		final double var4 = var4in;
		try {
			Connection conn = getConnection();
			PreparedStatement posted = conn.prepareStatement("INSERT INTO tipo_cambio(moneda,fecha,venta,compra) VALUES("+var1+",'"+var2+"'"+","+var3+","+var4+")");
			posted.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void testVariablesDisponibles() {
		
		TipoCambioSoap servicio = new TipoCambio().getTipoCambioSoap();
		//int tm = servicio.variablesDisponibles().getTotalItems();
		
		for (Variable array : servicio.variablesDisponibles().getVariables().getVariable()) {
			if (array.getMoneda() % 2 == 0) {
				System.out.println("Codigo de Moneda: "+array.getMoneda()+" Nombre de la moneda: "+array.getDescripcion());
		    } 
			
		}				
	}
	
	public static ArrayList<monedamodel> select() throws Exception{
		Connection conn = getConnection();
		PreparedStatement posted = conn.prepareStatement("SELECT id,moneda,fecha,venta,compra FROM tipo_cambio ORDER BY id DESC");
		ResultSet result = posted.executeQuery();
		ArrayList<monedamodel> array = new ArrayList<monedamodel>();		
		while (result.next()) {
			monedamodel moneda = new monedamodel(result.getInt("id"),result.getInt("moneda"),result.getString("fecha"),result.getFloat("venta"),result.getFloat("compra"));
			array.add(moneda);
		}
		
		
		
		return array;
		
	}

	public static void tipoCambioRango(String first, String second) throws Exception {
		TipoCambioSoap servicio = new TipoCambio().getTipoCambioSoap();		
		for (Var array : servicio.tipoCambioRango(first, second).getVars().getVar()) {
			insert(array.getMoneda(), array.getFecha(), array.getVenta(), array.getCompra());			
		}
		
	}

	public static Connection getConnection() throws Exception {
			
			try {
				
				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://127.0.0.1:3306/pronet";
				String username = "root";
				String password = "Campos1100#";
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url,username,password);			
				return conn;
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			return null;
			
		}
	
	public static void createTable() throws Exception {
			
			try {
				
				Connection conn = getConnection();
				PreparedStatement create = conn.prepareStatement("CREATE TABLE IF NOT EXISTS tipo_cambio(id int NOT NULL AUTO_INCREMENT,moneda int, fecha varchar(10),venta double,compra double,PRIMARY KEY(id))");
				create.executeUpdate();
				
			} catch (Exception e) {
				System.out.println(e);
			}
			finally{System.out.println("Function CREATE completed");};
			
		}

}
