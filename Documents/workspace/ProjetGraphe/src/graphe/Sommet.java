package graphe;

import java.util.ArrayList;

public class Sommet {
	
	// numero du sommet
	private int nSommet;
	
	// liste des arcs entrants
	private ArrayList<Arc> arcsEntr;
	
	// liste des arcs sortants
	private ArrayList<Arc> arcsSort;
	
	/**
	 * Constructeur simple qui appelle le constructeur complet avec des ArrayList vides
	 * @param numSommet numero du sommet
	 */
	public Sommet( int numSommet ) {
		this( numSommet, new ArrayList<Arc>(), new ArrayList<Arc>() );
	}
	
	/**
	 * Constructeur complet
	 * @param numSommet numero du sommet
	 * @param arcsEntrants liste des arcs entrants
	 * @param arcsSortants liste des arcs sortants
	 */
	public Sommet( int numSommet, ArrayList<Arc> arcsEntrants, ArrayList<Arc> arcsSortants ) {
		nSommet  = numSommet;
		arcsEntr = arcsEntrants;
		arcsSort = arcsSortants;
	}
	
	/**
	 * Ajout d'un arc entrant au sommet
	 * @param arc l'arc à ajouter
	 */
	public void addArcEntrant( Arc arc ) { arcsEntr.add( arc ); }
	
	/**
	 * Ajout d'un arc sortant au sommet
	 * @param arc l'arc à ajouter
	 */
	public void addArcSortant( Arc arc ) { arcsSort.add( arc ); }

	// Getters
	public int getnSommet() { return nSommet; }
	public ArrayList<Arc> getArcsEntr() { return arcsEntr; }
	public ArrayList<Arc> getArcsSort() { return arcsSort; }
	
}
