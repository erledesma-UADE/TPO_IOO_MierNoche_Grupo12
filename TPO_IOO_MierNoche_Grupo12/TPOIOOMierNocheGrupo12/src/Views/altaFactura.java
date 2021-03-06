package Views;

import controllers.DocumentosController;
import controllers.MainController;
import controllers.RubrosController;
import models.domain.*;
import models.domain.documentos.Documento;
import models.domain.enums.TipoDocumento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class altaFactura extends JFrame{
    private JPanel panel1;
    private JTextField fechaTxt;
    private JTextField montoTotTxt;
    private JTextField ordenCompraTxt;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JTable tableArt;
    private JButton agregarArticuloButton;
    private JButton asociarButton;
    private JTextField txtProv;

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

        ordenCompraTxt.setEditable(false);

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Integer idProv = Integer.parseInt(txtProv.getText());

        asociarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frmLista = new JFrame();
                frmLista.setBounds(100,100,850,500);
                frmLista.setTitle("Listado de Ordenes de compra");
                frmLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmLista.setVisible(true);

                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn("Nro Orden");
                tableModel.addColumn("Proveedor");
                tableModel.addColumn("Fecha");
                tableModel.addColumn("Producto");

                List<OrdenCompra> oOC = new ArrayList<>();
                //oOC = MainController.getInstancia().getRepositorioOrdenDeCompra().buscarTodos();

                Vector<Vector> rows2 = new Vector<Vector>();
                for(int i=0; i < oOC.size(); i++){
                    Vector<String> x = new Vector<String>();
                    x.addElement(String.valueOf(oOC.get(i).getID()));
                    x.addElement(String.valueOf(oOC.get(i).getProducto()));
                    x.addElement(String.valueOf(oOC.get(i).getFecha()));
                    x.addElement(String.valueOf(oOC.get(i).getProducto().get(0).getNombre()));//prueba para un prod
                    tableModel.addRow(x);

                }
                JTable tableProv = new JTable();
                tableProv.setModel(tableModel);
                tableProv.setBounds(10, 0, 457, 103);
                frmLista.add(new JScrollPane(tableProv));
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Integer idProv = Integer.parseInt(txtProv.getText());

                String pattern = "dd/MM/yyyy";
                String date = fechaTxt.getText();
                Date fecha = null ;
                try {
                    DateFormat df = new SimpleDateFormat(pattern);
                    fecha = df.parse(date);
                } catch (ParseException ie) {
                    ie.printStackTrace();
                }

                float monto = Float.parseFloat(montoTotTxt.getText());
                TipoDocumento tipoDoc = TipoDocumento.Factura;

                LocalDate fechaFact = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Documento.DocumentoDTO fact = new Documento.DocumentoDTO();
                //Optional<Proveedor> prov = MainController.getInstancia().getRepositorioProveedores().buscarPorCuit(idProv);
                fact.cuitProveedor = idProv;
                fact.fecha = fechaFact;
                fact.montoTotal = monto;
                fact.tipoDocumento = tipoDoc;
                //fact.agregarArticulo();

               // DocumentosController.getInstancia().altaDocumento(fact,prov);

            }
        });

        agregarArticuloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frmLista = new JFrame();
                frmLista.setBounds(100,100,850,500);
                frmLista.setTitle("Listado de Ordenes de Pago Emitidas");
                frmLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmLista.setVisible(true);

                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn("Cuit");
                tableModel.addColumn("Fecha");
                tableModel.addColumn("Tipo de Pago");
                tableModel.addColumn("Monto total");

                Integer idProveedor = idProv;
                PrecioPorProveedor prod = new PrecioPorProveedor();
                //prod = RubrosController.getInstancia().getRepositorioPrecioPorProveedor().buscarPrecioProveedor(idProv).get();

                /*for(int i=0; i < prod.size(); i++){
                    Vector<String> x = new Vector<String>();
                    x.addElement(String.valueOf(prod.get(i).getNombre()));
                    x.addElement(String.valueOf(prod.get(i).getTipoUnidad()));
                    x.addElement(String.valueOf(prod.get(i).getNombre());
                    x.addElement(String.valueOf(prod.get(i).montoTotal));
                    tableModel.addRow(x);

                }*/
                JTable tableOD= new JTable();
                tableOD.setModel(tableModel);
                tableOD.setBounds(10, 0, 457, 103);
                tableOD.setEnabled(false);
                frmLista.add(new JScrollPane(tableOD));
            }
        });
    }
}