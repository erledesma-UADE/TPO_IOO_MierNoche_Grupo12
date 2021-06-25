package Views;

import controllers.MainController;
import controllers.RubrosController;
import models.domain.Proveedor;
import models.domain.Proveedor.ProveedorDTO;
import models.domain.Rubro;
import models.domain.enums.Responsabilidad;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
    private JTextArea txtARubro;
    private JButton agregarCertificadoNoRetenciónButton;
    private JPanel mainPanel;
    private JTextField txtTope;
    private JList listRubros;
    public ProveedorDTO prov;

    public altaProveedor(){
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,600,500);
        this.setTitle("Alta Proveedor");

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        cboResp.setModel(new DefaultComboBoxModel(Responsabilidad.values()));

        DefaultListModel lista = new DefaultListModel();
        listRubros.setModel(lista);

        List<Rubro.RubroDTO> rubro = RubrosController.getInstancia().listarTodos();

        for (int i =0;i < rubro.size(); i++) {
            lista.addElement(rubro.get(i).nombre);
        }

        listRubros.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String rubroSelect = (String) listRubros.getSelectedValue();
                System.out.println("rubro select: " +rubroSelect);
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                int cuit = Integer.parseInt(txtCuit.getText());
                Responsabilidad resp = (Responsabilidad) cboResp.getSelectedItem();
                String razonSocial = txtRazSocial.getText();
                String direccion = txtDireccion.getText();
                int telefono = Integer.parseInt(txtTelefono.getText());
                String email = txtMail.getText();
                int numeroIngresosBrutos = Integer.parseInt(txtIIBB.getText());

                //FALTA SETEAR RUBRO

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

                float tope = Float.parseFloat(txtTope.getText());

                Proveedor prov = new Proveedor();
                prov.setCuit(cuit);
                prov.setResponsabilidad(resp);
                prov.setRazonSocial(razonSocial);
                prov.setNombre(nombre);
                prov.setDireccion(direccion);
                prov.setTelefono(telefono);
                prov.setEmail(email);
                prov.setNumeroIngresosBrutos(numeroIngresosBrutos);
                prov.setInicioActividades(inicioAct2);
                //prov.agregarRubro(rubroP);
                prov.setTope(tope);
                ProveedorDTO prov2 = prov.toTDO();

                MainController.getInstancia().altaProveedor(prov2);

            }


        });
    }
}
