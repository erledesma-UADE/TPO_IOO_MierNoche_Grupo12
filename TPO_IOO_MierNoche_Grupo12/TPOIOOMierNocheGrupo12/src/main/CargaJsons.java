package main;

import com.google.gson.Gson;
import models.domain.Producto;
import models.repositories.Repositorio;
import models.repositories.RepositorioProductos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CargaJsons {

    public void cargaArchivos(RepositorioProductos repositorioProductos){

        Gson gson = new Gson();
        String json = this.cargarJsonVariable("Productos.json");

        Producto[] userArray = gson.fromJson(json, Producto[].class);

        for (Producto producto : userArray) {
            repositorioProductos.agregar(producto);
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
