package Modele;
/**
 * 
 * @author Benjamin,lo�c
 *Exception pour la classe Date qui verifie:
 *	Si la date est valide et renvoi le String "Date Invalide"
 */
public class ExceptionDate extends Exception{
	public ExceptionDate(String parstr)
	{
		super(parstr);// appel le construcuteur de la class m�re.
	}

}
