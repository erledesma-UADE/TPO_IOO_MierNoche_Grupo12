package Views;

import controllers.RubrosController;
import models.domain.PrecioPorProveedor;
import models.domain.Producto;
import models.domain.Rubro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class compulsaDePrecios extends JFrame{
    private JTextField txtProd;
    private JButton buscarButton;
    private JTable tablePrecios;
    private JPanel mainPanel;
    private JComboBox cmbRubro;

    public compulsaDePrecios(){

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,400,200);
        this.setTitle("Compulsa de Precios");

        List<Rubro.RubroDTO> rubro = RubrosController.getInstancia().listarTodos();

        cmbRubro.setModel(new DefaultComboBoxModel());
        List<String> lista = new ArrayList<>();
        for (int i =0;i < rubro.size(); i++) {
            cmbRubro.addItem((rubro.get(i).nombre));
        }

        Vector colName = new Vector(10);
        colName.addElement(new String("Cuit Proveedor"));
        colName.addElement(new String("Fecha"));
        colName.addElement(new String("Precio"));

        int nmbrRows = 10;
        DefaultTableModel tableModel = new DefaultTableModel(nmbrRows,colName.size());
        tableModel.setColumnIdentifiers(colName);
        tablePrecios.setModel(tableModel);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prod = Integer.parseInt(txtProd.getText());
                String rubro = (String) cmbRubro.getSelectedItem();
                int rubroId=0;
                List<Rubro.RubroDTO> rubroList = RubrosController.getInstancia().listarTodos();
                for (int i=0; i < rubroList.size();i++){
                    if(rubroList.get(i).nombre.equals(rubro)){
                        rubroId = rubroList.get(i).idRubro;
                    }
                }
                System.out.println("1 " +RubrosController.getInstancia().verProducto(1));
                System.out.println("2 " +RubrosController.getInstancia().verProducto(2));
                System.out.println("rubroId " +rubroId);

                System.out.println("Prod" +prod);

                Producto.ProductoDTO prod2 = RubrosController.getInstancia().verProducto(prod);
                System.out.println("Prod nombre" +prod2.nombre);
                System.out.println("Prod nombre 2 " +prod2.precioPorProveedor);
                List<PrecioPorProveedor> precios = RubrosController.getInstancia().getPreciosPorProveedor(rubroId, prod2.idProducto);
                List<PrecioPorProveedor.UltimoPrecioDTO> ultimo = RubrosController.getInstancia().verUltimosPrecios(precios);
                Vector<String> x = new Vector<>();
                for(int i=0; i < ultimo.size(); i++){
                    x.addElement(String.valueOf(ultimo.get(i).cuit));
                    x.addElement(String.valueOf(ultimo.get(i).fechaAcuerdo));
                    x.addElement(String.valueOf(ultimo.get(i).monto));
                    tableModel.addRow(x);
                }


            }
        });

    }
}
