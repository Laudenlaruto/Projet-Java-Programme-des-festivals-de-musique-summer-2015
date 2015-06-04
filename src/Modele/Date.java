package Modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
/**
 * Classe qui permet de créer une date contenant:
 * le jour, le mois, l'année, le numero du jour de la semaine en int
 * et le jour de la semaine, ainsi que le nom du mois en String
 * @author Benjamin, Loïc
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
	private static final String[] moisDeLannee = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Août","Septembre","Octobre","Novembre","Decembre"};
	//Tableau des jours de la semaine pour se servir de la fonction get day of week de Greogrian calendar. (-1 parcque tableau commence a 0)

		/**
		 * Constructeur par défaut qui renvoie la date courante
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
	 * Constructeur avec paramètre qui renvoie la date grâce a l'année, le mois et le jour	
	 * @param parJour jour de la date
	 * @param parMois mois de la date
	 * @param parAn année de la date
	 * @throws ExceptionDate Exception qui renvoit un string si la date est non valide
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
		 * toString personalisé 
		 */
	public String toString()
	{
		return(chJour+" "+chMoisAnnee);
	}//toString()
	/**
	 * Méthode qui permet de déterminer le dernier jour du mois grâce au mois et a l'année
	 * @param parMois le mois pour lequel on cherche le dernier jour du mois
	 * @param parAn l'année pour lequel on cherche le dernier jour du mois
	 * @return le dernier jour du mois : int
	 */
	public static int dernierJourDuMois(int parMois, int parAn){
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
	 * Méthode qui verifie si la date est bien dans le calendrier grégorien
	 * @return boolean
	 */
	public boolean estValide(){
		if (chAn<1582)
			return false;
		if (chMois<1 || chMois >12)
			return false;
		if (chJour<1 || chJour > dernierJourDuMois(chMois,chAn))
			return false;
		return true;
	}//estValide()
	/**
	 * 
	 * Méthode qui vérifie si la date passée en paramètre précède la date appelante
	 * @param parDate (date à comparer)
	 * @return int (1 pour précède, 0 pour égale, -1 pour ne précède pas)
	 */
	
	public int precede(Date parDate){
		if(this.chAn > parDate.chAn)
			return -1;
		if(this.chAn < parDate.chAn)
			return 1;
			if(this.chMois > parDate.chMois)
				return -1;
			if(this.chMois < parDate.chMois)
				return 1;
				if(this.chJour > parDate.chJour)
				return -1;
				if(this.chJour < parDate.chJour)
				return 1;
	return 0;
	}//precede()
	
	/**
	 * Méthode qui va créer un tableau d'intervale de date entre la date appelante et la date passée en paramètre
	 * @param parDate1 date de fin qui permet l'élaboration de l'intervale
	 * @return Date[], le tableau de date à mettre dans festival
	 * @throws ExceptionDate Exception qui affiche si la date est non valide
	 */
	public Date[] intervalleFestival(Date parDate1) throws ExceptionDate{
		int nbBoucle;
		if (this.chMois == parDate1.chMois){
			if(this.chJour == parDate1.chJour){
				Date[] tabDate = new Date[1];
				tabDate[0]=new Date(this.chJour,parDate1.chMois,2015);
				
				return tabDate;
			}//if
			else{
				nbBoucle = parDate1.chJour - this.chJour +1;
				Date[] tabDate = new Date[nbBoucle];
				int j = 0;
				for (int i=this.chJour; i <= parDate1.chJour; i++){
					tabDate[j]=new Date(i,this.chMois,2015);
					j++;
				}//for
				
				return tabDate;
			}//else
		}//if
		else
		{
			int j = 0;
			nbBoucle = dernierJourDuMois(this.chMois,2015) - this.chJour +1;
			int nbBoucle2 = parDate1.chJour;
			Date[] tabDate = new Date[nbBoucle+nbBoucle2];
			for (int i = this.chJour;i <= dernierJourDuMois(this.chMois,2015);i++){
				tabDate[j]=new Date (i,this.chMois,2015);
				j++;
			}//for
			for (int i = 1; i <= parDate1.chJour;i++){
				tabDate[j]=new Date (i,parDate1.chMois,2015);
				j++;
			}//for
			
			return tabDate;
		}//else
		
		
		
	}//intervaleFestival()
	
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