package model.entidades;

import model.PanelMenuEnum;

public class MenuItemSistema {
	
	private String nomeMenu;
	private PanelMenuEnum panelEnum;
	
	public MenuItemSistema() {}
	
	public MenuItemSistema(String nomeMenu, PanelMenuEnum panelEnum) {
		super();
		this.nomeMenu = nomeMenu;
		this.panelEnum = panelEnum;
	}
	
	/**
	 * @return the nomeMenu
	 */
	public String getNomeMenu() {
		return nomeMenu;
	}
	/**
	 * @param nomeMenu the nomeMenu to set
	 */
	public void setNomeMenu(String nomeMenu) {
		this.nomeMenu = nomeMenu;
	}
	/**
	 * @return the panelEnum
	 */
	public PanelMenuEnum getPanelEnum() {
		return panelEnum;
	}
	/**
	 * @param panelEnum the panelEnum to set
	 */
	public void setPanelEnum(PanelMenuEnum panelEnum) {
		this.panelEnum = panelEnum;
	}
	
}
