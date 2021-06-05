package view.enumerations;

public enum ConfirmDialogEnum {

	SIM(0),
	NAO(1),
	CANCELAR(2);
	
	private Integer codigo;
	
	private ConfirmDialogEnum(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	public static ConfirmDialogEnum obterPorCodigo(Integer codigo) {
		
		for (ConfirmDialogEnum confirmEnum : ConfirmDialogEnum.values()) {
			
			if(confirmEnum.getCodigo().equals(codigo)) {
				
				return confirmEnum;
				
			}
			
		}
		
		return null;
		
	}
	
}
