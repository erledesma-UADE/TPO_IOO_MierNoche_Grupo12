package Views;

import controllers.MainController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class totalDeudaProv extends JFrame{
    private JTextField textCuit;
    private JButton consultarButton;
    private JTextField textMontoDeuda;
    private JPanel mainPanel;

    public totalDeudaProv(){

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100,100,400,200);
        this.setTitle("Total Deuda por Proveedor");


        textMontoDeuda.setEditable(false);

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cuitP = Integer.parseInt(textCuit.getText());

                float monto = MainController.getInstancia().deudaPorProveedor(cuitP);
                textMontoDeuda.setText(String.valueOf(monto));
            }
        });
    }
}
