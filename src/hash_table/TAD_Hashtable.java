package hash_table;

import excepcions.NoEsborrat;
import excepcions.NoInserit;
import excepcions.NoObtingut;
import excepcions.NoTrobat;
import linked_list.Linked_List;

public interface TAD_Hashtable<T extends Comparable<T>,K extends Comparable<K>>{
	/**
	 * Constructor per inicialitzar la taula
	 */
	public void Crear();

	/**
	 * Funcio per inserir un element a la taula de Hash, si un element ja existeix, l'actualitza
	 * @param La clau del ciutada
	 * @param Les dades del ciutada
	 */
	public void Inserir(K key, T data) throws NoInserit;
	
	/**
	 * Retorna l'element que te la clau K
	 * @param Clau del ciutada
	 * @return Les dades corresponent a la clau
	 */
	public T obtenir(K key) throws NoObtingut;
	
	/**
	 * Comprova si un element esta a la taula
	 * @param Clau del ciutada
	 * @return Nombre d'elements que s'han recorregut
	 */
	public int Buscar(K Key) throws NoTrobat;
	
	/**
	 * Retorna el nombre d'elements que conté la taula
	 * @return nombre d'element de la taula
	 */
	public int Mida();
	
	/**
	 * Esborra un element de la taula
	 * @param Clau del ciutada
	 */
	public void Esborrar(K key) throws NoEsborrat;
	/**
	 * Guarda el valor de les dades de la taula
	 * @return una llista enllaçada amb els valors
	 */
	Linked_List<T> ObtenirValors() throws NoInserit;
	
	/**
	 * Guarda els valors de les claus de la taula
	 * @return una llista ellaçada amb les claus
	 */
	Linked_List<K> ObtenirClaus() throws NoInserit;
	
	/**
	 * Retorna el factor de carrega
	 * @return el factor de carrega
	 */
	public float ObtenirFactorDeCarrega();
}
