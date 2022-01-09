package Entity;
import Helper.Koneksi;
import java.util.Date;

public class TransaksiEntity extends EntityAbstract {
    protected String nama;
    protected int stok;
    protected Double harga,total;
    
    public TransaksiEntity(){}

    public TransaksiEntity( String nama, int stok, Double harga, Double total) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.total = total;
    }


    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

}
