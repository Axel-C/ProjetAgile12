//////////////////////////////////////////////////////////////////////////////
//                         AUTEUR : THIBAULT CORBRION                       //
//////////////////////////////////////////////////////////////////////////////
package lesCases;
/**
 * 
 * @author thibault corbrion
 *
 */
public enum ObjetATrouver {
	
	pomme(1,Case.GREEN+"Q"+Case.RESET,1,0), pomme_pourri(2,Case.RED+"Q"+Case.RESET,-1,0), cafe(3,Case.GREEN+"U"+Case.RESET,0,1), tisane(4,Case.GREEN+"U"+Case.RESET,0,-1);

//////////////////////////////////////////////////////////////////////////////
//                               ATRIBUS                                    //
//////////////////////////////////////////////////////////////////////////////	
	private int numeroOBJ ;
	private static ObjetATrouver[] vecteurOBJ =values();
	private String representation;
	private int influenceTaille;
	private int influenceAction;
	
	/**
	 * Objet a trouver  qui prend un numero et une representation
	 * @param numero
	 *        numero entier : ici entre 1 et 7
	 * @param representation
	 *        representation  string : en vu de l affichage
	 */
	private ObjetATrouver(int numero,String representation,int influenceTaille,int influenceAction){
		this.numeroOBJ=numero;
		this.representation= representation;
		this.influenceTaille=influenceTaille;
		this.influenceAction=influenceAction;
	}
	/**
	 * Retourne le numero associer a un objet
	 * @retrun le numero associer a un objet		
	 */
	public int getnumeroObjetATrouver() {
		return numeroOBJ ;
	}
	/**
	 * Retourne la representaion associer a un objet
	 * @return la representaion associer a un objet
	 */
	public String getRepresentationObjetATrouver() {
		return representation ;
	}
	/**
	 * Retourne l objet associer au numero
	 * @param numero
	 * @return
	 */
	public static ObjetATrouver getObjetATrouver(int numero){
		return vecteurOBJ[numero-1];
	
	}
	/**
	 * Retourne la hauteur sur le plateau ici 2	
	 * @return 2
	 */
	public int getHauteur(){
		return 2;
	}
	public int getInfluenceTaille(){
		return influenceTaille;
	}
	public int getInfulenceAction(){
		return influenceAction;
	}

}
