/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.controlador;

import com.carlos.modelo.*;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class CargueVentanaPrincipal {

    private static ArrayList<String> consulta_tablas, consulta_funciones, consulta_paquetes, consulta_procedimientos, consulta_triggers, consulta_vistas, consulta_usuarios, consulta_indices, consulta_roles = new ArrayList<>();
    private static DefaultMutableTreeNode treeNode1, treeNode2, treeNode3;

    private static void deteccion_motor() {
        switch (DatosConexion.motor) {
            case "Oracle" -> {
                consulta_tablas = Consultar.consulta("SELECT TABLE_NAME FROM USER_TABLES ORDER BY TABLE_NAME ASC");
                consulta_funciones = Consultar.consulta("SELECT OBJECT_NAME FROM USER_PROCEDURES WHERE OBJECT_TYPE = 'FUNCTION' ORDER BY OBJECT_NAME ASC");
                consulta_paquetes = Consultar.consulta("SELECT OBJECT_NAME FROM USER_PROCEDURES WHERE OBJECT_TYPE = 'PACKAGE' GROUP BY OBJECT_NAME");
                consulta_procedimientos = Consultar.consulta("SELECT OBJECT_NAME FROM USER_PROCEDURES WHERE OBJECT_TYPE = 'PROCEDURE' ORDER BY OBJECT_NAME ASC");
                consulta_triggers = Consultar.consulta("SELECT TRIGGER_NAME FROM USER_TRIGGERS ORDER BY TRIGGER_NAME ASC");
                consulta_vistas = Consultar.consulta("SELECT VIEW_NAME FROM USER_VIEWS ORDER BY VIEW_NAME ASC");
                consulta_usuarios = Consultar.consulta("SELECT USERNAME FROM USER_USERS");
                consulta_indices = Consultar.consulta("SELECT INDEX_NAME FROM USER_INDEXES ORDER BY INDEX_NAME ASC");
                consulta_roles = Consultar.consulta("SELECT GRANTED_ROLE  FROM USER_ROLE_PRIVS");
            }
            case "SQL Server" -> {
                consulta_tablas = Consultar.consulta("SELECT NAME FROM SYS.TABLES ORDER BY NAME ASC");
                consulta_funciones = Consultar.consulta("SELECT NAME FROM SYS.OBJECTS WHERE TYPE='FN' ORDER BY NAME ASC");
                consulta_procedimientos = Consultar.consulta("SELECT NAME FROM SYS.OBJECTS WHERE TYPE='P' ORDER BY NAME ASC");
                consulta_triggers = Consultar.consulta("SELECT NAME FROM SYS.OBJECTS WHERE TYPE='TR' ORDER BY NAME ASC");
                consulta_vistas = Consultar.consulta("SELECT NAME FROM SYS.OBJECTS WHERE TYPE='V' ORDER BY NAME ASC");
                consulta_usuarios = Consultar.consulta("SELECT NAME FROM SYS.DATABASE_PRINCIPALS WHERE TYPE='S' ORDER BY NAME ASC");
                consulta_indices = Consultar.consulta("SELECT INDEXE.NAME FROM SYS.INDEXES INDEXE , SYS.TABLES TABLES WHERE INDEXE.OBJECT_ID = TABLES.OBJECT_ID AND  INDEXE.NAME != 'NULL'");
                consulta_roles = Consultar.consulta("SELECT NAME FROM SYS.SYSUSERS WHERE ALTUID='1' ORDER BY NAME ASC");
                consulta_paquetes = null;
            }
        }
    }

    public static DefaultMutableTreeNode cargue_navegacion() {
        javax.swing.JTree Navegacion_Jtree = new javax.swing.JTree();
        Navegacion_Jtree.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14));
        deteccion_motor();
        treeNode1 = new DefaultMutableTreeNode("Base de datos " + DatosConexion.motor);
        treeNode2 = new DefaultMutableTreeNode("Tablas");
        try {
            for (int i = 0; i < consulta_tablas.size(); i++) {
                treeNode3 = new DefaultMutableTreeNode(consulta_tablas.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        treeNode3 = new DefaultMutableTreeNode();

        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Funciones");
        try {
            for (int i = 0; i < consulta_funciones.size(); i++) {
                treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(consulta_funciones.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Paquetes");
        try {
            for (int i = 0; i < consulta_paquetes.size(); i++) {
                treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(consulta_paquetes.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Procedimientos");
        try {
            for (int i = 0; i < consulta_procedimientos.size(); i++) {
                treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(consulta_procedimientos.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Indices");
        try {
            for (int i = 0; i < consulta_indices.size(); i++) {
                treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(consulta_indices.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Triggers");
        try {
            for (int i = 0; i < consulta_triggers.size(); i++) {
                treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(consulta_triggers.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Vistas");
        try {
            for (int i = 0; i < consulta_vistas.size(); i++) {
                treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(consulta_vistas.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Roles");
        try {
            for (int i = 0; i < consulta_roles.size(); i++) {
                treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(consulta_roles.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Usuario");
        try {
            for (int i = 0; i < consulta_usuarios.size(); i++) {
                treeNode3 = new javax.swing.tree.DefaultMutableTreeNode(consulta_usuarios.get(i));
                treeNode2.add(treeNode3);
                treeNode1.add(treeNode2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return treeNode1;
    }

    public static void cerrar() {
        Conexion.getClose();
    }

//    public static void CorrerDDL(JTextArea DDL_Jarea, JTextArea Consola_Jarea) {
//        String consulta = String.valueOf(DDL_Jarea.getSelectedText());
//        String resul = "";
//        if (consulta.equals("null")) {
//            int i = 0;
//            try {
//                for (i = 0; i < DDL_Jarea.getLineCount(); i++) {
//                    resul = Insertar.Consulta_CUD(String.valueOf(DDL_Jarea.getText(DDL_Jarea.getLineStartOffset(i),
//                            (DDL_Jarea.getLineEndOffset(i)) - (DDL_Jarea.getLineStartOffset(i)))));
//                }
//                if (resul.equals("true")) {
//                    Consola_Jarea.setText(+i + " fila(s) ejecutada(s)");
//                } else {
//                    Consola_Jarea.setText(resul);
//                }
//            } catch (BadLocationException | SQLException ex) {
//                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//                Consola_Jarea.setText(ex.getMessage());
//            }
//        } else if (!consulta.equals("null")) {
//            try {
//                String[] cadena = DDL_Jarea.getSelectedText().split("\n");
//                int i = 0;
//                for (i = 0; i < cadena.length; i++) {
//                    resul = Insertar.Consulta_CUD(String.valueOf(cadena[i]));
//                }
//                if (resul.equals("true")) {
//                    Consola_Jarea.setText(+i + " fila(s) ejecutada(s)");
//                } else {
//                    Consola_Jarea.setText(resul);
//                }
//            } catch (SQLException ex) {
//                Consola_Jarea.setText(resul);
//            }
//        }
//    }
}
