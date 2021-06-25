package Views;

import controllers.MainController;
import models.domain.Proveedor;
import models.domain.enums.Responsabilidad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class modifProveedor extends JFrame{
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
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JButton asociarRubroButton;
    private JTextArea txtARubro;
    private JButton agregarCertificadoNoRetenciónButton;
    private JPanel mainPanel;
    private JButton buscarButton;

    public modifProveedor(){
        //super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(400,400);
        this.pack();
        this.setTitle("Modificar Proveedor");

        txtNombre.setEditable(false);
        txtRazSocial.setEditable(false);
        txtCuit.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
        txtMail.setEditable(false);
        cboResp.setEditable(false);
        txtIIBB.setEditable(false);
        txtIniAct.setEditable(false);
        txtARubro.setEditable(false);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer id = Integer.parseInt(txtIdProv.getText());
                Proveedor.ProveedorDTO prov;
                prov = MainController.getInstancia().buscarProveedor(id);

                txtIdProv.setEditable(true);
                txtNombre.setEditable(true);
                txtRazSocial.setEditable(true);
                txtCuit.setEditable(true);
                txtDireccion.setEditable(true);
                txtTelefono.setEditable(true);
                txtMail.setEditable(true);
                cboResp.setEditable(true);
                txtIIBB.setEditable(true);
                txtIniAct.setEditable(true);
                txtARubro.setEditable(true);

                txtNombre.setText(prov.nombre);
                txtRazSocial.setText(prov.razonSocial);
                txtCuit.setText(String.valueOf(prov.cuit));
                txtDireccion.setText(prov.direccion);
                txtTelefono.setText(String.valueOf(prov.telefono));
                txtMail.setText(prov.email);
                cboResp.setSelectedItem(prov.responsabilidad);
                cboResp.setModel(new DefaultComboBoxModel(Responsabilidad.values()));



            }
        });

    }


}
