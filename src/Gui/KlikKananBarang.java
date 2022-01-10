package Gui;

import AllObject.AllObjectModel;
import Entity.AdminEntity;
import Entity.BarangEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class KlikKananBarang extends JDialog{
    private BarangEntity barang;
    private JButton jButton1 = new JButton();
    private JComboBox<String> jComboBox1 = new JComboBox<>();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField3 = new JTextField();

    public KlikKananBarang(JFrame parent, BarangEntity barang) {
        super(parent);
        setTitle("Edit Data");
        setSize(350, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setResizable(false);
        this.barang = barang;
        this.initComponent();

        setModal(true);
        setVisible(true);
    }

    private void initComponent() {
        jLabel1.setText("Nama");
        add(jLabel1);
        jLabel1.setBounds(12, 27, 80, 16);

        add(jTextField1);
        jTextField1.setBounds(12, 50, 306, 22);
        jTextField1.setText(barang.getNama());


        jLabel2.setText("Stok");
        add(jLabel2);
        jLabel2.setBounds(12, 90, 40, 16);

        add(jTextField2);
        jTextField2.setBounds(12, 113, 306, 22);
        jTextField2.setText(barang.getStok().toString());

        jLabel3.setText("Harga");
        add(jLabel3);
        jLabel3.setBounds(12, 153, 40, 16);

        add(jTextField3);
        jTextField3.setBounds(12, 176, 306, 22);
        jTextField3.setText(barang.getStok().toString());

        jButton1.setText("Save");
        add(jButton1);
        jButton1.setBounds(240, 216, 80, 25);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AllObjectModel.barangModel.getupdate(barang.getId(), jTextField1.getText(), Integer.parseInt(jTextField2.getText()),Double.parseDouble(jTextField3.getText()), Komponen.convertDate(Komponen.getCurrentTime()));
                    dispose();
                } catch (ParseException err) {
                    err.printStackTrace();
                }
            }
        });
    }
}
