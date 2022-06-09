/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.controlador;

import com.carlos.modelo.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class Consultar {

    private static String Error = null;
    
    public static String Error() {
        return Error;
    }

    public static ArrayList<String> consulta(String consulta) {
        ResultSet rs = null;
        ArrayList<String> lista = new ArrayList<String>();

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement st = con.prepareStatement(consulta);
            rs = st.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return lista;
    }

   
    public static DefaultTableModel consulTableModel(String consulta, int indentificador) {
        DefaultTableModel resul = new DefaultTableModel();
        ResultSet rs = null;

        try {
            Connection con = Conexion.getConnection();
            Statement st = con.createStatement();
            switch (indentificador) {
                case 0 -> {
                    rs = st.executeQuery("SELECT * FROM " + consulta);
                }
                case 1 -> {
                    rs = st.executeQuery(consulta);
                }
            }
            ResultSetMetaData resultt = rs.getMetaData();
            int columns = resultt.getColumnCount();
            System.out.println(columns);
            for (int i = 0; i < columns; i++) {
                resul.addColumn(resultt.getColumnLabel(i + 1));
            }
            while (rs.next()) {
                Object vector[] = new Object[columns];
                for (int i = 0; i < columns; i++) {
                    vector[i] = rs.getObject(i + 1);

                }
                resul.addRow(vector);
                System.out.println("");
            }
            Error = "";
        } catch (SQLException ex) {
            Error = String.valueOf(ex.getMessage());
        }
        return resul;
    }
    
//    public static void Consultar_select(String consulta, JTable resultado, JTextArea error, int verificador) {
//        try {
//            ResultSet result = null;
//            Connection con = Conexion.getConnection();
//            Statement st = con.createStatement();
//            DefaultTableModel resul = new DefaultTableModel();
//
//            resultado.setModel(resul);
//            switch (verificador) {
//                case 0 -> {
//                    result = st.executeQuery("SELECT * FROM " + consulta);
//                }
//                case 1 -> {
//                    result = st.executeQuery(consulta);
//                }
//            }
//            ResultSetMetaData resultt = result.getMetaData();
//            int columns = resultt.getColumnCount();
//            for (int i = 0; i < columns; i++) {
//                resul.addColumn(resultt.getColumnLabel(i + 1));
//            }
//            while (result.next()) {
//                Object vector[] = new Object[columns];
//                for (int i = 0; i < columns; i++) {
//                    vector[i] = result.getObject(i + 1);
//                }
//                resul.addRow(vector);
//                error.setText("");
//            }
//        } catch (SQLException e) {
//            error.setText("ERROR: " + e.getMessage());
//        }
//    }
}
