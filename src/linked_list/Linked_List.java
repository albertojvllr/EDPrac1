package linked_list;

import java.util.Iterator;

import excepcions.NoEsborrat;
import excepcions.NoInserit;
import excepcions.NoObtingut;
import excepcions.NoTrobat;

public class Linked_List<T extends Comparable<T>> implements Iterable<T>, TAD_Linked_List<T> {

	private Nodo inicio, fin;
	private int nElems = 0;

	public class Nodo {

		public T dades;
		Nodo anterior;
		Nodo siguiente;

		public Nodo(T dades, Nodo a, Nodo s) {
			this.dades = dades;
			this.anterior = a;
			this.siguiente = s;
		}

		public Nodo(T dades) {
			this(dades, null, null);
		}

	}

	@Override
	public void Crear() {
		inicio = null;
		fin = inicio;
	}

	public boolean EstBuit() {
		return inicio == null;
	}

	public void Inserir(T dades) throws NoInserit {
		try {
			Nodo nou = new Nodo(dades);
			if (!EstBuit()) {
				if (fin.anterior == null) {
					nou.anterior = inicio;
					fin = nou;
					inicio.siguiente = fin;

				} else {
					fin.siguiente = nou;
					nou.anterior = fin;
					fin = nou;

				}

			} else {
				inicio = new Nodo(dades, null, null);
				fin = inicio;
			}
			nElems++;

		} catch (Exception e) {
			throw new NoInserit();
		}
	}

	public void Inserir(int posicio, T dades) throws NoInserit {
		Nodo posterioranou, actual, anterior;
		posterioranou = inicio;
		int x;
		try {
			for (x = 1; x < posicio; x++) {
				posterioranou = posterioranou.siguiente;
			}
			if (x == 1) {

				actual = new Nodo(dades, null, inicio);
				inicio.anterior = actual;
				inicio = actual;

			} else {
				anterior = posterioranou.anterior;
				actual = new Nodo(dades, anterior, posterioranou);
				anterior.siguiente = actual;
				posterioranou.anterior = actual;
			}
			nElems++;
		} catch (Exception e) {
			throw new NoInserit();
		}

	}

	public T Obtenir(int posicio) throws NoObtingut {
		Nodo actual = inicio;
		try {
			for (int x = 0; x < posicio - 1; x++) {
				if (actual.siguiente != null) {
					actual = actual.siguiente;
				} else {
					actual.dades = (inicio.dades);
				}
			}

		} catch (Exception e) {
			throw new NoObtingut();
		}
		return (actual.dades);
	}

	public int Longitud(Linked_List<T> llista) {
		Nodo actual = inicio;
		int longitud = 1;
		while (actual.siguiente != null) {
			actual = actual.siguiente;
			longitud++;
		}
		return (longitud);
	}

	public void Esborrar(int posicio) throws NoEsborrat {
		Nodo actual = inicio;
		Nodo anterior, posterior;
		try {
			for (int x = 0; x < posicio - 1; x++) {
				if (actual.siguiente != null) {
					actual = actual.siguiente;
				}
			}

			anterior = actual.anterior;
			posterior = actual.siguiente;
			if (actual.anterior == null) {
				posterior.anterior = null;
				actual.siguiente = null;
				inicio = posterior;
			} else {
				if (actual.siguiente == null) {
					anterior.siguiente = null;
					actual.anterior = null;
					fin = anterior;
				} else {
					anterior.siguiente = posterior;
					posterior.anterior = anterior;
					actual.siguiente = null;
					actual.anterior = null;
				}
			}
			nElems--;
		} catch (Exception e) {
			throw new NoEsborrat();
		}

	}

	public int Buscar(T dades) throws NoTrobat {
		int i = 1;
		if (!EstBuit()) {
			boolean trobat = false;
			try {
				
				Nodo aux = inicio;
				while (i <= nElems && !trobat) {
					if (aux.dades.compareTo(dades) == 0) {
						trobat = true;
					} else {
						i++;
						aux = aux.siguiente;
					}
				}
			} catch (Exception e) {
				throw new NoTrobat();
				}
			if (!trobat) {
				throw new NoTrobat();
				
			}

		}
		return i;
	}

	@Override
	public Iterator<T> iterator() {

		IteratorLL<T> elem = new IteratorLL<>(this);

		return elem;
	}

}
