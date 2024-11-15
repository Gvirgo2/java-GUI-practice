package common;
import java.io.File;
import javax.swing.JOptionPane;
import dao.inventoryutils;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author GudaT
 */
public class openpdf {

    public static void openbyId(String id) {
        try {
           if((new File(inventoryutils.billpath+id+".pdf")).exists()){
               Process p =Runtime
                         .getRuntime()
                         .exec("rundll32 url.dll,FileProtocolHandler "+inventoryutils.billpath+""+id+".pdf");
           }
           else{
                JOptionPane.showMessageDialog(null, "Please add some Products to cart or select customer");
           }

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        }
    }
}
