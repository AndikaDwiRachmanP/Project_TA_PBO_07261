package Gui;

import AllObject.AllObjectModel;
import Entity.AdminEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlikKananAdmin extends JDialog{
    private AdminEntity admin;
    private JButton jButton1 = new JButton();
    private JComboBox<String> jComboBox1 = new JComboBox<>();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();

    public KlikKananAdmin(JFrame parent, AdminEntity admin) {
        super(parent);
        setTitle("Edit Data");
        setSize(350, 300);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setResizable(false);
        this.admin = admin;
        this.initComponent();

        setModal(true);
        setVisible(true);
    }

    private void initComponent() {
        add(jTextField1);
        jTextField1.setBounds(12, 50, 306, 22);
        jTextField1.setText(admin.getName());

        jLabel1.setText("Username");
        add(jLabel1);
        jLabel1.setBounds(12, 27, 80, 16);

        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(12, 90, 40, 16);

        add(jTextField2);
        jTextField2.setBounds(12, 176, 306, 22);
        String Password = admin.getPassword();
        jTextField2.setText(Password);

        jButton1.setText("Save");
        add(jButton1);
        jButton1.setBounds(240, 216, 80, 25);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminEntity admintoUpdate = new AdminEntity();
                admintoUpdate.setId(admin.getId());
                admintoUpdate.setName(jTextField1.getText());
                admintoUpdate.setPassword(jTextField2.getText());
                AllObjectModel.adminModel.update(admintoUpdate);
                dispose();
            }
        });
    }
}
