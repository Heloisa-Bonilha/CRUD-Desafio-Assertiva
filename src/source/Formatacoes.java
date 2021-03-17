package source;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.text.MaskFormatter;

public class Formatacoes {
	//Formata string para um padrão definido pelo usuário
	public String formatString(String valor, String padrao) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(padrao);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(valor);
        } catch (ParseException ex) {
            return valor;
        }
    }
	//Converte data e retorna tipo Data
	public java.sql.Date converteData(String data1) { 
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy"); 
		java.util.Date d1 = null; 
		try { d1 = f.parse(data1); 
		f.applyPattern("yyyy-MM-dd"); 
		data1 = f.format(d1); 
		} 
		catch (Exception e) { 
			return null; 
			} 
		java.sql.Date dt1 = java.sql.Date.valueOf(data1); 
		return dt1; 
		}
	//Converte data e retorna String
	public String converteDatatoString(String data1) { 
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date d1 = null; 
		try { d1 = f.parse(data1); 
		f.applyPattern("dd/MM/yyyy"); 
		data1 = f.format(d1); 
		} 
		catch (Exception e) { 
			return null; 
			} 
		String dt1 = String.valueOf(data1); 
		return dt1; 
		}
	
	
}
