package Modele;
/**
 * Classe qui definit les festivals avec un nom, un genre, un tableau de Date, un lieu et un tableau de places
 * 
 * @author Benjamin, Loïc
 *
 */
public class Festival {

	private String chNom;
	private String chGenre;
	private Date chDate[];
	private String chLieu;
	private int chPlaces[];
	public static final String[] Genres = {"Rock","Pop","Jazz","Electronique","Blues","Classique","Metal","Reggae"};
	/**
	 * 
	 * @param chNom
	 * @param chGenre
	 * @param chDate
	 * @param chLieu
	 * @param Places
	 */
	public Festival(String parNom, String parGenre, Date[] parDate, String parLieu, int[] parPlaces){
		chNom = parNom;
		chGenre = parGenre;
		chDate = parDate;
		chLieu = parLieu;
		chPlaces = parPlaces;
	}//Festival()
	
	public Festival(String parNom, String parGenre, Date parDate1, Date parDate2, String parLieu, int parPlace) throws ExceptionDate{ 
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
	}//Festival()
	/**
	 * Méthode qui renvoie un string par rapport au jour de début et de fin du festival
	 * @param parFestival
	 * @return
	 */
	public String toString(Festival parFestival){
		if(parFestival.chDate[0].getChMois()==parFestival.chDate[parFestival.chDate.length-1].getChMois()){
			if(parFestival.chDate[0].getChJour()==parFestival.chDate[parFestival.chDate.length-1].getChJour()){
				return ("le Festival \n "+chNom+"\n aura lieu à "+chLieu+" \n le \n "+chDate[0].toString());
			}
			return ("le Festival \n "+chNom+"\n aura lieu à "+chLieu+" \n du \n "+chDate[0].getChJour()+"au"+chDate[chDate.length-1].getChJour());
		}
		return ("le Festival \n "+chNom+"\n aura lieu à "+chLieu+" \n du \n "+chDate[0].toString()+"\n au \n "+chDate[chDate.length-1].toString());
	}
	/**
	 * Méthode qui permet de vérifier si il y a des places de libres pour un festivals
	 * @param parJour
	 * @param parMois
	 * @return
	 */
	public boolean estReservable(int parJour, int parMois){
		for (int i = 0;i< chDate.length;i++){
			if (chDate[i].getChMois() == parMois && chDate[i].getChJour()== parJour){
				if (chPlaces[i] != 0){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Méthode qui verifie si un festival est complet
	 * @return true si vrai
	 */
	public boolean estComplet(){
		for(int i =0;i<chDate.length;i++){
			if(chPlaces[i] != 0){
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
