package lesCases;


public class test {
	public static Plateau plateau;

	public static void main(String[] args) {

		final Menu menu = new Menu() ;
		plateau = menu.getPlateauChoisi();
		  
		new Game();
	}
}
