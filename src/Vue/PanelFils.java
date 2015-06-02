package Vue;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
/**
 * Classe du conteneur secondaire, qui hérite de JPanel, instancie un JTabbedPane
 * avec les interfaces de saisie, affichage et réservation
 * @author Loïc, Benjamin
 *
 */

public class PanelFils extends JPanel{

	private JTabbedPane onglet = new JTabbedPane(JTabbedPane.TOP);
	private JPanel interfaceReservation = new JPanel();
	private JPanel interfaceAffichage = new JPanel();
	private JPanel interfaceSaisie = new JPanel();
	
	public PanelFils(){
		onglet.addTab("Saisie", interfaceSaisie);
		onglet.addTab("Affichage", interfaceAffichage);
		onglet.addTab("Reservation", interfaceReservation);
		onglet.setSelectedIndex(0);
		this.setLayout(new GridLayout(1, 1));
		this.add(onglet);
		
		
		
		
		
	} //PanelFils()
	
} //PanelFils
