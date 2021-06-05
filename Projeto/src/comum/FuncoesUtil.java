package comum;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FuncoesUtil {

	public static String formatarDataHora(Date data) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault()).format(formatter);
		
	}
	
}
