package model;

public enum TipoEntregaEnum {

	TRANSFERENCIA(1, "Transferência"),
	RETIRADA(2, "Retirada"),
	ENTREGA(3, "Entrega");
	
	private Integer codigo;
	private String descricao;
	
	private TipoEntregaEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoEntregaEnum obterPorCodigo(Integer codigo) {
		
		for (TipoEntregaEnum tipoEntrega : TipoEntregaEnum.values()) {
			
			if(tipoEntrega.getCodigo().equals(codigo)) {
				
				return tipoEntrega;
				
			}
			
		}
		
		return null;
		
	}
	
	
}
