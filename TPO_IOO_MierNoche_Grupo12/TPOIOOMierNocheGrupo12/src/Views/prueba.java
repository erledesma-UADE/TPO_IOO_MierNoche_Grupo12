package Views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class prueba extends JFrame{
    private JTable tableLibroIVA;
    private JPanel panel1;

    public prueba(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.setSize(400,400);
        this.pack();
        this.setTitle("Consulta Libro IVA");

        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Cuit");
        columnNames.add("Nombre");
        columnNames.add("Fecha");
        columnNames.add("Tipo");
        columnNames.add("IVA");
        columnNames.add("Total");
        //tableLibroIVA.addColumn(columnNames,"");
            tableLibroIVA.setModel(new DefaultTableModel(
                new Object[][] {
                    {this.getTitle(), "2", "3"},
                    {"4", "5", "6"},
                },
                new String[] {
                    "Cuit", "Nombre", "Fecha"
                }
            ));
    }


}
