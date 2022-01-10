package Controller;
import AllObject.AllObjectModel;
import Entity.BarangEntity;
import Controller.ControllerInterface;
import Entity.CustomerEntity;

import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.ArrayList;

public class BarangController implements ControllerInterface {
    @Override
    public ArrayList<BarangEntity> getData(){
        return AllObjectModel.barangModel.getData();
    }
    public int UpdateBarang(int Id, String Nama, int Stok, Double Harga, Date updated_at){
        return AllObjectModel.barangModel.getupdate(Id, Nama, Stok, Harga, updated_at);
    }

    public static DefaultTableModel syncTable() {
        DefaultTableModel barangDataset = new DefaultTableModel();
        Object[] column = {"id", "nama","stok","harga","created_at","updated_at"};
        barangDataset.setColumnIdentifiers(column);
        ArrayList<BarangEntity> barang = AllObjectModel.barangModel.getData();
        for(BarangEntity i : barang) {
            Object[] data = new Object[6];
            data[0] = i.getId();
            data[1] = i.getNama();
            data[2] = i.getStok();
            data[3] = i.getHarga();
            data[4] = i.getCreated_at();
            data[5] = i.getUpdated_at();
            barangDataset.addRow(data);
        }
        return barangDataset;
    }

    public static DefaultTableModel syncTableCust() {
        DefaultTableModel barangDataset = new DefaultTableModel();
        Object[] column = {"id","nama","stok","harga"};
        barangDataset.setColumnIdentifiers(column);
        ArrayList<BarangEntity> barang = AllObjectModel.barangModel.getData();
        for(BarangEntity i : barang) {
            Object[] data = new Object[4];
            data[0] = i.getId();
            data[1] = i.getNama();
            data[2] = i.getStok();
            data[3] = i.getHarga();
            barangDataset.addRow(data);
        }
        return barangDataset;
    }

    public void insertBarang(int id, Date created_at, Date updated_at ,String nama, int stok, Double harga){
        AllObjectModel.barangModel.getInsert(new BarangEntity(0,created_at,updated_at,nama,stok, harga));
    }
   public void HapusBarang(int IdHapus){
       AllObjectModel.barangModel.Delete(IdHapus);
    }
   
    
}
