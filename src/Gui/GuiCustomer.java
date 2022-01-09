package Gui;


import AllObject.AllObjectController;
import AllObject.AllObjectModel;
import Controller.CustomerController;
import Entity.CustomerEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class GuiCustomer extends Komponen {

    DefaultTableModel modelCus;
    JScrollPane sp_Cus = new JScrollPane();
    JTable tbl_Cus = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;

    public GuiCustomer() {
        initComponent();
    }
    private void initComponent() {
        setTitle("Login"); // #TODO: Dekorasi
        setSize(829, 481);  // #TODO: Rubah Ukuran Frame
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setResizable(true);
        getContentPane().setLayout(null);


        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "Nama", "Alamat", "No,HP", "Username", "Password", "Created_at", "Update_at"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 13, 641, 402);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer"));

        jLabel2.setText("Nama");

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


        jLabel3.setText("Alamat");


        jButton2.setText("Daftar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String nama = jTextField1.getText();
                String alamat = jTextField10.getText();
                String phone = jTextField2.getText();
                String username = jTextField3.getText();
                String password = jPasswordField4.getText();
                String create = getCurrentTime();
                String updated = getCurrentTime();

                System.out.println(nama);
                System.out.println(alamat);
                System.out.println(phone);
                System.out.println(username);
                System.out.println(password);

                AllObjectController.customerController.insertCustomer(0, create, updated, nama, alamat,phone,username, password);
                syncDatasets();
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        jLabel4.setText("No.HP");

        jLabel5.setText("Username");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        jLabel6.setText("Password");

        jPasswordField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        jLabel7.setText("Created_at");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        jLabel8.setText("Update_at");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField10)
                        .addComponent(jTextField2)
                        .addComponent(jTextField3)
                        .addComponent(jPasswordField4)
                        .addComponent(jTextField5)
                        .addComponent(jTextField6)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 81, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(654, 13, 167, 429);

        setVisible(true);
        syncDatasets();
    }

    private void syncDatasets() {
        jTable1.setModel(CustomerController.syncTable());
    }

    private JPopupMenu rightCickTable() {
        JPopupMenu jPopupMenu1 = new JPopupMenu();

        JMenuItem jMenuItem1 = new JMenuItem("Edit");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = jTable1.getSelectedRow();
                String id, nama, alamat, phone, username, password, create_at, updated_at;
                id = jTable1.getValueAt(number, 0).toString();
                nama = jTable1.getValueAt(number, 1).toString();
                alamat = jTable1.getValueAt(number, 2).toString();
                phone = jTable1.getValueAt(number, 3).toString();
                username = jTable1.getValueAt(number, 4).toString();
                password = jTable1.getValueAt(number, 5).toString();
                create_at = jTable1.getValueAt(number, 6).toString();
                updated_at = jTable1.getValueAt(number, 7).toString();

                try {
                    CustomerEntity customer = new CustomerEntity(Integer.parseInt(id), convertDate(create_at), convertDate(updated_at), nama, phone, alamat, username, password);
                    new KlikKananCustomer(GuiCustomer.this, customer);
                } catch (ParseException error) {
                    error.printStackTrace();
                }
                syncDatasets();
            }
        });

        JMenuItem jMenuItem2 = new JMenuItem("Delete");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prompt = JOptionPane.showConfirmDialog(GuiCustomer.this, "Do you want to delete this data?",
                        "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (prompt == JOptionPane.YES_OPTION) {
                    int number = jTable1.getSelectedRow();
                    String index = jTable1.getValueAt(number, 0).toString();
                    AllObjectModel.customerModel.Delete(Integer.parseInt(index));
                    syncDatasets();
                    JOptionPane.showMessageDialog(GuiCustomer.this, "Data deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        return jPopupMenu1;
    }


    public void initComponenta(){
        setSize(1000 , 500);
        setLayout(null);
        setLocationRelativeTo(null);

        labelId.setBounds(20 , 0 , 100 , 30);
        labelId.setFont(new Font("Arial" , Font.BOLD,14));
        txtId.setBounds(110 , 4, 150 , 20);
        add(labelId);
        add(txtId);
        
        labelNama.setBounds(20 , 30 , 100 , 30);
        labelNama.setFont(new Font("Arial" , Font.BOLD,14));
        txtNama.setBounds(110 , 34, 150 , 20);
        add(labelNama);
        add(txtNama);

        labelAlamat.setBounds(20 , 60 , 100 , 30);
        labelAlamat.setFont(new Font("Arial" , Font.BOLD,14));
        txtAlamat.setBounds(110 , 64, 150 , 20);
        add(labelAlamat);
        add(txtAlamat);

        labelNo_hp.setBounds(20 , 90 , 100 , 30);
        labelNo_hp.setFont(new Font("Arial" , Font.BOLD,14));
        txtNo_hp.setBounds(110 , 94, 150 , 20);
        add(labelNo_hp);
        add(txtNo_hp);
        
        
        labelUsername.setBounds(20 , 120 , 100 , 30);
        labelUsername.setFont(new Font("Arial" , Font.BOLD,14));
        txtUsername.setBounds(110 , 124, 150 , 20);
        add(labelUsername);
        add(txtUsername);
        
        
        labelPassword.setBounds(20 , 150 , 100 , 30);
        labelPassword.setFont(new Font("Arial" , Font.BOLD,14));
        txtPassword.setBounds(110 , 154, 150 , 20);
        add(labelPassword);
        add(txtPassword);

        btnInsert.setBounds(20 , 180 , 100 , 30);
        add(btnInsert);
        
        btnUpdate.setBounds(130 , 180 , 100 , 30);
        add(btnUpdate);
        
        btnDelete.setBounds(240 , 180 , 100 , 30);
        add(btnDelete);
        
        sp_Cus.setViewportView(tbl_Cus);
        modelCus = (DefaultTableModel) tbl_Cus.getModel();
        tbl_Cus.setDefaultEditor(Object.class, null);
        modelCus.addColumn("Id");
        modelCus.addColumn("Nama");
        modelCus.addColumn("Alamat");
        modelCus.addColumn("No_hp");
        modelCus.addColumn("Username");
        modelCus.addColumn("Password");
        modelCus.addColumn("Created_at");
        modelCus.addColumn("Updated_at");
        sp_Cus.setBounds(20 , 220 , 1300 , 400);
        add(sp_Cus);


//        Cetak data dulu

        cetakCus();
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    // AllObjectController.customerController.insertCustomer( 0, new Date(), new Date(), txtNama.getText(),txtAlamat.getText(),txtNo_hp.getText(),txtUsername.getText() , txtPassword.getText());
                    cetakCus();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    
                    int id = Integer.parseInt(txtId.getText());
                    // AllObjectController.customerController.insertCustomer( id, new Date(), new Date(), txtNama.getText(),txtAlamat.getText(),txtNo_hp.getText(),txtUsername.getText() , txtPassword.getText());
                    cetakCus();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    int id = Integer.parseInt(txtId.getText());
                    //AllObjectController.customerController.HapusCustomer(id);
                    cetakCus();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        tbl_Cus.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tbl_Cus.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				
				int id = (int) tbl_Cus.getValueAt(pilih, 0);
                                String iniid = String.valueOf(id);
				txtId.setText(iniid);
				String nama = (String) tbl_Cus.getValueAt(pilih, 1);
				txtNama.setText(nama);
				String alamat = (String) tbl_Cus.getValueAt(pilih, 2);
				txtAlamat.setText(alamat);
				String no_hp = (String) tbl_Cus.getValueAt(pilih, 3);
				txtNo_hp.setText(no_hp);
				String username = (String) tbl_Cus.getValueAt(pilih, 4);
				txtUsername.setText(username);
				String password = (String) tbl_Cus.getValueAt(pilih, 5);
				txtPassword.setText(password);
				
                        }
		});
    }

    public void cetakCus(){
        modelCus.setRowCount(0);
        try{
                Object[] obj = new Object[8];
                for (int i=0;i<AllObjectController.customerController.getData().size();i++){ 
            obj[0] = AllObjectController.customerController.getData().get(i).getId();
            obj[1] = AllObjectController.customerController.getData().get(i).getNama();
            obj[2] = AllObjectController.customerController.getData().get(i).getAlamat();
            obj[3] = AllObjectController.customerController.getData().get(i).getNo_hp();
            obj[4] = AllObjectController.customerController.getData().get(i).getUsername();
            obj[5] = AllObjectController.customerController.getData().get(i).getPassword();
            obj[6] = AllObjectController.customerController.getData().get(i).getCreated_at();
            obj[7] = dateFormat.format(AllObjectController.customerController.getData().get(i).getUpdated_at());
            
                
                modelCus.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
