package graphe;

public class Circuit {
	
	// la liste des valeurs des rangs
	private int[] rang;
	// la matrice adjacente en int avec 0 s'il n'y a pas de sommets, 1 sinon
	private int[][] matriceAdjacente;
	// liste des sommets supprimés
	private int[] deleteSommets;
	// le degrès actuellement dans la supression des sommets
	private int degrés;

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

	// Calcul les degrès de la matrice
	public int[] CalculDegresInt(int[][] matriceAdjacente, int nbSommets, int degrés)
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
	
	// Affiche les sommets supprimés, ajoute le sommet dans la liste des sommets supprimés, affiche lorsqu'il n'y a plus de sommet à supprimer
	public void Rang(int[] degresInt,int[] rang, int[] deleteSommets, int[][] matriceAdjacente, int degrés)
	{
		System.out.println("Points d'entrée :");
		int bool = 0; 
		for(int i = 0; i < degresInt.length;i++)
		{
			if(degresInt[i] == 0 && deleteSommets[i] == -2)
			{
				rang[i] = degrés;
				System.out.print(" " + i);
				deleteSommets[i] = degrés;
				deleteSommet(matriceAdjacente,i);
				bool = 1;
			}
		}
		
		if(bool == 0){
			System.out.println("Aucun");
			System.out.println("Le graphe contient au moins "+ (degrés) + " circuit");
		}
		else
			System.out.println(" ");
	}
	
	// Calcul le nombre de sommet supprimé
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
	
	// initialise la matrice de sommet supprimé
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
		System.out.println("*Détection de circuit\n*Méthode d'élimination des points d'entrée");
		int nbSommets = matriceAdjacenteTab.length;
		int[] degresInt;

		deleteSommetInit(deleteSommets);
		// matrice adjacente
		matriceAdjacenteConvert(matriceAdjacenteTab, matriceAdjacente);
		int deleteSommetSuiv;
		int deleteSommetPrec;
		degrés = 0;
		do{
		degresInt = CalculDegresInt(matriceAdjacente, nbSommets, degrés);
		
	    deleteSommetPrec = deleteCount(deleteSommets);
		Rang(degresInt,rang,deleteSommets, matriceAdjacente, degrés);
		deleteSommetSuiv = deleteCount(deleteSommets);
		degrés =+ 1;
		
		}while(deleteSommetSuiv != deleteSommetPrec );
		
	}

}
