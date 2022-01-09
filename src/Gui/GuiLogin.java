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
                                new GuiTransaksi().setVisible(true);
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

        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Register?");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 213, 100, 16);
    }

    void initComponentA() { // #TODO: Ram's original
        setTitle("Login");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320, 480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        labelNama.setBounds(35, 250, 80, 25);
        add(labelNama);
        txtNama.setBounds(130, 250, 130, 25);
        add(txtNama);

        labelPassword.setBounds(35, 290, 80, 25);
        add(labelPassword);
        txtPassword.setBounds(130, 290, 130, 25);
        add(txtPassword);

        btnLogin.setBounds(110, 350, 100, 25);
        btnLogin.setBackground(Color.black);
        btnLogin.setForeground(Color.white);
        btnLogin.setBorder(null);
        add(btnLogin);

        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setForeground(Color.black);
                btnLogin.setBackground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setForeground(Color.white);
                btnLogin.setBackground(Color.black);
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                String password = txtPassword.getText();
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
                                new GuiTransaksi().setVisible(true);
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
    }
}
