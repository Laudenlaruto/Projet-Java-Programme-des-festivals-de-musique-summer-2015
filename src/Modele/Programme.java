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
		 * Fonction qui ajout un festival avec son genre comme clé
		 * Verifie si la clé est déjà présente dans la HashMap et si elle l'est l'ajoute avec la même clé sinon la crée.
		 * @param parFestival
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
		 * Renvoie tout les festivales dans l'ordre de leur genre.
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
		public HashMap<String, ArrayList<Festival>> getChProgramme() {
			return chProgramme;
		}
		public void setChProgramme(HashMap<String, ArrayList<Festival>> chProgramme) {
			this.chProgramme = chProgramme;
		}
}
