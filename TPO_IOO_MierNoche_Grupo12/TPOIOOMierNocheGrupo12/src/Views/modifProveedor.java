package Views;

import javax.swing.*;

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
    }
}
