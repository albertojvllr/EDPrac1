package hash_table;

public class NodoHash<T extends Comparable<T>, K extends Comparable<K>> implements Comparable<T> {

	private NodoHash<T,K> next;
	private K key;
	private T data;
	
	public NodoHash() {
		next=null;
		key=null;
		data=null;
	}
	public NodoHash(NodoHash<T,K> next, K key, T data) {
		this.next = next;
		this.key = key;
		this.data=data;
	}
	public void setNext(NodoHash<T,K> next) {
		this.next=next;
	}
	public void setKey(K key) {
		this.key=key;
	}
	public void setData(T data) {
		this.data=data;
	}
	public NodoHash<T,K> getNext(){
		return next;
	}
	public K getKey() {
		return key;
	}
	public T getData() {
		return data;
	}

	@Override
	public int compareTo(T o) {
		if(data.compareTo(o)==0) {			
			return 0;
		}
		return -1;
	}

}
