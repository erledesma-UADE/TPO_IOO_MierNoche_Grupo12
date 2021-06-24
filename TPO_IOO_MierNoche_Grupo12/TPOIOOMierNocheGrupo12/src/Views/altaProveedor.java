package Views;

import controllers.MainController;
import models.domain.Proveedor.ProveedorDTO;
import models.domain.Rubro;
import models.domain.enums.Responsabilidad;

import javax.swing.*;
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

public class altaProveedor extends JFrame{
    private JTextField txtIdProv;
    private JTextField txtNombre;
    private JTextField txtRazSocial;
    private JTextField txtCuit;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtMail;
    private JComboBox cboResp;
    private JTextField txtIIBB;
    private JTextField txtIniAct;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JButton asociarRubroButton;
    private JTextArea txtARubro;
    private JButton agregarCertificadoNoRetenciónButton;
    private JPanel mnpanel;
    private JPanel mainPanel;
    private JTextField txtTope;

    public altaProveedor(){
        //super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(400,400);
        this.pack();
        this.setTitle("Alta Proveedor");

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainPanel.setVisible(false);
            }
        });

        cboResp.setModel(new DefaultComboBoxModel(Responsabilidad.values()));

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //txtIdProv.setVisible(false);
                //int idProv = Integer.parseInt(txtIdProv.getText());
                String nombre = txtNombre.getText();
                int cuit = Integer.parseInt(txtCuit.getText());
                Responsabilidad resp = (Responsabilidad) cboResp.getSelectedItem();
                String razonSocial = txtRazSocial.getText();
                String direccion = txtDireccion.getText();
                int telefono = Integer.parseInt(txtTelefono.getText());
                String email = txtMail.getText();
                int numeroIngresosBrutos = Integer.parseInt(txtIIBB.getText());
                //--------VER COMO AGREGAR UN ELEMENENTO------
                //-----------A LA LISTA DE RUBROS-------------
                List<Rubro> rubros = new ArrayList<>();

                String pattern = "dd/MM/yyyy";
                String date = txtIniAct.getText();
                Date inicioAct = null ;
                try {
                    DateFormat df = new SimpleDateFormat(pattern);
                    inicioAct = df.parse(date);
                    System.out.println("Today = " + df.format(inicioAct));
                } catch (ParseException ie) {
                    ie.printStackTrace();
                }

                LocalDate inicioAct2 = inicioAct.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                //----------------FALTA EL TOPE EN LA VISTA---------------
                //float tope = Float.parseFloat(txtTope.getText());
                float tope = 10000;
                ProveedorDTO prov = new ProveedorDTO();
                //prov.id = idProv;
                prov.cuit = cuit;
                prov.responsabilidad = resp;
                prov.razonSocial = razonSocial;
                prov.nombre = nombre;
                prov.direccion = direccion;
                prov.telefono = telefono;
                prov.email = email;
                prov.numeroIngresosBrutos = numeroIngresosBrutos;
                prov.inicioActividades = inicioAct2;
                prov.tope = tope;
                MainController.getInstancia().crearProveedor(prov);

            }
        });
    }
}
