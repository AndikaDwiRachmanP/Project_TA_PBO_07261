package Gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMenu extends Komponen {

    public GuiMenu() {
        initComponents();
    }

    void initComponents() {
        setTitle("Login");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(255, 400);  // #TODO: Rubah Ukuran Frame
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Halaman Admin");
        getContentPane().add(jButton1);
        jButton1.setBounds(51, 105, 135, 25);
        jButton1.addActionListener(e -> {
            new GuiAdmin().setVisible(true);
        });

        jButton2.setText("Halaman Customer");
        jButton2.addActionListener(evt -> {
            new GuiCustomer().setVisible(true);
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(51, 148, 135, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel4.setText("Menu");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(87, 55, 58, 32);

        jButton3.setText("Halaman Barang");
        jButton3.addActionListener(e -> {
            new GuiBarang().setVisible(true);
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(51, 191, 135, 25);

        jButton4.setText("Halaman Transaksi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });
        jButton4.addActionListener(e -> {
            new GuiTransaksiAdmin().setVisible(true);
        });
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 11));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 11));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 11));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 11));

        getContentPane().add(jButton4);
        jButton4.setBounds(50, 230, 135, 25);

        jButton5.setText("Logout");
        jButton5.addActionListener(e -> {
            new GuiLogin().setVisible(true);
            dispose();
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(51, 269, 135, 25);
        setVisible(true);


    }

    public void initComponentA(){  // #TODO: Ram's original
        setSize(300 , 300);
        setLayout(null);
        setLocationRelativeTo(null);

        btnCustomer.setBounds(5 , 10 , 275 , 100);
        btnCustomer.setFont(new Font("Arial" , Font.BOLD,17));
        add(btnCustomer);

        btnBarang.setBounds(4, 130 , 275 , 100);
        btnBarang.setFont(new Font("Arial" , Font.BOLD,17));
        add(btnBarang);

        
        btnCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiCustomer().setVisible(true);
            }
        });

        btnBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiBarang().setVisible(true);
            }
        });
        
        
    }
}
