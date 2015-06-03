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
<<<<<<< HEAD
	private int Places[];
	private String chImagePath;
=======
	private int chPlaces[];
>>>>>>> branch 'InterfaceSaisie2' of https://github.com/Laudenlaruto/Projet-Java-Programme-des-festivals-de-musique-summer-2015.git
	public static final String[] Genres = {"Rock","Pop","Jazz","Electronique","Blues","Classique","Metal","Reggae"};
	/**
	 * 
	 * @param chNom
	 * @param chGenre
	 * @param chDate
	 * @param chLieu
	 * @param Places
	 */
<<<<<<< HEAD
	public Festival(String parNom, String parGenre, Date[] parDate, String parLieu, int[] parPlaces,String parImagePath) {
=======
	public Festival(String parNom, String parGenre, Date[] parDate, String parLieu, int[] parPlaces){
>>>>>>> branch 'InterfaceSaisie2' of https://github.com/Laudenlaruto/Projet-Java-Programme-des-festivals-de-musique-summer-2015.git
		chNom = parNom;
		chGenre = parGenre;
		chDate = parDate;
		chLieu = parLieu;
<<<<<<< HEAD
		Places = parPlaces;
		chImagePath = parImagePath;
	}
=======
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
>>>>>>> branch 'InterfaceSaisie2' of https://github.com/Laudenlaruto/Projet-Java-Programme-des-festivals-de-musique-summer-2015.git
	/**
	 * Méthode qui renvoie un string par rapport au jour de début et de fin du festival
	 * @param this
	 * @return
	 */
	public String toString(){
		if(this.chDate[0].getChMois()==this.chDate[this.chDate.length-1].getChMois()){
			if(this.chDate[0].getChJour()==this.chDate[this.chDate.length-1].getChJour()){
				return ("le Festival "+chNom+"\naura lieu à "+chLieu+"\nle \n "+chDate[0].toString()+" " +chDate[0].getChMoisAnnee());
			}
			return ("le Festival "+chNom+"\naura lieu à "+chLieu+" \ndu "+chDate[0].getChJour()+" au "+chDate[chDate.length-1].getChJour()+" " +chDate[0].getChMoisAnnee());
		}
		return ("le Festival "+chNom+"\naura lieu à \n"+chLieu+" \ndu "+chDate[0].toString()+" au "+chDate[chDate.length-1].toString());
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

	public int nombreDePlaceTotal(){
		int places=0;
		for (int i : Places) {
			places+=i;

		}
		return places;
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
	public void setChImagePath(String chImagePath) {
		this.chImagePath = chImagePath;
	}
}
