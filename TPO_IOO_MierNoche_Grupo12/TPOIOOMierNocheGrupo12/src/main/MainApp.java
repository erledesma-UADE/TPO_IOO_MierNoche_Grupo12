package main;

import Views.MenuPrincipal;
import controllers.RubrosController;
import models.domain.Rubro;

public class MainApp {



    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.framePpal.setVisible(true);
        //System.exit(0);

        Rubro rubro = new Rubro();
        rubro.setNombre("Medicina Prepaga");
        Rubro.RubroDTO dto = rubro.toDTO();
        RubrosController.getInstancia().agregarRubro(dto);
        rubro.setNombre("Viáticos y movilidad");
        Rubro.RubroDTO dto1 = rubro.toDTO();
        RubrosController.getInstancia().agregarRubro(dto1);
        rubro.setNombre("Mantenimiento de muebles e instalaciones");
        Rubro.RubroDTO dto2 = rubro.toDTO();
        RubrosController.getInstancia().agregarRubro(dto2);
        rubro.setNombre("Librería y otros insumos");
        Rubro.RubroDTO dto3 = rubro.toDTO();
        RubrosController.getInstancia().agregarRubro(dto3);
        rubro.setNombre("Papelería e impresiones");
        Rubro.RubroDTO dto4 = rubro.toDTO();
        RubrosController.getInstancia().agregarRubro(dto4);
        rubro.setNombre("Productos de reventa");
        Rubro.RubroDTO dto5 = rubro.toDTO();
        RubrosController.getInstancia().agregarRubro(dto5);

    }

}

