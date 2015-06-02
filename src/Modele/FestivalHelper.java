package Modele;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Classe qui aide la classe festival
 * @author Benjamin
 *
 */
public class FestivalHelper {
/**
 * Fonction qui renvoie un arraylist de festival d'un genre donné
 * @param map
 * @param Genre
 * @return
 */
	public static List<Festival> extractListFestival(HashMap<String,ArrayList<Festival>> map,String Genre){
		if (!map.isEmpty()){
			for (String Cle : map.keySet()) {
				
				if (Cle == Genre){
						return map.get(Cle);
				}
			}
		}
		return null;
	}
}
