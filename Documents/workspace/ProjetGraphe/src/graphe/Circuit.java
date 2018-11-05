package graphe;

public class Circuit {
	
	// la liste des valeurs des rangs
	private int[] rang;
	// la matrice adjacente en int avec 0 s'il n'y a pas de sommets, 1 sinon
	private int[][] matriceAdjacente;
	// liste des sommets supprim�s
	private int[] deleteSommets;
	// le degr�s actuellement dans la supression des sommets
	private int degr�s;

	// Constructeur
	public Circuit(int nbSommets)
	{
	  rang = new int[nbSommets];
	  matriceAdjacente = new int[nbSommets][nbSommets];
	  deleteSommets = new int[nbSommets];
	}
	
	
	// Convertit la matrice de string en int
	public void matriceAdjacenteConvert(String[][] matriceAdjacenteTab, int[][] matriceAdjacente)
	{
		for(int i = 0;i < matriceAdjacenteTab.length ;i++){
			for(int j = 0; j < matriceAdjacenteTab.length; j++){
				if(matriceAdjacenteTab[i][j] == "V")
					matriceAdjacente[i][j] = 1;
				else
					matriceAdjacente[i][j] = 0;
			}
		}
	}

	// Calcul les degr�s de la matrice
	public int[] CalculDegresInt(int[][] matriceAdjacente, int nbSommets, int degr�s)
	{
		int[] degresInt = new int[nbSommets];
		for(int k = 0;k < nbSommets; k++)
			degresInt[k] = 0;
		
		for(int i = 0; i < nbSommets ;i++)
		{
			for(int j = 0; j < nbSommets; j++)
				degresInt[i] += matriceAdjacente[j][i];
		}
		
		return degresInt;
	}
	
	// Affiche les sommets supprim�s, ajoute le sommet dans la liste des sommets supprim�s, affiche lorsqu'il n'y a plus de sommet � supprimer
	public void Rang(int[] degresInt,int[] rang, int[] deleteSommets, int[][] matriceAdjacente, int degr�s)
	{
		System.out.println("Points d'entr�e :");
		int bool = 0; 
		for(int i = 0; i < degresInt.length;i++)
		{
			if(degresInt[i] == 0 && deleteSommets[i] == -2)
			{
				rang[i] = degr�s;
				System.out.print(" " + i);
				deleteSommets[i] = degr�s;
				deleteSommet(matriceAdjacente,i);
				bool = 1;
			}
		}
		
		if(bool == 0){
			System.out.println("Aucun");
			System.out.println("Le graphe contient au moins "+ (degr�s) + " circuit");
		}
		else
			System.out.println(" ");
	}
	
	// Calcul le nombre de sommet supprim�
	public int deleteCount(int[] deleteSommets)
	{
		int count = 0;
		for(int i = 0; i < deleteSommets.length; i++)
		{
			if(deleteSommets[i] >= -1)
				count++;
		}
		return count;
	}
	
	// initialise la matrice de sommet supprim�
	public void deleteSommetInit(int[] deleteSommets)
	{
		for(int i = 0; i < deleteSommets.length; i++)
			deleteSommets[i] = -2;
	}
	
	// supprime dans la matrice le sommet voulu
	public void deleteSommet(int[][] matriceAdjacente,int j){
		for(int i = 0; i < matriceAdjacente.length;i++)
		{
			matriceAdjacente[j][i] = 0;
		}
	}
	
	
	
	public void DetectionCircuit(String[][] matriceAdjacenteTab){
		System.out.println("*D�tection de circuit\n*M�thode d'�limination des points d'entr�e");
		int nbSommets = matriceAdjacenteTab.length;
		int[] degresInt;

		deleteSommetInit(deleteSommets);
		// matrice adjacente
		matriceAdjacenteConvert(matriceAdjacenteTab, matriceAdjacente);
		int deleteSommetSuiv;
		int deleteSommetPrec;
		degr�s = 0;
		do{
		degresInt = CalculDegresInt(matriceAdjacente, nbSommets, degr�s);
		
	    deleteSommetPrec = deleteCount(deleteSommets);
		Rang(degresInt,rang,deleteSommets, matriceAdjacente, degr�s);
		deleteSommetSuiv = deleteCount(deleteSommets);
		degr�s =+ 1;
		
		}while(deleteSommetSuiv != deleteSommetPrec );
		
	}

}
