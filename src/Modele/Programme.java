package Modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Classe qui stockerai tous les festivales dans une HashMap avec comme cl� leur Genre
 * @author Benjamin, Lo�c 
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
		 * M�thode qui ajoute un festival avec son genre comme cl�
		 * Verifie si la cl� est d�j� pr�sente dans la HashMap et si elle l'est, l'ajoute avec la m�me cl� sinon la cr�e.
		 * @param parFestival prend le festival � ajouter dans la HashMap
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
		 * M�thode qui renvoie tout les festivales dans l'ordre de leur genre.
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
		 * M�thode qui determine le nombre de festivals maximum par genre pour pouvoir d�finir le nombre de ligne de l'interface Affichage et R�servation
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
