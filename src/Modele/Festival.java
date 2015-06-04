package Modele;

import java.io.Serializable;

/**
 * Classe qui definit les festivals avec un nom, un genre, un tableau de Date, un lieu, un tableau de places, un chemin d'image et un prix
 * 
 * @author Benjamin, Loïc
 *
 */
public class Festival implements Serializable {

	private String chNom;
	private String chGenre;
	private Date chDate[];
	private String chLieu;
	private String chImagePath;
	private int chPlaces[];
	private int chPrix;
	public static final String[] Genres = {"Rock","Pop","Jazz","Electronique","Blues","Classique","Metal","Reggae"};
	
	/**
	 * Constructeur permettant de rentrer directement le tableau de date
	 * 
	 * @param parNom
	 * @param parGenre
	 * @param parDate
	 * @param parLieu
	 * @param parPlaces
	 * @param parImagePath
	 * @param parPrix
	 */

	public Festival(String parNom, String parGenre, Date[] parDate, String parLieu, int[] parPlaces, String parImagePath, int parPrix) {

		chNom = parNom;
		chGenre = parGenre;
		chDate = parDate;
		chLieu = parLieu;
		chImagePath = parImagePath;
		chPlaces = parPlaces;
		chPrix = parPrix;
	}//Festival()
	
	/**
	 * Constructeur prennant cette fois deux dates et crée l'intervale via la fonction intervaleFestival() de date
	 * 
	 * @param parNom
	 * @param parGenre
	 * @param parDate1
	 * @param parDate2
	 * @param parLieu
	 * @param parPlace
	 * @param parImagePath
	 * @param parPrix
	 * @throws ExceptionDate
	 */
	
	public Festival(String parNom, String parGenre, Date parDate1, Date parDate2, String parLieu, int parPlace, String parImagePath, int parPrix) throws ExceptionDate{ 
		chNom = parNom;
		chGenre = parGenre;
		chLieu = parLieu;
		Date[] tabDate = parDate1.intervaleFestival(parDate2);
		int[] tabPlace = new int[tabDate.length];
		int place = parPlace;
		for (int i = 0; i < tabDate.length; i++){
			tabPlace[i]=place;
		}//for
		chDate = tabDate;
		chPlaces = tabPlace;
		chPrix = parPrix;
		chImagePath = parImagePath;
	}//Festival()
	
	/**
	 * Méthode qui renvoie un string selon le jour de début et le jour fin du festival
	 * @param this
	 * @return String
	 */
	
	public String toString(){
		if(this.chDate[0].getChMois()==this.chDate[this.chDate.length-1].getChMois()){
			if(this.chDate[0].getChJour()==this.chDate[this.chDate.length-1].getChJour()){
				return ("le Festival "+chNom+" \nAura lieu à "+chLieu+" \nLe "+chDate[0].toString());
			}
			return ("le Festival "+chNom+" \nAura lieu à "+chLieu+" \nDu "+chDate[0].getChJour()+" au "+chDate[chDate.length-1].getChJour()+" " +chDate[0].getChMoisAnnee());
		}
		return ("le Festival "+chNom+" \nAura lieu à \n"+chLieu+" \nDu "+chDate[0].toString()+" au "+chDate[chDate.length-1].toString());
	}
	
	/**
	 * 
	 * Méthode qui permet de vérifier si il y a des places de libres pour un festival
	 * 
	 * @param parJour
	 * @param parMois
	 * @return int du nombre de place disponible
	 */
	
	public int nombreDePlace(Date parDate){
		int i =0;
		for (Date date : chDate) {
			if (date.equals(parDate)){
					return chPlaces[i];
			}
			i++;
		}
		return 0;
	}

	/**
	 * 
	 * Méthode qui renvoit le nombre de place total du festival (utilisation pour BoutonFestival)
	 * 
	 * @return int
	 */
	
	public int nombreDePlaceTotal(){
		int places=0;
		for (int i : chPlaces) {
			places+=i;

		}
		return places;
	}
	
	/**
	 * 
	 * Méthode qui décrémente chPlace du festival (permet la réservation)
	 * 
	 * @param parDate (pour décrémenter selon la date)
	 */
	
	public void reservationFestival(Date parDate){
		int i=0;
		for (Date date : chDate) {
			if (date.equals(parDate))
					this.chPlaces[i]=chPlaces[i]-1;
			i++;
			}
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
	public String getChImagePath() {
		return chImagePath;
	}
	public int getChPlace(int i){
		return chPlaces[i];
	}
	public Date getchDate(int i){
		return chDate[i];
	}
	public void setChImagePath(String chImagePath) {
		this.chImagePath = chImagePath;
	}

	public int getChPrix() {
		return chPrix;
	}

	public void setChPrix(int chPrix) {
		this.chPrix = chPrix;
	}

	public Date[] getChDate() {
		return chDate;
	}

	public void setChDate(Date[] chDate) {
		this.chDate = chDate;
	}

	public int[] getChPlaces() {
		return chPlaces;
	}

	public void setChPlaces(int[] chPlaces) {
		this.chPlaces = chPlaces;
	}
}
