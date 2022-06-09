/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.controlador;

import com.carlos.modelo.Conexion;
import java.sql.*;
import java.util.stream.Stream;
import javax.swing.JTable;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class Procedimental {

     public static String Procedimental(String consulta) {
        String r = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;
        try {
            cstmt = Conexion.getConnection().prepareCall(
                    "{" + consulta + "}");
            System.out.println("{" + consulta + "}");
            cstmt.execute();
            rs = cstmt.getResultSet();
            r = "true";
        } catch (SQLException ex) {
            r = ex.getMessage();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if (cstmt != null) {
                try {
                    cstmt.close();
                } catch (SQLException ex) {
                }
            }
        }
        return r;
    }
}
