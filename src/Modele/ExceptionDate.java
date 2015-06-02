package Modele;
/**
 * 
 * @author Benjamin,loïc
 *Exception pour la classe Date qui verifie:
 *	Si la date est valide et renvoi le String "Date Invalide"
 */
public class ExceptionDate extends Exception{
	public ExceptionDate(String parstr)
	{
		super(parstr);// appel le construcuteur de la class mère.
	}

}
