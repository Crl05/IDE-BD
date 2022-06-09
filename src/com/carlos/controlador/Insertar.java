/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.controlador;

import com.carlos.modelo.Conexion;
import java.sql.*;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class Insertar {
    public static String Consulta_CUD(String CUD) throws SQLException {
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement st = con.prepareStatement(CUD);
            st.execute();
            st.close();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return "true";
    }
}
