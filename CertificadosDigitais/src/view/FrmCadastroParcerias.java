package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import controller.Database;
import controller.MySql_Parceria;
import model.Parceria;

@SuppressWarnings("serial")
public class FrmCadastroParcerias extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_empresa;
	private JTextField txt_celular;
	private JLabel lblEmail;
	private JTextField txt_email;
	private JTable tebela_parceria;
	private JButton btnEditar;
	private JLabel label_mensagem;
	private JButton btnCancelar;
	
	static Parceria parceriaEditar;
	private JButton btnExcluir;
	private JLabel lblCodParceiro;
	private JTextField txt_codigoParceiro;
	
	public FrmCadastroParcerias() {
		setResizable(false);
		
		label_mensagem = new JLabel("");
		label_mensagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				FrmCadastroParcerias f = new FrmCadastroParcerias();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnCancelar.setEnabled(false);
		txt_celular = new JTextField();
		txt_email = new JTextField();
		txt_email.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
		});
		
		setTitle("Cadastro de Parcerias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1102, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 53, 136, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("Empresa:");
	
		lblCPF.setBounds(499, 53, 77, 14);
		contentPane.add(lblCPF);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(82, 50, 407, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		txt_empresa = new JTextField();
		txt_empresa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
			
			       
			}
		});
		txt_empresa.setBounds(567, 50, 301, 20);
		contentPane.add(txt_empresa);
		txt_empresa.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (parceriaEditar == null) {
					
					String nome = txt_nome.getText().toUpperCase();
					
					if (nome.equalsIgnoreCase("")) {
						txt_nome.setBackground(Color.yellow );
						return;
					}else {
						txt_nome.setBackground(Color.white);
					}
					
					
					if (txt_empresa.getText().equalsIgnoreCase("")) {
						txt_empresa.setBackground(Color.yellow);
						return;
					}else {
						txt_empresa.setBackground(Color.white);
					}
					String empresa = txt_empresa.getText();
					
							
					if (txt_celular.getText().equalsIgnoreCase("")) {
						txt_celular.setBackground(Color.yellow);
						return;
					}else {
						txt_celular.setBackground(Color.white);
					}
					
					String celular = txt_celular.getText();
					
					
					if (txt_codigoParceiro.getText().equalsIgnoreCase("")) {
						txt_codigoParceiro.setBackground(Color.yellow);
						return;
					}else {
						txt_codigoParceiro.setBackground(Color.white);
					}
					
					String codigoParceiro = txt_codigoParceiro.getText();
					
					
					if (txt_email.getText().equalsIgnoreCase("")) {
						txt_email.setBackground(Color.yellow);
						return;
					}else {
						txt_email.setBackground(Color.white);
					}
					
					String email = txt_email.getText();
					
					
					
					
					try {
						MySql_Parceria.getInsereParceria(nome, empresa, celular, codigoParceiro, email);
						JOptionPane.showMessageDialog(null, "Cadastro Gravado");
						dispose();
						FrmCadastroParcerias cp = new FrmCadastroParcerias();
						cp.setLocationRelativeTo(null);
						cp.setVisible(true);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "NAO PASSOU PELO METODO DE INSERIR \n"
								+ "PROBLEMA NA GRAVACAO NO BANCO");
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO CAPTURADO: \n"+e.toString());
					}
					
					
				}else { // se entrar aqui é por que tem algum objeto na variavel entao não é novo cadastro e sim edição
					
					int idAlunoEditar = parceriaEditar.getId();
					
String nome = txt_nome.getText().toUpperCase();
					
					if (nome.equalsIgnoreCase("")) {
						txt_nome.setBackground(Color.yellow );
						return;
					}else {
						txt_nome.setBackground(Color.white);
					}
					
					
					if (txt_empresa.getText().equalsIgnoreCase("")) {
						txt_empresa.setBackground(Color.yellow);
						return;
					}else {
						txt_empresa.setBackground(Color.white);
					}
					String empresa = txt_empresa.getText();
					
							
					if (txt_celular.getText().equalsIgnoreCase("")) {
						txt_celular.setBackground(Color.yellow);
						return;
					}else {
						txt_celular.setBackground(Color.white);
					}
					
					String celular = txt_celular.getText();
					
					
					if (txt_email.getText().equalsIgnoreCase("")) {
						txt_email.setBackground(Color.yellow);
						return;
					}else {
						txt_email.setBackground(Color.white);
					}
					
					String email = txt_email.getText();
					
					
					parceriaEditar.setNome(nome);
					parceriaEditar.setEmpresa(empresa);
					parceriaEditar.setTelefone(celular);
					parceriaEditar.setEmail(email);
					
					try {
						MySql_Parceria.editaParceria(parceriaEditar);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					parceriaEditar = null;
					limparCampos();
					
				}
				
				
				
			}
		});
		btnGravar.setBounds(10, 151, 175, 45);
		contentPane.add(btnGravar);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 84, 121, 14);
		contentPane.add(lblCelular);
		
		
		txt_celular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				String caracteres="0987654321";

			       if(! caracteres.contains(arg0.getKeyChar()+"")){

			    	   arg0.consume();

			       }
			       
			       int caracteres_maximo3=10;
				if (txt_celular.getText().length()>caracteres_maximo3) {
			    	   arg0.consume();
			    	   JOptionPane.showMessageDialog(null, "Maximo de caracteres permitido");
					
				}
				
			}
		});
		txt_celular.setBounds(82, 81, 121, 20);
		contentPane.add(txt_celular);
		txt_celular.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(229, 84, 136, 14);
		contentPane.add(lblEmail);
		
	
		txt_email.setColumns(10);
		txt_email.setBounds(288, 81, 580, 20);
		contentPane.add(txt_email);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 1076, 263);
		contentPane.add(scrollPane);
		
		tebela_parceria = new JTable();
		tebela_parceria.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "EMPRESA", "CELULAR","COD PARC.", "EMAIL"
			}
		));
		
		DefaultTableModel minhaTabela = (DefaultTableModel) tebela_parceria.getModel();
		try {
			
			Connection connection = Database.getConnection();
			Statement statement = connection.createStatement();
			boolean resultado = statement.execute("select * from parceria");
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "PROBLEMA NO SELECT * PESSOA");
			}
			ResultSet resultSet = statement.getResultSet();
			Parceria p = new Parceria();
			while (resultSet.next()) {
				
				p.setId(resultSet.getInt("id"));
				p.setNome(resultSet.getString("nome"));
				p.setEmpresa(resultSet.getString("empresa"));
				p.setTelefone(resultSet.getString("telefone"));
				p.setCodParceiro(resultSet.getString("codigoParceiro"));
				p.setEmail(resultSet.getString("email"));
				
				Object[] linha1 = {p.getId(),p.getNome(),p.getEmpresa(),p.getTelefone(),p.getCodParceiro(),p.getEmail(),};
				minhaTabela.addRow(linha1);
			}
		} catch (SQLException e1) {
			String erro = e1.getMessage();
			if (erro.contains("Communications")) {
				JOptionPane.showMessageDialog(null, "VERIFIQUE A COMUNICACAO COM O SERVIDOR DO BANCO DE DADOS");
				
			}
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		
		tebela_parceria.getColumnModel().getColumn(0).setMaxWidth(35);
		tebela_parceria.getColumnModel().getColumn(1).setMaxWidth(260);
		tebela_parceria.getColumnModel().getColumn(2).setMaxWidth(260);
		tebela_parceria.getColumnModel().getColumn(3).setMaxWidth(90);
		tebela_parceria.getColumnModel().getColumn(4).setMaxWidth(150);
		tebela_parceria.getColumnModel().getColumn(5).setMaxWidth(260);
		
		
		scrollPane.setViewportView(tebela_parceria);
		
		JLabel lblEstoqueDeMdias = new JLabel("Cadastro & Listagem Parceiros");
		lblEstoqueDeMdias.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoqueDeMdias.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEstoqueDeMdias.setBounds(0, 11, 1086, 28);
		contentPane.add(lblEstoqueDeMdias);
		
		JButton btnImprimir = new JButton("Imprimir Tabela");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MessageFormat titulo = new MessageFormat("Listagem de Pessoas / Estoque\n");//Imprime um Titulo no cabeçalho da página.  
				MessageFormat numeroPaginas = new MessageFormat("Desenvolvido por www.mpiinformatica.com - Pagina - {0,number,integer}");//Imprime o numero de página no rodapé de cada página.  
				  
				try {  
				    // Imprime o coteudo da "jTable1":  
				    tebela_parceria.print(JTable.PrintMode.FIT_WIDTH, titulo, numeroPaginas);  
				  
				} catch (java.awt.print.PrinterException ex) {  
				    JOptionPane.showMessageDialog(null, "Erro de impressão: " + ex.getMessage(), "Erro de impressão", JOptionPane.ERROR_MESSAGE);  
				}
				
				
			}
		});
		btnImprimir.setBounds(942, 481, 144, 23);
		contentPane.add(btnImprimir);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)tebela_parceria.getModel();
				
				
				int index = tebela_parceria.getSelectedRow();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma pessoa para ser editada !");
					limparCampos();
					return;
				}
				
				int cod = (int)model.getValueAt(index, 0);
				
				Parceria p = new Parceria();
				
				try {
					p = MySql_Parceria.buscaParceria(cod);
					
					int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja editar a pessoa :\n"
							+ "Codigo: "+p.getId()+"\n "
						+ "Descrição: "+p.getNome());
					if (opc == 0) { // opcao 0 = sim
						
						btnGravar.setText("Salvar Alteracoes");
						label_mensagem.setForeground(Color.red);
						label_mensagem.setText("Editando ID: "+p.getId()+" Descrição antiga: "+p.getNome());
						btnEditar.setEnabled(false);
						btnImprimir.setEnabled(false);
						btnCancelar.setEnabled(true);
						
						txt_nome.setText(p.getNome());
						txt_empresa.setText(p.getEmpresa());
						txt_email.setText(p.getEmail());
						txt_codigoParceiro.setText(p.getCodParceiro());
						txt_celular.setText(p.getTelefone());

						
						
							parceriaEditar = p;
						
					
					}else {
						JOptionPane.showMessageDialog(null, "Operacao Cancelada");
						limparCampos();
						return;
						
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null,"PROBLEMA NA EDICAO FRM CADASTRO PESSOAS "+e1.toString());
				}
				
				

				
				
			}
		});
		btnEditar.setBounds(802, 173, 89, 23);
		contentPane.add(btnEditar);
		
		
		label_mensagem.setBounds(206, 142, 483, 27);
		contentPane.add(label_mensagem);
		
		
		btnCancelar.setBounds(901, 173, 89, 23);
		contentPane.add(btnCancelar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
DefaultTableModel model = (DefaultTableModel)tebela_parceria.getModel();
				
				
				int index = tebela_parceria.getSelectedRow();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma pessoa a ser excluida!");
					limparCampos();
					return;
				}
				
				

				int cod = (int)model.getValueAt(index, 0);
				
				Parceria p = new Parceria();
				
					try {
						
						p = MySql_Parceria.buscaParceria(cod);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
						
						int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a pessoa:\n"
								+ "Codigo: "+p.getId()+"\n "
								+ "Nome: "+p.getNome());
						if (opc == 0) {
							try {
								MySql_Parceria.removeParceria(p);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							
							JOptionPane.showMessageDialog(null, "Cadastro excluido");
							limparCampos();
							return;
							
						}else {
							JOptionPane.showMessageDialog(null, "Operação Cancelada!");
							limparCampos();
						}
				
				
			}
		});
		btnExcluir.setBounds(997, 173, 89, 23);
		contentPane.add(btnExcluir);
		
		lblCodParceiro = new JLabel("Cod. Parceiro:");
		lblCodParceiro.setBounds(886, 53, 121, 14);
		contentPane.add(lblCodParceiro);
		
		txt_codigoParceiro = new JTextField();
		txt_codigoParceiro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				String caracteres="0987654321";

			       if(! caracteres.contains(arg0.getKeyChar()+"")){

			              arg0.consume();

			       }
			       
//			       int caracteres_maximo1=10;
//				if (txt_empresa.getText().length()>caracteres_maximo1) {
//			    	   arg0.consume();
//			    	   JOptionPane.showMessageDialog(null, "Maximo de caracteres permitido");
//					
//				}
			}
		});
		txt_codigoParceiro.setColumns(10);
		txt_codigoParceiro.setBounds(965, 50, 121, 20);
		contentPane.add(txt_codigoParceiro);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_nome, txt_empresa, btnGravar, lblNome, lblCPF}));
	}
	protected void limparCampos() {
		// TODO Auto-generated method stub
		dispose();
		FrmCadastroParcerias f = new FrmCadastroParcerias();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
