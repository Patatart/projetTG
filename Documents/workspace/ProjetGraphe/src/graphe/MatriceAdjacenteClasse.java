package graphe;

public class MatriceAdjacenteClasse {
	
	//matrice d'adjacence
	private String[][] matriceAdjacenteTab;

	
	int sommetInit;
	int sommetTerm;
	int valeur;

	public MatriceAdjacenteClasse(String[][] matAds)
	{
		matriceAdjacenteTab = matAds;
	}
	public void afficheMatAdj()
	{
		System.out.println("Matrice d'adjacence");
		System.out.print("  ");
		for (int j = 0; j < matriceAdjacenteTab.length; j++)
		{
			System.out.print(j + " ");
		}
		System.out.println("");
		for (int i = 0; i < matriceAdjacenteTab.length; i++)
		{
			System.out.print(i + " ");
			for (int j = 0; j < matriceAdjacenteTab.length; j++)
			{
				System.out.print(matriceAdjacenteTab[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void initMatAdj(String[][] matriceAdjacente_t)
	{
		for (int i = 0; i < matriceAdjacente_t.length; i++)
		{
			for (int j = 0; j < matriceAdjacente_t.length; j++)
			{
				matriceAdjacente_t[i][j] = "F";
			}
		}
	}
	
	public void remplirMatAdj(String[][] matriceAdjacence, int sommetInit, int sommetTerm,int valeur)
	{
		matriceAdjacenteTab[sommetInit][sommetTerm] = "V";
	}
}
