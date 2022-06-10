package excepcions;

public class NoTrobat extends Exception{
	private static final long serialVersionUID=1L;
	
	public NoTrobat(int i) {
		super("Error: no s'ha trobat l'element, cost:" + i);
	}
}
