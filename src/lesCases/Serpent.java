package lesCases;

import java.util.ArrayList;
import java.util.List;

public class Serpent {
	int id;
	private int taille;
	private ArrayList<Corp> serpent;
	private int direction;
	private Tete tete;

	public Serpent(int id, int x, int y) {
		serpent = new ArrayList<Corp>();
		tete = new Tete(x, y, id);
		test.plateau.placer(x, y, tete);
		serpent.add(new Corp(id, x, y + 1));
		test.plateau.placer(x, y + 1, new Corp(id, x, y + 1));
		//serpent.add(new Corp(id, x, y + 2));
		//test.plateau.placer(x, y + 2, new Corp(id, x, y + 2));

	}

	public void grandir() {
		taille = taille++;
	}

	public void deplacer(int direction) {
		
		int teteX = tete.getX() ;
		int teteY = tete.getY();
		Case arrivee = new Case(0,0) {
			
			@Override
			public int getNumeroEquipe() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
 		
		if (direction == Directions.NORD) {
			
			arrivee = test.plateau.getCase(teteX, teteY - 1);
			tete.y--;
			

		}
		if (direction == Directions.EST) {
			arrivee = test.plateau.getCase(teteX + 1, teteY);
			tete.x++;
		}
		if (direction == Directions.SUD) {
			arrivee = test.plateau.getCase(teteX, teteY + 1);
			tete.y++;
		}
		if (direction == Directions.OUEST) {
			arrivee = test.plateau.getCase(teteX - 1, teteY);
			tete.x--;

		}
		if(!test.plateau.getCase(teteX, teteY).estfranchissable()){
			
		}
		test.plateau.placer(tete);
		ArrayList<Corp> copie = (ArrayList<Corp>) serpent.clone(); 
		serpent.get(0).x = teteX ;
		serpent.get(0).y = teteY ;
		test.plateau.placer(serpent.get(0));
		for(int i = 1 ; i < serpent.size() ; i++){
			serpent.get(i).x = copie.get(i - 1).getX() ;
			serpent.get(i).y = copie.get(i - 1).getY();
			test.plateau.placer(serpent.get(i));
					
		}
if(!arrivee.estfranchissable()){
	System.out.println("X : "+ teteX + " Y : " + teteY);
	
		if(id == 1){
			System.out.println(Case.BLUE + "L'équipe 2 a gagné" + Case.RESET);
		}else{
			System.out.println(Case.RED + "L'équipe 1 à gagné" + Case.RESET);
		}
		test.jeu.finDePartie();
}
		
		

	}

	/*
	 * public Snacke(){ numeroEquipe=1; taille=0; serpent.add(new tete(1,x,y));
	 * }
	 */

	/*
	 * public void getBigger(){ this.serpent.add(new corp(1,x,y)); }
	 */

	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getNumeroEquipe() {
		// TODO Auto-generated method stub
		return 0;
	}

}
