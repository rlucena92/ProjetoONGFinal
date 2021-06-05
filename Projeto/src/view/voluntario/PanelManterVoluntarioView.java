package view.voluntario;


import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import comum.InformacoesUsuario;
import comum.excecoes.NegocioException;
import controller.AcessoController;
import model.PerfilAcessoEnum;
import model.entidades.Login;
import model.entidades.Pessoa;
import view.components.AbstractPanel;
import view.components.jtable.PessoaTableModel;
import view.components.jtable.TableCellRemoveImageRenderer;
import view.enumerations.ConfirmDialogEnum;

public class PanelManterVoluntarioView extends AbstractPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Create the panel.
	 */
	public PanelManterVoluntarioView() {
		
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(52, 74, 95, 14);
		add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF/CNPJ:");
		lblCpf.setBounds(52, 49, 95, 14);
		add(lblCpf);
		
		txtNome = new JTextField();
		txtNome.setBounds(157, 71, 429, 20);
		add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(157, 46, 148, 20);
		add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.addActionListener(event -> {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setNome(txtNome.getText());
			pessoa.setNumCpfCnpj(txtCpf.getText());
			Login login = new Login();
			login.setLogin(txtLogin.getText().toLowerCase());
			login.setPerfilAcessoEnum(PerfilAcessoEnum.VOLUNTARIO);
			login.setSenha(new String(txtSenha.getPassword()));
			pessoa.setLoginPessoa(login);
			pessoa.setDataHoraCadastro(new Date());
			pessoa.setLoginResponsavel(InformacoesUsuario.getInstance().getUsuarioLogado().getLoginPessoa().getLogin());
			
			try {

				AcessoController.getInstance().cadastrarPessoa(pessoa);
				txtNome.setText("");
				txtCpf.setText("");
				txtLogin.setText("");
				txtSenha.setText("");
				
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
				carregarPessoas();
				
			} catch (NegocioException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage());
				
			}
			
		});
		
		btnCadastrar.setBounds(483, 182, 103, 23);
		add(btnCadastrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 233, 594, 231);
		add(scrollPane);
		
		table = new JTable();
		adicionarMouseListener();
		
		scrollPane.setViewportView(table);
		
		lblLogin = new JLabel("Login:");
		lblLogin.setBounds(52, 99, 46, 14);
		add(lblLogin);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(52, 124, 46, 14);
		add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(157, 96, 148, 20);
		add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(157, 121, 148, 20);
		add(txtSenha);
	
		carregarPessoas();
		
	}

	private void adicionarMouseListener() {
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	
		    	if(table.columnAtPoint(evt.getPoint()) == 5) {

		    		String numCpfCnpj = ((PessoaTableModel) table.getModel()).obterCpfCnpjPessoa(table.rowAtPoint(evt.getPoint()));
		    		
		    		int input = JOptionPane.showConfirmDialog(null, 
		    				"Deseja realmente excluir o registro?", "Selecione uma opção...", JOptionPane.YES_NO_CANCEL_OPTION);
		    		
		    		if(ConfirmDialogEnum.SIM.getCodigo().equals(input)) {
		    			
		    			AcessoController.getInstance().removerPessoaPorCpfCnpj(numCpfCnpj);
		    			carregarPessoas();
		    			
		    		}
		    		
		    	}
		        
		    }
		    
		});
	}
	
	private void carregarPessoas() {
		
		List<Pessoa> pessoas = AcessoController.getInstance().carregarPessoas(PerfilAcessoEnum.VOLUNTARIO);
		
		table.setModel(new PessoaTableModel(pessoas));
		table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRemoveImageRenderer(15, 15));
		
		table.revalidate();
		table.repaint();
		
	}
	
}
