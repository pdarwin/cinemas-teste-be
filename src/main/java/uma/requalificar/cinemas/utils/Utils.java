package uma.requalificar.cinemas.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
	public static boolean validateEmail (String email)
    {
    	final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    	
    	Pattern pattern = Pattern.compile (regex);

            Matcher matcher = pattern.matcher (email);

            return matcher.matches ();
    }
    
    public static boolean validatePassword (String password)
    {
    	final String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
    	
    	Pattern pattern = Pattern.compile (regex);

            Matcher matcher = pattern.matcher (password);

            return matcher.matches ();	
    }
    
}
