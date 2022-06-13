package excepcions;

public class NoTrobat extends Exception{
	private static final long serialVersionUID=1L;
	
	public NoTrobat() {
		super("Error: no s'ha trobat l'element");
	}
}
