package Vue;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Modele.Festival;
import Modele.FestivalHelper;
import Modele.Programme;
/**
 * Classe qui extends DefaultTabelModel qui servira à l'affichage en colomn de tout les festivales par rapport à leur genre
 * @author Benjamin, loïc
 *
 */
public class InterfaceAffichage extends DefaultTableModel {
	/**
	 * Constructeur
	 * @param chProgramme Le programme des festivals
	 */
	public InterfaceAffichage(Programme chProgramme){
		int chNombreDeGenres = Festival.Genres.length-1;
		setColumnCount(chNombreDeGenres);
		setRowCount(chProgramme.nombreDeFestivalsParGenre());
		String [] entete = new String [chNombreDeGenres];
		for (int i = 0;i<chNombreDeGenres;i++)
			entete[i]=Festival.Genres[i];
		setColumnIdentifiers(entete);
		
		for (int i = 0; i <= chNombreDeGenres;i++ ){
			
			List<Festival>  list = FestivalHelper.extractListFestival(chProgramme.getChProgramme(),Festival.Genres[i]);	
			int j = 0;
			if(list !=null){
				for (Festival festival : list) {
					if (festival.getChGenre()== Festival.Genres[i]){
						setValueAt(festival.toString(festival), j, i);
						j++;
					}
				}
			}
		}
		
	}//InterfaceAffichage
}
