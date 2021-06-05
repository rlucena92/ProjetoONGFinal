package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.entidades.Doacao;

/**
 * Classe responsável para manter os dados das doações.
 */
public class DoacaoDAO {

	private static DoacaoDAO doacaoDAO;
	
	private static List<Doacao> doacoes = new ArrayList<Doacao>();
	
	private DoacaoDAO() {
		
	}
	
	public static DoacaoDAO getInstance() {
		
		if(doacaoDAO == null) {
			
			doacaoDAO = new DoacaoDAO();
			
		}
		
		return doacaoDAO;
		
	}
	
	public void realizarDoacao(Doacao doacao) {
		
		doacoes.add(doacao);
		
	}
	
}
