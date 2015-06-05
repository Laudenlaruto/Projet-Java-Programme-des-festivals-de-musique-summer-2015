package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.xml.ws.handler.MessageContext.Scope;

import Fichier.Fichier;
import Modele.Date;
import Modele.ExceptionDate;
import Modele.Festival;
import Modele.Programme;

/**
 * Classe qui créé une interface comportant les interfaces de saisie, affichage et réservation dans un cardlayout
 * @author Loïc, Benjamin
 *
 */

public class PanelFils extends JPanel implements ActionListener{
	File file = new File("Programme");
	private JMenuItem initMenu = new JMenuItem("Initialisation",'I');
	private JMenuItem progMenu = new JMenuItem("Programme",'P');
	private JMenuItem reservMenu = new JMenuItem("Réservation",'R');
	private JMenuBar menuBar = new JMenuBar();
	private JPanel panelMenu = new JPanel();
	private JPanel panelInterface = new JPanel();
	private JTable chTableInterfaceAffichage = new JTable();
	private CardLayout diapoInterface = new CardLayout();
	private InterfaceSaisie chInterfaceSaisie;
	private InterfaceReservation chInterfaceReservation;
	public PanelFils(){
		
		//Préparation du Menu
		initMenu.addActionListener(this);
	    menuBar.add(initMenu);
	    initMenu.setAccelerator(KeyStroke.getKeyStroke('I',java.awt.Event.CTRL_MASK));
	    progMenu.addActionListener(this);
	    menuBar.add(progMenu);
	    progMenu.setAccelerator(KeyStroke.getKeyStroke('P',java.awt.Event.CTRL_MASK));
	    reservMenu.addActionListener(this);
	    menuBar.add(reservMenu);
	    reservMenu.setAccelerator(KeyStroke.getKeyStroke('R',java.awt.Event.CTRL_MASK));
	    initMenu.setBackground(new Color(208,237,189));
	    progMenu.setBackground(new Color(208,237,189));
	    reservMenu.setBackground(new Color(208,237,189));
	    //BorderLayout
	    this.setLayout(new BorderLayout());
	    panelMenu.setLayout(new BorderLayout());
		panelMenu.add(menuBar,BorderLayout.WEST);
		add(panelMenu,BorderLayout.NORTH);
		menuBar.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLUE));
		//Cardlayout
		panelInterface.setLayout(diapoInterface);
		//Intilisation du programme avec fichier 
		Programme programme;
		//Fichier.reset(file);
		programme = (Programme)Fichier.lecture(file);
		
		//Table affichage
		chTableInterfaceAffichage.setRowHeight(100);
		chTableInterfaceAffichage.setModel(new InterfaceAffichage(programme));
		chTableInterfaceAffichage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i=0; i<Festival.Genres.length;i++){
			chTableInterfaceAffichage.getColumnModel().getColumn(i).setPreferredWidth(200);
			}
		JScrollPane scrollAffichage = new JScrollPane(chTableInterfaceAffichage);
		chTableInterfaceAffichage.setEnabled(false);
		diapoInterface.addLayoutComponent(scrollAffichage, "InterfaceAffichage");
		panelInterface.add(scrollAffichage,BorderLayout.CENTER);
		chTableInterfaceAffichage.setBackground(new Color(208,237,189));
		
		// Interface Réservation
		chInterfaceReservation = new InterfaceReservation(programme);
		JScrollPane scrollReservation = new JScrollPane(chInterfaceReservation);
		diapoInterface.addLayoutComponent(scrollReservation, "InterfaceRéservation");
		panelInterface.add(scrollReservation,BorderLayout.CENTER);
		// Interface de saisie
				chInterfaceSaisie= new InterfaceSaisie(programme,chTableInterfaceAffichage,chInterfaceReservation);
				diapoInterface.addLayoutComponent(chInterfaceSaisie, "InterfaceSaisie");
				panelInterface.add(chInterfaceSaisie);
		
		// PanelInterface
		diapoInterface.show(panelInterface, "InterfaceSaisie");
		add(panelInterface);
		panelMenu.setBackground(new Color(208,237,189));
	} //PanelFils()
	/**
	 * Set le modele pour la table Affichage
	 * @param chProgramme set le modele par rapport à un programme
	 */
	public void setModele(Programme chProgramme){
		chTableInterfaceAffichage.setModel(new InterfaceAffichage(chProgramme));
	}
	@Override
	public void actionPerformed(ActionEvent parEvt) {
		
		if(parEvt.getSource()==initMenu){
			diapoInterface.show(panelInterface, "InterfaceSaisie");
		}
		
		if(parEvt.getSource()==progMenu){
			diapoInterface.show(panelInterface, "InterfaceAffichage");
		}
		
		if(parEvt.getSource()==reservMenu){
			diapoInterface.show(panelInterface, "InterfaceRéservation");
		}
	}
	
} //PanelFils
