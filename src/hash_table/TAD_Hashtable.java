package hash_table;
public interface TAD_Hashtable<K,T> {
	/**
	 * Constructor per inicialitzar la taula
	 */
	public void Crear();

	/**
	 * Funcio per inserir un element a la taula de Hash, si un element ja existeix, l'actualitza
	 * @param La clau del ciutada
	 * @param Les dades del ciutada
	 */
	public void Inserir(K key, T data);
	
	/**
	 * Retorna l'element que te la clau K
	 * @param Clau del ciutada
	 * @return Les dades corresponent a la clau
	 */
	public T obtenir(K key);
	
	/**
	 * Comprova si un element esta a la taula
	 * @param Clau del ciutada
	 * @return Nombre d'elements que s'han recorregut
	 */
	public int Buscar(K Key);
	
	/**
	 * Retorna el nombre d'elements que conté la taula
	 * @return nombre d'element de la taula
	 */
	public int Mida();
	
	/**
	 * Esborra un element de la taula
	 * @param Clau del ciutada
	 */
	public void Esborrar(K key);
	/**
	 * 
	 * @return
	 */
	//public <K> ObtenirClaus();
	//public <T> ObtenirValors();
	
	/**
	 * Retorna el factor de carrega
	 * @return el factor de carrega
	 */
	public float ObtenirFactorDeCarrega();
}
