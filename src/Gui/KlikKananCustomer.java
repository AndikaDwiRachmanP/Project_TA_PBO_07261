package Gui;

import AllObject.AllObjectModel;
import Entity.AdminEntity;
import Entity.CustomerEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlikKananCustomer extends JDialog{
    private CustomerEntity customer;
    private JButton jButton1 = new JButton();
    private JComboBox<String> jComboBox1 = new JComboBox<>();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JLabel jLabel5 = new JLabel();
    private JLabel jLabel6 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private JTextField jTextField3 = new JTextField();
    private JTextField jTextField4 = new JTextField();
    private JTextField jTextField5 = new JTextField();
    private JTextField jTextField6 = new JTextField();

    public KlikKananCustomer(JFrame parent, CustomerEntity customer) {
        super(parent);
        setTitle("Edit Data");
        setSize(350, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setResizable(false);
        this.customer = customer;
        this.initComponent();

        setModal(true);
        setVisible(true);
    }

    private void initComponent() {
        jLabel1.setText("Nama");
        add(jLabel1);
        jLabel1.setBounds(12, 27, 80, 16);

        add(jTextField1);
        jTextField1.setBounds(12, 50, 306, 22);
        jTextField1.setText(customer.getNama());

        jLabel2.setText("Alamat");
        add(jLabel2);
        jLabel2.setBounds(12, 90, 40, 16);

        add(jTextField2);
        jTextField2.setBounds(12, 113, 306, 22);
        jTextField2.setText(customer.getAlamat());

        jLabel3.setText("No.Hp");
        add(jLabel3);
        jLabel3.setBounds(12, 153, 80, 16);

        add(jTextField3);
        jTextField3.setBounds(12, 176, 306, 22);
        jTextField3.setText(customer.getNo_hp());

        jLabel4.setText("Password");
        add(jLabel4);
        jLabel4.setBounds(12, 216, 80, 16);

        add(jTextField4);
        jTextField4.setBounds(12, 239, 306, 22);
        jTextField4.setText(customer.getPassword());

        jButton1.setText("Save");
        add(jButton1);
        jButton1.setBounds(240, 279, 80, 25);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerEntity customerToUpdate = new CustomerEntity(customer.getId(), customer.getCreated_at(), customer.getUpdated_at(), jTextField1.getText(), jTextField3.getText(), jTextField2.getText(), customer.getUsername(), jTextField4.getText());
                AllObjectModel.customerModel.update(customerToUpdate);
                dispose();
            }
        });
    }
}
