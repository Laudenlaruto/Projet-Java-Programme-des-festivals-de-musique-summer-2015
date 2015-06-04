package Modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Classe qui stockerai tous les festivales dans une HashMap avec comme clé leur Genre
 * @author Benjamin, Loïc 
 *
 */
public class Programme implements Serializable{

		private HashMap<String,ArrayList<Festival>> chProgramme;
		
		/**
		 * Constructeur d'un programme
		 */
		public Programme(){
			chProgramme = new HashMap<String, ArrayList<Festival>>();
		}
		/**
		 * Méthode qui ajoute un festival avec son genre comme clé
		 * Verifie si la clé est déjà présente dans la HashMap et si elle l'est, l'ajoute avec la même clé sinon la crée.
		 * @param parFestival prend le festival à ajouter dans la HashMap
		 */
		public void ajout(Festival parFestival)
		{
			if (chProgramme.containsKey(parFestival.getChGenre()))
			{
				chProgramme.get(parFestival.getChGenre()).add(parFestival);
			}
			else
			{
				ArrayList newListe = new ArrayList<Festival>();
				newListe.add(parFestival);
				chProgramme.put(parFestival.getChGenre(),newListe);
			}
		}
		/**
		 * Méthode qui renvoie tout les festivales dans l'ordre de leur genre.
		 * 
		 * @return String
		 */
		public String toString()
		{
			String message = new String();
			for (String Cle : chProgramme.keySet()) {
				List<Festival> L = chProgramme.get(Cle);
				message += Cle ;
				for (Festival festival : L) {
					message +=  festival.toString();
				}
				message += "\n";
			}
			return message; 
		}
		/**
		 * Méthode qui determine le nombre de festivals maximum par genre pour pouvoir définir le nombre de ligne de l'interface Affichage et Réservation
		 * @return int (nombre de ligne)
		 */
		public int nombreDeFestivalsParGenre(){
			int max =0;
			if(!chProgramme.isEmpty()){
				for (String Cle : chProgramme.keySet()) {
					List<Festival> L = chProgramme.get(Cle);
					int maxTemp=0;
					for (Festival festival : L) {
						maxTemp++;
					}
					if (maxTemp>max){
						max = maxTemp;
					}
				}
			}
			return max;
		}
		public HashMap<String, ArrayList<Festival>> getChProgramme() {
			return chProgramme;
		}
		public void setChProgramme(HashMap<String, ArrayList<Festival>> chProgramme) {
			this.chProgramme = chProgramme;
		}
}
