package Views;

import javax.swing.*;

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

    public altaProveedor(){
        //super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(400,400);
        this.pack();
        this.setTitle("Alta Proveedor");
    }


}
