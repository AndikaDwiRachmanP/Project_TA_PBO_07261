package Controller;
import AllObject.AllObjectController;
import AllObject.AllObjectModel;
import Entity.BarangEntity;
import Entity.TransaksiEntity;
import Controller.ControllerInterface;

import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.ArrayList;

public class TransaksiController implements ControllerInterface {
    @Override
    public ArrayList<TransaksiEntity> getData(){
        return AllObjectModel.transaksiModel.getData();
    }
    
    public void insertTrans(int id_cust, String nama_barang, int id_item, int total, Double harga){
        TransaksiEntity transaksi = new TransaksiEntity();
        transaksi.setId_cust(id_cust);
        transaksi.setId_item(id_item);
        transaksi.setNama(nama_barang);
        transaksi.setHarga(harga);
        transaksi.setStok(total);
        AllObjectModel.transaksiModel.getInsert(transaksi);
    }

    public static DefaultTableModel syncTableTransaksi(int customer_id) {
        DefaultTableModel transaksiDataset = new DefaultTableModel();
        Object[] column = {"ID", "Barang", "Jumlah", "Total"};
        transaksiDataset.setColumnIdentifiers(column);
        ArrayList<TransaksiEntity> barang = AllObjectModel.transaksiModel.getDataByID(customer_id);
        for (TransaksiEntity i : barang) {
            String namaItem = AllObjectModel.barangModel.getNamaBarang(i.getId_item());
            System.out.println(namaItem);
            Object[] data = new Object[4];
            data[0] = i.getId();
            data[1] = namaItem;
            data[2] = i.getStok();
            data[3] = i.getHarga();
            transaksiDataset.addRow(data);
        }
        return transaksiDataset;
    }

    public static DefaultTableModel syncTableforAdmin() {
        DefaultTableModel transaksiDataset = new DefaultTableModel();
        Object[] column = {"ID", "ID Cust",  "Barang", "Jumlah", "Total", "ID Item"};
        transaksiDataset.setColumnIdentifiers(column);
        ArrayList<TransaksiEntity> barang = AllObjectModel.transaksiModel.getData();
        for (TransaksiEntity i : barang) {
            String namaItem = AllObjectModel.barangModel.getNamaBarang(i.getId_item());
            System.out.println(namaItem);
            Object[] data = new Object[6];
            data[0] = i.getId();
            data[1] = i.getId_cust();
            data[2] = i.getNama();
            data[3] = i.getStok();
            data[4] = i.getHarga();
            data[5] = i.getId_item();
            transaksiDataset.addRow(data);
        }
        return transaksiDataset;
    }

    public void HapusTrans(String namHapus){
       AllObjectModel.transaksiModel.getdelete(namHapus);
    }
   
    
}
