package Gui;


import AllObject.AllObjectController;
import AllObject.AllObjectModel;
import Entity.AdminEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GuiAdmin extends Komponen {

    public GuiAdmin() {
        initComponent();
    }
    private void initComponent() {
        setTitle("Login"); // #TODO: Dekorasi
        setSize(630, 330);  // #TODO: Rubah Ukuran Frame
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "ID", "Username", "Password"
                }
        ));
        jScrollPane1.setViewportView(jTable1);
        syncDatasets();

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 13, 375, 275);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin"));

        jLabel2.setText("Username");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        jLabel3.setText("Password");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = jTable1.rowAtPoint(e.getPoint());
                if (r >= 0 && r < jTable1.getRowCount()) {
                    jTable1.setRowSelectionInterval(r, r);
                } else {
                    jTable1.clearSelection();
                }

                int rowindex = jTable1.getSelectedRow();
                if (rowindex < 0)
                    return;
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {

                    JPopupMenu popup = rightCickTable();
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        jButton2.setText("Daftar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                String username = jTextField1.getText();
                String password = jPasswordField1.getText();

                if (username.isEmpty() && password.isEmpty()) {
                    JOptionPane.showConfirmDialog(GuiAdmin.this, "Field cannot be empty", "Error ocurred", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    return;
                }

                AllObjectController.adminController.insert(username, password);
                syncDatasets();
                jTextField1.setText("");
                jPasswordField1.setText("");
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jPasswordField1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 135, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(jButton2)
                                .addContainerGap(76, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(388, 13, 221, 275);
    }
    public void initComponents(){
        setSize(700 , 400);
        setLayout(null);
        setLocationRelativeTo(null);

        labelAdmin.setBounds(270 , 10 , 240 , 40);
        labelAdmin.setFont(new Font("Calibri", Font.BOLD,25));
        labelAdmin.setForeground(new Color(20,1,188));
        add(labelAdmin);

        btnMhs.setBounds(20 , 100 , 200 , 40);
        add(btnMhs);

        btnKeluar.setBounds(470 , 300 , 200 , 40);
        add(btnKeluar);

        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GuiMenu().setVisible(true);
            }
        });

        btnMhs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    new GUI_mahasiswa().setVisible(true);
            }
        });
    }

    private void syncDatasets() {
        jTable1.setModel(AllObjectController.adminController.syncTable());
    }

    private JPopupMenu rightCickTable() {
        JPopupMenu jPopupMenu1 = new JPopupMenu();

        JMenuItem jMenuItem1 = new JMenuItem("Edit");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = jTable1.getSelectedRow();
                String id, username, password;
                id = jTable1.getValueAt(number, 0).toString();
                username = jTable1.getValueAt(number, 1).toString();
                password = jTable1.getValueAt(number, 2).toString();


                AdminEntity admin = new AdminEntity();
                admin.setId(Integer.parseInt(id));
                admin.setName(username);
                admin.setPassword(password);
                new KlikKananAdmin(GuiAdmin.this, admin);
                syncDatasets();
            }
        });

        JMenuItem jMenuItem2 = new JMenuItem("Delete");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prompt = JOptionPane.showConfirmDialog(GuiAdmin.this, "Do you want to delete this data?",
                        "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (prompt == JOptionPane.YES_OPTION) {
                    int number = jTable1.getSelectedRow();
                    String index = jTable1.getValueAt(number, 0).toString();
                    AllObjectModel.adminModel.delete(Integer.parseInt(index));
                    syncDatasets();
                    JOptionPane.showMessageDialog(GuiAdmin.this, "Data deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        return jPopupMenu1;
    }
}
