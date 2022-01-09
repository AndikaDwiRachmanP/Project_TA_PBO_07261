package Controller;
import AllObject.AllObjectModel;
import Entity.TransaksiEntity;
import Controller.ControllerInterface;
import java.util.Date;
import java.util.ArrayList;

public class TransaksiController implements ControllerInterface {
    @Override
    public ArrayList<TransaksiEntity> getData(){
        return AllObjectModel.transaksiModel.getData();
    }
    
    public void insertTrans(String nama, int stok, Double harga,Double total){
        AllObjectModel.transaksiModel.getInsert(new TransaksiEntity(nama,stok, harga,total));
    }
    
    public void HapusTrans(String namHapus){
       AllObjectModel.transaksiModel.getdelete(namHapus);
    
    }
   
    
}
