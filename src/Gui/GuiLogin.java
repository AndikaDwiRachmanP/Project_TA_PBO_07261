package Gui;

import AllObject.AllObjectController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiLogin extends Komponen {
    public GuiLogin() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Login"); // #TODO: Dekorasi
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(280, 350);  // #TODO: Rubah Ukuran Frame
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);

        getContentPane().add(jTextField1);
        jTextField1.setBounds(12, 106, 235, 22);

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setText("Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(192, 21, 55, 32);  // #TODO: Change layout size

        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 83, 100, 16);

        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 146, 100, 16);

        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(12, 169, 235, 22);

        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nama = jTextField1.getText();
                String password = jPasswordField1.getText();
                try {
                    int cek = AllObjectController.adminController.checkAdmin(nama, password);
                    if (cek > 0) {
                        dispose();
                        new GuiMenu().setVisible(true);

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
        jButton2.setBounds(173, 209, 74, 25);

        jButton3.setText("Kembali");
        getContentPane().add(jButton3);
        jButton3.setBounds(90, 209, 80, 25);
        jButton3.addActionListener(e -> {
            new GuiLoginCustomer().setVisible(true);
            dispose();
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 255));

        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 213, 100, 16);
    }


}
