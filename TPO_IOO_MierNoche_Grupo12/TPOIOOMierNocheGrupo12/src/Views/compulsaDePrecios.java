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

        List<Rubro.RubroDTO> rubro = RubrosController.getInstancia().listarRubros();

        cmbRubro.setModel(new DefaultComboBoxModel());
        List<String> lista = new ArrayList<>();
        for (int i =0;i < rubro.size(); i++) {
            cmbRubro.addItem((rubro.get(i).nombre));
        }

        Vector colName = new Vector(10);

        int nmbrRows = 10;


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn(("Cuit Proveedor"));
                tableModel.addColumn(("Fecha"));
                tableModel.addColumn(("Precio"));

                int prod = Integer.parseInt(txtProd.getText());
                String rubro = (String) cmbRubro.getSelectedItem();
                int rubroId=0;
                List<Rubro.RubroDTO> rubroList = RubrosController.getInstancia().listarRubros();
                for (int i=0; i < rubroList.size();i++){
                    if(rubroList.get(i).nombre.equals(rubro)){
                        rubroId = rubroList.get(i).idRubro;
                    }
                }

                Producto.ProductoDTO prod2 = RubrosController.getInstancia().verProducto(prod);

                List<PrecioPorProveedor> precios = RubrosController.getInstancia().getPreciosPorProveedor(rubroId, prod2.idProducto);
                List<PrecioPorProveedor.UltimoPrecioDTO> ultimo = RubrosController.getInstancia().verUltimosPrecios(precios);

                for(int i=0; i < ultimo.size(); i++){
                    Vector<String> x = new Vector<>();
                    x.addElement(String.valueOf(ultimo.get(i).cuit));
                    x.addElement(String.valueOf(ultimo.get(i).fechaAcuerdo));
                    x.addElement(String.valueOf(ultimo.get(i).monto));
                    tableModel.addRow(x);
                }

                tablePrecios.setModel(tableModel);
                tablePrecios.setBounds(10, 0, 457, 103);
            }
        });

    }
}
