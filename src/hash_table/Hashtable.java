package hash_table;
import excepcions.NoEsborrat;
import excepcions.NoObtingut;
import excepcions.NoTrobat;
import linked_list.Linked_List;
import excepcions.NoInserit;

public class Hashtable<T extends Comparable<T>,K extends Comparable<K>> implements TAD_Hashtable<T,K> {

	private final int mida=25;
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
	public T obtenir(K key) throws NoObtingut{
		NodoHash<T,K>actual=taula[this.FuncioHash(key)];
		while(actual !=null) {
			if(actual.getKey().compareTo(key)==0) {
				return actual.getData();
			}
			else {
				actual=actual.getNext();
			}
		}
		throw new NoObtingut();
	}

	@Override
	public int Buscar(K key) throws NoTrobat{
		NodoHash<T,K> actual= taula[this.FuncioHash(key)];
		int x=1;
		while(actual != null) {
			if(actual.getKey().compareTo(key)==0) {
				return x;
			}else {
				actual=actual.getNext();
				x++;
			}
		}
		throw new NoTrobat(x);
	}

	@Override
	public int Mida() {
		return nElems;
	}

	@Override
	public void Esborrar(K key) throws NoEsborrat{
		NodoHash<T,K> prev, actual = taula[this.FuncioHash(key)];
		prev=null;
		boolean borrat=false;
		while(actual!=null) {
			if(actual.getKey().compareTo(key)==0) {
				if(prev==null) {
					taula[this.FuncioHash(key)]=actual.getNext();
				}else {
					prev.setNext(actual.getNext());
				}
				actual=null;
				borrat=true;
			}else {
				prev=actual;
				actual=actual.getNext();
			}
		}
		if(!borrat) {
			throw new NoEsborrat();
		}
		nElems--;
	}

	@Override
	public Linked_List<T> ObtenirValors() throws NoInserit{
		Linked_List<T> llista = new Linked_List<T>();
		NodoHash<T,K> actual;
		for(int i=0; i<mida; i++) {
			actual=taula[i];
			while(actual!=null) {
				try {
					llista.Inserir(actual.getData());
				} catch (Exception e) {
					throw new NoInserit();
				}
				actual=actual.getNext();
			}
		}
		return llista;
	}

	@Override
	public Linked_List<K> ObtenirClaus() throws NoInserit{
		Linked_List<K> llista = new Linked_List<K>();
		NodoHash<T,K> actual;
		for(int i=0; i<mida; i++) {
			actual=taula[i];
			while(actual!=null) {
				try {
					llista.Inserir(actual.getKey());
				} catch (Exception e) {
					throw new NoInserit();
				}
				actual=actual.getNext();
			}
		}
		return llista;
	}

	@Override
	public float ObtenirFactorDeCarrega() {
		return (float)nElems/mida;
	}
	public int FuncioHash(K key) {
		int clau=0;
		String tmp=key.toString();
		for(int i=0; i<tmp.length();i++) {
			clau=clau+tmp.codePointAt(i);
		}
		
		return (int)clau%mida;
	}
}
