public class Ciutada implements Comparable<Ciutada>{

    private String nom;
    private String cognom;
    private String DNI;
    
    //Constructor sense parametres
    public Ciutada() {
        nom = "Alberto";
        cognom = "Jovellar";
        DNI = "48054983W";
    }
    
    /**
     * Constructor d'un Ciutada
     * @param nom del Ciutada
     * @param cognom del Ciutada
     * @param DNI del Ciutada
     */
    public Ciutada(String nom, String cognom, String DNI) {
        this.setNom(nom);
        this.cognom = cognom;
        this.DNI = DNI;
    }

    /**
     * Getter del nom
     * @return el nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter del nom
     * @param nom del ciutada
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Getter del cognom
     * @return retorna el cognom
     */
    public String getCognom() {
        return cognom;
    }

    /**
     * Setter del cognom
     * @param cognom cognom del ciutada
     */
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    /**
     * Getter del DNI
     * @return el DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Setter del DNI
     * @param DNI DNI del ciutada
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public int compareTo(Ciutada ciut) {
        if(ciut.getDNI().equals(this.getDNI())) {
            return 0;
        }else {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return "Nom -> " + this.nom + "\nCognom -> " + this.cognom + "\nDNI -> " + this.DNI + "\n\n\n";
    }
}
