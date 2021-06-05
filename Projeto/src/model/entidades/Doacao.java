package model.entidades;

import model.TipoDoacaoEnum;
import model.TipoEntregaEnum;

public class Doacao {
	
	private Pessoa doador;
	private TipoDoacaoEnum tipoDoacao;
	private String descricao;
	private String valor;
	private TipoEntregaEnum tipoEntrega;
	
	
	public Pessoa getDoador() {
		return doador;
	}
	public void setDoador(Pessoa doador) {
		this.doador = doador;
	}
	public TipoDoacaoEnum getTipoDoacao() {
		return tipoDoacao;
	}
	public void setTipoDoacao(TipoDoacaoEnum tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public TipoEntregaEnum getTipoEntrega() {
		return tipoEntrega;
	}
	public void setTipoEntrega(TipoEntregaEnum tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}
	
}
