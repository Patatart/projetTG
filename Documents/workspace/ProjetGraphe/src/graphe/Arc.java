package graphe;

public class Arc {

	// sommet initial de l'arc
	private int sommetInit;
	
	// sommet terminal de l'arc
	private int sommetTerm;
	
	// valeur de l'arc
	private int valeur;
	
	public Arc( int sommetInit, int sommetTerm, int valeur ) {
		this.sommetInit = sommetInit;
		this.sommetTerm = sommetTerm;
		this.valeur     = valeur;
	}

	// Getters
	public int getSommetInit() { return sommetInit; }
	public int getSommetTerm() { return sommetTerm; }
	public int getValeur()     { return valeur;     }
	
	public String toString() {
		return sommetInit + " -> " + sommetTerm + " = " + valeur;
	}
}