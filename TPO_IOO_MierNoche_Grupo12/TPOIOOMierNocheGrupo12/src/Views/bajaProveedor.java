package Views;

import javax.swing.*;

public class bajaProveedor extends JFrame{
    private JTextField txtIdProv;
    private JButton buscarButton;
    private JTextField txtNombre;
    private JTextField txtRazSoc;
    private JTextField txtCuit;
    private JTextField txtDireccion;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel mainPanel;

    public bajaProveedor(){
        //super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(400,400);
        this.pack();
        this.setTitle("Baja Proveedor");
    }
}
