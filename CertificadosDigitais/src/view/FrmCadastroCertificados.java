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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import controller.Database;
import controller.MySql;
import model.Certificado;
import model.Midia;

@SuppressWarnings("serial")
public class FrmCadastroCertificados extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Descricao;
	private JTextField txt_Custo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCampoCusto;
	private JTextField txtCampoCusto_1;
	private JTable tabela_certificados;
	private JTextField txt_preco_venda;
	private JTextField txt_preco_comissao_contador;
	private JTextField txt_preco_vista;
	static Certificado certificadoEditar;
	private JTextField txt_margem;
	private JTextField txt_quantidade_midia;
	private JTextField txt_valor_venda_midia;

	public FrmCadastroCertificados() {
		
		txt_quantidade_midia = new JTextField();
		JComboBox<Midia> comboBoxMidia = new JComboBox<Midia>();
		carregaComboBox(comboBoxMidia);
		comboBoxMidia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMidia.getSelectedIndex() == 0) {
					txt_quantidade_midia.setText("");;
					return;
				} else {

					int idMidia = ((Midia) comboBoxMidia.getSelectedItem()).getId();
					int quantidade = ((Midia) comboBoxMidia.getSelectedItem()).getQuantidade();
					// JOptionPane.showMessageDialog(null, "Teste:"+idMidia);
					txt_quantidade_midia.setText("" + quantidade);
				}

			}
		});

		txt_margem = new JTextField();

		txt_margem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {

				// String caracteres="0987654321";
				//
				// if(! caracteres.contains(arg0.getKeyChar()+"")){
				//
				// arg0.consume();
				//
				// }

				// int caracteres_maximo = 3;
				// if (txt_margem.getText().length()>caracteres_maximo ) {
				// arg0.consume();
				// JOptionPane.showMessageDialog(null, "Maximo setado para 3 DIGITOS");
				//
				// }
				//
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER || arg0.getKeyCode() == KeyEvent.VK_TAB) {
					String testa = txt_margem.getText();
					String testa2 = txt_Custo.getText();
					if (testa2.equalsIgnoreCase("")) {
						return;

					}
					if (testa.equalsIgnoreCase("")) {
						return;
					}
					int margem = Integer.valueOf(txt_margem.getText());
					int custo = Integer.valueOf(txt_Custo.getText());
					int valor = custo * margem / 100;
					int valorFinal = valor + custo;
					txt_preco_venda.setText("" + valorFinal);
				}

			}
		});
		JRadioButton rb_12 = new JRadioButton("12");
		JRadioButton rb_24 = new JRadioButton("24");
		JRadioButton rb_36 = new JRadioButton("36");
		JLabel label_mensagem = new JLabel(".");
		label_mensagem.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		JButton btnGravar = new JButton("Gravar");
		JButton btnCancelar = new JButton("Cancelar");
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabela_certificados.getModel();

				int index = tabela_certificados.getSelectedRow();

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um certificado para ser editado !");
					limparCampos();
					return;
				}

				int cod = (int) model.getValueAt(index, 0);

				Certificado c = new Certificado();

				try {
					c = MySql.buscaCertificado(cod);

					int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja editar a midia :\n"
							+ "Codigo: " + c.getId() + "\n " + "Descrição: " + c.getDescricao());
					if (opc == 0) { // opcao 0 = sim

						btnGravar.setText("Salvar Alteracoes");
						label_mensagem.setForeground(Color.red);
						label_mensagem.setText("Editando ID: " + c.getId() + " Descrição antiga: " + c.getDescricao());
						btnEditar.setEnabled(false);
						btnCancelar.setEnabled(true);

						txt_Descricao.setText(c.getDescricao());
						txt_Custo.setText(String.valueOf(c.getCusto()));
						txt_preco_comissao_contador.setText(String.valueOf(c.getComissao() + ""));
						txt_preco_venda.setText(String.valueOf(c.getPreco_prazo() + ""));
						txt_preco_vista.setText(String.valueOf(c.getPreco_vista() + ""));
						int valorRB = c.getValidade();
						if (valorRB == 12) {
							rb_12.setSelected(true);
						} else if (valorRB == 24) {
							rb_24.setSelected(true);
						} else if (valorRB == 36) {
							rb_36.setSelected(true);
						}

						certificadoEditar = c;

					} else {
						JOptionPane.showMessageDialog(null, "Operacao Cancelada");
						limparCampos();
						return;

					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "PROBLEMA NA EDICAO FRM CADASTRO MIDIAS " + e1.toString());
				}

			}
		});
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel model = (DefaultTableModel) tabela_certificados.getModel();

				int index = tabela_certificados.getSelectedRow();

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione um certificado a ser excluido!");
					limparCampos();
					return;
				}

				int cod = (int) model.getValueAt(index, 0);

				Certificado c = new Certificado();

				try {

					c = MySql.buscaCertificado(cod);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o certificado:\n"
						+ "Codigo: " + c.getId() + "\n " + "Descricao: " + c.getDescricao());
				if (opc == 0) {
					try {
						MySql.removeCertificado(c);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

					JOptionPane.showMessageDialog(null, "Cadastro excluido");
					limparCampos();
					return;

				} else {
					JOptionPane.showMessageDialog(null, "Operação Cancelada!");
					limparCampos();
				}

			}
		});

		btnCancelar.setEnabled(false);

		txt_preco_vista = new JTextField();
		setTitle("Cadastro Certificados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1085, 572);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_Descricao = new JLabel("Descri\u00E7\u00E3o:");
		label_Descricao.setBounds(10, 51, 72, 14);
		contentPane.add(label_Descricao);

		JLabel label_Validade = new JLabel("Validade:");
		label_Validade.setBounds(422, 51, 71, 14);
		contentPane.add(label_Validade);

		JLabel label_Custo = new JLabel("Custo R$");
		label_Custo.setToolTipText("CUSTO QUE VOCE TEM COM A CERTIFICADORA QUE ESTA NA TABELA DO SEU CONTRATO");
		label_Custo.setBounds(717, 51, 72, 14);
		contentPane.add(label_Custo);

		txt_Descricao = new JTextField();
		txt_Descricao.setToolTipText("EX: E-CPF A1 12 MESES  EX: E-CNPJ A3 24 MESES EX: APENAS NFE A3 36 MESES");
		txt_Descricao.setBounds(73, 48, 339, 20);
		contentPane.add(txt_Descricao);
		txt_Descricao.setColumns(10);

		txt_Custo = new JTextField();
		txt_Custo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321.";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

				int caracteres_maximo = 5;
				if (txt_Custo.getText().length() > caracteres_maximo) {
					ev.consume();
					JOptionPane.showMessageDialog(null, "Maximo setado para 999.99");

				}
			}
		});
		txt_Custo.setColumns(10);
		txt_Custo.setBounds(777, 48, 51, 20);
		contentPane.add(txt_Custo);

		buttonGroup.add(rb_12);
		rb_12.setBounds(499, 47, 40, 23);
		contentPane.add(rb_12);

		buttonGroup.add(rb_24);
		rb_24.setBounds(541, 47, 51, 23);
		contentPane.add(rb_24);

		buttonGroup.add(rb_36);
		rb_36.setBounds(594, 47, 51, 23);
		contentPane.add(rb_36);

		JLabel label_meses = new JLabel("Meses");
		label_meses.setBounds(651, 51, 67, 14);
		contentPane.add(label_meses);

		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (certificadoEditar == null) {

					String descricao = txt_Descricao.getText().toUpperCase();
					if (descricao.equalsIgnoreCase("")) {
						txt_Descricao.setBackground(Color.yellow);
						return;
					} else {
						txt_Descricao.setBackground(Color.white);
					}

					int validade = 0;

					if (rb_12.isSelected()) {
						validade = 12;
					} else if (rb_24.isSelected()) {
						validade = 24;
					} else if (rb_36.isSelected()) {
						validade = 36;
					} else if (!rb_12.isSelected() && !rb_24.isSelected() && !rb_36.isSelected()) {
						rb_12.setBackground(Color.yellow);
						rb_24.setBackground(Color.yellow);
						rb_36.setBackground(Color.yellow);
						return;
					}

					if (txt_Custo.getText().equalsIgnoreCase("")) {
						txt_Custo.setBackground(Color.yellow);
						return;
					} else {
						txt_Custo.setBackground(Color.white);
					}
					double custo = Double.parseDouble(txt_Custo.getText());

					if (txt_preco_venda.getText().equalsIgnoreCase("")) {
						txt_preco_venda.setBackground(Color.yellow);
						return;
					} else {
						txt_preco_venda.setBackground(Color.white);
					}
					double valor_venda = Double.parseDouble(txt_preco_venda.getText());

					if (txt_preco_vista.getText().equalsIgnoreCase("")) {
						txt_preco_vista.setBackground(Color.yellow);
						return;
					} else {
						txt_preco_vista.setBackground(Color.white);
					}
					double valor_venda_vista = Double.parseDouble(txt_preco_vista.getText());

					if (txt_preco_comissao_contador.getText().equalsIgnoreCase("")) {
						txt_preco_comissao_contador.setBackground(Color.yellow);
						return;
					} else {
						txt_preco_comissao_contador.setBackground(Color.white);
					}
					double valor_comissao_contador = Double.parseDouble(txt_preco_comissao_contador.getText());

					try {
						MySql.getInsereCertificado(descricao, validade, custo, valor_comissao_contador, valor_venda,
								valor_venda_vista);
						JOptionPane.showMessageDialog(null, "Cadastro Gravado");
						dispose();
						FrmCadastroCertificados f = new FrmCadastroCertificados();
						f.setLocationRelativeTo(null);
						f.setVisible(true);

					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,
								"NAO PASSOU PELO METODO DE INSERIR \n" + "PROBLEMA NA GRAVACAO NO BANCO");
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO CAPTURADO: \n" + e.toString());
					}

				} else {

					String descricao = txt_Descricao.getText().toUpperCase();
					if (descricao.equalsIgnoreCase("")) {
						txt_Descricao.setBackground(Color.yellow);
						return;
					} else {
						txt_Descricao.setBackground(Color.white);
					}

					int validade = 0;

					if (rb_12.isSelected()) {
						validade = 12;
					} else if (rb_24.isSelected()) {
						validade = 24;
					} else if (rb_36.isSelected()) {
						validade = 36;
					} else if (!rb_12.isSelected() && !rb_24.isSelected() && !rb_36.isSelected()) {
						rb_12.setBackground(Color.yellow);
						rb_24.setBackground(Color.yellow);
						rb_36.setBackground(Color.yellow);
						return;
					}

					if (txt_Custo.getText().equalsIgnoreCase("")) {
						txt_Custo.setBackground(Color.yellow);
						return;
					} else {
						txt_Custo.setBackground(Color.white);
					}

					if (txt_preco_venda.getText().equalsIgnoreCase("")) {
						txt_preco_venda.setBackground(Color.yellow);
						return;
					} else {
						txt_preco_venda.setBackground(Color.white);
					}

					if (txt_preco_vista.getText().equalsIgnoreCase("")) {
						txt_preco_vista.setBackground(Color.yellow);
						return;
					} else {
						txt_preco_vista.setBackground(Color.white);
					}

					if (txt_preco_comissao_contador.getText().equalsIgnoreCase("")) {
						txt_preco_comissao_contador.setBackground(Color.yellow);
						return;
					} else {
						txt_preco_comissao_contador.setBackground(Color.white);
					}

					certificadoEditar.setDescricao(txt_Descricao.getText());
					certificadoEditar.setCusto(Double.parseDouble(txt_Custo.getText()));
					certificadoEditar.setComissao(Double.parseDouble(txt_preco_comissao_contador.getText()));
					certificadoEditar.setPreco_prazo(Double.parseDouble(txt_preco_venda.getText()));
					certificadoEditar.setPreco_vista(Double.parseDouble(txt_preco_vista.getText()));
					certificadoEditar.setValidade(Integer.valueOf(validade));

					try {
						MySql.editaCertificado(certificadoEditar);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					certificadoEditar = null;
					limparCampos();

				}
			}
		});
		btnGravar.setBounds(882, 156, 177, 46);
		contentPane.add(btnGravar);

		txtCampoCusto = new JTextField();
		txtCampoCusto.setText("* Campo custo use somente valores ate 999.99 Reais");
		txtCampoCusto.setEditable(false);
		txtCampoCusto.setColumns(10);
		txtCampoCusto.setBounds(10, 182, 339, 20);
		contentPane.add(txtCampoCusto);

		txtCampoCusto_1 = new JTextField();
		txtCampoCusto_1.setText("* Campo custo operador decimal (ponto) \".\"");
		txtCampoCusto_1.setEditable(false);
		txtCampoCusto_1.setColumns(10);
		txtCampoCusto_1.setBounds(379, 182, 339, 20);
		contentPane.add(txtCampoCusto_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 1049, 275);
		contentPane.add(scrollPane);

		tabela_certificados = new JTable();
		tabela_certificados.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID",
				"DESCRI\u00C7\u00C3O", "TEMPO", "CUSTO", "VENDA PRAZO", "VENDA VISTA", "COMISSAO" }));

		DefaultTableModel minhaTabela = (DefaultTableModel) tabela_certificados.getModel();

		try {

			Connection connection = Database.getConnection();
			Statement statement = connection.createStatement();
			boolean resultado = statement.execute("select * from certificado");
			System.out.println(resultado);
			ResultSet resultSet = statement.getResultSet();
			Certificado c = new Certificado();
			while (resultSet.next()) {

				c.setId(resultSet.getInt("id"));
				c.setDescricao(resultSet.getString("descricao"));
				c.setValidade(resultSet.getInt("validade"));
				c.setCusto(resultSet.getDouble("custo"));
				c.setPreco_prazo(resultSet.getDouble("valor_venda"));
				c.setComissao(resultSet.getDouble("valor_comissao_contador"));
				c.setPreco_vista(resultSet.getDouble("valor_a_vista"));

				Object[] linha1 = { c.getId(), c.getDescricao(), c.getValidade() + " Meses", "R$ " + c.getCusto(),
						"R$ " + c.getPreco_prazo(), "R$ " + c.getPreco_vista(), "R$ " + c.getComissao(), };
				minhaTabela.addRow(linha1);

			}
			resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		tabela_certificados.getColumnModel().getColumn(0).setMaxWidth(40);
		tabela_certificados.getColumnModel().getColumn(1).setMaxWidth(250);
		tabela_certificados.getColumnModel().getColumn(2).setMaxWidth(80);
		tabela_certificados.getColumnModel().getColumn(3).setMaxWidth(70);
		tabela_certificados.getColumnModel().getColumn(4).setMaxWidth(95);
		tabela_certificados.getColumnModel().getColumn(5).setMaxWidth(95);
		tabela_certificados.getColumnModel().getColumn(6).setMaxWidth(78);

		///////
		scrollPane.setViewportView(tabela_certificados);

		JLabel lblPreoDeVenda = new JLabel("Pre\u00E7o parcelado R$");
		lblPreoDeVenda.setToolTipText("CUSTO QUE VOCE TEM COM A CERTIFICADORA QUE ESTA NA TABELA DO SEU CONTRATO");
		lblPreoDeVenda.setBounds(422, 84, 127, 14);
		contentPane.add(lblPreoDeVenda);

		JLabel lblComissoContadorR = new JLabel("Comiss\u00E3o R$");
		lblComissoContadorR.setToolTipText("CUSTO QUE VOCE TEM COM A CERTIFICADORA QUE ESTA NA TABELA DO SEU CONTRATO");
		lblComissoContadorR.setBounds(922, 84, 96, 14);
		contentPane.add(lblComissoContadorR);

		txt_preco_venda = new JTextField();
		txt_preco_venda.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();

				}

				int caracteres_maximo = 5;
				if (txt_preco_venda.getText().length() > caracteres_maximo) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Maximo setado para 999.99");

				}

			}
		});
		txt_preco_venda.setColumns(10);
		txt_preco_venda.setBounds(534, 81, 51, 20);
		contentPane.add(txt_preco_venda);

		txt_preco_comissao_contador = new JTextField();
		txt_preco_comissao_contador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();

				}

				int caracteres_maximo = 5;
				if (txt_preco_comissao_contador.getText().length() > caracteres_maximo) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Maximo setado para 999.99");

				}

			}
		});
		txt_preco_comissao_contador.setColumns(10);
		txt_preco_comissao_contador.setBounds(1008, 81, 51, 20);
		contentPane.add(txt_preco_comissao_contador);

		JLabel lblPreoVista = new JLabel("Pre\u00E7o \u00E0 vista R$");
		lblPreoVista.setToolTipText("CUSTO QUE VOCE TEM COM A CERTIFICADORA QUE ESTA NA TABELA DO SEU CONTRATO");
		lblPreoVista.setBounds(661, 84, 111, 14);
		contentPane.add(lblPreoVista);

		txt_preco_vista.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321.";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();

				}

				int caracteres_maximo = 5;
				if (txt_preco_vista.getText().length() > caracteres_maximo) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Maximo setado para 999.99");

				}

			}
		});
		txt_preco_vista.setColumns(10);
		txt_preco_vista.setBounds(758, 79, 51, 20);
		contentPane.add(txt_preco_vista);

		JButton btnNewButton = new JButton("Imprimir Tabela");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MessageFormat titulo = new MessageFormat("Listagem de Certificados\n");// Imprime um Titulo no cabeçalho
																						// da página.
				MessageFormat numeroPaginas = new MessageFormat(
						"Desenvolvido por www.mpiinformatica.com - Pagina - {0,number,integer}");// Imprime o numero de
																									// página no rodapé
																									// de cada página.

				try {
					// Imprime o coteudo da "jTable1":
					tabela_certificados.print(JTable.PrintMode.FIT_WIDTH, titulo, numeroPaginas);

				} catch (java.awt.print.PrinterException ex) {
					JOptionPane.showMessageDialog(null, "Erro de impressão: " + ex.getMessage(), "Erro de impressão",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnNewButton.setBounds(557, 499, 161, 23);
		contentPane.add(btnNewButton);

		btnEditar.setBounds(10, 499, 89, 23);
		contentPane.add(btnEditar);

		btnCancelar.setBounds(114, 499, 89, 23);
		contentPane.add(btnCancelar);

		btnExcluir.setBounds(217, 499, 89, 23);
		contentPane.add(btnExcluir);

		JLabel lblCadastroDeCertificados = new JLabel("Cadastro de certificados d\u00EDsponiveis para venda");
		lblCadastroDeCertificados.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroDeCertificados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblCadastroDeCertificados.setBounds(10, 11, 708, 20);
		contentPane.add(lblCadastroDeCertificados);

		label_mensagem.setBounds(422, 118, 647, 14);
		contentPane.add(label_mensagem);

		txt_margem.setBounds(912, 48, 40, 20);
		contentPane.add(txt_margem);
		txt_margem.setColumns(10);

		JLabel lblMargem = new JLabel("Margem");
		lblMargem.setBounds(854, 51, 72, 14);
		contentPane.add(lblMargem);

		JLabel lblMidia = new JLabel("Midia:");
		lblMidia.setBounds(10, 84, 46, 14);
		contentPane.add(lblMidia);

		comboBoxMidia.setBounds(54, 81, 358, 20);
		contentPane.add(comboBoxMidia);

		JLabel lblQtdDisponivelDa = new JLabel("Qtd Disponivel da midia selecionada:");
		lblQtdDisponivelDa.setBounds(10, 118, 225, 14);
		contentPane.add(lblQtdDisponivelDa);

		JLabel lblVl = new JLabel("VL Venda");
		lblVl.setBounds(10, 143, 89, 14);
		contentPane.add(lblVl);

		txt_quantidade_midia.setEditable(false);
		txt_quantidade_midia.setBounds(245, 115, 86, 20);
		contentPane.add(txt_quantidade_midia);
		txt_quantidade_midia.setColumns(10);

		txt_valor_venda_midia = new JTextField();
		txt_valor_venda_midia.setEditable(false);
		txt_valor_venda_midia.setBounds(94, 140, 86, 20);
		contentPane.add(txt_valor_venda_midia);
		txt_valor_venda_midia.setColumns(10);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { rb_12, rb_24, rb_36,
				label_meses, txt_Custo, btnGravar, label_Validade, label_Custo, txt_Descricao, label_Descricao }));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { txt_Descricao, rb_12, rb_24, rb_36,
				label_meses, txt_Custo, btnGravar, contentPane, label_Validade, label_Custo, label_Descricao }));

	}

	protected void limparCampos() {
		// TODO Auto-generated method stub
		dispose();
		FrmCadastroCertificados c = new FrmCadastroCertificados();
		c.setLocationRelativeTo(null);
		c.setVisible(true);
	}

	public JComboBox carregaComboBox(JComboBox comboBoxMidia) {
		try {

			comboBoxMidia.addItem("Selecione...");
			Connection conn;
			conn = Database.getConnection();// classse de conexao com banco
			Statement st = conn.createStatement();
			// ResultSet rs = st.executeQuery("SELECT midia.descricao FROM midia ORDER BY
			// descricao");
			ResultSet rs = st.executeQuery("select * from midia");

			while (rs.next()) {
				Midia m = new Midia();
				m.setDescricao(rs.getString("descricao"));
				m.setId(rs.getInt("id"));
				m.setQuantidade(rs.getInt("quantidade"));
				m.setCusto(rs.getDouble("custo"));

				// comboBoxMidia.addItem(rs.getString("descricao"));
				comboBoxMidia.addItem(m); // adiciona o objeto todo
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu erro ao carregar a Combo Box", "Erro: " + e,
					JOptionPane.ERROR_MESSAGE);
		}
		return comboBoxMidia;
	}
}
