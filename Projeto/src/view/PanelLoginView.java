package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import comum.InformacoesUsuario;
import comum.excecoes.NegocioException;
import controller.AcessoController;
import model.entidades.Pessoa;

public class PanelLoginView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public PanelLoginView(TelaPrincipalView telaPrincipal) {
		
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(212, 188, 47, 14);
		add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(283, 185, 157, 20);
		txtLogin.setColumns(10);
		add(txtLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(212, 231, 52, 14);
		add(lblSenha);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(283, 228, 157, 20);
		add(txtPassword);
		
		JButton btnNewButton = new JButton("Logar");
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				try {

					Pessoa pessoa = AcessoController.getInstance().realizarLogin(txtLogin.getText(), new String(txtPassword.getPassword()));
					InformacoesUsuario.getInstance().setUsuarioLogado(pessoa);
					
					telaPrincipal.realizarAjustesPosLogin();
					telaPrincipal.abrirPanel(new PanelAcessoRestritoView());
					
				} catch (NegocioException e) {
					
					JOptionPane.showMessageDialog(null, e.getMessage());
					
				}

			}
			
		});
		
		btnNewButton.setBounds(323, 271, 70, 23);
		add(btnNewButton);

	}
}
