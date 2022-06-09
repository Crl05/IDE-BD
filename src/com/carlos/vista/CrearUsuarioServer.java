/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.vista;

import com.carlos.controlador.CargueCrearUsuario;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos A. Amaya C.
 */
public class CrearUsuarioServer extends javax.swing.JFrame {

    /**
     * Creates new form CrearUsuarioServer
     */
    public CrearUsuarioServer() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/com/carlos/imagenes/sql.png")).getImage());
        Crear_Jboton.setIcon(setIcono("/com/carlos/imagenes/mas.png", Crear_Jboton));
        Eliminar_Jboton.setIcon(setIcono("/com/carlos/imagenes/menos.png", Eliminar_Jboton));
    }

    private static ArrayList<String> checkRolesS() {
        ArrayList<String> checkbox = new ArrayList<>();
        if (rol1_Jcheck.isSelected() == true) {
            checkbox.add(rol1_Jcheck.getText());
        }
        if (rol2_Jcheck.isSelected() == true) {
            checkbox.add(rol2_Jcheck.getText());
        }
        if (rol3_Jcheck.isSelected() == true) {
            checkbox.add(rol3_Jcheck.getText());
        }
        if (rol4_Jcheck.isSelected() == true) {
            checkbox.add(rol4_Jcheck.getText());
        }
        if (rol5_Jcheck.isSelected() == true) {
            checkbox.add(rol5_Jcheck.getText());
        }
        if (rol6_Jcheck.isSelected() == true) {
            checkbox.add(rol6_Jcheck.getText());
        }
        if (rol7_Jcheck.isSelected() == true) {
            checkbox.add(rol7_Jcheck.getText());
        }
        if (rol8_Jcheck.isSelected() == true) {
            checkbox.add(rol8_Jcheck.getText());
        }
        return checkbox;
    }

    private static ArrayList<String> checkDatabase() {
        ArrayList<String> checkbox = new ArrayList<>();
        if (bd1_Jcheck.isSelected() == true) {
            checkbox.add(bd1_Jcheck.getText());
        }
        if (bd2_Jcheck.isSelected() == true) {
            checkbox.add(bd2_Jcheck.getText());
        }
        if (bd3_Jcheck.isSelected() == true) {
            checkbox.add(bd3_Jcheck.getText());
        }
        if (bd4_Jcheck.isSelected() == true) {
            checkbox.add(bd4_Jcheck.getText());
        }
        if (bd5_Jcheck.isSelected() == true) {
            checkbox.add(bd5_Jcheck.getText());
        }
        return checkbox;
    }

    private static ArrayList<String> checkRolesDB() {
        ArrayList<String> checkbox = new ArrayList<>();
        if (rolbd1_Jcheck.isSelected() == true) {
            checkbox.add(rolbd1_Jcheck.getText());
        }
        if (rolbd2_Jcheck.isSelected() == true) {
            checkbox.add(rolbd2_Jcheck.getText());
        }
        if (rolbd3_Jcheck.isSelected() == true) {
            checkbox.add(rolbd3_Jcheck.getText());
        }
        if (rolbd4_Jcheck.isSelected() == true) {
            checkbox.add(rolbd4_Jcheck.getText());
        }
        if (rolbd5_Jcheck.isSelected() == true) {
            checkbox.add(rolbd5_Jcheck.getText());
        }
        if (rolbd6_Jcheck.isSelected() == true) {
            checkbox.add(rolbd6_Jcheck.getText());
        }
        if (rolbd7_Jcheck.isSelected() == true) {
            checkbox.add(rolbd7_Jcheck.getText());
        }
        if (rolbd8_Jcheck.isSelected() == true) {
            checkbox.add(rolbd8_Jcheck.getText());
        }
        if (rolbd9_Jcheck.isSelected() == true) {
            checkbox.add(rolbd9_Jcheck.getText());
        }
        return checkbox;
    }

    public boolean ContraseñaVerificada() {
        return Contraseña_Jtext.getText().equals(CContraseña_Jtext.getText());
    }

    public void limpiar() {
        Login_Jtext.setText("");
        Usuario_Jtext.setText("");
        Contraseña_Jtext.setText("");
        CContraseña_Jtext.setText("");
        rol1_Jcheck.setSelected(false);
        rol2_Jcheck.setSelected(false);
        rol3_Jcheck.setSelected(false);
        rol4_Jcheck.setSelected(false);
        rol5_Jcheck.setSelected(false);
        rol6_Jcheck.setSelected(false);
        rol7_Jcheck.setSelected(false);
        rol8_Jcheck.setSelected(false);
        bd1_Jcheck.setSelected(false);
        bd2_Jcheck.setSelected(false);
        bd3_Jcheck.setSelected(false);
        bd4_Jcheck.setSelected(false);
        bd5_Jcheck.setSelected(false);
        rolbd1_Jcheck.setSelected(false);
        rolbd2_Jcheck.setSelected(false);
        rolbd3_Jcheck.setSelected(false);
        rolbd4_Jcheck.setSelected(false);
        rolbd5_Jcheck.setSelected(false);
        rolbd6_Jcheck.setSelected(false);
        rolbd7_Jcheck.setSelected(false);
        rolbd8_Jcheck.setSelected(false);
        rolbd9_Jcheck.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login_Jlabel = new javax.swing.JLabel();
        Usuario_Jlabel = new javax.swing.JLabel();
        Contraseña_Jlabel = new javax.swing.JLabel();
        CContraseña_Jlabel = new javax.swing.JLabel();
        Login_Jtext = new javax.swing.JTextField();
        Usuario_Jtext = new javax.swing.JTextField();
        Contraseña_Jtext = new javax.swing.JPasswordField();
        CContraseña_Jtext = new javax.swing.JPasswordField();
        RolesS_Jpanel = new javax.swing.JPanel();
        rol1_Jcheck = new javax.swing.JCheckBox();
        rol2_Jcheck = new javax.swing.JCheckBox();
        rol3_Jcheck = new javax.swing.JCheckBox();
        rol4_Jcheck = new javax.swing.JCheckBox();
        rol5_Jcheck = new javax.swing.JCheckBox();
        rol6_Jcheck = new javax.swing.JCheckBox();
        rol7_Jcheck = new javax.swing.JCheckBox();
        rol8_Jcheck = new javax.swing.JCheckBox();
        PBases_Jpanel = new javax.swing.JPanel();
        BD_Jpanel = new javax.swing.JPanel();
        bd1_Jcheck = new javax.swing.JCheckBox();
        bd4_Jcheck = new javax.swing.JCheckBox();
        bd2_Jcheck = new javax.swing.JCheckBox();
        bd5_Jcheck = new javax.swing.JCheckBox();
        bd3_Jcheck = new javax.swing.JCheckBox();
        RolesBD_Jpanel = new javax.swing.JPanel();
        rolbd1_Jcheck = new javax.swing.JCheckBox();
        rolbd2_Jcheck = new javax.swing.JCheckBox();
        rolbd3_Jcheck = new javax.swing.JCheckBox();
        rolbd4_Jcheck = new javax.swing.JCheckBox();
        rolbd5_Jcheck = new javax.swing.JCheckBox();
        rolbd6_Jcheck = new javax.swing.JCheckBox();
        rolbd7_Jcheck = new javax.swing.JCheckBox();
        rolbd8_Jcheck = new javax.swing.JCheckBox();
        rolbd9_Jcheck = new javax.swing.JCheckBox();
        Crear_Jboton = new javax.swing.JButton();
        Eliminar_Jboton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear Usuario");
        setResizable(false);

        Login_Jlabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        Login_Jlabel.setText("Login");

        Usuario_Jlabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        Usuario_Jlabel.setText("Usuario");

        Contraseña_Jlabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        Contraseña_Jlabel.setText("Contraseña");

        CContraseña_Jlabel.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        CContraseña_Jlabel.setText("Confirmar Contraseña");

        Login_Jtext.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N

        Usuario_Jtext.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N

        RolesS_Jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Roles del Servidor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Tai Le", 0, 14))); // NOI18N

        rol1_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rol1_Jcheck.setText("bulkadmin");

        rol2_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rol2_Jcheck.setText("dbcreator");

        rol3_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rol3_Jcheck.setText("diskadmin");

        rol4_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rol4_Jcheck.setText("processadmin");

        rol5_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rol5_Jcheck.setText("securityadmin");

        rol6_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rol6_Jcheck.setText("serveradmin");

        rol7_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rol7_Jcheck.setText("setupadmin");

        rol8_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rol8_Jcheck.setText("sysadmin");

        javax.swing.GroupLayout RolesS_JpanelLayout = new javax.swing.GroupLayout(RolesS_Jpanel);
        RolesS_Jpanel.setLayout(RolesS_JpanelLayout);
        RolesS_JpanelLayout.setHorizontalGroup(
            RolesS_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RolesS_JpanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(RolesS_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rol2_Jcheck)
                    .addComponent(rol3_Jcheck)
                    .addComponent(rol4_Jcheck)
                    .addComponent(rol1_Jcheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(RolesS_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rol6_Jcheck)
                    .addComponent(rol7_Jcheck)
                    .addComponent(rol8_Jcheck)
                    .addComponent(rol5_Jcheck))
                .addGap(15, 15, 15))
        );
        RolesS_JpanelLayout.setVerticalGroup(
            RolesS_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RolesS_JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RolesS_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rol1_Jcheck)
                    .addComponent(rol5_Jcheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(RolesS_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RolesS_JpanelLayout.createSequentialGroup()
                        .addComponent(rol6_Jcheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rol7_Jcheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rol8_Jcheck))
                    .addGroup(RolesS_JpanelLayout.createSequentialGroup()
                        .addComponent(rol2_Jcheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rol3_Jcheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rol4_Jcheck)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        PBases_Jpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BD_Jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bases de datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Tai Le", 0, 14))); // NOI18N

        bd1_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        bd1_Jcheck.setText("master");

        bd4_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        bd4_Jcheck.setText("TALLERES");

        bd2_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        bd2_Jcheck.setText("model");

        bd5_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        bd5_Jcheck.setText("tempdb");

        bd3_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        bd3_Jcheck.setText("msdb");

        javax.swing.GroupLayout BD_JpanelLayout = new javax.swing.GroupLayout(BD_Jpanel);
        BD_Jpanel.setLayout(BD_JpanelLayout);
        BD_JpanelLayout.setHorizontalGroup(
            BD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BD_JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BD_JpanelLayout.createSequentialGroup()
                        .addGroup(BD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bd1_Jcheck)
                            .addComponent(bd2_Jcheck))
                        .addGap(29, 29, 29)
                        .addGroup(BD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bd5_Jcheck)
                            .addComponent(bd4_Jcheck)))
                    .addComponent(bd3_Jcheck))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        BD_JpanelLayout.setVerticalGroup(
            BD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BD_JpanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bd1_Jcheck)
                    .addComponent(bd4_Jcheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bd5_Jcheck)
                    .addComponent(bd2_Jcheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd3_Jcheck))
        );

        RolesBD_Jpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Roles ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Tai Le", 0, 14))); // NOI18N

        rolbd1_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd1_Jcheck.setText("db_accessadmin");

        rolbd2_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd2_Jcheck.setText("db_backupoperator");

        rolbd3_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd3_Jcheck.setText("db_datareader");

        rolbd4_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd4_Jcheck.setText("db_datawriter");

        rolbd5_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd5_Jcheck.setText("db_ddladmin");

        rolbd6_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd6_Jcheck.setText("db_denydatareader");

        rolbd7_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd7_Jcheck.setText("db_denydatawriter");

        rolbd8_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd8_Jcheck.setText("db_owner");

        rolbd9_Jcheck.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        rolbd9_Jcheck.setText("db_securityadmin");

        javax.swing.GroupLayout RolesBD_JpanelLayout = new javax.swing.GroupLayout(RolesBD_Jpanel);
        RolesBD_Jpanel.setLayout(RolesBD_JpanelLayout);
        RolesBD_JpanelLayout.setHorizontalGroup(
            RolesBD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RolesBD_JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RolesBD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rolbd1_Jcheck)
                    .addComponent(rolbd2_Jcheck)
                    .addComponent(rolbd3_Jcheck)
                    .addComponent(rolbd4_Jcheck)
                    .addComponent(rolbd5_Jcheck)
                    .addComponent(rolbd6_Jcheck)
                    .addComponent(rolbd7_Jcheck)
                    .addComponent(rolbd8_Jcheck)
                    .addComponent(rolbd9_Jcheck))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        RolesBD_JpanelLayout.setVerticalGroup(
            RolesBD_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RolesBD_JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rolbd1_Jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolbd2_Jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolbd3_Jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolbd4_Jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolbd5_Jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolbd6_Jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolbd7_Jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rolbd8_Jcheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rolbd9_Jcheck)
                .addContainerGap())
        );

        javax.swing.GroupLayout PBases_JpanelLayout = new javax.swing.GroupLayout(PBases_Jpanel);
        PBases_Jpanel.setLayout(PBases_JpanelLayout);
        PBases_JpanelLayout.setHorizontalGroup(
            PBases_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBases_JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PBases_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RolesBD_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BD_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PBases_JpanelLayout.setVerticalGroup(
            PBases_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBases_JpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BD_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RolesBD_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Crear_Jboton.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        Crear_Jboton.setText("Crear");
        Crear_Jboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Crear_JbotonActionPerformed(evt);
            }
        });

        Eliminar_Jboton.setFont(new java.awt.Font("Microsoft Tai Le", 0, 14)); // NOI18N
        Eliminar_Jboton.setText("Eliminar");
        Eliminar_Jboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_JbotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addComponent(RolesS_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CContraseña_Jlabel)
                                    .addComponent(Contraseña_Jlabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Usuario_Jlabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Login_Jlabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Usuario_Jtext, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Login_Jtext, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Contraseña_Jtext, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(CContraseña_Jtext)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(Crear_Jboton)
                                .addGap(58, 58, 58)
                                .addComponent(Eliminar_Jboton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PBases_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PBases_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Login_Jlabel)
                    .addComponent(Login_Jtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Usuario_Jlabel)
                    .addComponent(Usuario_Jtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contraseña_Jlabel)
                    .addComponent(Contraseña_Jtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CContraseña_Jlabel)
                    .addComponent(CContraseña_Jtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RolesS_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Crear_Jboton)
                    .addComponent(Eliminar_Jboton))
                .addGap(22, 22, 22))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Crear_JbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Crear_JbotonActionPerformed
        // TODO add your handling code here:7
        String resul = null;
        if (ContraseñaVerificada() == true) {
            resul = CargueCrearUsuario.CrearServer(Login_Jtext.getText(), Usuario_Jtext.getText(), CContraseña_Jtext.getText(), checkRolesS(), checkDatabase(), checkRolesDB());
        } else {
            JOptionPane.showMessageDialog(rootPane, "No coinciden las contraseñas", "ERROR", 2);
        }
        try {
            if (resul.equals("true")) {
                JOptionPane.showMessageDialog(rootPane, " Creado Exitosamente " + Login_Jtext.getText(), "INFORMACION", 1);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(rootPane, resul, "ERROR", 2);
            }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_Crear_JbotonActionPerformed

    private void Eliminar_JbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_JbotonActionPerformed
        // TODO add your handling code here:
        String resul = CargueCrearUsuario.eliminarServer(Login_Jtext.getText());
        if (resul.equals("true")) {
            JOptionPane.showMessageDialog(rootPane, " Borrado Exitosamente " + Login_Jtext.getText(), "INFORMACION", 1);
            limpiar();
        } else {
            JOptionPane.showMessageDialog(rootPane, resul, "ERROR", 2);
        }
    }//GEN-LAST:event_Eliminar_JbotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearUsuarioServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuarioServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuarioServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuarioServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuarioServer().setVisible(true);
            }
        });
    }

    public Icon setIcono(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING));
        return icono;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BD_Jpanel;
    private javax.swing.JLabel CContraseña_Jlabel;
    private javax.swing.JPasswordField CContraseña_Jtext;
    private javax.swing.JLabel Contraseña_Jlabel;
    private javax.swing.JPasswordField Contraseña_Jtext;
    private javax.swing.JButton Crear_Jboton;
    private javax.swing.JButton Eliminar_Jboton;
    private javax.swing.JLabel Login_Jlabel;
    private javax.swing.JTextField Login_Jtext;
    private javax.swing.JPanel PBases_Jpanel;
    private javax.swing.JPanel RolesBD_Jpanel;
    private javax.swing.JPanel RolesS_Jpanel;
    private javax.swing.JLabel Usuario_Jlabel;
    private javax.swing.JTextField Usuario_Jtext;
    private static javax.swing.JCheckBox bd1_Jcheck;
    private static javax.swing.JCheckBox bd2_Jcheck;
    private static javax.swing.JCheckBox bd3_Jcheck;
    private static javax.swing.JCheckBox bd4_Jcheck;
    private static javax.swing.JCheckBox bd5_Jcheck;
    private static javax.swing.JCheckBox rol1_Jcheck;
    private static javax.swing.JCheckBox rol2_Jcheck;
    private static javax.swing.JCheckBox rol3_Jcheck;
    private static javax.swing.JCheckBox rol4_Jcheck;
    private static javax.swing.JCheckBox rol5_Jcheck;
    private static javax.swing.JCheckBox rol6_Jcheck;
    private static javax.swing.JCheckBox rol7_Jcheck;
    private static javax.swing.JCheckBox rol8_Jcheck;
    private static javax.swing.JCheckBox rolbd1_Jcheck;
    private static javax.swing.JCheckBox rolbd2_Jcheck;
    private static javax.swing.JCheckBox rolbd3_Jcheck;
    private static javax.swing.JCheckBox rolbd4_Jcheck;
    private static javax.swing.JCheckBox rolbd5_Jcheck;
    private static javax.swing.JCheckBox rolbd6_Jcheck;
    private static javax.swing.JCheckBox rolbd7_Jcheck;
    private static javax.swing.JCheckBox rolbd8_Jcheck;
    private static javax.swing.JCheckBox rolbd9_Jcheck;
    // End of variables declaration//GEN-END:variables
}
