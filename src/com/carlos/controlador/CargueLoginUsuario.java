/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.controlador;

import com.carlos.modelo.Conexion;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class CargueLoginUsuario {

    public static boolean Conectar(String contraseña, String usuario, String instancia, String ip, String puerto, String bd, String motor)  {
        DatosConexion dc = new DatosConexion();
        dc.setUsuario(usuario);
        dc.setContraseña(contraseña);
        dc.setInstancia(instancia);
        dc.setIp(ip);
        dc.setPuerto(puerto);
        dc.setBd(bd);
        dc.setMotor(motor);

        try {
            if (Conexion.getConnection() != null) {
                return true;
            }
        } catch (HeadlessException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(CargueLoginUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

