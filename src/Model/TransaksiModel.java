package Model;

import Entity.TransaksiEntity;
import Helper.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Timestamp;


public class TransaksiModel extends ModelAbstract {
    Date date = new Date();
    protected static ArrayList<TransaksiEntity> transEntity = new ArrayList<TransaksiEntity>();
    private String sql;
    public Connection conn = Koneksi.getconection();


    public ArrayList<TransaksiEntity> getData(){
        ArrayList<TransaksiEntity> arraylistTransaksi = new ArrayList<>();
        try{
                Statement stat = conn.createStatement();
                sql = "select\n" +
                        "\t*\n" +
                        "from\n" +
                        "\ttransaksiv2 t\n" +
                        "left join customer c on\n" +
                        "\tt.id_cust = c.id\n" +
                        "left join barang b on\n" +
                        "\tt.id_item = b.id";
                ResultSet rs = stat.executeQuery(sql);
                while(rs.next()){
                    TransaksiEntity transaksi = new TransaksiEntity();
                    transaksi.setId(rs.getInt(1));
                    transaksi.setId_cust(rs.getInt(2));
                    transaksi.setId_item(rs.getInt(6));
                    transaksi.setNama(rs.getString(3));
                    transaksi.setHarga(rs.getDouble(5));
                    transaksi.setStok(rs.getInt(4));
                    arraylistTransaksi.add(transaksi);
                }
            }catch(SQLException e){
            e.printStackTrace();
        }
        return arraylistTransaksi;
    }

    public ArrayList<TransaksiEntity> getDataByID(int id_cust) {
        ArrayList<TransaksiEntity> arraylistTransaksi = new ArrayList<>();
        try{
            Statement stat = conn.createStatement();
            sql = "select\n" +
                    "\t*\n" +
                    "from\n" +
                    "\ttransaksiv2 t\n" +
                    "left join customer c on\n" +
                    "\tt.id_cust = c.id\n" +
                    "left join barang b on\n" +
                    "\tt.id_item = b.id where t.id_cust = " + id_cust;
            ResultSet rs = stat.executeQuery(sql);
            System.out.println(stat.toString());
            while(rs.next()){
                TransaksiEntity transaksi = new TransaksiEntity();
                transaksi.setId(rs.getInt(1));
                transaksi.setId_cust(rs.getInt(2));
                transaksi.setId_item(rs.getInt(6));
                transaksi.setNama(rs.getString(3));
                transaksi.setHarga(rs.getDouble(5));
                transaksi.setStok(rs.getInt(4));
                arraylistTransaksi.add(transaksi);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return arraylistTransaksi;
    }

    public void Delete(int id) {
        try {
            Statement stat = conn.createStatement();
            String sql = String.format("DELETE FROM transaksiv2 WHERE id=%d", id);
            stat.execute(sql);
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getInsert(TransaksiEntity transaksiEntity){
        try{
                sql = "INSERT INTO database_ta.transaksiv2 (id_cust, item_name, quantity, total, id_item) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,transaksiEntity.getId_cust());
            preparedStatement.setString(2,transaksiEntity.getNama());
            preparedStatement.setInt(3,transaksiEntity.getStok());
            preparedStatement.setDouble(4,transaksiEntity.getHarga());
            preparedStatement.setInt(5,transaksiEntity.getId_item());
            System.out.println(preparedStatement.toString());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<TransaksiEntity> getdelete(String nama) {
         ArrayList<TransaksiEntity> arraylistTransaksi = new ArrayList<>();
    
     try {
           Statement stat = conn.createStatement();
            // buat query hapus
            String sql = String.format("DELETE FROM transaksi WHERE nama=%s", nama);

            // hapus data
            stat.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
     return arraylistTransaksi;
       }
}
