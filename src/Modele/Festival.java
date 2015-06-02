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
	public boolean estReservable(int parJour, int parMois){
		return false;
		
	}
	

}
