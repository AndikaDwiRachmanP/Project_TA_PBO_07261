package Entity;
import Helper.Koneksi;
import java.util.Date;

public class TransaksiEntity extends EntityAbstract {
    protected String nama;
    protected int stok, id, id_cust, id_item;
    protected Double harga, total;


    public TransaksiEntity() {
    }

    public TransaksiEntity(String nama, int id, int id_cust, int id_item, int stok, Double harga, Double total) {
        this.id = id;
        this.id_cust = id_cust  ;
        this.nama = nama;
        this.stok = stok;
        this.total = total;
        this.id_item = id_item
        ;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_cust(int id_cust) {
        this.id_cust = id_cust;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getId_cust() {
        return id_cust;
    }

    public int getId_item() {
        return id_item;
    }

    public Double getHarga() {
        return harga;
    }

    public Double getTotal() {
        return total;
    }
}
