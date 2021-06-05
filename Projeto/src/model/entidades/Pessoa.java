package model.entidades;

import java.util.Date;

public class Pessoa {
	
	private String numCpfCnpj;
	private String nome;
	private Login loginPessoa;
	private Date dataHoraCadastro;
	private String loginResponsavel;
	
	public Pessoa() {}
	
	public Pessoa(String numCpfCnpj, String nome, Login login, Date dataHoraCadastro, String loginResponsavel) {
		super();
		this.numCpfCnpj = numCpfCnpj;
		this.nome = nome;
		this.loginPessoa = login;
		this.dataHoraCadastro = dataHoraCadastro;
		this.loginResponsavel = loginResponsavel;
	}
	
	/**
	 * @return the numCpfCnpj
	 */
	public String getNumCpfCnpj() {
		return numCpfCnpj;
	}
	/**
	 * @param numCpfCnpj the numCpfCnpj to set
	 */
	public void setNumCpfCnpj(String numCpfCnpj) {
		this.numCpfCnpj = numCpfCnpj;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the login
	 */
	public Login getLoginPessoa() {
		return loginPessoa;
	}
	/**
	 * @param login the login to set
	 */
	public void setLoginPessoa(Login login) {
		this.loginPessoa = login;
	}

	/**
	 * @return the dataHoraCadastro
	 */
	public Date getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	/**
	 * @param dataHoraCadastro the dataHoraCadastro to set
	 */
	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	/**
	 * @return the loginResponsavel
	 */
	public String getLoginResponsavel() {
		return loginResponsavel;
	}

	/**
	 * @param loginResponsavel the loginResponsavel to set
	 */
	public void setLoginResponsavel(String loginResponsavel) {
		this.loginResponsavel = loginResponsavel;
	}
	
	
}
