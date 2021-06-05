package model;

public enum PerfilAcessoEnum {
	
	VOLUNTARIO(1),
	GESTOR(2),
	FUNCIONARIO(3);
	
	private Integer codigo;
	
	private PerfilAcessoEnum(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	public static PerfilAcessoEnum obterPorCodigo(Integer codigo) {
		
		for (PerfilAcessoEnum perfilAcesso : PerfilAcessoEnum.values()) {
			
			if(perfilAcesso.getCodigo().equals(codigo)) {
				
				return perfilAcesso;
				
			}
			
		}
		
		return null;
		
	}
	
}
