package model;

public enum TipoDoacaoEnum {
	
	DINHEIRO(1, "Dinheiro"),
	ROUPAS(2, "Roupas"),
	ALIMENTOS(3, "Alimentos");
	
	private Integer codigo;
	private String descricao;
	
	private TipoDoacaoEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoDoacaoEnum obterPorCodigo(Integer codigo) {
		
		for (TipoDoacaoEnum tipoDoacao : TipoDoacaoEnum.values()) {
			
			if(tipoDoacao.getCodigo().equals(codigo)) {
				
				return tipoDoacao;
				
			}
			
		}
		
		return null;
		
	}
	
	
}
