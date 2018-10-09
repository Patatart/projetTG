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
	
	public int[] Rang(int[] degresInt,int[] rang, int nbIteration, int[] deleteSommets)
	{
		System.out.println("Points d'entrée : \n");
		for(int i = 0; i < degresInt.length;i++)
		{
			if(degresInt[i] == 0 && deleteSommets[i] != 0)
			{
				rang[i] = nbIteration;
				System.out.println(" " + i);
				deleteSommets[i] = 0;
			}
		}
		
		return rang;
	}
	
	public int deleteCont(int[] delete)
	{
		int count = 0;
		return count;
	}
	public Circuit(int nbSommets)
	{
	  rang = new int[nbSommets];
	  matriceAdjacente = new int[nbSommets][nbSommets];
	  deleteSommet = new int[nbSommets];
	}

}
