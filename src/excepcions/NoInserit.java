package excepcions;

public class NoInserit extends Exception{
	public static final long serialVersionUID=1L;
	public NoInserit() {
		super("Error; No s'ha inserit l'element");
	}
}
