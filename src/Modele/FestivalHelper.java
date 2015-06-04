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
 * M�thode qui renvoie un arraylist de festival d'un genre donn�
 * @param map prend la map du HashMap
 * @param Genre prend la clef pour s�lectionner dans le HashMap
 * 
 * @return List d'un genre pr�cis
 */
	public static List<Festival> extractListFestival(HashMap<String,ArrayList<Festival>> map,String Genre){
		if (!map.isEmpty()){
			for (String Cle : map.keySet()) {
				if (Cle.equalsIgnoreCase(Genre)){
						return map.get(Cle);
				}
			}
		}
		return null;
	}
}
