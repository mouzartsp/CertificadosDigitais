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
import controller.MySql_Pessoas;
import model.Pessoa;

@SuppressWarnings("serial")
public class FrmCadastroPessoas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_cpf;
	private JTextField txt_celular;
	private JLabel lblEmail;
	private JTextField txt_email;
	private JTable tabela_pessoas;
	private JButton btnEditar;
	private JLabel label_mensagem;
	private JButton btnCancelar;
	
	static Pessoa pessoaEditar;
	private JButton btnExcluir;
	
	public FrmCadastroPessoas() {
		
		label_mensagem = new JLabel("");
		label_mensagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				FrmCadastroPessoas f = new FrmCadastroPessoas();
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
		
		setTitle("Cadastro de Pessoas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 53, 136, 14);
		contentPane.add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF:");
	
		lblCPF.setBounds(10, 84, 77, 14);
		contentPane.add(lblCPF);
		
		txt_nome = new JTextField();
		txt_nome.setBounds(82, 50, 607, 20);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		txt_cpf = new JTextField();
		txt_cpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				String caracteres="0987654321";

			       if(! caracteres.contains(arg0.getKeyChar()+"")){

			              arg0.consume();

			       }
			       
			       int caracteres_maximo=10;
				if (txt_cpf.getText().length()>caracteres_maximo) {
			    	   arg0.consume();
			    	   JOptionPane.showMessageDialog(null, "Maximo de caracteres permitido");
					
				}
			       
			}
		});
		txt_cpf.setBounds(82, 78, 132, 20);
		contentPane.add(txt_cpf);
		txt_cpf.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (pessoaEditar == null) {
					
					String nome = txt_nome.getText().toUpperCase();
					
					if (nome.equalsIgnoreCase("")) {
						txt_nome.setBackground(Color.yellow );
						return;
					}else {
						txt_nome.setBackground(Color.white);
					}
					
					
					if (txt_cpf.getText().equalsIgnoreCase("")) {
						txt_cpf.setBackground(Color.yellow);
						return;
					}else {
						txt_cpf.setBackground(Color.white);
					}
					String cpf = txt_cpf.getText();
					
							
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
					
					
					
					
					try {
						MySql_Pessoas.getInserePessoa(nome, cpf, celular, email);
						JOptionPane.showMessageDialog(null, "Cadastro Gravado");
						dispose();
						FrmCadastroPessoas cm = new FrmCadastroPessoas();
						cm.setLocationRelativeTo(null);
						cm.setVisible(true);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "NAO PASSOU PELO METODO DE INSERIR \n"
								+ "PROBLEMA NA GRAVACAO NO BANCO");
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO CAPTURADO: \n"+e.toString());
					}
					
					
				}else { // se entrar aqui é por que tem algum objeto na variavel entao não é novo cadastro e sim edição
					
					int idAlunoEditar = pessoaEditar.getId();
					
String nome = txt_nome.getText().toUpperCase();
					
					if (nome.equalsIgnoreCase("")) {
						txt_nome.setBackground(Color.yellow );
						return;
					}else {
						txt_nome.setBackground(Color.white);
					}
					
					
					if (txt_cpf.getText().equalsIgnoreCase("")) {
						txt_cpf.setBackground(Color.yellow);
						return;
					}else {
						txt_cpf.setBackground(Color.white);
					}
					String cpf = txt_cpf.getText();
					
							
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
					
					
					pessoaEditar.setNome(nome);
					pessoaEditar.setCpf(cpf);
					pessoaEditar.setTelefone(celular);
					pessoaEditar.setEmail(email);
					
					try {
						MySql_Pessoas.editaPessoa(pessoaEditar);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					pessoaEditar = null;
					limparCampos();
					
				}
				
				
				
			}
		});
		btnGravar.setBounds(10, 151, 175, 45);
		contentPane.add(btnGravar);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(224, 84, 121, 14);
		contentPane.add(lblCelular);
		
		
		txt_celular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				String caracteres="0987654321";

			       if(! caracteres.contains(arg0.getKeyChar()+"")){

			    	   arg0.consume();

			       }
			       
			       int caracteres_maximo=10;
				if (txt_celular.getText().length()>caracteres_maximo) {
			    	   arg0.consume();
			    	   JOptionPane.showMessageDialog(null, "Maximo de caracteres permitido");
					
				}
				
			}
		});
		txt_celular.setBounds(279, 81, 121, 20);
		contentPane.add(txt_celular);
		txt_celular.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(410, 84, 136, 14);
		contentPane.add(lblEmail);
		
	
		txt_email.setColumns(10);
		txt_email.setBounds(451, 83, 238, 20);
		contentPane.add(txt_email);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 679, 263);
		contentPane.add(scrollPane);
		
		tabela_pessoas = new JTable();
		tabela_pessoas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "NOME", "CPF", "CELULAR", "EMAIL"
			}
		));
		
		DefaultTableModel minhaTabela = (DefaultTableModel) tabela_pessoas.getModel();
		try {
			
			Connection connection = Database.getConnection();
			Statement statement = connection.createStatement();
			boolean resultado = statement.execute("select * from pessoa");
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "PROBLEMA NO SELECT * PESSOA");
			}
			ResultSet resultSet = statement.getResultSet();
			Pessoa p = new Pessoa();
			while (resultSet.next()) {
				
				p.setId(resultSet.getInt("id"));
				p.setNome(resultSet.getString("nome"));
				p.setCpf(resultSet.getString("cpf"));
				p.setTelefone(resultSet.getString("telefone"));
				p.setEmail(resultSet.getString("email"));
				
				Object[] linha1 = {p.getId(),p.getNome(),p.getCpf(),p.getTelefone(),p.getEmail(),};
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
		
		tabela_pessoas.getColumnModel().getColumn(0).setMaxWidth(20);
		tabela_pessoas.getColumnModel().getColumn(1).setMaxWidth(250);
		tabela_pessoas.getColumnModel().getColumn(2).setMaxWidth(90);
		tabela_pessoas.getColumnModel().getColumn(3).setMaxWidth(90);
		tabela_pessoas.getColumnModel().getColumn(4).setMaxWidth(240);
		
		
		scrollPane.setViewportView(tabela_pessoas);
		
		JLabel lblEstoqueDeMdias = new JLabel("Cadastro & Listagem Pessoas");
		lblEstoqueDeMdias.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoqueDeMdias.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEstoqueDeMdias.setBounds(0, 11, 699, 28);
		contentPane.add(lblEstoqueDeMdias);
		
		JButton btnImprimir = new JButton("Imprimir Tabela");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MessageFormat titulo = new MessageFormat("Listagem de Pessoas / Estoque\n");//Imprime um Titulo no cabeçalho da página.  
				MessageFormat numeroPaginas = new MessageFormat("Desenvolvido por www.mpiinformatica.com - Pagina - {0,number,integer}");//Imprime o numero de página no rodapé de cada página.  
				  
				try {  
				    // Imprime o coteudo da "jTable1":  
				    tabela_pessoas.print(JTable.PrintMode.FIT_WIDTH, titulo, numeroPaginas);  
				  
				} catch (java.awt.print.PrinterException ex) {  
				    JOptionPane.showMessageDialog(null, "Erro de impressão: " + ex.getMessage(), "Erro de impressão", JOptionPane.ERROR_MESSAGE);  
				}
				
				
			}
		});
		btnImprimir.setBounds(545, 481, 144, 23);
		contentPane.add(btnImprimir);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)tabela_pessoas.getModel();
				
				
				int index = tabela_pessoas.getSelectedRow();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma pessoa para ser editada !");
					limparCampos();
					return;
				}
				
				int cod = (int)model.getValueAt(index, 0);
				
				Pessoa p = new Pessoa();
				
				try {
					p = MySql_Pessoas.buscaPessoa(cod);
					
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
						txt_cpf.setText(p.getCpf());
						txt_email.setText(p.getEmail());
						txt_celular.setText(p.getTelefone());

						
						
							pessoaEditar = p;
						
					
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
		btnEditar.setBounds(405, 173, 89, 23);
		contentPane.add(btnEditar);
		
		
		label_mensagem.setBounds(206, 142, 483, 27);
		contentPane.add(label_mensagem);
		
		
		btnCancelar.setBounds(504, 173, 89, 23);
		contentPane.add(btnCancelar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
DefaultTableModel model = (DefaultTableModel)tabela_pessoas.getModel();
				
				
				int index = tabela_pessoas.getSelectedRow();
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma pessoa a ser excluida!");
					limparCampos();
					return;
				}
				
				

				int cod = (int)model.getValueAt(index, 0);
				
				Pessoa p = new Pessoa();
				
					try {
						
						p = MySql_Pessoas.buscaPessoa(cod);
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
						
						int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a pessoa:\n"
								+ "Codigo: "+p.getId()+"\n "
								+ "Nome: "+p.getNome());
						if (opc == 0) {
							try {
								MySql_Pessoas.removePessoa(p);
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
		btnExcluir.setBounds(600, 173, 89, 23);
		contentPane.add(btnExcluir);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_nome, txt_cpf, btnGravar, lblNome, lblCPF}));
	}
	protected void limparCampos() {
		// TODO Auto-generated method stub
		dispose();
		FrmCadastroPessoas f = new FrmCadastroPessoas();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
