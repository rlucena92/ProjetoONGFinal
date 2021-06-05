package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.entidades.Doacao;

/**
 * Classe respons�vel para manter os dados das doa��es.
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
