package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class altaFactura extends JFrame{
    private JPanel panel1;
    private JTextField fechaTxt;
    private JTextField montoTotTxt;
    private JTextField ordenCompraTxt;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTable table1;
    private JButton agregarArticuloButton;

    public altaFactura() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.setBounds(100, 100, 500, 400);
        this.setTitle("Alta Factura");

        montoTotTxt.setEditable(false);
        fechaTxt.setEditable(false);

        Date hoy = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strHoy = formatter.format(hoy);

        fechaTxt.setText(String.valueOf(strHoy));

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}