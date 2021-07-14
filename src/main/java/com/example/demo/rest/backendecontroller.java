package com.example.demo.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Greeting;

@RestController
public class backendecontroller {

	@GetMapping("/nombre")
	public String nombreSitio (@RequestParam(value = "name", defaultValue = "Full Stack") String name) {
		try {
			getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.format("Carlos Campos "+name);
	}
	
	@GetMapping("/descripcion")
	public String descipcionSitio () {
		return "CRUD SERVICES";
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

}
