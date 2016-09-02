package lesCases;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	
	private Plateau plateauChoisi;
	private int taillePlateau=10;
	
	public Menu(){
		int choix;
		System.out.println(Case.BOLD + "Bonjour, voulez-vous :" + Case.RESET);
		System.out.println("1 : Jouer");
		System.out.println("2 : Option");
		System.out.println("3 : Regles");
		System.out.println("4 : Quitter");
		Scanner s = new Scanner(System.in);
		choix = s.nextInt();
		choix_menu(choix);
	}
	public void choix_menu(int choix){
		switch (choix)
		{
		  case 1:
		    jouer();
		    break; 
		  case 2 :
			option();
			break;
		  case 3 :
			try {
				regles();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		  case 4 :
			quitter();
			break;
		  default:
			  System.out.println("Choisissez une option valide");
			  new Menu();
		              
		}
	}
	private void quitter() {
		int n;
		System.out.println("L'application va se fermer, voulez vous continuer? (0 : quitter ou 1 : rester sur le jeu)");
		Scanner s = new Scanner(System.in);
		n=s.nextInt();
		if (n==0){
			System.exit(0);
		} else if (n==1) {
			new Menu();
		}
		
	}
	private void regles() throws IOException {
		FileReader inputReader;
		BufferedReader inputBuffer;
		String name = "";
		try {
			inputReader = new FileReader("regles.txt");
			inputBuffer = new BufferedReader(inputReader);
			name = inputBuffer.readLine();
			while(name != null){
				System.out.println(name);
				name = inputBuffer.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Menu();
	}
	private void option() {
		int scan;
		System.out.println("Que voulez-vous modifier?");
		System.out.println("1 : Taille du plateau");
		System.out.println("2 : Revenir au menu");
		Scanner s1=new Scanner(System.in);
		scan=s1.nextInt();
		if (scan==1){
			int taille;
			System.out.println("Quelle taille souhaitez-vous ?");
			Scanner s2=new Scanner(System.in);
			taille=s2.nextInt();
			while (taille<10 || taille > 25){
				taille=s2.nextInt();
			}
			this.taillePlateau=taille;
			try {
				
				FileWriter ffw=new FileWriter("options.txt");
				ffw.write(""+this.taillePlateau);
				ffw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("e");
				e.printStackTrace();
			}
			
		} else if (scan==2){
			new Menu();	
			
		}
			System.out.println(this.taillePlateau);
			
			new Menu();
		 
		
		
	}
	private void jouer() {
		int choix_plateau;
		System.out.println("Choisissez un plateau");
		
		for(int i = 1 ; i <5 ; i++){
			System.out.println(i);
			Plateau monPlateau = new Plateau(i-1);
			monPlateau.afficher();
			
		}
		Scanner s = new Scanner(System.in);
		choix_plateau = s.nextInt();
		while(choix_plateau<0 || choix_plateau>4){
			System.out.print("Entrez un choix valide entre 1 et 3");
			choix_plateau = s.nextInt();
		}
		
		plateauChoisi=new Plateau(choix_plateau); 
		
	}
	
	public Plateau getPlateauChoisi() {
		return plateauChoisi;  
	}
}
