package view.components;

import javax.swing.JPanel;

import comum.InformacoesUsuario;

public abstract class AbstractPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected String getLoginUsuario() {
		
		return InformacoesUsuario.getInstance().getUsuarioLogado().getLoginPessoa().getLogin();
		
	}
	
}
