/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class CargueCrearUsuario {

    public static String crearOracle(String usuario, String contraseña, ArrayList<String> checkbox) {
        String resul = "";
        try {
            resul = Insertar.Consulta_CUD("alter session set \"_ORACLE_SCRIPT\"=true");
            resul = Insertar.Consulta_CUD("CREATE USER " + usuario + " IDENTIFIED BY " + contraseña);
            for (int i = 0; i < checkbox.size(); i++) {
                resul = Insertar.Consulta_CUD("GRANT " + checkbox.get(i) + " TO " + usuario);
            }
        } catch (SQLException e) {
//            System.out.println(e.getMessage());
        }
        if (resul.equals("true")) {
            return "true";
        } else {
            return resul;
        }
    }

    public static String eliminarOracle(String usuario) {
        String resul = "";
        try {
            resul = Insertar.Consulta_CUD("alter session set \"_ORACLE_SCRIPT\"=true");
            resul = Insertar.Consulta_CUD("drop user " + usuario);
        } catch (SQLException ex) {
//            Logger.getLogger(CargueCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (resul.equals("true")) {
            return "true";
        } else {
            return resul;
        }
    }

    public static String CrearServer(String login, String usuario, String contraseña, ArrayList<String> rolesS, ArrayList<String> database, ArrayList<String> rolesbd) {
        String resul = "";
        try {
            resul = Insertar.Consulta_CUD("CREATE LOGIN " + login + " WITH PASSWORD = '" + contraseña + "'");
//            System.out.println("CREATE LOGIN " + login + " WITH PASSWORD = '" + contraseña + "'");
//            System.out.println("   ");

            for (int i = 0; i < rolesS.size(); i++) {
                resul = Insertar.Consulta_CUD("ALTER SERVER ROLE " + rolesS.get(i) + " ADD MEMBER " + login);
//                System.out.println("ALTER SERVER ROLE " + rolesS.get(i) + " ADD MEMBER " + login);
            }
//            System.out.println("   ");
            for (int i = 0; i < database.size(); i++) {
                resul = Insertar.Consulta_CUD("USE " + database.get(i)
                        + " CREATE USER " + usuario + " FOR LOGIN " + login);
//                System.out.println("   ");
//                System.out.println("USE " + database.get(i)
//                        + " CREATE USER " + usuario + " FOR LOGIN " + login);
                for (int j = 0; j < rolesbd.size(); j++) {
                    resul = Insertar.Consulta_CUD("USE " + database.get(i)
                            + " exec sp_addrolemember " + rolesbd.get(j) + "," + usuario);
//                    System.out.println("USE " + database.get(i)
//                            + " exec sp_addrolemember " + rolesbd.get(j) + "," + usuario);
                }
            }
        } catch (SQLException e) {
//            System.out.println(e.getMessage());
        }
        if (resul.equals(
                "true")) {
            return "true";
        } else {
            return resul;
        }
    }

    public static String eliminarServer(String login) {
        String resul = "";
        try {
            resul = Insertar.Consulta_CUD("drop login " + login);
        } catch (SQLException ex) {
            Logger.getLogger(CargueCrearUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (resul.equals("true")) {
            return "true";
        } else {
            return resul;
        }

    }     
}


//      CREATE LOGIN namelogin   
//      WITH PASSWORD = 'contraseña'; 
//      USE databse;  
//      CREATE nameuser ede FOR LOGIN namelogin   
//      WITH DEFAULT_SCHEMA = schema(dbo);
//      use database
//      exec sp_addrolemember rol bd,nameuser
//	ALTER SERVER ROLE  rolserver  ADD MEMBER namelogin;

