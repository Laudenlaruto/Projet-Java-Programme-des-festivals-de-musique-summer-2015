package Modele;

import java.awt.Color;

import javax.swing.JButton;
/**
 * Classe qui extends JButton qui stocke un festival et change la couleur du bouton si le festival est complet
 * @author Benjamin, Loïc
 *
 */
public class BoutonFestival extends JButton{
	private Festival chFestival;
	/**
	 * Constructeur du bouton Reservation 
	 * @param parFestival
	 */
	public BoutonFestival(Festival parFestival){
		super("Réserver");
		chFestival = parFestival;
		
		JButton bouton = new JButton(parFestival.toString());
		if (chFestival.nombreDePlaceTotal()==0)
			setBackground(Color.BLACK);
		else
			setBackground(Color.CYAN);
	}
	/**
	 * Retourne le Festival dans le bouton
	 * @return
	 */
	public Festival getFestival(){
		return chFestival;
	}
}
