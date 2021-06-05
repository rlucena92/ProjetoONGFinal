package view.components.jtable;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import comum.FuncoesUtil;
import model.entidades.Pessoa;

public class PessoaTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PessoaTableModel(List<Pessoa> pessoas) {

		super.addColumn("CPF");
		super.addColumn("Nome");
		super.addColumn("Login");
		super.addColumn("Data/Hora Cadastro");
		super.addColumn("Login Responsável");
		super.addColumn("");

		for (Pessoa pessoa : pessoas) {

			super.addRow(new Object[] { pessoa.getNumCpfCnpj(), pessoa.getNome(), pessoa.getLoginPessoa().getLogin(),
					FuncoesUtil.formatarDataHora(pessoa.getDataHoraCadastro()), pessoa.getLoginResponsavel(), null });

		}
		
	}
	
    @Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
    
    public String obterCpfCnpjPessoa(int linha) {
    	
    	return (String) super.getValueAt(linha, 0);
    	
    }


}