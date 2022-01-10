package Core;
//import Gui.GuiCustomer;
          
import Gui.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyy HH:mm:ss");

    public static void main(String[] args) {
        //  new GuiTransaksi(8).setVisible(true);

        new GuiLoginCustomer().setVisible(true);
        Date tanggal = new Date();
        String tanggal_f = dateFormat.format(tanggal);
        try {
            Date tanggal_o = dateFormat.parse(tanggal_f);
            System.out.println(tanggal_o);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}