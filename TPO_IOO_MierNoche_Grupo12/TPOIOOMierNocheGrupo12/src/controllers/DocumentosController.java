package controllers;

import java.time.LocalDate;

public class DocumentosController {
    public static class MainController {
        private static MainController instancia;

        private MainController(){

        }

        public static MainController getInstancia(){
            if(instancia ==  null){
                instancia = new MainController();
            }
            return instancia;
        }

        public int totalFacturasRecibidas(int idProveedor){
            //todo
            return 0;
        }

        public int totalFacturasRecibidasPorProveedor(int idProveedor, LocalDate fecha){
            //todo
            return 0;
        }

        public void detalleCuentaCorriente(int idProveedor){
            //todo    }

        public float totalDeudaPorProveedor(int idProveedor){
            //todo
            return 0;
        }

        public void mostrarLibroIVACompras(){
            //todo
        }

        public void getProveedorPorId (int idProveedor){
            //todo
        }
    }
}
