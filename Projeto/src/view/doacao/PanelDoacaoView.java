package view.doacao;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import comum.InformacoesUsuario;
import comum.excecoes.NegocioException;
import controller.DoacaoController;
import model.TipoDoacaoEnum;
import model.TipoEntregaEnum;
import model.entidades.Doacao;
import view.components.AbstractPanel;
import view.components.ItemComboBox;

public class PanelDoacaoView extends AbstractPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtDescDoacao;
	private JTextField txtValorDoacao;
	private JComboBox cmbTipoEntrega; 
	private JComboBox cmbTipoDoacao;

	/**
	 * Create the panel.
	 */
	public PanelDoacaoView() {
		setLayout(null);
		
		cmbTipoEntrega = new JComboBox();
		cmbTipoDoacao = new JComboBox();
		
		txtDescDoacao = new JTextField();
		txtDescDoacao.setText("");
		txtDescDoacao.setBounds(297, 125, 192, 20);
		add(txtDescDoacao);
		txtDescDoacao.setColumns(10);
		
		txtValorDoacao = new JTextField();
		txtValorDoacao.setBounds(297, 156, 192, 20);
		add(txtValorDoacao);
		txtValorDoacao.setColumns(10);
		
		cmbTipoDoacao.addActionListener(event -> {
			
			ItemComboBox item = (ItemComboBox) cmbTipoDoacao.getSelectedItem();
			
			if(item != null) {
				
				if(item.getChave().equals(TipoDoacaoEnum.DINHEIRO.getCodigo())) {
					
					adicionarTodasOpcoesTipoEntrega();
					
				} else {
					
					adicionarOpcoesSemTransferenciasTipoEntrega();
					
				}
				
				cmbTipoEntrega.setSelectedIndex(0);
				
			}
			
		});
		
		cmbTipoDoacao.addItem(new ItemComboBox(0, "--- Selecione ---"));
		cmbTipoDoacao.addItem(new ItemComboBox(TipoDoacaoEnum.DINHEIRO.getCodigo(), TipoDoacaoEnum.DINHEIRO.getDescricao()));
		cmbTipoDoacao.addItem(new ItemComboBox(TipoDoacaoEnum.ALIMENTOS.getCodigo(), TipoDoacaoEnum.ALIMENTOS.getDescricao()));
		cmbTipoDoacao.addItem(new ItemComboBox(TipoDoacaoEnum.ROUPAS.getCodigo(), TipoDoacaoEnum.ROUPAS.getDescricao()));
		
		cmbTipoEntrega.setBounds(297, 187, 192, 22);
		add(cmbTipoEntrega);
		
		cmbTipoDoacao.setBounds(297, 92, 194, 22);
		add(cmbTipoDoacao);
		
		JLabel lblTipoDoacao = new JLabel("Tipo Doa\u00E7\u00E3o:");
		lblTipoDoacao.setBounds(153, 96, 91, 14);
		add(lblTipoDoacao);
		
		JLabel lblDescDoacao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescDoacao.setBounds(153, 128, 91, 14);
		add(lblDescDoacao);
		
		JLabel lblValorDoacao = new JLabel("Valor:");
		lblValorDoacao.setBounds(153, 159, 91, 14);
		add(lblValorDoacao);
		
		JLabel lblTipoEntrega = new JLabel("Entrega:");
		lblTipoEntrega.setBounds(153, 191, 91, 14);
		add(lblTipoEntrega);
		
		cmbTipoEntrega.addActionListener(event -> {
			
		});
		
		cmbTipoEntrega.setBounds(297, 187, 192, 22);
		add(cmbTipoEntrega);
		
		JButton btnRealizarDoacao = new JButton("Realizar Doa\u00E7\u00E3o");
		btnRealizarDoacao.setBounds(244, 237, 159, 23);
		btnRealizarDoacao.addActionListener(event -> {
			
			Doacao doacao = new Doacao();
			
			doacao.setDescricao(txtDescDoacao.getText());
			doacao.setValor(txtValorDoacao.getText());
			doacao.setDoador(InformacoesUsuario.getInstance().getUsuarioLogado());
			ItemComboBox tipoDoacao = (ItemComboBox) cmbTipoDoacao.getSelectedItem();
			ItemComboBox tipoEntrega = (ItemComboBox) cmbTipoEntrega.getSelectedItem();
			doacao.setTipoDoacao(TipoDoacaoEnum.obterPorCodigo(tipoDoacao.getChave()));
			doacao.setTipoEntrega(TipoEntregaEnum.obterPorCodigo(tipoEntrega.getChave()));
			
			try {
				
				DoacaoController.getInstance().realizarDoacao(doacao);
				JOptionPane.showMessageDialog(null, "Doação realizada com sucesso.");
				
				txtDescDoacao.setText("");
				txtValorDoacao.setText("");
				cmbTipoDoacao.setSelectedIndex(0);
				cmbTipoEntrega.setSelectedIndex(0);

			} catch (NegocioException e) {
				
				JOptionPane.showMessageDialog(null, e.getMessage());
				
			}
			
			
		});
		add(btnRealizarDoacao);
		
		
	}

	private void adicionarTodasOpcoesTipoEntrega() {
		cmbTipoEntrega.removeAllItems();
		cmbTipoEntrega.addItem(new ItemComboBox(0, "---Selecione---"));
		cmbTipoEntrega.addItem(new ItemComboBox(TipoEntregaEnum.ENTREGA.getCodigo(), TipoEntregaEnum.ENTREGA.getDescricao()));
		cmbTipoEntrega.addItem(new ItemComboBox(TipoEntregaEnum.RETIRADA.getCodigo(), TipoEntregaEnum.RETIRADA.getDescricao()));
		cmbTipoEntrega.addItem(new ItemComboBox(TipoEntregaEnum.TRANSFERENCIA.getCodigo(), TipoEntregaEnum.TRANSFERENCIA.getDescricao()));
	}
	
	private void adicionarOpcoesSemTransferenciasTipoEntrega() {
		cmbTipoEntrega.removeAllItems();
		cmbTipoEntrega.addItem(new ItemComboBox(0, "---Selecione---"));
		cmbTipoEntrega.addItem(new ItemComboBox(TipoEntregaEnum.ENTREGA.getCodigo(), TipoEntregaEnum.ENTREGA.getDescricao()));
		cmbTipoEntrega.addItem(new ItemComboBox(TipoEntregaEnum.RETIRADA.getCodigo(), TipoEntregaEnum.RETIRADA.getDescricao()));
	}
	
	
	
}
