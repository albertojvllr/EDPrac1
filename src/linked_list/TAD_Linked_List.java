package linked_list;
import excepcions.NoEsborrat;
import excepcions.NoInserit;
import excepcions.NoObtingut;
import excepcions.NoTrobat;

public interface TAD_Linked_List<T extends Comparable<T>> {
	
	/**
	 * Inicialitza la llista
	 */
	public void Crear();
	
	/**
	 * Revisa si la llista esta buida
	 * @return Fals si esta buida, Cert si no
	 */
	public boolean EstBuit();
	
	/**
	 * Insereix un node a la llista
	 * @param dades del ciutada
	 */
	public void Inserir(T dades) throws NoInserit;
	
	/**
	 * Insereix un node a la llista
	 * @param posicio a la llista
	 * @param dades del ciutada
	 */
	public void Inserir(int posicio, T dades) throws NoInserit;
	
	/**
	 * Obtenir les dades de un ciutada
	 * @param posicio a la llista del node
	 * @return les dades del ciutada
	 */
	public T Obtenir(int posicio) throws NoObtingut;
	
	/**
	 * Retorna la longitud de la llista
	 * @param llista
	 * @return la longitud
	 */
	public int Longitud(Linked_List<T> llista);
	
	/**
	 * Esborra un node de la llista en una posicio
	 * @param posicio del node a esborrar
	 */
	public void Esborrar(int posicio) throws NoEsborrat;
	
	/**
	 * Obtenir la posicio d'un ciutada a la llista
	 * @param dades del ciutada
	 * @return la posicio de la llista del ciutada
	 */
	public int Buscar(T data) throws NoTrobat;
}
