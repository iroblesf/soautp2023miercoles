/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
//Patrón Creacional SINGLETON
public class ConnectionDB {

    private static ConnectionDB instance = null;
    private static Connection con;
    private static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=sistemasoaputp";
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String USER = "sa";
    private static final String PASS = "12345678";

    private ConnectionDB() {
        try {
            Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado a la BD");
        } catch (Exception e) {
            System.out.println("Eror al conectar :" + e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized static ConnectionDB getInstance() {

        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;

    }

    public Connection getConnection(){
      return con;
    }
    
    public void close(){
     instance = null;
    }
    
    
}



