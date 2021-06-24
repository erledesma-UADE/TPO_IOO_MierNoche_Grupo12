package repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class RepositorioGenerico<T extends ID> {
    private List<T> elementos;

    protected RepositorioGenerico(){
        this.elementos = new ArrayList<>();
    }

    public List<T> buscarTodos(){
        //select
        return this.elementos;
    }

    public Optional<T> buscar(Integer id){
        return this.elementos.stream().filter(e -> e.getID().equals(id)).findFirst();
    }

    public void agregar(T elemento){
        //insert
        elemento.setID(this.elementos.size() +1);
        this.elementos.add(elemento);
    }

    public void modificar(T elemento){
        //uptate
        //------------------>BUSCAR<--------------------
        //--------------->COMO SE HACE<-----------------
    }

    public void eliminar(T unElemento){
        //delete
        this.elementos.remove(unElemento);
    }



}
