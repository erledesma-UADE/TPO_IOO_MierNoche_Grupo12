package models.domain.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Repositorio<T extends ID> {
    List<T> elementos;

    public Repositorio() {
        this.elementos = new ArrayList<>();
    }

    public List<T> buscarTodos() {
        //SELECT
        return this.elementos;
    }

    /*public Optional<T> getPorID(Integer id) {
        return this.elementos
                .stream()
                .filter(e -> e.getID().equals(id))
                .findFirst();
    }*/

    public void agregar(T elemento) {
        //INSERT
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
}
