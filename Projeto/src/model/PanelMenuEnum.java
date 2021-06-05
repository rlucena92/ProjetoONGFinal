package model;

public enum PanelMenuEnum {
	
	PANEL_MANTER_FUNCIONARIO("view.funcionario.PanelManterFuncionarioView"),
	PANEL_MANTER_VOLUNTARIO("view.voluntario.PanelManterVoluntarioView"),
	PANEL_REALIZAR_DOACAO("view.doacao.PanelDoacaoView");
	
	private String path;
	
	private PanelMenuEnum(String path) {
		this.path = path;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
}
