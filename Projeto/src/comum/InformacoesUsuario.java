package comum;

import model.entidades.Pessoa;

public class InformacoesUsuario {
	
	private static InformacoesUsuario usuarioSessao;
	
	private Pessoa usuarioLogado;
	
	private InformacoesUsuario() {}
	
	public static InformacoesUsuario getInstance() {
		
		if(usuarioSessao == null) {
			
			usuarioSessao = new InformacoesUsuario();
			
		}
		
		return usuarioSessao;
		
	}
	
	public void setUsuarioLogado(Pessoa usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public Pessoa getUsuarioLogado() {
		return usuarioLogado;
	}
	
}
