package view;


import javax.swing.JLabel;

import view.components.AbstractPanel;

public class PanelAcessoRestritoView extends AbstractPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelAcessoRestritoView() {
		
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seja Bem Vindo " + getLoginUsuario());
		lblNewLabel.setBounds(261, 234, 203, 14);
		add(lblNewLabel);
		
	}
}
