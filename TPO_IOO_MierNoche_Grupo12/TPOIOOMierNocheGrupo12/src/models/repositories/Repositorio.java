package models.repositories;

import models.domain.ID;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Repositorio<T extends ID> {
    protected List<T> elementos;

    public Repositorio() {
        this.elementos = new ArrayList<>();
    }

    public List<T> buscarTodos() {
        return this.elementos;
    }

    public Optional<T> getPorID(Integer id) {
        return this.elementos
                .stream()
                .filter(e -> e.getID().equals(id))
                .findFirst();
    }

    public void agregar(T elemento) {
        elemento.setID(this.elementos.size() + 1);
        this.elementos.add(elemento);
    }

    public void modificar(T elemento) {
        //UPDATE
        //TODO
    }

    public void eliminar(T unElemento) {
        //DELETE
        this.elementos.remove(unElemento);
    }

    public List<T> getElementos(){
        return this.elementos;
    }

}
