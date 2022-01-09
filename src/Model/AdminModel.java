package Model;
import Core.Main;
import Entity.AdminEntity;
import Entity.BarangEntity;
import Helper.Koneksi;

import java.sql.*;
import java.util.ArrayList;

public class AdminModel {
    private String sql;
    public Connection conn = Koneksi.getconection();
    public int checkAdmin(String nama, String password) { 
        int cek = 0;
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM admin WHERE username='"+nama+"' AND password='"+password+"'";
            ResultSet rs = stat.executeQuery(sql);
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(nama.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    System.out.println("berhasil login");
                    cek = rs.getInt("id");
                }
            }else{
                    System.out.println("gagal login");
                    cek=0;
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cek;
    }

    private PreparedStatement pstmt = null;

    public ArrayList<AdminEntity> getAdmin() {
        ArrayList<AdminEntity> adminData = new ArrayList<>();
        try {
            String sql = "select * from admin";
            conn = Koneksi.getconection();
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            System.out.println(pstmt.toString());
            while (rs.next()) {
                AdminEntity shoesEntity = new AdminEntity();
                shoesEntity.setId(rs.getInt("id"));
                shoesEntity.setName(rs.getString("username"));
                shoesEntity.setPassword(rs.getString("password"));
                adminData.add(shoesEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminData;
    }

    public void insertData_07264 (String name, String password) {
        try {
            String sql = ("INSERT INTO admin (username, password) VALUES ('%s', '%s');");
            sql = String.format(sql, name, password);
            conn = Koneksi.getconection();
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println(pstmt.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update (AdminEntity admin) {
        try {
            conn = Koneksi.getconection();
            String sql = "UPDATE admin t set t.username = '%s', t.password = '%s' where t.id = %d";
            sql = String.format(sql, admin.getName(), admin.getPassword(), admin.getId());
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println(pstmt.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }


    public void delete (int index) {
        try {
            conn = Koneksi.getconection();
            String sql = "DELETE FROM database_ta.admin WHERE id = %d";
            sql = String.format(sql, index);
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println(pstmt.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }


