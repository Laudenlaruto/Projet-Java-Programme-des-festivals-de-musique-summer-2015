package Modele;
/**
 * Classe qui defini les Festivals avec un nom, un genre, un tableau de Date, un lieu et un tableau de places
 * 
 * @author Benjamin
 *
 */
public class Festival {

	private String chNom;
	private String chGenre;
	private Date chDate[];
	private String chLieu;
	private int Places[];
	
	/**
	 * 
	 * @param chNom
	 * @param chGenre
	 * @param chDate
	 * @param chLieu
	 * @param places
	 */
	public Festival(String chNom, String chGenre, Date[] chDate, String chLieu, int[] places) {
		chNom = chNom;
		chGenre = chGenre;
		chDate = chDate;
		chLieu = chLieu;
		Places = places;
	}
	/**
	 * Fonction qui verifie si un festival est reservable pour un jour précis
	 * @param parJour
	 * @param parMois
	 * @return true si vrai
	 */
	public boolean estReservable(int parJour, int parMois){
		for (int i = 0;i< chDate.length;i++){
			if (chDate[i].getChMois() == parMois && chDate[i].getChJour()== parJour){
				if (Places[i] != 0){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Fonction qui verifie si un festival est complet
	 * @return true si vrai
	 */
	public boolean estComplet(){
		for(int i =0;i<chDate.length;i++){
			if(Places[i] != 0){
				return false;
			}
		}
		return true;
	}
}
