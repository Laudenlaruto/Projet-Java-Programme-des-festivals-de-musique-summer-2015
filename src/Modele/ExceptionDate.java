package Modele;

import javax.swing.JOptionPane;

/**
 * Exception pour la classe Date qui verifie:
 *	Si la date est valide et renvoi le String "Date Invalide"
 * @author Benjamin,loïc
 *
 */
public class ExceptionDate extends Exception{
	public ExceptionDate(String parstr)
	{
		System.out.println(parstr);
		//super(parstr);// appel le construcuteur de la class mère.
	}

}
