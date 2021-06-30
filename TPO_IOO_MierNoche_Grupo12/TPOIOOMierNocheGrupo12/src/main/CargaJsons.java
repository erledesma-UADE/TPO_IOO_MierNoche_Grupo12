package main;

import com.google.gson.Gson;
import models.domain.Producto;
import models.domain.documentos.Documento;
import models.domain.documentos.Factura;
import models.repositories.Repositorio;
import models.repositories.RepositorioDocumentos;
import models.repositories.RepositorioProductos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CargaJsons {

    public void cargaArchivos(RepositorioProductos repositorioProductos, RepositorioDocumentos repositorioDocumentos){

        Gson gson = new Gson();
        String json = this.cargarJsonVariable("TPO_IOO_MierNoche_Grupo12/Productos.json");
        Producto[] productosArray = gson.fromJson(json, Producto[].class);
        for (Producto producto : productosArray) {
            repositorioProductos.agregar(producto);
        }

        json = this.cargarJsonVariable("TPO_IOO_MierNoche_Grupo12/documentos2.json");
        Factura[] documentosArray = gson.fromJson(json,Factura[].class);
        for (Factura factura : documentosArray){
            repositorioDocumentos.agregar(factura);
        }


    }

    public String cargarJsonVariable(String nombreArchivo){
        BufferedReader br = null;
        String json = "";
        try {
            br = new BufferedReader(new FileReader(nombreArchivo));
            String linea = "";
            while ((linea = br.readLine()) != null) {
                json += linea;
            }
            br.close();

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
