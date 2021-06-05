package model.entidades;

import model.PerfilAcessoEnum;

public class Login {
	
	private String login;
	private String senha;
	private PerfilAcessoEnum perfilAcessoEnum;
	
	public Login() {
		
	}
	
	public Login(String login, String senha, PerfilAcessoEnum perfilAcessoEnum) {
		super();
		this.login = login;
		this.senha = senha;
		this.perfilAcessoEnum = perfilAcessoEnum;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * @return the perfilAcessoEnum
	 */
	public PerfilAcessoEnum getPerfilAcessoEnum() {
		return perfilAcessoEnum;
	}
	/**
	 * @param perfilAcessoEnum the perfilAcessoEnum to set
	 */
	public void setPerfilAcessoEnum(PerfilAcessoEnum perfilAcessoEnum) {
		this.perfilAcessoEnum = perfilAcessoEnum;
	}
	
	
	
	
}
