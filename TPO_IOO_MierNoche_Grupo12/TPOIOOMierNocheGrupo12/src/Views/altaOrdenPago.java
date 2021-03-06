package Views;

import controllers.DocumentosController;
import controllers.MainController;
import models.domain.OrdenPago;
import models.domain.documentos.Documento;
import models.domain.enums.TipoPago;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class altaOrdenPago extends JFrame{
    private JTextField txtFecha;
    private JTextField txtProv;
    private JTextField txtTotalRet;
    private JTextField txtMontoTotal;
    private JButton crearButton;
    private JButton cancelarButton;
    private JButton asociarDocsButton;
    private JPanel mainPanel;
    private JTable tableDocs;
    private JComboBox cboPago;

    public altaOrdenPago(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,500,300);
        this.setTitle("Alta Orden de Pago");

        txtFecha.setEditable(false);

        Date hoy = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strHoy = formatter.format(hoy);

        txtFecha.setText(String.valueOf(strHoy));

        cboPago.setModel(new DefaultComboBoxModel(TipoPago.values()));

        asociarDocsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cuit = Integer.parseInt(txtProv.getText());

                List<Documento.DocumentoDTO> docs = DocumentosController.getInstancia().documentosPorProveedor(cuit);

                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn("Id Doc");
                tableModel.addColumn("Monto");

                System.out.println("docs " +docs);
                docs.forEach(d -> {System.out.println(d.idDocumento);});
                Vector<Vector> rows2 = new Vector<Vector>();
                for(int i=0; i < docs.size(); i++) {
                    Vector<String> x = new Vector<String>();
                    x.addElement(String.valueOf(docs.get(i).idDocumento));
                    x.addElement(String.valueOf(docs.get(i).montoTotal));

                    tableModel.addRow(x);
                }
                tableDocs.setModel(tableModel);
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int cuit = Integer.parseInt(txtProv.getText());

                OrdenPago.OrdenPagoDTO ordenPago = new OrdenPago.OrdenPagoDTO();
                ordenPago.cuitProveedor= cuit;

                String pattern = "dd/MM/yyyy";
                String date = txtFecha.getText();
                Date fecha = null ;
                try {
                    DateFormat df = new SimpleDateFormat(pattern);
                    fecha = df.parse(date);
                } catch (ParseException ie) {
                    ie.printStackTrace();
                }

                LocalDate fecha1 = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                ordenPago.fecha = fecha1;

                TipoPago tipoPago = (TipoPago) cboPago.getSelectedItem();

                ordenPago.tipoPago = tipoPago;

                List<Integer> idDocs = new ArrayList<>();

                int[] index = tableDocs.getSelectedRows();
                for(int i=0; i<index.length;i++ ){
                    System.out.println("tabla "+tableDocs.getValueAt(i,0));
                    Integer id = Integer.parseInt(String.valueOf(tableDocs.getValueAt(i,0)));
                    idDocs.add(id);
                }

                ordenPago.idsDocumentos = idDocs;

                MainController.getInstancia().altaOrdenPago(ordenPago);
            }
        });

    }

}
