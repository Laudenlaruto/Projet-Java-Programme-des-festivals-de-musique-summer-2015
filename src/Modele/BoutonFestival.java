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
	 * @param parFestival Festival qui caractérise le bouton
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
	 * Méthode qui retourne le Festival dans le bouton
	 * 
	 * @return chFestival Renvoie le festival dans le bouton
	 */
	public Festival getFestival(){
		return chFestival;
	}
}
