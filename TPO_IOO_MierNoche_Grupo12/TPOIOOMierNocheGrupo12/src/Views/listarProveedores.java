package Views;

import controllers.MainController;
import models.domain.Proveedor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class listarProveedores extends JFrame {

    public JFrame frmLista;
    public JTable tableProv;

    public listarProveedores(){
        frmLista = new JFrame();
        frmLista.setBounds(100,100,850,500);
        frmLista.setTitle("Listado de Proveedores");
        frmLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLista.setVisible(true);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Cuit");
        tableModel.addColumn("Tope");
        tableModel.addColumn("Name");
        tableModel.addColumn("Razon Social");

        List<Proveedor.ProveedorDTO> prov = new ArrayList<>();
        prov = MainController.getInstancia().listarProveedores();
        System.out.println(prov.size());

        Vector<Vector> rows2 = new Vector<Vector>();
        for(int i=0; i < prov.size(); i++){
            Vector<String> x = new Vector<String>();
            x.addElement(String.valueOf(prov.get(i).cuit));
            x.addElement(String.valueOf(prov.get(i).tope));
            x.addElement(String.valueOf(prov.get(i).nombre));
            x.addElement(String.valueOf(prov.get(i).razonSocial));
            tableModel.addRow(x);

            System.out.println(rows2.size());
        }
        tableProv = new JTable();
        tableProv.setModel(tableModel);
        tableProv.setBounds(10, 0, 457, 103);
        frmLista.add(new JScrollPane(tableProv));

    }
}
