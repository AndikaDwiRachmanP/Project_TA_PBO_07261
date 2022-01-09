package Controller;

import AllObject.AllObjectController;
import AllObject.AllObjectModel;
import Entity.AdminEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class AdminController {
    public int checkAdmin(String nama, String password){
        return AllObjectModel.adminModel.checkAdmin(nama, password);
    }

    public static DefaultTableModel syncTable() {
        DefaultTableModel adminDataset = new DefaultTableModel();
        Object[] column = {"ID", "Username", "Password"};
        adminDataset.setColumnIdentifiers(column);
        ArrayList<AdminEntity> shoes = AllObjectModel.adminModel.getAdmin();
        for(AdminEntity i : shoes) {
            Object[] data = new Object[3];
            data[0] = i.getId();
            data[1] = i.getName();
            data[2] = i.getPassword();
            adminDataset.addRow(data);
        }
        return adminDataset;
    }

    public void insert(String username, String password) {
        AllObjectModel.adminModel.insertData_07264(username, password);
    }
}
