package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modele.Date;
import Modele.ExceptionDate;
import Modele.Festival;
import Modele.Programme;
/**
 * Interface de Saisie pour la création d'un festival
 * @author Loïc, Benjamin
 *
 */
public class InterfaceSaisie extends JPanel implements ActionListener{
	
	//String
	private String cheminDefaut = new String ("Images/defaut.jpg");
	//JLabel
	private JLabel labelIni = new JLabel("Initialisez votre festival :");
	private JLabel labelGenre = new JLabel("Genre :");
	private JLabel labelNom = new JLabel("Nom :");
	private JLabel labelLieu = new JLabel("Lieu :");
	private JLabel labelDateD = new JLabel("Date de début :");
	private JLabel labelDateF = new JLabel("Date de fin :");
	private JLabel labelPlace = new JLabel("Place disponible :");
	private JLabel labelImagePath = new JLabel("Chemin de l'image :");
	private JLabel labelPrix = new JLabel("Prix :");
	//JTextField
	private JTextField fieldImagePath = new JTextField("(Optionnel)",8);
	private JTextField fieldNom = new JTextField(8);
	private JTextField fieldLieu = new JTextField(8);
	//Tableau
	private String[] tabPlace ={"100","500","1000","2000","4000","8000","16000","50000","100000","200000"};
	private String[] tabMois = {"Juillet","Aout"};
	private int[] convertMois = {7,8};
	private String[] tabJour = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private int[] convertJour = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
	private String[] tabPrix ={"5","10","25","50","100"};
	//ComboBox
	private JComboBox comboGenre = new JComboBox(Festival.Genres);
	private JComboBox comboDateDJour = new JComboBox(tabJour);
	private JComboBox comboDateDMois = new JComboBox(tabMois);
	private JComboBox comboDateFJour = new JComboBox(tabJour);
	private JComboBox comboDateFMois = new JComboBox(tabMois);
	private JComboBox comboPlace = new JComboBox(tabPlace);
	private JComboBox comboPrix = new JComboBox(tabPrix);
	//JButton
	private JButton boutonCree = new JButton("Créer le festival !");
	
	
	public InterfaceSaisie(Programme chProgramme){
		this.setLayout(new GridBagLayout());
		GridBagConstraints cont = new GridBagConstraints();
		cont.insets = new Insets (10,10,10,10); //bordure (haut,gauche,bas droite)
		cont.fill = GridBagConstraints.BOTH;
		cont.gridx=0;cont.gridy=0;cont.gridwidth=3;
		add(labelIni,cont);
		cont.gridy=1;cont.gridwidth=1;
		add(labelNom,cont);
		cont.gridx=1;cont.gridwidth=4;cont.insets = new Insets (20,10,20,10);
		add(fieldNom,cont);
		fieldNom.addActionListener(this);
		cont.gridx=0;cont.gridwidth=1;cont.gridy=2;
		add(labelLieu,cont);
		cont.gridx=1;cont.gridwidth=4;
		add(fieldLieu,cont);
		fieldLieu.addActionListener(this);
		cont.gridx=0;cont.gridy=3;cont.gridwidth=1;
		add(labelGenre,cont);
		cont.gridx=1;cont.gridy=3;
		add(comboGenre,cont);
		comboGenre.addActionListener(this);
		cont.gridx=2;
		add(labelPrix,cont);
		cont.gridx=3;
		add(comboPrix,cont);
		comboPrix.addActionListener(this);
		cont.gridx=0;cont.gridy=4;cont.gridwidth=2;
		add(labelDateD,cont);
		cont.gridx=2;cont.gridy=4;cont.gridwidth=1;cont.fill = GridBagConstraints.VERTICAL;
		add(comboDateDJour,cont);cont.fill = GridBagConstraints.BOTH;
		comboDateDJour.addActionListener(this);
		cont.gridx=3;cont.gridwidth=1;cont.gridwidth=2;
		add(comboDateDMois,cont);
		comboDateDMois.addActionListener(this);
		cont.gridx=0;cont.gridy=5;cont.gridwidth=2;
		add(labelDateF,cont);
		cont.gridx=2;cont.gridwidth=1;cont.fill = GridBagConstraints.VERTICAL;
		add(comboDateFJour,cont);cont.fill = GridBagConstraints.BOTH;
		comboDateFJour.addActionListener(this);
		cont.gridx=3;cont.gridwidth=2;
		add(comboDateFMois,cont);
		comboDateFMois.addActionListener(this);
		cont.gridy=6;cont.gridx=0;cont.gridwidth =4;
		add(labelImagePath,cont);
		cont.gridx=2;
		add(fieldImagePath,cont);
		cont.gridy=7;cont.gridx=0;cont.gridwidth=2;
		add(labelPlace,cont);
		cont.gridx=2;cont.gridwidth=1;
		add(comboPlace,cont);
		comboPlace.addActionListener(this);
		cont.gridx=10;cont.gridwidth=0;
		add(boutonCree,cont);
		boutonCree.addActionListener(this);
		this.setBackground(new Color(208,237,189));
	}


	@Override
	public void actionPerformed(ActionEvent parEvt){
		
		
		if ((String) comboDateDMois.getSelectedItem() == "Aout"){
				comboDateFMois.setSelectedItem("Aout");
				comboDateFMois.setEnabled(false);
		} //if
		else{
				comboDateFMois.setEnabled(true);
		}
		
		if (parEvt.getSource() == boutonCree){
		Festival festival;
		Date date1;
		Date date2;
		if (fieldNom.getText().length() != 0 && fieldLieu.getText().length() != 0){
		try{
			date1 = new Date(convertJour[comboDateDJour.getSelectedIndex()],convertMois[comboDateDMois.getSelectedIndex()],2015);
			date2 = new Date(convertJour[comboDateFJour.getSelectedIndex()],convertMois[comboDateFMois.getSelectedIndex()],2015);
			if (date1.precede(date2) == 1 || date1.precede(date2) == 0){
				if (!fieldImagePath.getText().equals("(Optionnel)")){
					festival = new Festival(fieldNom.getText(),comboGenre.getSelectedItem().toString(),date1,date2,fieldLieu.getText(),Integer.parseInt(comboPlace.getSelectedItem().toString()),fieldImagePath.getText(),Integer.parseInt(comboPrix.getSelectedItem().toString()));
				}//if
				else{
					festival = new Festival(fieldNom.getText(),comboGenre.getSelectedItem().toString(),date1,date2,fieldLieu.getText(),Integer.parseInt(comboPlace.getSelectedItem().toString()),cheminDefaut,Integer.parseInt(comboPrix.getSelectedItem().toString()));
				}//else
				System.out.println(festival);
				}//if
			else{
			JOptionPane.showMessageDialog(this, 
			         "La date est invalide ! \n La date de début précède la date de fin",
			         " Erreur ! ",
			         JOptionPane.WARNING_MESSAGE);
			}//else
			
		}//try
		catch (ExceptionDate e) {
			e.printStackTrace();
		}//catch
		}//if
		else{
			JOptionPane.showMessageDialog(this, 
			         "Veuillez compléter tout les champs",
			         " Erreur ! ",
			         JOptionPane.WARNING_MESSAGE);
		}//else
		
		
	} 
	
	}// actionPerformed()
}
