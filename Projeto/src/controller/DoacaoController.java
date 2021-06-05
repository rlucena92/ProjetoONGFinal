package controller;

import comum.excecoes.NegocioException;
import model.dao.DoacaoDAO;
import model.entidades.Doacao;

/**
 * Classe responsável pela regra de negócio das doações.
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
			
			throw new NegocioException("Campo descrição inválido.");
			
		}
		
		if(doacao.getTipoDoacao() == null) {
			
			throw new NegocioException("Campo tipo doação precisa ser preenchido.");
			
		}
		
		if(doacao.getTipoEntrega() == null) {
			
			throw new NegocioException("Campo tipo entrega precisa ser preenchido.");
			
		}
		
	}
	
	
}
