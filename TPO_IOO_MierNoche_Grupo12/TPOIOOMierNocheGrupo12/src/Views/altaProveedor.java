/*package Views;

import controllers.MainController;
import controllers.RubrosController;
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
    private JTextArea txtARubro;
    private JButton agregarCertificadoNoRetenciónButton;
    private JPanel mainPanel;
    private JTextField txtTope;
    private JList listRubros;
    public ProveedorDTO prov;
    public String rubroSelect;

    public altaProveedor(){
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
                rubroSelect = (String) listRubros.getSelectedValue();
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

                List<Rubro.RubroDTO> rubro = RubrosController.getInstancia().listarTodos();
                String rubrotxt = rubroSelect;
                List<Rubro.RubroDTO> rubroDTO = new ArrayList<>();
                List<Rubro> rubroO = new ArrayList<>();
                Rubro rubroCont = new Rubro();
                System.out.println("rubro tamaño: " +rubro.size());

                for (int i = 1;i < rubro.size(); i++) {
                    if(rubro.get(i).nombre.equals(rubrotxt)) {
                        rubroDTO.add(rubro.get(i));
                        rubroCont.setNombre(rubroDTO.get(i).nombre);
                        rubroCont.setIdRubro(rubroDTO.get(i).id);
                        System.out.println("rubro selecionado: " +i);
                        rubroO.set(i,rubroCont);
                        //rubroO.add(rubroCont);
                    }
                }


                String pattern = "dd/MM/yyyy";
                String date = txtIniAct.getText();
                Date inicioAct = null ;
                try {
                    DateFormat df = new SimpleDateFormat(pattern);
                    inicioAct = df.parse(date);
                    //System.out.println("Today = " + df.format(inicioAct));
                } catch (ParseException ie) {
                    ie.printStackTrace();
                }

                LocalDate inicioAct2 = inicioAct.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                float tope = Float.parseFloat(txtTope.getText());

                ProveedorDTO prov2 = new ProveedorDTO();//prov.toDTO();
                prov2.cuit = cuit;
                prov2.responsabilidad = resp;
                prov2.razonSocial = razonSocial;
                prov2.nombre = nombre;
                prov2.direccion = direccion;
                prov2.telefono = telefono;
                prov2.email = email;
                prov2.numeroIngresosBrutos = numeroIngresosBrutos;
                prov2.inicioActividades = inicioAct2;
                prov2.rubros = rubroO;
                prov2.tope = tope;
                MainController.getInstancia().altaProveedor(prov2);

                int ok = JOptionPane.showConfirmDialog(null, "Proveedor Creado","Confirmación",JOptionPane.DEFAULT_OPTION);
            }

        });

    }


}
*/