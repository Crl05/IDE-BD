/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.vista;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class Main {

    public static void main(String[] args) {
        
        System.out.println("hola mundo");
        FlatArcIJTheme.setup();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUsuarios().setVisible(true);
            }
        });

    }

}
