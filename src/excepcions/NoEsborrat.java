package excepcions;

public class NoEsborrat extends Exception{
	public static final long serialVersionUID=1L;
	public NoEsborrat() {
		super("Error: No s'ha esborrat l'element");
	}
}
