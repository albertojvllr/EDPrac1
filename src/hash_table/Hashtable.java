package hash_table;
import excepcions.NoEsborrat;
import excepcions.NoObtingut;
import excepcions.NoTrobat;
import excepcions.NoInserit;

public class Hashtable<T extends Comparable<T>,K extends Comparable<K>> implements TAD_Hashtable<T,K> {

	private final int mida=23;
	private NodoHash<T,K>[] taula;
	private int nElems;
	
	//SupressWarning perque java te problemes quan creem una llista de generics
	@SuppressWarnings("unchecked")
	@Override
	public void Crear() {
		this.taula = (NodoHash<T,K>[]) new NodoHash[mida];
		nElems=0;
	}

	@Override
	public void Inserir(K key, T data) throws NoInserit{
		if(taula[this.FuncioHash(key)]==null){
			taula[this.FuncioHash(key)] = new NodoHash<T,K>(null, key, data);
		}
		NodoHash<T, K> prev, actual = taula[this.FuncioHash(key)];
		boolean inserit=false;
		prev=actual;
		
		if(actual!=null) {
			while(actual !=null && !inserit) {
				if(actual.getKey().compareTo(key) == 0) {
					inserit=true;
					actual.setData(data);
				}else {
					prev=actual;
					actual=actual.getNext();
				}
			}
			if(!inserit) {
				actual=new NodoHash<T,K>(null, key, data);
				prev.setNext(actual);
				inserit=true;
			}
		}
		else {
			actual = new NodoHash<T,K>(null, key, data);
			inserit=true;
		}
		if(!inserit) {
			throw new NoInserit();
		}
		nElems++;
	}

	@Override
	public T obtenir(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int Buscar(K Key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Mida() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void Esborrar(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float ObtenirFactorDeCarrega() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
