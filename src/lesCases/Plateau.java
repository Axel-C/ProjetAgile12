package lesCases;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.sun.jmx.snmp.SnmpStringFixed;
import com.sun.org.apache.xpath.internal.operations.Gt;

import sun.misc.ThreadGroupUtils;
public class Plateau {
	private int y=getTaille();
	private int x=getTaille();
	private int numeroPlateau;
    private Affichable[][][] plateau;
	private int nbEquipe;
	private Random random;
	
	public Plateau() {
		x = getTaille();
		y = getTaille();
		numeroPlateau = 0;
	    plateau = new Affichable[x][y][3];
	    
	    generationPlateau(plateau);
        
		
	}
	
	public Plateau(int numPlateau) {
		x = getTaille();
		y = getTaille();
		numeroPlateau = numPlateau;
	    plateau = new Affichable[x][y][3];
	    
	    generationPlateau(plateau);
        
		
	}
	
	public Plateau(int x, int y,int numPlateau) {
		this.x = x;
		this.y = y;
		numeroPlateau = numPlateau;
	    plateau = new Affichable[this.x][this.y][3];
	    
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
						this.plateau[j][i][0] = new CaseNormal(tab);
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
		switch (numero)
		{
		  case 1:
			  
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
		    break; 
		  case 2:
			  
			  for(int i1=2; i1<x-2; i1++){
				  tab[0] = i1;
				  tab[1] = 4;
				  tab[2] = 0;
					this.plateau[i1][5][0] = new Rocher(tab);
			  }
			  
			  for (int i2=3; i2<x-3; i2++){
				  tab[0] = 5;
				  tab[1] = i2;
				  tab[2] = 0;
					this.plateau[5][i2][0] = new Rocher(tab);
			  }
			  
			break;
			
		  case 3:
			  for(int i1=2; i1<x-2; i1++){
				  tab[0] = 2;
				  tab[1] = i1;
				  tab[2] = 0;
					this.plateau[2][i1][0] = new Rocher(tab);
			  }
			  
			  for (int i2=2; i2<x-2; i2++){
				  tab[0] = x-2;
				  tab[1] = i2;
				  tab[2] = 0;
					this.plateau[x-3][i2][0] = new Rocher(tab);
			  }
			  break;
			  
		  
			  
			  
		  default:
		    /*Action*/;             
		}
		
		}
		
		public void afficher() {
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {

					System.out.print("|" + this.plateau[j][i][0].getRepresentation());
					
				}
				System.out.println("|");
			}
			System.out.println();
		}
		
		public void placer( int x , int y ,Case c){
			this.plateau[x][y][0] = c ;
		}
		public void placer(Affichable c){
			this.plateau[c.getX()][c.getY()][0] = c ;
		}
		
		public int getTaille(){
			FileReader lectureTaille;
			BufferedReader buffer;
			String tailleLue="";
			
			try {
				lectureTaille= new FileReader("options.txt");
				buffer=new BufferedReader(lectureTaille);
				tailleLue=buffer.readLine();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e){
				e.printStackTrace();
			}
			return Integer.parseInt(tailleLue);
		}
		
	
		public void setOptions (int taille){
			System.out.println("1");
			try {
				System.out.println("grde");
				FileWriter ffw=new FileWriter("options.txt");
				ffw.write(taille);
				ffw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("e");
				e.printStackTrace();
			}
		}
		
		public Case getCase(int x , int y){
			return (Case) plateau[x][y][0] ;
		}
		
	
	}


