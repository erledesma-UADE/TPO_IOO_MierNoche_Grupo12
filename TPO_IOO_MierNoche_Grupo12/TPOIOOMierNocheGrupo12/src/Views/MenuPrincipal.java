package Views;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal{

    //private JPanel mainPanel;
    private JButton proveedoresButton;
    private JButton consultasGeneralesButton;
    private JMenuBar barMenu;
    private JFrame framePpal;
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
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //framePpal.setContentPane(framePpal);
        //this.setSize(400, 400);
        //this.pack();

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

        jmDocumentos = new JMenu("Documentos Recibidos");
        barMenu.add(jmDocumentos);

        jmOrderPago = new JMenu("Ordenes de Pago");
        barMenu.add(jmOrderPago);

        jmConsultas = new JMenu("Consultas Generales");
        barMenu.add(jmConsultas);

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
                bajaProveedor bajaProv =  new bajaProveedor();
                bajaProv.setVisible(true);
            }
        });

        modifProv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifProveedor modifProv =  new modifProveedor();
                modifProv.setVisible(true);
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

    }

    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.framePpal.setVisible(true);
        //System.exit(0);
    }


}
