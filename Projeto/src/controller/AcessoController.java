package controller;

import java.util.List;

import comum.excecoes.NegocioException;
import model.PerfilAcessoEnum;
import model.dao.AcessoDAO;
import model.entidades.MenuSistema;
import model.entidades.Pessoa;

/**
 * Classe respons�vel pela regra de neg�cio do acesso.
 *
 */
public class AcessoController {
	
	private static AcessoController loginController;
	
	private AcessoController() {}
	
	public static AcessoController getInstance() {
		
		if(loginController == null) {
			
			loginController = new AcessoController();
			
		}
		
		return loginController;
		
	}
	
	public Pessoa realizarLogin(String login, String senha) throws NegocioException {
		
		Pessoa pessoa = AcessoDAO.getInstance().realizarLogin(login, senha);
		
		if(pessoa == null) {
			
			throw new NegocioException("Login/Senha inv�lido.");
			
		}
		
		return pessoa;
		
	}
	
	public List<MenuSistema> obterMenu(PerfilAcessoEnum perfilAcessoEnum) {
		
		return AcessoDAO.getInstance().obterMenu(perfilAcessoEnum);
		
	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		
		AcessoDAO acessoDAO = AcessoDAO.getInstance();
		
		validarInclusaoPessoa(pessoa, acessoDAO);
		
		acessoDAO.cadastrarPessoa(pessoa);
		
	}
	
	public void removerPessoaPorCpfCnpj(String cpfCnpj) {
		
		AcessoDAO.getInstance().removerPessoaPorCpfCnpj(cpfCnpj);
		
	}

	private void validarInclusaoPessoa(Pessoa pessoa, AcessoDAO acessoDAO) {
		
		if(pessoa.getLoginPessoa().getLogin().isEmpty()) {
			
			throw new NegocioException("Login inv�lido.");
			
		}
		
		if(pessoa.getNome() == null || pessoa.getNome().isEmpty()) {
			
			throw new NegocioException("Nome inv�lido.");
			
		}
		
		if(pessoa.getNumCpfCnpj() == null || pessoa.getNumCpfCnpj().isEmpty()) {
			
			throw new NegocioException("CPF/CNPJ inv�lido.");
			
		}
		
		if(acessoDAO.existeLogin(pessoa.getLoginPessoa().getLogin())) {
			
			throw new NegocioException("J� existe o login " + pessoa.getLoginPessoa().getLogin() + " cadastrado.");
			
		}
		
		if(acessoDAO.existeCpfCnpj(pessoa.getNumCpfCnpj())) {

			throw new NegocioException("J� existe CPF " + pessoa.getNumCpfCnpj() + " cadastrado.");
			
		}
		
	}
	
	public List<Pessoa> carregarPessoas(PerfilAcessoEnum perfilAcessoEnum) {
		
		return AcessoDAO.getInstance().carregarPessoas(perfilAcessoEnum);
		
	}
	
}
