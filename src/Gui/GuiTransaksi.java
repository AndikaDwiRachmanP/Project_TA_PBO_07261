package Gui;


import AllObject.AllObjectController;
import AllObject.AllObjectModel;
import Controller.BarangController;
import Controller.CustomerController;

import static Gui.GuiBarang.dateFormat;

import Controller.TransaksiController;
import Entity.CustomerEntity;
import Entity.TransaksiEntity;
import Gui.Komponen;
import com.sun.jdi.IntegerValue;

import java.awt.event.MouseAdapter;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuiTransaksi extends Komponen {
    DefaultTableModel modelBar;
    DefaultTableModel modelTrans;
    JScrollPane sp_Mhs = new JScrollPane();
    JScrollPane sp_Trans = new JScrollPane();
    JTable tbl_Mhs = new JTable();
    JTable tbl_Trans = new JTable();
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");
    Object a;
    Double currentPrice;
    private int customer_id, barang_id;
    private CustomerEntity customer = AllObjectModel.customerModel.getName(customer_id);

    public GuiTransaksi(int customer_id) {
        this.customer_id = customer_id;
        initComponent();
    }


    private void initComponent() {
        setTitle("Login"); // #TODO: Dekorasi
        setSize(940, 500);  // #TODO: Rubah Ukuran Frame
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Nama", "Stok", "Harga"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 432, 330);

        jTable1.setModel(BarangController.syncTableCust());


        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "ID", "Barang", "Jumlah", "Harga", "Harga Total"
                }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(460, 50, 452, 185);
        jTable2.setModel(AllObjectController.transaksiController.syncTableTransaksi(customer_id));

        jLabel1.setText("Barang");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 240, 60, 16);

        jLabel2.setText("Jumlah");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(460, 290, 60, 16);

        jTextField2.setEditable(false);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(460, 260, 232, 22);

        jTextField3.setEditable(false);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(460, 360, 232, 22);
        jTextField3.setText("0");

        jLabel3.setText("Harga");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(460, 340, 60, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Halaman Transaksi");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(350, 10, 230, 30);
        getContentPane().add(jSpinner1);
        jSpinner1.setBounds(460, 310, 232, 22);

        jButton1.setText("Beli");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String total = jTextField3.getText();
                int quantity = (int) jSpinner1.getValue();
                int cust_id = customer_id;
                int id_barang = barang_id;
                String namaBarang = jTextField2.getText();

                AllObjectController.transaksiController.insertTrans(cust_id, namaBarang, id_barang, quantity, Double.parseDouble(total));
                jTable1.setModel(BarangController.syncTableCust());
                jTable2.setModel(TransaksiController.syncTableTransaksi(customer_id));
                jTextField2.setText("");
                jTextField3.setText("");
                jSpinner1.setValue(Integer.valueOf(0));
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(700, 340, 100, 37);

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pilih = jTable1.getSelectedRow();
                if (pilih == -1) {
                    return;
                }

                int id = (int) jTable1.getValueAt(pilih, 0);
                String dimana = String.valueOf(id);
                barang_id = Integer.parseInt(dimana);
                // jTextField1.setText(dimana);
                String nama = (String) jTable1.getValueAt(pilih, 1);
                jTextField2.setText(nama);
                int stok = (int) jTable1.getValueAt(pilih, 2);
                String apa = String.valueOf(stok);
                Double harga = (Double) jTable1.getValueAt(pilih, 3);
                String kapan = String.valueOf(harga);
                currentPrice = Double.parseDouble(kapan);
                jTextField3.setText(kapan);
            }
        });

        jSpinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Integer getValue = (Integer) jSpinner1.getValue();
                Double totalHarga = getValue * currentPrice;
                jTextField3.setText(totalHarga.toString());
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
                    //rightCickTable();
                }
            }
        });
    }


    public void initComponenta() {
        setSize(1000, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        labelId.setBounds(20, 0, 70, 30);
        labelId.setFont(new Font("Arial", Font.BOLD, 14));
        txtId.setBounds(90, 4, 150, 20);
        add(labelId);
        add(txtId);

        labelNama.setBounds(20, 30, 70, 30);
        labelNama.setFont(new Font("Arial", Font.BOLD, 14));
        txtNama.setBounds(90, 34, 150, 20);
        add(labelNama);
        add(txtNama);

        labelStok.setBounds(20, 60, 70, 30);
        labelStok.setFont(new Font("Arial", Font.BOLD, 14));
        txtStok.setBounds(90, 64, 150, 20);
        add(labelStok);
        add(txtStok);

        labelHarga.setBounds(20, 90, 70, 30);
        labelHarga.setFont(new Font("Arial", Font.BOLD, 14));
        txtHarga.setBounds(90, 94, 150, 20);
        add(labelHarga);
        add(txtHarga);


        labelTotal.setBounds(20, 120, 70, 30);
        labelTotal.setFont(new Font("Arial", Font.BOLD, 14));
        txtTotal.setBounds(90, 124, 150, 20);
        add(labelTotal);
        add(txtTotal);

        sp_Mhs.setViewportView(tbl_Mhs);
        modelBar = (DefaultTableModel) tbl_Mhs.getModel();
        tbl_Mhs.setDefaultEditor(Object.class, null);
        modelBar.addColumn("Id");
        modelBar.addColumn("Nama");
        modelBar.addColumn("Stok");
        modelBar.addColumn("Harga");


        sp_Trans.setViewportView(tbl_Trans);
        modelTrans = (DefaultTableModel) tbl_Trans.getModel();
        tbl_Trans.setDefaultEditor(Object.class, null);
        modelTrans.addColumn("Nama");
        modelTrans.addColumn("Jumlah");
        modelTrans.addColumn("Harga");
        modelTrans.addColumn("Total");


        sp_Mhs.setBounds(380, 0, 400, 120);
        add(sp_Mhs);

        sp_Trans.setBounds(380, 150, 400, 120);
        add(sp_Trans);


        btnInsert.setBounds(20, 124, 100, 30);
        add(btnInsert);

        btnDelete.setBounds(240, 180, 100, 30);
        add(btnDelete);
        cetakMhs();
        cetakTrans();
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    success((MouseEvent) a);
                    int stok = Integer.parseInt(txtStok.getText());
                    Double harga = Double.parseDouble(txtHarga.getText());
                    Double total = stok * harga;
                    txtTotal.setText(String.valueOf(total));
                    // AllObjectController.transaksiController.insertTrans(txtNama.getText(),stok,harga,total);
                    cetakTrans();
                } catch (Exception ex) {
                    failed((MouseEvent) a);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    success((MouseEvent) a);
                    int id = Integer.parseInt(txtId.getText());
                    AllObjectController.barangController.HapusBarang(id);
                    cetakMhs();
                } catch (Exception ex) {
                    failed((MouseEvent) a);
                }
            }
        });

        tbl_Mhs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int pilih = tbl_Mhs.getSelectedRow();
                if (pilih == -1) {
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

        tbl_Trans.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int pilih = tbl_Trans.getSelectedRow();
                if (pilih == -1) {
                    return;
                }

                int id = (int) tbl_Trans.getValueAt(pilih, 0);
                String dimana = String.valueOf(id);
                txtId.setText(dimana);
                String nama = (String) tbl_Trans.getValueAt(pilih, 1);
                txtNama.setText(nama);
                int stok = (int) tbl_Trans.getValueAt(pilih, 2);
                String apa = String.valueOf(stok);
                txtStok.setText(apa);
                Double harga = (Double) tbl_Trans.getValueAt(pilih, 3);
                String kapan = String.valueOf(harga);
                txtHarga.setText(kapan);
            }
        });
    }

    public void cetakMhs() {
        modelBar.setRowCount(0);
        try {
            Object[] obj = new Object[4];
            for (int i = 0; i < AllObjectController.barangController.getData().size(); i++) {
                obj[0] = AllObjectController.barangController.getData().get(i).getId();
                obj[1] = AllObjectController.barangController.getData().get(i).getNama();
                obj[2] = AllObjectController.barangController.getData().get(i).getStok();
                obj[3] = AllObjectController.barangController.getData().get(i).getHarga();

                modelBar.addRow(obj);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cetakTrans() {
        modelTrans.setRowCount(0);
        try {
            Object[] obj = new Object[4];
            for (int i = 0; i < AllObjectController.transaksiController.getData().size(); i++) {
                obj[0] = AllObjectController.transaksiController.getData().get(i).getNama();
                obj[1] = AllObjectController.transaksiController.getData().get(i).getStok();
                obj[2] = AllObjectController.transaksiController.getData().get(i).getHarga();
                obj[3] = AllObjectController.transaksiController.getData().get(i).getTotal();

                modelTrans.addRow(obj);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

