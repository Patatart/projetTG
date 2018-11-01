package graphe;

public class MatriceArcs {
	
	private String[][] matriceArcsTab;

	
	int sommetInit;
	int sommetTerm;
	int valeur;

	public MatriceArcs(String[][] matAds)
	{
		matriceArcsTab = matAds;
	}
	public void afficheMatArcs()
	{
		System.out.println("Valeur des arcs");
		System.out.print("  ");
		for (int j = 0; j < matriceArcsTab.length; j++)
		{
			System.out.print(j + " ");
		}
		System.out.println("");
		for (int i = 0; i < matriceArcsTab.length; i++)
		{
			System.out.print(i + " ");
			for (int j = 0; j < matriceArcsTab.length; j++)
			{
				System.out.print(matriceArcsTab[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	public void initMatArcs(String[][] matriceArcs_t)
	{
		for (int i = 0; i < matriceArcs_t.length; i++)
		{
			for (int j = 0; j < matriceArcs_t.length; j++)
			{
				matriceArcs_t[i][j] = "*";
			}
		}
	}
	
	public void remplirMatArcs(String[][] matriceArcs, int sommetInit, int sommetTerm,int valeur)
	{
		matriceArcs[sommetInit][sommetTerm] = String.valueOf(valeur);
	}
}
