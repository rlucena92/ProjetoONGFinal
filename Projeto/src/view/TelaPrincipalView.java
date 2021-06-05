package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import comum.InformacoesUsuario;
import controller.AcessoController;
import model.PerfilAcessoEnum;
import model.entidades.MenuItemSistema;
import model.entidades.MenuSistema;

public class TelaPrincipalView {

	private JFrame frame;
	private JPanel jPanel;
	private JMenuBar menuBar = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalView window = new TelaPrincipalView();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipalView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
        frame.setSize(700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 684, 22);
		frame.getContentPane().add(menuBar);
		
		JPanel panelLogin = new PanelLoginView(this);
		panelLogin.setBounds(0, 23, 684, 511);
		frame.getContentPane().add(panelLogin);
		
	}
	
	public void abrirPanel(JPanel jPanel) {
		
		frame.getContentPane().remove(1);
		
		jPanel.setBounds(0, 0, 684, 22);
		jPanel.revalidate();
		jPanel.repaint();
		frame.getContentPane().add(jPanel);
		frame.getContentPane().validate();
		frame.getContentPane().repaint();
		
	}
	
	public void realizarAjustesPosLogin() {
		
		montarMenus();
		
	}

	private void montarMenus() {
		
		PerfilAcessoEnum perfilAcessoEnum = InformacoesUsuario.getInstance().getUsuarioLogado().getLoginPessoa().getPerfilAcessoEnum();
		
		List<MenuSistema> menusSistema = AcessoController.getInstance().obterMenu(perfilAcessoEnum);
		
		JMenu jMenu = null;
		
		if(menusSistema != null) {
			
			for (MenuSistema menuSistema : menusSistema) {
				
				jMenu = new JMenu(menuSistema.getNome());
				adicionarMenuIens(jMenu, menuSistema);
				
				menuBar.add(jMenu);
				
			}
			
		}
		
		
		jMenu = new JMenu("Sessao");
		JMenuItem jMenuItem = new JMenuItem("Logout");
		jMenu.add(jMenuItem);
		jMenuItem.addActionListener(event -> {
			
			InformacoesUsuario.getInstance().setUsuarioLogado(null);
			JPanel jpanel = new PanelLoginView(this);
			this.abrirPanel(jpanel);
			menuBar.removeAll();
			
		});
		
		menuBar.add(jMenu);
		
	}

	private void adicionarMenuIens(JMenu jMenu, MenuSistema menuSistema) {
		
		JMenuItem jMenuItem = null;
		for (MenuItemSistema menuItem : menuSistema.getMenuItens()) {
			
			jMenuItem = new JMenuItem(menuItem.getNomeMenu());
			
			jMenuItem.addActionListener((e) -> {
				
				 try {
					 
					jPanel = (JPanel) Class.forName(menuItem.getPanelEnum().getPath()).newInstance();
					this.abrirPanel(jPanel);
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					
					e1.printStackTrace();
					
				}
				
			});
			
			jMenu.add(jMenuItem);
			
		}
	}
	
}
