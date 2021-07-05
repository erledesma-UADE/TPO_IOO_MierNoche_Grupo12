package Views;

import controllers.MainController;

import javax.swing.*;

public class totalRetenciones extends JFrame {
    private JTextField txtTotalRet;
    private JPanel mainPanel;

    public totalRetenciones() {

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setBounds(100, 100, 500, 200);
        this.setTitle("Total Impuestos Retenidos");

        txtTotalRet.setEditable(false);

       txtTotalRet.setText(String.valueOf(MainController.getInstancia().totalImpuestosRetenidos()));

    }
}
