package lesCases;


public class test {
	public static Plateau plateau;
	public static Game jeu ;

	public static void main(String[] args) {

		final Menu menu = new Menu() ;
		plateau = menu.getPlateauChoisi();
		  
		jeu = new Game(plateau);
	}
}
