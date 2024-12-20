package linked_list;
import java.util.Iterator;

import excepcions.NoObtingut;

public class IteratorLL<T extends Comparable<T>> implements Iterator<T>{

    private Linked_List<T> llista;
    private int comptador = 1;
    
    /**
     * Constructor de la classe
     * @param llista amb la informacio
     */
    public IteratorLL(Linked_List<T> llista) {
        this.llista = llista;
    }
    
    /**
     * Funcio hasNext
     */
    @Override
    public boolean hasNext() {
        return comptador < llista.Longitud(llista);
    }

    /**
     * Funcio Next
     */
    @Override
    public T next(){
        
        T aux = null;
        	try {
				aux = llista.Obtenir(comptador);
			} catch (NoObtingut e) {
				e.printStackTrace();
			}
        	comptador++;

        
        return aux;
    }
}
