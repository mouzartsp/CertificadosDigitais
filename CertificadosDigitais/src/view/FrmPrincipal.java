package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame {

	private JPanel contentPane;

	public FrmPrincipal() {
		setTitle("Controle de Certificados Digitais by Mpi Inform\u00E1tica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);
		
		JMenu mnClientes = new JMenu("Cadastros");
		menuBar.add(mnClientes);
		
		JMenuItem menuCadastroCliente = new JMenuItem("Cadastrar Pessoa Fisica");
		menuCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmCadastroPessoas c = new FrmCadastroPessoas();
				c.setLocationRelativeTo(null);
				c.setVisible(true);
			}
		});
		mnClientes.add(menuCadastroCliente);
		
		JMenuItem mntmCadastroCertificados = new JMenuItem("Cadastro Certificados");
		mntmCadastroCertificados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmCadastroCertificados cc = new FrmCadastroCertificados();
				cc.setLocationRelativeTo(null);
				cc.setVisible(true);
			}
		});
		mnClientes.add(mntmCadastroCertificados);
		
		JMenuItem mntmCadastroParcerias = new JMenuItem("Cadastro Parcerias");
		mntmCadastroParcerias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmCadastroParcerias cp = new FrmCadastroParcerias();
				cp.setLocationRelativeTo(null);
				cp.setVisible(true);
			}
		});
		
		JMenuItem mntmCadastroMidias = new JMenuItem("Cadastro Midias");
		mntmCadastroMidias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmCadastroMidias cm = new FrmCadastroMidias();
				cm.setLocationRelativeTo(null);
				cm.setVisible(true);
			}
		});
		mnClientes.add(mntmCadastroMidias);
		mnClientes.add(mntmCadastroParcerias);
		
		JMenuItem mntmCadastroEmpresas = new JMenuItem("Cadastro Empresas");
		mntmCadastroEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmCadastroEmpresas ce = new FrmCadastroEmpresas();
				ce.setLocationRelativeTo(null);
				ce.setVisible(true);
			}
		});
		mnClientes.add(mntmCadastroEmpresas);
		
		JMenu mnLanvc = new JMenu("Certificacao");
		mnLanvc.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnLanvc);
		
		JMenuItem mntmLancar = new JMenuItem("Lancar");
		mntmLancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmLancaCertificacao flc = new FrmLancaCertificacao();
				flc.setLocationRelativeTo(null);
				flc.setVisible(true);
			}
		});
		mnLanvc.add(mntmLancar);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 1.0");
		lblVerso.setBounds(147, 236, 73, 14);
		contentPane.add(lblVerso);
		
		JLabel lblBancoDeDados = new JLabel("BD: MySql / Nome do BD: certificados_digitais / login e senha: root");
		lblBancoDeDados.setBounds(10, 211, 414, 14);
		contentPane.add(lblBancoDeDados);
		
		JLabel lblBuildDate = new JLabel("Build date: 01/09/2017");
		lblBuildDate.setBounds(10, 236, 134, 14);
		contentPane.add(lblBuildDate);
		
		JLabel lblByMouzatPassos = new JLabel("By Mpi Inform\u00E1tica");
		lblByMouzatPassos.setBounds(300, 236, 134, 14);
		contentPane.add(lblByMouzatPassos);
	}
}
