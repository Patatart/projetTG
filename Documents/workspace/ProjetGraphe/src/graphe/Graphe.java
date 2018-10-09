package graphe;

import java.io.*;
import java.util.ArrayList;

public class Graphe {
	
	// liste des sommmets du graphe
	private ArrayList<Sommet> sommets;
	
	// liste des arcs du graphe
	private ArrayList<Arc> arcs;
	
	/**
	 * Construction du graphe a partir du fichier
	 * @param nomFichier nom du fichier a traiter
	 */
	public Graphe( String nomFichier ) {
		// initialisation des listes
		sommets = new ArrayList<Sommet>();
		arcs    = new ArrayList<Arc>();
		
		// initialisation de la lecture du fichier
		System.out.println("* Lecture du graphe sur fichier");
		BufferedReader br = null;
		try {
			br = new BufferedReader( new FileReader( new File( "donnees/" + nomFichier ) ) );
		} catch ( FileNotFoundException e ) { e.printStackTrace(); }
		
		// lecture du fichier et remplissage du graphe
		try {
			// creation des sommets
			int nbSommets = Integer.parseInt( br.readLine() );
			System.out.println( nbSommets + " sommets" );
			for( int i = 0; i < nbSommets; i++ )
				sommets.add( new Sommet(i) );
			
			// creation des arcs et remplissage des sommets
			int nbArcs = Integer.parseInt( br.readLine() );
			System.out.println( nbArcs + " arcs" );
			Arc nvArc;
			String[] donneesArc;
			int sommetInit, sommetTerm, valeur;
			for( int i = 0; i < nbArcs; i++ ) {
				donneesArc = br.readLine().split(" ");
				sommetInit = Integer.parseInt( donneesArc[0] );
				sommetTerm = Integer.parseInt( donneesArc[1] );
				valeur     = Integer.parseInt( donneesArc[2] );
				nvArc = new Arc( sommetInit, sommetTerm, valeur );
				
				arcs.add(nvArc);
				sommets.get( nvArc.getSommetInit() ).addArcSortant(nvArc);
				sommets.get( nvArc.getSommetTerm() ).addArcEntrant(nvArc);
				
				// affichage de l'arc cree
				System.out.println(nvArc);
			}
		} catch ( IOException e ) { e.printStackTrace(); }
	}
	
	// Getters
	public int getNbSommets() { return sommets.size(); }
	public int getNbArcs()    { return arcs.size();    }
	
	public static void main( String[] args ) {
		Graphe graph1 = new Graphe( "graphe2.txt" );
		
		
	}

}
