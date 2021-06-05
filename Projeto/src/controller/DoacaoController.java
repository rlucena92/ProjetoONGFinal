package controller;

import comum.excecoes.NegocioException;
import model.dao.DoacaoDAO;
import model.entidades.Doacao;

/**
 * Classe respons�vel pela regra de neg�cio das doa��es.
 */
public class DoacaoController {
	
	private static DoacaoController doacaoController;

	private DoacaoController() {
		
	}
	
	public static DoacaoController getInstance() {
	
		if(doacaoController == null) {
			
			doacaoController = new DoacaoController();
			
		}
		
		return doacaoController;
		
	}
	
	public void realizarDoacao(Doacao doacao) {
		
		realizarValidacoes(doacao);
		DoacaoDAO.getInstance().realizarDoacao(doacao);
		
	}
	
	private void realizarValidacoes(Doacao doacao) {
		
		if(doacao.getDescricao() == null || doacao.getDescricao().isEmpty()) {
			
			throw new NegocioException("Campo descri��o inv�lido.");
			
		}
		
		if(doacao.getTipoDoacao() == null) {
			
			throw new NegocioException("Campo tipo doa��o precisa ser preenchido.");
			
		}
		
		if(doacao.getTipoEntrega() == null) {
			
			throw new NegocioException("Campo tipo entrega precisa ser preenchido.");
			
		}
		
	}
	
	
}
