package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import Fichier.Fichier;
import Modele.Date;
import Modele.ExceptionDate;
import Modele.Festival;
import Modele.Programme;
/**
 * Classe du conteneur secondaire, qui hérite de JPanel, instancie un JMenu et un CardLayout
 * avec les interfaces de saisie, affichage et réservation
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
	private InterfaceSaisie interfaceSaisie;
	private InterfaceReservation interfaceReservation;
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
		//Cardlayout
		panelInterface.setLayout(diapoInterface);
		//Intilisation du programme avec fichier 
		Programme programme;
		programme = (Programme)Fichier.lecture(file);
		
		//Fichier.reset(file);
		
		//Table affichage
		chTableInterfaceAffichage.setRowHeight(50);
		chTableInterfaceAffichage.setModel(new InterfaceAffichage(programme));
		chTableInterfaceAffichage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i=0; i<Festival.Genres.length;i++){
			chTableInterfaceAffichage.getColumnModel().getColumn(i).setPreferredWidth(400);
			}
		JScrollPane scroll = new JScrollPane(chTableInterfaceAffichage);
		
		diapoInterface.addLayoutComponent(scroll, "InterfaceAffichage");
		panelInterface.add(scroll,BorderLayout.CENTER);
		
	
		// Interface Réservation
		 interfaceReservation = new InterfaceReservation(programme);
		
		diapoInterface.addLayoutComponent(interfaceReservation, "InterfaceRéservation");
		panelInterface.add(interfaceReservation);
		
		// Interface de saisie
				interfaceSaisie= new InterfaceSaisie(programme,chTableInterfaceAffichage,interfaceReservation);
				diapoInterface.addLayoutComponent(interfaceSaisie, "InterfaceSaisie");
				panelInterface.add(interfaceSaisie);
		
		// PanelInterface
		diapoInterface.show(panelInterface, "InterfaceSaisie");
		add(panelInterface);
		panelMenu.setBackground(new Color(208,237,189));
	} //PanelFils()
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
