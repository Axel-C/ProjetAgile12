package lesCases;
import java.util.*;
public class Plateau {
	private int y;
	private int x;
	private int numeroPlateau;
    private Affichable[][][] plateau;
	private int nbEquipe;
	private Random random;
	
	public Plateau() {
		x = 10;
		y = 10;
		numeroPlateau = 0;
	    plateau = new Affichable[x][y][3];
	    
	    generationPlateau(plateau);
        
		
	}
	
	private void generationPlateau(Affichable[][][] plateau) {
		
		int[] tab = new int[3];
				/// PLATEAU VIERGE UNIQUEMENT CASE NORMAL
				for (int i = 0; i < y; i++) {
					for (int j = 0; j < x; j++) {
						tab[0] = j;
						tab[1] = i;
						tab[2] = 0;
						this.plateau[j][i][0] = new CaseNormal(tab, 20);
					}
				}

				// CONTOUR EN ROCHER
				genereContour(plateau);
				genereMotif(plateau,numeroPlateau);
				
		}
	
	private void genereContour(Affichable[][][] plateau) {

		int[] tab = new int[3];
		for (int i1 = 0; i1 < x; i1++) {
			tab[0] = i1;
			tab[1] = 0;
			tab[2] = 0;
			this.plateau[i1][0][0] = new Rocher(tab);
			tab[0] = i1;
			tab[1] = y - 1;
			tab[2] = 0;
			this.plateau[i1][y - 1][0] = new Rocher(tab);
		}

		for (int j = 0; j < y; j++) {
			tab[0] = 0;
			tab[1] = j;
			tab[2] = 0;
			this.plateau[0][j][0] = new Rocher(tab);
			tab[0] = x - 1;
			tab[1] = j;
			tab[2] = 0;
			this.plateau[x - 1][j][0] = new Rocher(tab);
		}
	}
	private void genereMotif(Affichable[][][] plateau,int numero){
		
		int[] tab = new int[3];
		for (int i1 =2 ; i1 < x-2 ; i1++) {
			tab[0] = i1;
			tab[1] = 2;
			tab[2] = 0;
			this.plateau[i1][2][0] = new Rocher(tab);
		}
		for (int i1 =2 ; i1 < x-2 ; i1++) {
			tab[0] = i1;
			tab[1] = y-2;
			tab[2] = 0;
			this.plateau[i1][y-3][0] = new Rocher(tab);
		}
		}
		
		public void afficher() {
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {

					System.out.print("|" + this.plateau[j][i][0].getRepresentationEquipe1());
					
				}
				System.out.println("|");
			}
			System.out.println();
		}
		
	
	}

