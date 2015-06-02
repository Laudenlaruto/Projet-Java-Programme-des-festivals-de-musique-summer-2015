package Modele;
 import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
/**
 * Classe qui permet de cr�er une date contenant:
 * le jour, le mois, l'ann�e, le numero du jour de la semaine en int
 * et le jour de la semaine, ainsi que le nom du mois en String
 * @author Benjamin, Lo�c
 *
 */
public class Date implements Serializable
{
	private int chJour; //Champ&Attribut
	private int chMois;
	private int chAn;
	private String chJourSemaine; 
	private int chNumSemaine;
	private String chMoisAnnee;
	private static final String[] JourDeSemaine = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi"};
	private static final String[] moisDeLannee = {"Janvier","F�vrier","Mars","Avril","Mai","Juin","Juillet","Ao�t","Septembre","Octobre","Novembre","Decembre"};
	//Tableau des jours de la semaine pour se servir de la fonction get day of week de Greogrian calendar. (-1 parcque tableau commence a 0)

		/**
		 * Constructeur par D�fault qui renvoie la date courante
		 */
		public Date ()
		{
			GregorianCalendar dateAuj = new GregorianCalendar();
			chAn = dateAuj.get(Calendar.YEAR);
			chMois = dateAuj.get(Calendar.MONTH)+1;
			chJour = dateAuj.get(Calendar.DAY_OF_MONTH);
			chJourSemaine = JourDeSemaine[dateAuj.get(Calendar.DAY_OF_WEEK)-1];
			chNumSemaine = dateAuj.get(Calendar.DAY_OF_WEEK);
			chMoisAnnee = moisDeLannee[chMois-1];
		}//Date()
	/**
	 * Construcuteur avec Parametre qui renvoie la date grace a l'ann� le mois et le jour	
	 * @param parJour
	 * @param parMois
	 * @param parAn
	 * @throws ExceptionDate
	 */
		public Date (int parJour, int parMois, int parAn) throws ExceptionDate
		{
			
			chJour=parJour;
			chMois=parMois;
			chAn=parAn;
			if (estValide() == false)
				throw new ExceptionDate("Date invalide");
			GregorianCalendar date = new GregorianCalendar(chAn, chMois - 1, chJour);
			chNumSemaine = date.get(Calendar.DAY_OF_WEEK);
			chJourSemaine = JourDeSemaine[chNumSemaine-1];
			chMoisAnnee = moisDeLannee[chMois-1];
		}//Date()
		/**
		 * toString personalis� 
		 */
	public String toString()
	{
		return(chJour+" "+chMoisAnnee);
	}//toString()
	/**
	 * Fonction permetant de d�terminer le dernier jour du mois gr�ce au mois et a l'ann�e
	 * @param parMois le mois pour lequel on cherche le dernier jour du mois
	 * @param parAn l'ann�e pour lequel on cherche le dernier jour du mois
	 * @return le dernier jour du mois : int
	 */
	public static int dernierJourDuMois(int parMois, int parAn)
	{
		switch(parMois)
			{
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				if ((parAn%4==0 && parAn%100!=0) || parAn%400==0)
				return 29;
				else 
				return 28;
			default:
				return 31;
			}
	}//dernierJourDuMois()
	/**
	 * Fonction qui verifie si la date est bien dans le calendrier gr�gorien
	 * @return boolean
	 */
	public boolean estValide()
	{
		if (chAn<1582)
			return false;
		if (chMois<1 || chMois >12)
			return false;
		if (chJour<1 || chJour > dernierJourDuMois(chMois,chAn))
			return false;
		return true;
	}//estValide()
	
	// Getter ---------------------------------------
	public int getChJour() {
		return chJour;
	}
	public void setChJour(int chJour) {
		this.chJour = chJour;
	}
	public int getChMois() {
		return chMois;
	}
	public void setChMois(int chMois) {
		this.chMois = chMois;
	}
	public int getChAn() {
		return chAn;
	}
	// Setter ------------------------------------------
	public void setChAn(int chAn) {
		this.chAn = chAn;
	}
	public String getChJourSemaine() {
		return chJourSemaine;
	}
	public void setChJourSemaine(String chJourSemaine) {
		this.chJourSemaine = chJourSemaine;
	}
	public int getChNumSemaine() {
		return chNumSemaine;
	}
	public void setChNumSemaine(int chNumSemaine) {
		this.chNumSemaine = chNumSemaine;
	}
	public String getChMoisAnnee() {
		return chMoisAnnee;
	}
	public void setChMoisAnnee(String chMoisAnnee) {
		this.chMoisAnnee = chMoisAnnee;
	}

	
	
}//Date