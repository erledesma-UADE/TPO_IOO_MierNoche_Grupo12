package Views;

import controllers.MainController;
import models.domain.Proveedor;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MenuPrincipal{

    private JButton proveedoresButton;
    private JButton consultasGeneralesButton;
    private JMenuBar barMenu;
    public JFrame framePpal;
    private JMenu jmuser;
    private JMenu jmProv;
    private JMenu jmOrdenCompra;
    private JMenu jmDocumentos;
    private JMenu jmOrderPago;
    private JMenu jmConsultas;
    private JMenu jmSalir;
    private JMenuItem altaUser;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public MenuPrincipal() {


        framePpal = new JFrame();
        framePpal.setTitle("Menu Principal");
        framePpal.setBounds(100,100,850,500);
        framePpal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        barMenu = new JMenuBar();
        framePpal.setJMenuBar(barMenu);

        jmuser = new JMenu("Usuario");
        barMenu.add(jmuser);

        jmProv = new JMenu("Proveedor");
        barMenu.add(jmProv);

        jmOrdenCompra = new JMenu("Ordenes de Compra");
        barMenu.add(jmOrdenCompra);

        JMenuItem emitirOC = new JMenuItem("Emitir Órden");
        jmOrdenCompra.add(emitirOC);

        jmDocumentos = new JMenu("Documentos Recibidos");
        barMenu.add(jmDocumentos);

        JMenuItem nFactura = new JMenuItem("Nueva Factura");
        JMenuItem nNotaC = new JMenuItem("Nueva Nota Crédito");
        JMenuItem nNotaD = new JMenuItem("Nueva Nota Débito");
        jmDocumentos.add(nFactura);
        jmDocumentos.add(nNotaC);
        jmDocumentos.add(nNotaD);

        jmOrderPago = new JMenu("Ordenes de Pago");
        barMenu.add(jmOrderPago);

        JMenuItem emitirOP = new JMenuItem("Emitir Órden");
        jmOrderPago.add(emitirOP);

        jmConsultas = new JMenu("Consultas Generales");
        barMenu.add(jmConsultas);

        JMenuItem totFactRec = new JMenuItem("Total Facturas Recibidas");
        jmConsultas.add(totFactRec);

        JMenuItem ctaCtaProv = new JMenuItem("Cuenta Corriente Proveedores");
        jmConsultas.add(ctaCtaProv);

        JMenuItem compPrecio = new JMenuItem("Compulsas de Precios");
        jmConsultas.add(compPrecio);

        JMenuItem ordPagoEmit = new JMenuItem("Ordenes de Pago Emitidas");
        jmConsultas.add(ordPagoEmit);

        JMenuItem totDeudaProv = new JMenuItem("Total Deuda por Proveedor");
        jmConsultas.add(totDeudaProv);

        JMenuItem totImpReten = new JMenuItem("Total Impuestos Retenidos");
        jmConsultas.add(totImpReten);

        JMenuItem consultaIVA = new JMenuItem("Consulta Libro IVA");
        jmConsultas.add(consultaIVA);

        jmSalir = new JMenu("Salir");
        barMenu.add(jmSalir);

        altaUser = new JMenuItem("Alta Usuario");
        jmuser.add(altaUser);

        JMenuItem bajaUser = new JMenuItem("Baja Usuario");
        jmuser.add(bajaUser);

        JMenuItem altaProv = new JMenuItem("Alta Proveedor");
        jmProv.add(altaProv);

        JMenuItem bajaProv = new JMenuItem("Baja Proveedor");
        jmProv.add(bajaProv);

        JMenuItem modifProv = new JMenuItem("Modificar Proveedor");
        jmProv.add(modifProv);

        JMenuItem listarProv = new JMenuItem("Listar Proveedor");
        jmProv.add(listarProv);

        JMenuItem agregarCetf = new JMenuItem("Nuevo Certificado");
        jmProv.add(agregarCetf);

        altaProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                altaProveedor altaProv =  new altaProveedor();
                altaProv.setVisible(true);
            }
        });

        bajaProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //bajaProveedor bajaProv =  new bajaProveedor();
                //bajaProv.setVisible(true);
            }
        });

        modifProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //modifProveedor modifProv =  new modifProveedor();
                //modifProv.setVisible(true);
            }
        });


        consultaIVA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //prueba consulta =  new prueba();
                //consulta.setVisible(true);

            }
        });

        jmSalir.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                framePpal.dispose();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        totFactRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalFacturasRecibidas totalFact = new totalFacturasRecibidas();
                totalFact.setVisible(true);
            }
        });

        totImpReten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalRetenciones totalRet = new totalRetenciones();
                totalRet.setVisible(true);
            }
        });

        ctaCtaProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctaCteProveedores ctaCtaProv = new ctaCteProveedores();
                ctaCtaProv.setVisible(true);
            }
        });

        nFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                altaFactura altaFact = new altaFactura();
                altaFact.setVisible(true);
            }
        });

        ordPagoEmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenPagoEmitidas ordenPago = new ordenPagoEmitidas();
                ordenPago.setVisible(true);
            }
        });

        totDeudaProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalDeudaProv totalDeudaProveedor = new totalDeudaProv();
                totalDeudaProveedor.setVisible(true);
            }
        });

        emitirOP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                altaOrdenPago altaOP = new altaOrdenPago();
                altaOP.setVisible(true);
            }
        });

        compPrecio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compulsaDePrecios compDePrecio = new compulsaDePrecios();
                compDePrecio.setVisible(true);
            }
        });

        listarProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frmLista = new JFrame();
                frmLista.setBounds(100,100,850,500);
                frmLista.setTitle("Listado de Proveedores");
                frmLista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frmLista.setVisible(true);

                DefaultTableModel tableModel = new DefaultTableModel();
                tableModel.addColumn("Nombre");
                tableModel.addColumn("Razon Social");
                tableModel.addColumn("Cuit");
                tableModel.addColumn("Direccion");
                tableModel.addColumn("Telefono");
                tableModel.addColumn("Email");
                tableModel.addColumn("Rubro");
                tableModel.addColumn("Responsabilidad");
                tableModel.addColumn("Nro IIBB");
                tableModel.addColumn("Inicio Act.");
                tableModel.addColumn("Tope");

                List<Proveedor.ProveedorDTO> prov = new ArrayList<>();
                prov = MainController.getInstancia().listarProveedores();

                Vector<Vector> rows2 = new Vector<Vector>();
                for(int i=0; i < prov.size(); i++){
                    Vector<String> x = new Vector<String>();
                    x.addElement(String.valueOf(prov.get(i).nombre));
                    x.addElement(String.valueOf(prov.get(i).razonSocial));
                    x.addElement(String.valueOf(prov.get(i).cuit));
                    x.addElement(String.valueOf(prov.get(i).direccion));
                    x.addElement(String.valueOf(prov.get(i).telefono));
                    x.addElement(String.valueOf(prov.get(i).email));
                    x.addElement(String.valueOf(prov.get(i).rubros.get(0).getNombre()));//solo un rubro
                    x.addElement(String.valueOf(prov.get(i).responsabilidad));
                    x.addElement(String.valueOf(prov.get(i).numeroIngresosBrutos));
                    x.addElement(String.valueOf(prov.get(i).inicioActividades));
                    x.addElement(String.valueOf(prov.get(i).tope));

                    tableModel.addRow(x);

                }
                JTable tableProv = new JTable();
                tableProv.setModel(tableModel);
                tableProv.setBounds(10, 0, 457, 103);
                tableProv.setEnabled(false);
                frmLista.add(new JScrollPane(tableProv));
            }
        });

    }

    //---------------->ESTO VA EN EL MAIN APP<---------------
   /* public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.framePpal.setVisible(true);
        //System.exit(0);
    }*/


}
