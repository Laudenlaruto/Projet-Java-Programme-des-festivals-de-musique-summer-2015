package Modele;
/**
 * Classe qui defini les festivals avec un nom, un genre, un tableau de Date, un lieu et un tableau de places
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
	 * @param Places
	 */
	public Festival(String parNom, String parGenre, Date[] parDate, String parLieu, int[] parPlaces) {
		chNom = parNom;
		chGenre = parGenre;
		chDate = parDate;
		chLieu = parLieu;
		Places = parPlaces;
	}
	/**
	 * Fonction qui verifie si un festival est reservable pour un jour précis
	 * @param parJour
	 * @param parMois
	 * @return true si vrai
	 */
	public String toString(){
		return ("le Festival : "+chNom+" aura lieu : "+chLieu+"du "+chDate[0].toString()+"au "+chDate[chDate.length-1].toString());
	}
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
	//Getter ----------------------
	public String getChNom() {
		return chNom;
	}
	public void setChNom(String chNom) {
		this.chNom = chNom;
	}
	public String getChGenre() {
		return chGenre;
	}
	//Setter --------------------
	public void setChGenre(String chGenre) {
		this.chGenre = chGenre;
	}
	public String getChLieu() {
		return chLieu;
	}
	public void setChLieu(String chLieu) {
		this.chLieu = chLieu;
	}
}
