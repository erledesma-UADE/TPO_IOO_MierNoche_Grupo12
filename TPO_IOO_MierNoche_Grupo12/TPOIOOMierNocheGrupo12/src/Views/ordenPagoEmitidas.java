package Views;

import models.domain.OrdenPago;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class ordenPagoEmitidas extends JFrame{
    private JTable tableOrdenPago;
    private JPanel mainPanel;

    public ordenPagoEmitidas(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,600,500);
        this.setTitle("Ordenes de Pago Emitidas");

        ArrayList<OrdenPago> rows = new ArrayList<OrdenPago>();
        OrdenPago.OrdenPagoDto ordenPago = new OrdenPago.OrdenPagoDto();
        //rows = ordenPago.; traer todas las ordenes de pago
        Vector<Vector> rows2 = new Vector<Vector>();

        for(int i=0; i < rows.size(); i++){
            Vector<String> x = new Vector<String>();
            x.addElement(String.valueOf(rows.get(i).getFormaPago()));
            x.addElement(String.valueOf(rows.get(i).getFecha()));
            x.addElement(String.valueOf(rows.get(i).getMontoTotal()));
            x.addElement(String.valueOf(rows.get(i).getProveedor().getCuit()));
            rows2.add(x);
        }

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Forma de Pago");
        columnNames.add("Fecha");
        columnNames.add("Monto Total");
        columnNames.add("Proveedor");
        //String data[][]={{"","",""},{"","",""}};
        JTable tableOrdenPago2 = new JTable(rows2,columnNames);
        tableOrdenPago2.setBackground(new Color(250, 242, 200));
        tableOrdenPago2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        tableOrdenPago2.setLocation(20,10);
        tableOrdenPago2.setSize(437, 373);
        tableOrdenPago2.setToolTipText("Cronograma");
        tableOrdenPago2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

    }


}
