package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class ctaCteProveedores extends JFrame{
    private JTable tableCtaCte;
    private JPanel panel1;

    public ctaCteProveedores(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(panel1);
        this.setBounds(100,100,500,200);
        this.setTitle("Cuenta Corriente Proveedores");

        Vector colName = new Vector(10);
        colName.addElement(new String("Columna0"));
        colName.addElement(new String("Columna1"));
        colName.addElement(new String("Columna2"));

        int nmbrRows = 25;
        DefaultTableModel tableModel = new DefaultTableModel(nmbrRows,colName.size());
        tableModel.setColumnIdentifiers(colName);
        tableCtaCte.setModel(tableModel);
    }

}
