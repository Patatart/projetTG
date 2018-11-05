package graphe;

public class Circuit {
	
	private int[] rang;
	private int[][] matriceAdjacente;
	private int[] deleteSommets;

	public void affiche() {
		System.out.println("*Détection de circuit\n*Méthode d'élimination des points d'entrée");
	}
	public int[] CalculDegresInt(int[][] matriceAdjacente, int nbSommets)
	{
		int[] degresInt = new int[nbSommets];
		for(int k = 0;k < nbSommets; k++)
			degresInt[k] = 0;
		
		for(int i = 0; i < nbSommets ;i++)
		{
			for(int j = 0; j < nbSommets; j++)
			{
				degresInt[i] += matriceAdjacente[j][i];
			}
		}
		
		return degresInt;
	}
	
	public int[] Rang(int[] degresInt,int[] rang, int nbIteration, int[] deleteSommets, int[][] matriceAdjacente)
	{
		System.out.println("Points d'entrée : \n");
		for(int i = 0; i < degresInt.length;i++)
		{
			if(degresInt[i] == 0 && deleteSommets[i] != 0)
			{
				rang[i] = nbIteration;
				System.out.println(" " + i);
				deleteSommets[i] = 0;
				deleteSommet(matriceAdjacente, degresInt.length,i);
			}
		}
		
		return rang;
	}
	
	public int deleteCount(int[] deleteSommets)
	{
		int count = 0;
		for(int i = 0; i < deleteSommets.length; i++)
		{
			if(deleteSommets[i] == 0)
				count++;
		}
		return count;
	}
	public int[] deleteSommetInit(int[] deleteSommets)
	{
		for(int i = 0; i < deleteSommets.length; i++)
			deleteSommets[i] = 1;
		return deleteSommets;
	}
	
	public int[][] deleteSommet(int[][] matriceAdjacente, int longueur,int j){
		for(int i = 0; i < longueur;i++)
		{
			matriceAdjacente[j][i] = 0;
		}
		return matriceAdjacente;
	}
	
	public Circuit(int nbSommets)
	{
	  rang = new int[nbSommets];
	  matriceAdjacente = new int[nbSommets][nbSommets];
	  deleteSommets = new int[nbSommets];
	}
	
	public void DetectionCircuit(int nbSommets){
		affiche();
		Circuit circuit = new Circuit(nbSommets); // pas forcément utile
		
		rang = new int[nbSommets];
		matriceAdjacente = new int[nbSommets][nbSommets];
		deleteSommets = new int[nbSommets];
		int[] degresInt;
		deleteSommets = deleteSommetInit(deleteSommets);
		// matrice adjacente
		int nbIteration = 0;
		int deleteSommetSuiv;
		int deleteSommetPrec;
		
		do{
		degresInt = CalculDegresInt(matriceAdjacente, nbSommets);
		
	    deleteSommetPrec = deleteCount(deleteSommets);
		rang = Rang(degresInt,rang, nbIteration,deleteSommets, matriceAdjacente);
		
		deleteSommetSuiv = deleteCount(deleteSommets);
		nbIteration =+ 1;
		}while(deleteSommetSuiv != deleteSommetPrec );
		
	}

}
