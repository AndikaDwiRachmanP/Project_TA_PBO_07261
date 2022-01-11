package Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import AllObject.*;
import Entity.CustomerEntity;

public class GuiLoginCustomer extends Komponen {
    JButton btnloginadmin = new JButton();
    String pathicon;
    public GuiLoginCustomer(){
        initComponent();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponent() {

        setTitle("Login"); // #TODO: Dekorasi
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(270, 330);  // #TODO: Rubah Ukuran Frame
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 83, 60, 16);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(12, 106, 235, 22);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 146, 60, 16);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(12, 169, 235, 22);

        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nama = jTextField1.getText();
                String password = jPasswordField1.getText();
                try {
                    int cek = AllObjectController.customerController.checkCustomer(nama, password);
                    if (cek > 0) {
                        dispose();
                        new GuiTransaksi(cek).setVisible(true);
                    } else {
                        try {
                            cek = AllObjectController.customerController.checkCustomer(nama, password);
                            if (cek > 0) {
                                dispose();
                                new GuiTransaksi(cek).setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "GAGAL LOGIN");
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Cancelled");
                        }

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Cancelled");

                }
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 210, 74, 25);

        jButton1.setText("Login as Admin?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }

        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 210, 140, 25);
        jButton1.addActionListener(e -> {
                    new GuiLogin().setVisible(true);
                    dispose();
                });

        jLabel5.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel5.setText("CustomerLogin");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 30, 152, 32);
    }


}
