package Vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Fichier.Fichier;
import Modele.Date;
import Modele.Festival;

public class InterfaceReservationFestival extends JPanel implements ActionListener {
	JComboBox<Date> boxDates = new JComboBox<Date>();
	JLabel labelNomFestival;
	JLabel labelPrixFestival;
	JLabel labelNombreDePlaces;
	JButton boutonReservation;
	Festival chFestival ;
	File file = new File("Programme");
	public InterfaceReservationFestival(Festival festival){
		chFestival = festival;
		labelNomFestival = new JLabel("Festival " + festival.getChNom());
		labelPrixFestival = new JLabel("Prix : "+festival.getChPrix()+"€");
		labelNombreDePlaces = new JLabel("Places : "+ festival.nombreDePlace(festival.getchDate(0)));
		boutonReservation = new JButton("Réserver");
		boutonReservation.addActionListener(this);
		for (Date date : festival.getChDate()) {
				if(festival.nombreDePlace(date)!=0){
					boxDates.addItem(date);
			}
		}
		setLayout(new GridBagLayout());
		GridBagConstraints cont = new GridBagConstraints();
		cont.insets = new Insets (10,10,10,10); 
		add(labelNomFestival,cont);
		cont.gridx=1;
		add(labelPrixFestival,cont);
		cont.gridx=0;
		cont.gridy=1;
		add(boxDates,cont);
		boxDates.addActionListener(this);
		cont.gridx=1;
		add(labelNombreDePlaces,cont);
		cont.gridx=0;
		cont.gridy=3;
		cont.gridwidth=2;
		add(boutonReservation,cont);
	}

	@Override
	public void actionPerformed(ActionEvent parEvt) {
		Date dateSelectionne = (Date)boxDates.getSelectedItem();
		if(parEvt.getSource()==boxDates){
			labelNombreDePlaces.setText("Places : "+chFestival.nombreDePlace(dateSelectionne));
		}
		if(parEvt.getSource()==boutonReservation){
			chFestival.reservationFestival((Date)boxDates.getSelectedItem());
			labelNombreDePlaces.setText("Places : "+chFestival.nombreDePlace(dateSelectionne));
			JOptionPane.showMessageDialog(this, "La réservation à bien été effectuée","Confirmation",JOptionPane.PLAIN_MESSAGE);
			//Fichier.ecriture(file, chFestival); TODO mettre Programme
		}
	}
}
