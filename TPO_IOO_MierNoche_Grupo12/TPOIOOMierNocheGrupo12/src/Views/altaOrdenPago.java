package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class altaOrdenPago extends JFrame{
    private JTextField txtFecha;
    private JTextField txtProv;
    private JList list1;
    private JTextField txtTotalRet;
    private JTextField txtMontoTotal;
    private JButton crearButton;
    private JButton cancelarButton;
    private JButton asociarDocsButton;
    private JPanel mainPanel;

    public altaOrdenPago(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,500,300);
        this.setTitle("Alta Orden de Pago");

        txtFecha.setEditable(false);
        txtTotalRet.setEditable(false);
        txtMontoTotal.setEditable(false);

        Date hoy = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strHoy = formatter.format(hoy);

        txtFecha.setText(String.valueOf(strHoy));


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

}
