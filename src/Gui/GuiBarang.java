package Gui;


import AllObject.AllObjectController;
import AllObject.AllObjectModel;
import Controller.BarangController;
import Controller.CustomerController;
import Entity.BarangEntity;
import Entity.CustomerEntity;
import Gui.Komponen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GuiBarang extends Komponen {

    DefaultTableModel modelBar;
    JScrollPane sp_Mhs = new JScrollPane();
    JTable tbl_Mhs = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;

    public GuiBarang() {
        initComponent();
    }

    private void initComponent() {

        setTitle("Login"); // #TODO: Dekorasi
        setSize(720, 580);  // #TODO: Rubah Ukuran Frame
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);

        getContentPane().setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer"));

        jLabel17.setText("Nama");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jButton4.setText("Daftar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = jTextField3.getText();
                String stock_string = jTextField4.getText();
                String harga_string = jTextField5.getText();
                Integer stock = Integer.parseInt(stock_string);
                Double harga = Double.parseDouble(harga_string);
                String create = getCurrentTime();
                String update = getCurrentTime();

                System.out.println(name);
                System.out.println(harga);
                System.out.println(stock);

                try {
                    AllObjectController.barangController.insertBarang(0, convertDate(create), convertDate(update), name, stock, harga);
                    syncDatasets();
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField5.setText("");

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jLabel18.setText("Stock");

        jLabel19.setText("Harga");

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


        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jLabel21.setText("Created_at");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            }
        });

        jLabel22.setText("Update_at");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3)
                        .addComponent(jTextField4)
                        .addComponent(jTextField5)
                        .addComponent(jTextField7)
                        .addComponent(jTextField8)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 81, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel22))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addGap(52, 52, 52))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(588, 13, 167, 330);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "ID", "Nama", "Stock", "Harga", "Created_at", "Update_at"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 13, 575, 330);

        syncDatasets();

    }

    private void syncDatasets() {
        jTable1.setModel(BarangController.syncTable());
    }

    private JPopupMenu rightCickTable() {
        JPopupMenu jPopupMenu1 = new JPopupMenu();

        JMenuItem jMenuItem1 = new JMenuItem("Edit");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = jTable1.getSelectedRow();
                String id, nama, stock, harga, create_at, updated_at;
                id = jTable1.getValueAt(number, 0).toString();
                nama = jTable1.getValueAt(number, 1).toString();
                stock = jTable1.getValueAt(number, 2).toString();
                harga = jTable1.getValueAt(number, 3).toString();
                create_at = jTable1.getValueAt(number, 4).toString();
                updated_at = jTable1.getValueAt(number, 5).toString();

                try {
                    BarangEntity barang = new BarangEntity(Integer.parseInt(id), convertDate(create_at), convertDate(updated_at), nama, Integer.parseInt(stock), Double.parseDouble(harga));
                    new KlikKananBarang(GuiBarang.this, barang);
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
                int prompt = JOptionPane.showConfirmDialog(GuiBarang.this, "Do you want to delete this data?",
                        "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (prompt == JOptionPane.YES_OPTION) {
                    int number = jTable1.getSelectedRow();
                    String index = jTable1.getValueAt(number, 0).toString();
                    AllObjectModel.barangModel.Delete(Integer.parseInt(index));
                    syncDatasets();
                    JOptionPane.showMessageDialog(GuiBarang.this, "Data deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        return jPopupMenu1;
    }



    public void initComponenta(){
        setSize(1000 , 500);
        setLayout(null);
        setLocationRelativeTo(null);

        labelId.setBounds(20 , 0 , 70 , 30);
        labelId.setFont(new Font("Arial" , Font.BOLD,14));
        txtId.setBounds(90 , 4, 150 , 20);
        add(labelId);
        add(txtId);
        
        labelNama.setBounds(20 , 30 , 70 , 30);
        labelNama.setFont(new Font("Arial" , Font.BOLD,14));
        txtNama.setBounds(90 , 34, 150 , 20);
        add(labelNama);
        add(txtNama);

        labelStok.setBounds(20 , 60 , 70 , 30);
        labelStok.setFont(new Font("Arial" , Font.BOLD,14));
        txtStok.setBounds(90 , 64, 150 , 20);
        add(labelStok);
        add(txtStok);

        labelHarga.setBounds(20 , 90 , 70 , 30);
        labelHarga.setFont(new Font("Arial" , Font.BOLD,14));
        txtHarga.setBounds(90 , 94, 150 , 20);
        add(labelHarga);
        add(txtHarga);

        sp_Mhs.setViewportView(tbl_Mhs);
        modelBar = (DefaultTableModel) tbl_Mhs.getModel();
        tbl_Mhs.setDefaultEditor(Object.class, null);
        modelBar.addColumn("Id");
        modelBar.addColumn("Nama");
        modelBar.addColumn("Stok");
        modelBar.addColumn("Harga");
        modelBar.addColumn("Created_at");
        modelBar.addColumn("Updated_at");
        sp_Mhs.setBounds(380 , 30 , 400 , 400);
        add(sp_Mhs);
        btnInsert.setBounds(20 , 180 , 100 , 30);
        add(btnInsert);
        
        btnUpdate.setBounds(130 , 180 , 100 , 30);
        add(btnUpdate);
        
        btnDelete.setBounds(240 , 180 , 100 , 30);
        add(btnDelete);

//        Cetak data dulu

        cetakMhs();
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    int stok = Integer.parseInt(txtStok.getText());
                    Double harga = Double.parseDouble(txtHarga.getText());
                    AllObjectController.barangController.insertBarang( 0, new Date(), new Date(), txtNama.getText(),stok,harga);
                    cetakMhs();
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
                    int stok = Integer.parseInt(txtStok.getText());
                    Double harga = Double.parseDouble(txtHarga.getText());
                    AllObjectController.barangController.UpdateBarang(id,txtNama.getText(),stok,harga,new Date());
                    cetakMhs();
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
                    AllObjectController.barangController.HapusBarang(id);
                    cetakMhs();
                }catch (Exception ex){
                    failed((MouseEvent) a);
                }
            }
        });
        tbl_Mhs.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tbl_Mhs.getSelectedRow();
				if(pilih == -1)
				{
					return;
				}
				
				int id = (int) tbl_Mhs.getValueAt(pilih, 0);
                                String dimana = String.valueOf(id);
				txtId.setText(dimana);
				String nama = (String) tbl_Mhs.getValueAt(pilih, 1);
				txtNama.setText(nama);
				int stok = (int) tbl_Mhs.getValueAt(pilih, 2);
                                String apa = String.valueOf(stok);
				txtStok.setText(apa);
				Double harga = (Double) tbl_Mhs.getValueAt(pilih, 3);
                                String kapan = String.valueOf(harga);
				txtHarga.setText(kapan);
                        }
		});
    }

    public void cetakMhs(){
        modelBar.setRowCount(0);
        try{
                Object[] obj = new Object[6];
                for (int i=0;i<AllObjectController.barangController.getData().size();i++){ 
            obj[0] = AllObjectController.barangController.getData().get(i).getId();
            obj[1] = AllObjectController.barangController.getData().get(i).getNama();
            obj[2] = AllObjectController.barangController.getData().get(i).getStok();
            obj[3] = AllObjectController.barangController.getData().get(i).getHarga();
            obj[4] = AllObjectController.barangController.getData().get(i).getCreated_at();
            obj[5] = dateFormat.format(AllObjectController.barangController.getData().get(i).getUpdated_at());
            
                
                modelBar.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
