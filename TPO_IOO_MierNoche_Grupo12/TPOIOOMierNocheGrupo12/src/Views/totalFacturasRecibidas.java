package Views;

import controllers.DocumentosController;
import controllers.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class totalFacturasRecibidas extends JFrame{
    private JTextField txtTotalFact;
    private JPanel mainPanel;
    private JTextField txtFecha;
    private JTextField txtProv;
    private JButton buscarButton;
    private LocalDate fechaFact2;
    private int prov2;

    public totalFacturasRecibidas(){

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,500,200);
        this.setTitle("Total Factura recibidas");

        txtTotalFact.setEditable(false);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               String date1 = null;
               String date = txtFecha.getText();

               if(!date.equals("") || !date.isEmpty() || !date.isBlank()) {
                   String pattern = "dd/MM/yyyy";
                   Date fechaFact = null;
                   try {
                       DateFormat df = new SimpleDateFormat(pattern);
                       fechaFact = df.parse(date);
                   } catch (ParseException ie) {
                       ie.printStackTrace();
                   }
                   fechaFact2 = fechaFact.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
               }
                String prov = txtProv.getText();
                if(!prov.isBlank() || !prov.isEmpty()){
                    prov2 = Integer.parseInt(prov);
                }

                if((!date.isEmpty() || !date.isBlank()) && (prov.isBlank() || prov.isEmpty())){
                     try{
                         int totalF = DocumentosController.getInstancia().facturasEmitidasElDia(fechaFact2);
                         txtTotalFact.setText(String.valueOf(totalF));
                     }catch (Exception e1){
                        e1.printStackTrace();
                         txtFecha.setText("");
                         txtTotalFact.setText("");
                     }
                }else if ((!prov.isBlank() || !prov.isEmpty()) && (date.isEmpty() || date.isBlank())){
                    int totalP = MainController.getInstancia().totalFacturasRecibidas(prov2);
                    txtTotalFact.setText(String.valueOf(totalP));
                }else if((!prov.isBlank() || !prov.isEmpty()) && (!date.isEmpty() || !date.isBlank())){
                    int total = MainController.getInstancia().totalFacturasRecibidasEldia(prov2,fechaFact2);
                    txtTotalFact.setText(Integer.toString(total));
                }else{
                    int ok = JOptionPane.showConfirmDialog(null, "Debe ingresar al menos una fecha o un proveedor","Advertencia",JOptionPane.DEFAULT_OPTION);
                }

            }
        });




    }




}
