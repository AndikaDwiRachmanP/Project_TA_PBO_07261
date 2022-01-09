package Gui;


import AllObject.AllObjectController;
import Controller.CustomerController;
import static Gui.GuiBarang.dateFormat;
import Gui.Komponen;

import java.awt.event.MouseAdapter;
import javax.swing.*;
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
    
    public GuiTransaksi() {
        initComponent();
    }

    public void initComponent(){
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

        
        labelTotal.setBounds(20 , 120 , 70 , 30);
        labelTotal.setFont(new Font("Arial" , Font.BOLD,14));
        txtTotal.setBounds(90 , 124, 150 , 20);
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

        
        sp_Mhs.setBounds(380 , 0 , 400 , 120);
        add(sp_Mhs);
        
        sp_Trans.setBounds(380 , 150 , 400 , 120);
        add(sp_Trans);
        
        
        btnInsert.setBounds(20 , 124 , 100 , 30);
        add(btnInsert);
        
        btnDelete.setBounds(240 , 180 , 100 , 30);
        add(btnDelete);
        cetakMhs();
        cetakTrans();
        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    success((MouseEvent) a);
                    int stok = Integer.parseInt(txtStok.getText());
                    Double harga = Double.parseDouble(txtHarga.getText());
                    Double total = stok*harga;
                    txtTotal.setText(String.valueOf(total));
                    AllObjectController.transaksiController.insertTrans(txtNama.getText(),stok,harga,total);
                    cetakTrans();
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
        
        tbl_Trans.addMouseListener(new MouseAdapter()
		{
                    @Override
			public void mouseClicked(MouseEvent me)
			{
				int pilih = tbl_Trans.getSelectedRow();
				if(pilih == -1)
				{
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

    public void cetakMhs(){
        modelBar.setRowCount(0);
        try{
                Object[] obj = new Object[4];
                for (int i=0;i<AllObjectController.barangController.getData().size();i++){ 
            obj[0] = AllObjectController.barangController.getData().get(i).getId();
            obj[1] = AllObjectController.barangController.getData().get(i).getNama();
            obj[2] = AllObjectController.barangController.getData().get(i).getStok();
            obj[3] = AllObjectController.barangController.getData().get(i).getHarga();
            
                modelBar.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void cetakTrans(){
        modelTrans.setRowCount(0);
        try{
                Object[] obj = new Object[4];
                for (int i=0;i<AllObjectController.transaksiController.getData().size();i++){
            obj[0] = AllObjectController.transaksiController.getData().get(i).getNama();
            obj[1] = AllObjectController.transaksiController.getData().get(i).getStok();
            obj[2] = AllObjectController.transaksiController.getData().get(i).getHarga();
            obj[3] = AllObjectController.transaksiController.getData().get(i).getTotal();
            
                modelTrans.addRow(obj);
            
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

