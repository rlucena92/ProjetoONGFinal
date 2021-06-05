package view.components;

public class ItemComboBox {
	
	private Integer chave;
	private String valor;
	
	public ItemComboBox(Integer chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}
	
	public Integer getChave() {
		return chave;
	}
	public void setChave(Integer chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return valor;
	}
	
}
