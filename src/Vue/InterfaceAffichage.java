package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
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
 * Classe qui extends DefaultTabelModel qui sert à l'affichage en colomn de tous les festivales par rapport à leur genre
 * @author Benjamin, loïc
 *
 */
public class InterfaceAffichage extends DefaultTableModel {
	/**
	 * Constructeur
	 * @param chProgramme Le programme des festivals
	 */
	public InterfaceAffichage(Programme chProgramme){
		int chNombreDeGenres = Festival.Genres.length;
		setColumnCount(chNombreDeGenres);
		setRowCount(chProgramme.nombreDeFestivalsParGenre());
		String [] entete = new String [chNombreDeGenres];
		for (int i = 0;i<chNombreDeGenres;i++)
			entete[i]=Festival.Genres[i];
		setColumnIdentifiers(entete);
		for (int i = 0; i < chNombreDeGenres;i++ ){
			List<Festival>  list = FestivalHelper.extractListFestival(chProgramme.getChProgramme(),Festival.Genres[i]);	
			int j = 0;
			if(list !=null){
				for (Festival festival : list) {
					if (festival.getChGenre().equalsIgnoreCase(Festival.Genres[i])){
						setValueAt(festival, j, i);
						j++;
					}
				}
			}
		}
		
	}//InterfaceAffichage
}
