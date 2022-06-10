package excepcions;

public class NoObtingut extends Exception {
	private static final long serialVersionUID=1L;
	public NoObtingut() {
		super("Error; No s'ha obtingut l'element");
	}
}
