package model.entidades;

import java.util.List;

public class MenuSistema {
	
	private String nome;
	private List<MenuItemSistema> menuItens;
	
	public MenuSistema() {}
	
	public MenuSistema(String nome, List<MenuItemSistema> menuItens) {
		super();
		this.nome = nome;
		this.menuItens = menuItens;
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
	 * @return the menuItens
	 */
	public List<MenuItemSistema> getMenuItens() {
		return menuItens;
	}

	/**
	 * @param menuItens the menuItens to set
	 */
	public void setMenuItens(List<MenuItemSistema> menuItens) {
		this.menuItens = menuItens;
	}
	
	
}
