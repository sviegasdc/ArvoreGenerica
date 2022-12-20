import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private Object elemento;
    private No pai;
    private ArrayList <Object> filhos = new ArrayList<>();

    public No(No pai, Object elemento){
        this.pai = pai;
        this.elemento = elemento;
    }

    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public No paiDeUmNo(){
        return pai;
    }

    public void addFilho(No elemento){
        filhos.add(elemento);
    }

    public void removeFilho(No elemento){
        filhos.remove(elemento);
    }

    public int numeroFilhos(){
        return filhos.size();
    }

    public Iterator<Object> filhosDeUmNo(){
        return filhos.iterator();
    }

}
