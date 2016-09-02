package lesCases;

import java.awt.Color;

public class Game {
	boolean victoire=false;
	Serpent s1 ;
	Serpent s2 ;
	Serpent actif ;
	Interface controle ;
	
	

	public Game(Plateau plat){
		
		s1 = new Serpent(1, plat.getTaille()-2, plat.getTaille()-3);
		s2 = new Serpent(2, 1, 1);
		actif = s1 ;
		test.plateau.afficher();
		

//		char c;
//		
//		boolean b=true;
//		
//
//		Serpent s1 = new Serpent(1, plat.getTaille()-2, plat.getTaille()-3);
//		Serpent s2 = new Serpent(2, 1, 1);
//		Interface controle ;
//		
//		while(!victoire){
//			plat.afficher();
//			controle = new Interface();
//			c=getCar();
//			
//			System.out.println(b);
//			if(b){
//			
//				if(c=='z'){
//					s1.deplacer(Directions.NORD);
//				}else if (c=='q'){
//					s1.deplacer(Directions.OUEST);
//				}else if (c=='d'){
//					s1.deplacer(Directions.EST);
//				}else if (c=='s'){
//					s1.deplacer(Directions.SUD);
//				}else if (c=='e'){
//					System.out.println("Quitter le jeu ? (o/n)");
//					if(getCar()=='o'){
//						victoire=true;
//					}					
//				}
//				b=false;
//			}else {
//				if(c=='5'){
//					s2.deplacer(Directions.NORD);
//				}else if (c=='1'){
//					s2.deplacer(Directions.OUEST);
//				}else if (c=='3'){
//					s2.deplacer(Directions.EST);
//				}else if (c=='2'){
//					s2.deplacer(Directions.SUD);
//				}else if (c=='e'){
//					System.out.println("Quitter le jeu ? (o/n)");
//					if(getCar()=='o'){
//						victoire=true;
//					}	
//				}
//				b=!b;
//				
//			}
//			
//		}
		controle = new Interface();
		
		
	
	}
	
	public void tourSuivant(){
		test.plateau.afficher();
		if(actif.equals(s1)){
			actif = s2 ;
			controle.couleur.setBackground(Color.RED);
/*
		while(!victoire){
			plat.afficher();
			
			c=getCar();
			
			if(b){
			
				if(c=='z'){
					s1.deplacer(Directions.NORD);
				}else if (c=='q'){
					s1.deplacer(Directions.OUEST);
				}else if (c=='d'){
					s1.deplacer(Directions.EST);
				}else if (c=='s'){
					s1.deplacer(Directions.SUD);
				}else if (c=='e'){
					System.out.println("Quitter le jeu ? (o/n)");
					if(getCar()=='o'){
						victoire=true;
					}					
				}
				b=false;
			}else {
				if(c=='5'){
					s2.deplacer(Directions.NORD);
				}else if (c=='1'){
					s2.deplacer(Directions.OUEST);
				}else if (c=='3'){
					s2.deplacer(Directions.EST);
				}else if (c=='2'){
					s2.deplacer(Directions.SUD);
				}else if (c=='e'){
					System.out.println("Quitter le jeu ? (o/n)");
					if(getCar()=='o'){
						victoire=true;
					}	
				}
				b=!b;
				
			}
*/
			
		}else{
			actif = s1 ;
			controle.couleur.setBackground(Color.CYAN);
		}
		
	}
	public char getCar(){
		char c=' ';
		while (c==' '){
			try{
				c= new MonScanner().c;
			}catch(Exception e){
				c=' ';
			}
		}
		return c;
	}
	
	public void finDePartie(){
		controle.fermer();
		
	}
}