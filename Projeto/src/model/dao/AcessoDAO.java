package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import model.PanelMenuEnum;
import model.PerfilAcessoEnum;
import model.entidades.Login;
import model.entidades.MenuItemSistema;
import model.entidades.MenuSistema;
import model.entidades.Pessoa;

/**
 * Classe responsável para manter os dados do acesso.
 */
public class AcessoDAO {
	
	private static AcessoDAO loginDao;
	private static List<MenuSistema> menusGestor;
	private static List<MenuSistema> menusFuncionario;
	private static List<MenuSistema> menusVoluntario;
	private static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	
	static {
		
		criarMenusGestor();
		criarMenusFuncionario();
		criarMenusVoluntario();
		
		Pessoa pessoa = new Pessoa("12312312312", "gestor", new Login("gestor", "123", PerfilAcessoEnum.GESTOR), new Date(), "sistema");
		pessoas.add(pessoa);
		pessoa = new Pessoa("12332112332", "funcionario", new Login("funcionario", "123", PerfilAcessoEnum.FUNCIONARIO), new Date(), "sistema");
		pessoas.add(pessoa);
		pessoa = new Pessoa("32132132132", "voluntario", new Login("voluntario", "123", PerfilAcessoEnum.VOLUNTARIO), new Date(), "sistema");
		pessoas.add(pessoa);
		
	}

	private static void criarMenusGestor() {
		
		List<MenuItemSistema> menuItens = new ArrayList<MenuItemSistema>();
		MenuItemSistema menuItem = new MenuItemSistema("Funcionário", PanelMenuEnum.PANEL_MANTER_FUNCIONARIO);
		menuItens.add(menuItem);
		
		menusGestor = new ArrayList<MenuSistema>();
		MenuSistema menuManter = new MenuSistema("Manter", menuItens);
		menusGestor.add(menuManter);
		
	}
	
	private static void criarMenusFuncionario() {
		
		List<MenuItemSistema> menuItens = new ArrayList<MenuItemSistema>();
		MenuItemSistema menuItem = new MenuItemSistema("Voluntário", PanelMenuEnum.PANEL_MANTER_VOLUNTARIO);
		menuItens.add(menuItem);
		
		menusFuncionario = new ArrayList<MenuSistema>();
		
		MenuSistema menuManter = new MenuSistema("Manter", menuItens);
		menusFuncionario.add(menuManter);
		
	}
	
	private static void criarMenusVoluntario() {
		
		List<MenuItemSistema> menuItens = new ArrayList<MenuItemSistema>();
		MenuItemSistema menuItem = new MenuItemSistema("Realizar Doação", PanelMenuEnum.PANEL_REALIZAR_DOACAO);
		menuItens.add(menuItem);
		
		menusVoluntario = new ArrayList<MenuSistema>();
		
		MenuSistema menuManter = new MenuSistema("Doação", menuItens);
		menusVoluntario.add(menuManter);
		
	}
	
	
	public static AcessoDAO getInstance() {
		
		if(loginDao == null) {
			
			loginDao = new AcessoDAO();
			
		}
		
		return loginDao;
		
	}
	
	private AcessoDAO() {
		
	}
	
	
	
	public Pessoa realizarLogin(String login, String senha) {
		
		for (Pessoa pessoa : pessoas) {
			
			if(pessoa.getLoginPessoa().getLogin().equals(login) && pessoa.getLoginPessoa().getSenha().equals(senha)) {
				
				return pessoa;
				
			}
			
		}
		
		return null;
		
	}
	
	public List<MenuSistema> obterMenu(PerfilAcessoEnum perfilAcessoEnum) {
		
		if(PerfilAcessoEnum.GESTOR.getCodigo().equals(perfilAcessoEnum.getCodigo())) {
			
			return menusGestor;
			
		}
		
		if(PerfilAcessoEnum.FUNCIONARIO.getCodigo().equals(perfilAcessoEnum.getCodigo())) {
			
			return menusFuncionario;
			
		}
		
		if(PerfilAcessoEnum.VOLUNTARIO.getCodigo().equals(perfilAcessoEnum.getCodigo())) {
			
			return menusVoluntario;
			
		}
		
		return null;
		
	}
	
	
	public void cadastrarPessoa(Pessoa pessoa) {
		
		pessoas.add(pessoa);
		
	}
	
	public List<Pessoa> carregarPessoas(PerfilAcessoEnum perfilAcesso) {

		if (perfilAcesso == null) {
			return pessoas;
		}

		return pessoas.stream().filter(
				pessoa -> pessoa.getLoginPessoa().getPerfilAcessoEnum().getCodigo().equals(perfilAcesso.getCodigo()))
				.collect(Collectors.toList());

	}
	
	public boolean existeLogin(String login) {
		
		for (Pessoa pessoa : pessoas) {
			
			if(login.equals(pessoa.getLoginPessoa().getLogin())) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public Boolean existeCpfCnpj(String cpfCnpj) {
		
		for (Pessoa pessoa : pessoas) {
			
			if(cpfCnpj.equals(pessoa.getNumCpfCnpj())) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public void removerPessoaPorCpfCnpj(String cpfCnpj) {
		
		pessoas.removeIf(pessoa -> pessoa.getNumCpfCnpj().equals(cpfCnpj));
		
	}
	
}
