package Views;

import controllers.RubrosController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class compulsaDePrecios extends JFrame{
    private JTextField txtProd;
    private JButton buscarButton;
    private JTable tablePrecios;
    private JPanel mainPanel;

    public compulsaDePrecios(){

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,400,200);
        this.setTitle("Compulsa de Precios");


        Vector colName = new Vector(10);
        colName.addElement(new String("Columna0"));
        colName.addElement(new String("Columna1"));
        colName.addElement(new String("Columna2"));

        // more statements like the above to establish all col. titles

        int nmbrRows = 10;
        DefaultTableModel tableModel = new DefaultTableModel(nmbrRows,colName.size());
        tableModel.setColumnIdentifiers(colName);
        tablePrecios.setModel(tableModel);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prod = txtProd.getText();
                RubrosController.getInstancia().getRubroPorID(Integer.parseInt(prod));

                RubrosController.getInstancia().mostrarCompulsa(Integer.parseInt(prod),Integer.parseInt(prod));
            }
        });

    }
}
