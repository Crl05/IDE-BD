package com.carlos.modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.carlos.controlador.*;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author carli
 */
public class Conexion extends DatosConexion {

    public static Connection cn;

    public static Connection getConnection() throws SQLException {
         Statement stm= null;
                 try {
            if (Conexion.cn == null) {

                switch (motor) {
                    case "Oracle" -> {
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Conexion.cn = DriverManager.getConnection("jdbc:oracle:thin:@" + ip + ":"
                                + puerto + ":" + instancia, usuario, contraseña);
                    }
                    case "SQL Server" -> {
                        String url = "jdbc:sqlserver://" + ip + ":" + puerto + ";"
                                + "database=" + bd + ";user=" + usuario + ";password=" + contraseña + ";";
                        Conexion.cn = DriverManager.getConnection(url);
                    }
                }
                System.out.println("Conexion Exitosa");
                return Conexion.cn;
            }
        } catch (SQLException ex) {
            System.out.println("Conexion Rechazada");
            return Conexion.cn;
        }
        return Conexion.cn;
    }

    public static Connection getClose(){
        Conexion.cn = null;
        System.out.println("Conexion cerrada");
        return Conexion.cn;
    }

}
