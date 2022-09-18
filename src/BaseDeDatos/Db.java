/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Db {
    // Declaramos los datos de conexion a la bd
    private Connection con;
    private String driver;
    private String user;
    private String pass;
    private String url;
    
    public Db(){
        this(null, "com.mysql.jdbc.Driver", "root", "", "jdbc:mysql://localhost/arquitectura");
    }
    
    public Db(Connection con, String driver, String user, String pass, String url) {
        this.con = con;
        this.driver = driver;
        this.user = user;
        this.pass = pass;
        this.url = url;
        CreateConnection();
    }

    public Connection getCon() {
        return con;
    }
    
    
    // Funcion que va conectarse a mi bd de mysql
    public  Connection CreateConnection() {
        // Reseteamos a null la conexion a la bd
        con = null;
        try {
            Class.forName(driver);
            // Nos conectamos a la bd
            con = (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con != null  ) {
             System.out.println("Conexion establecida");
            }
        } catch ( ClassNotFoundException | SQLException e) {
            System.out.println(" Error de conexion " + e);
        }
        return con;
    }
}
