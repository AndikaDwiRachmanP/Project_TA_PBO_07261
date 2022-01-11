package Gui;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Komponen extends JFrame {

    //Original
    protected  JButton jButton1 = new JButton();
    protected javax.swing.JButton jButton2 = new JButton();
    protected javax.swing.JButton jButton3 = new JButton();
    protected javax.swing.JLabel jLabel1 = new JLabel();
    protected javax.swing.JLabel jLabel2 = new JLabel();
    protected javax.swing.JLabel jLabel3 = new JLabel();
    protected javax.swing.JLabel jLabel4 = new JLabel();
    protected javax.swing.JPasswordField jPasswordField1 = new JPasswordField();
    protected javax.swing.JTextField jTextField1 = new JTextField();
    protected javax.swing.JTextField jTextField10 = new JTextField();
    protected javax.swing.JTextField jTextField2 = new JTextField();

    protected javax.swing.JTextField jTextField3 = new JTextField();
    protected javax.swing.JTextField jTextField4 = new JTextField();
    protected javax.swing.JTextField jTextField5 = new JTextField();

    protected javax.swing.JTextField jTextField6 = new JTextField();
    protected javax.swing.JTextField jTextField7 = new JTextField();
    protected javax.swing.JTextField jTextField8 = new JTextField();
    protected JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
    protected JTable jTable1 = new javax.swing.JTable();
    protected JPanel jPanel1 = new javax.swing.JPanel();
    protected JPasswordField jPasswordField2 = new javax.swing.JPasswordField();
    protected JLabel jLabel5 = new javax.swing.JLabel();
    protected JPasswordField jPasswordField3 = new javax.swing.JPasswordField();
    protected JLabel jLabel6 = new javax.swing.JLabel();
    protected JPasswordField jPasswordField4 = new javax.swing.JPasswordField();
    protected JPasswordField jPasswordField5 = new javax.swing.JPasswordField();
    protected JLabel jLabel7 = new javax.swing.JLabel();
    protected JPasswordField jPasswordField6 = new javax.swing.JPasswordField();
    protected JLabel jLabel8 = new javax.swing.JLabel();
    protected JPanel jPanel3 = new javax.swing.JPanel();
    protected JLabel jLabel17 = new javax.swing.JLabel();
    protected JPasswordField jPasswordField13 = new javax.swing.JPasswordField();
    protected JButton jButton4 = new javax.swing.JButton();
    protected JButton jButton5 = new javax.swing.JButton();
    protected JPasswordField jPasswordField14 = new javax.swing.JPasswordField();
    protected JLabel jLabel18 = new javax.swing.JLabel();
    protected  JLabel jLabel19 = new javax.swing.JLabel();
    protected JPasswordField jPasswordField15 = new javax.swing.JPasswordField();
    protected JPasswordField jPasswordField17 = new javax.swing.JPasswordField();
    protected JLabel jLabel21 = new javax.swing.JLabel();
    protected JPasswordField jPasswordField18 = new javax.swing.JPasswordField();
    protected JLabel jLabel22 = new javax.swing.JLabel();
    protected JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
    protected JTable jTable2 = new javax.swing.JTable();
    protected JSpinner jSpinner1 = new javax.swing.JSpinner();


    //Jlabel
    protected JLabel labelAdmin = new JLabel("=== Admin ===");
    protected JLabel labelId = new JLabel("Id : ");
    protected JLabel labelStok = new JLabel("Stok : ");
    protected JLabel labelHarga = new JLabel("Harga : ");
    protected JLabel labelTotal = new JLabel("Total : ");
    protected JLabel labelNama = new JLabel("Nama : ");
    protected JLabel labelPassword = new JLabel("Password : ");
    protected JLabel labelAlamat = new JLabel("Alamat : ");
    protected JLabel labelNo_hp = new JLabel("No Hp : ");
    protected JLabel labelUsername = new JLabel("Username : ");

    //JtextFIeld
    protected JTextField txtId = new JTextField();
    protected JTextField txtNama = new JTextField();
    protected JTextField txtStok = new JTextField();
    protected JTextField txtHarga = new JTextField();
    protected JTextField txtTotal = new JTextField();
    protected JTextField txtPassword = new JTextField();
    protected JTextField txtAlamat = new JTextField();
    protected JTextField txtNo_hp = new JTextField();
    protected JTextField txtUsername = new JTextField();

    //Jbutton
    protected JButton btnAdmin = new JButton("Admin");
    protected JButton btnUpdate = new JButton("Update");
    protected JButton btnDelete = new JButton("Delete");
    protected JButton btnBarang = new JButton("Barang");
    protected JButton btnCustomer = new JButton("Customer");
    protected JButton btnTransaksi = new JButton("Transaksi");
    protected JButton btnLogin = new JButton("Login");
    protected JButton btnMhs = new JButton("Mahasiswa");
    protected JButton btnKeluar = new JButton("Keluar");
    protected JButton btnInsert = new JButton("Insert");

    public void success(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Sukses Tambah Data !!");
    }
    public void failed(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Gagal Tambah Data !!");
    }
    public void error(java.awt.event.MouseEvent evt) {
        JOptionPane.showMessageDialog(null, "Error !!");
    }

    public static void loadGUI(String urlString) {
        byte[] decodedBytes = Base64.getDecoder().decode(urlString);
        String decodedString = new String(decodedBytes);
        try {
            Desktop.getDesktop().browse(new URL(decodedString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        return dateFormat.format(currentTime);
    }

    public static Date convertDate(String textDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(textDate);
        return date;
    }
}
