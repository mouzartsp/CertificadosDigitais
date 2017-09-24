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
import controller.MySql;
import model.Midia;

@SuppressWarnings("serial")
public class FrmCadastroMidias extends JFrame {

	private JPanel contentPane;
	private JTextField txt_descricao;
	private JTextField txt_custo;
	private JTextField txt_quantidade;
	private JTable tabela_midias;
	private JButton btnEditar;
	private JLabel label_mensagem;
	private JButton btnCancelar;

	static Midia midiaEditar;
	private JButton btnExcluir;
	private JLabel lblObsNosCampos;

	public FrmCadastroMidias() {
		setResizable(false);

		label_mensagem = new JLabel("");
		label_mensagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				FrmCadastroMidias f = new FrmCadastroMidias();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnCancelar.setEnabled(false);

		setTitle("Cadastro de Midias");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 715, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_descricao = new JLabel("Descri\u00E7\u00E3o:");
		label_descricao.setBounds(10, 53, 136, 14);
		contentPane.add(label_descricao);

		JLabel lblCustoR = new JLabel("Custo R$ ");

		lblCustoR.setBounds(10, 84, 77, 14);
		contentPane.add(lblCustoR);

		JLabel lblQuantidadeInicial = new JLabel("Quantidade Inicial:");
		lblQuantidadeInicial.setBounds(182, 81, 136, 14);
		contentPane.add(lblQuantidadeInicial);

		txt_descricao = new JTextField();
		txt_descricao.setBounds(82, 50, 607, 20);
		contentPane.add(txt_descricao);
		txt_descricao.setColumns(10);

		txt_custo = new JTextField();
		txt_custo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {

				String caracteres = "0987654321.";

				if (!caracteres.contains(arg0.getKeyChar() + "")) {

					arg0.consume();

				}

				int caracteres_maximo = 5;
				if (txt_custo.getText().length() > caracteres_maximo) {
					arg0.consume();
					JOptionPane.showMessageDialog(null, "Maximo de caracteres permitido");

				}

			}
		});
		txt_custo.setBounds(82, 78, 86, 20);
		contentPane.add(txt_custo);
		txt_custo.setColumns(10);

		txt_quantidade = new JTextField();
		txt_quantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321";

				if (!caracteres.contains(e.getKeyChar() + "")) {

					e.consume();

				}

				int caracteres_maximo = 3;
				if (txt_quantidade.getText().length() > caracteres_maximo) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Maximo de caracteres permitido");

				}

			}
		});
		txt_quantidade.setBounds(298, 78, 59, 20);
		contentPane.add(txt_quantidade);
		txt_quantidade.setColumns(10);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (midiaEditar == null) {

					String descricao = txt_descricao.getText().toUpperCase();

					if (descricao.equalsIgnoreCase("")) {
						txt_descricao.setBackground(Color.yellow);
						return;
					} else {
						txt_descricao.setBackground(Color.white);
					}

					if (txt_custo.getText().equalsIgnoreCase("")) {
						txt_custo.setBackground(Color.yellow);
						return;
					} else {
						txt_custo.setBackground(Color.white);
					}
					double custo = Double.parseDouble(txt_custo.getText());

					if (txt_quantidade.getText().equalsIgnoreCase("")) {
						txt_quantidade.setBackground(Color.yellow);
						return;
					} else {
						txt_quantidade.setBackground(Color.white);
					}

					int quantidade = Integer.parseInt(txt_quantidade.getText());





					try {
						MySql.getInsereMidia(descricao, quantidade, custo);
						JOptionPane.showMessageDialog(null, "Cadastro Gravado");
						dispose();
						FrmCadastroMidias cm = new FrmCadastroMidias();
						cm.setLocationRelativeTo(null);
						cm.setVisible(true);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"NAO PASSOU PELO METODO DE INSERIR \n" + "PROBLEMA NA GRAVACAO NO BANCO");
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO CAPTURADO: \n" + e.toString());
					}

				} else { // se entrar aqui é por que tem algum objeto na variavel entao não é novo
							// cadastro e sim edição

					String descricao = txt_descricao.getText().toUpperCase();

					if (descricao.equalsIgnoreCase("")) {
						txt_descricao.setBackground(Color.yellow);
						return;
					} else {
						txt_descricao.setBackground(Color.white);
					}

					if (txt_custo.getText().equalsIgnoreCase("")) {
						txt_custo.setBackground(Color.yellow);
						return;
					} else {
						txt_custo.setBackground(Color.white);
					}
					double custo = Double.parseDouble(txt_custo.getText());

					if (txt_quantidade.getText().equalsIgnoreCase("")) {
						txt_quantidade.setBackground(Color.yellow);
						return;
					} else {
						txt_quantidade.setBackground(Color.white);
					}

					int quantidade = Integer.parseInt(txt_quantidade.getText());





					midiaEditar.setDescricao(descricao);
					midiaEditar.setCusto(custo);
					midiaEditar.setQuantidade(quantidade);

					try {
						MySql.editaMidia(midiaEditar);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					midiaEditar = null;
					limparCampos();

				}

			}
		});
		btnGravar.setBounds(10, 151, 175, 45);
		contentPane.add(btnGravar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 679, 263);
		contentPane.add(scrollPane);

		tabela_midias = new JTable();
		tabela_midias.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "DESCRI\u00C7\u00C3O", "QTD", "CUSTO"
			}
		));
		tabela_midias.getColumnModel().getColumn(0).setMaxWidth(35);
		tabela_midias.getColumnModel().getColumn(1).setMaxWidth(520);
		tabela_midias.getColumnModel().getColumn(2).setMaxWidth(45);
		tabela_midias.getColumnModel().getColumn(3).setMaxWidth(75);

		DefaultTableModel minhaTabela = (DefaultTableModel) tabela_midias.getModel();
		try {

			Connection connection = Database.getConnection();
			Statement statement = connection.createStatement();
			boolean resultado = statement.execute("select * from midia");
			if (resultado == false) {
				JOptionPane.showMessageDialog(null, "PROBLEMA NO SELECT * MIDIA");
			}
			ResultSet resultSet = statement.getResultSet();
			Midia m = new Midia();
			while (resultSet.next()) {

				m.setId(resultSet.getInt("id"));

				m.setCusto(resultSet.getDouble("custo"));
				m.setDescricao(resultSet.getString("descricao"));
				m.setQuantidade(resultSet.getInt("quantidade"));

				Object[] linha1 = { m.getId(), m.getDescricao(), m.getQuantidade(), "R$ " + m.getCusto(), };
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

		scrollPane.setViewportView(tabela_midias);

		JLabel lblEstoqueDeMdias = new JLabel("Cadastro & Estoque de M\u00EDdias");
		lblEstoqueDeMdias.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstoqueDeMdias.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblEstoqueDeMdias.setBounds(0, 11, 699, 28);
		contentPane.add(lblEstoqueDeMdias);

		JButton btnImprimir = new JButton("Imprimir Tabela");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MessageFormat titulo = new MessageFormat("Listagem de Midias / Estoque\n");// Imprime um Titulo no
																							// cabeçalho da página.
				MessageFormat numeroPaginas = new MessageFormat(
						"Desenvolvido por www.mpiinformatica.com - Pagina - {0,number,integer}");// Imprime o numero de
																									// página no rodapé
																									// de cada página.

				try {
					// Imprime o coteudo da "jTable1":
					tabela_midias.print(JTable.PrintMode.FIT_WIDTH, titulo, numeroPaginas);

				} catch (java.awt.print.PrinterException ex) {
					JOptionPane.showMessageDialog(null, "Erro de impressão: " + ex.getMessage(), "Erro de impressão",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnImprimir.setBounds(545, 481, 144, 23);
		contentPane.add(btnImprimir);

		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabela_midias.getModel();

				int index = tabela_midias.getSelectedRow();

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma midia para ser editada !");
					limparCampos();
					return;
				}

				int cod = (int) model.getValueAt(index, 0);

				Midia m = new Midia();

				try {
					m = MySql.buscaMidia(cod);

					int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja editar a midia :\n"
							+ "Codigo: " + m.getId() + "\n " + "Descrição: " + m.getDescricao());
					if (opc == 0) { // opcao 0 = sim

						btnGravar.setText("Salvar Alteracoes");
						label_mensagem.setForeground(Color.red);
						label_mensagem.setText("Editando ID: " + m.getId() + " Descrição antiga: " + m.getDescricao());
						btnEditar.setEnabled(false);
						btnImprimir.setEnabled(false);
						btnCancelar.setEnabled(true);

						txt_descricao.setText(m.getDescricao());
						txt_custo.setText(String.valueOf(m.getCusto()));
						txt_quantidade.setText(m.getQuantidade() + "");

						midiaEditar = m;

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
		btnEditar.setBounds(405, 173, 89, 23);
		contentPane.add(btnEditar);

		label_mensagem.setBounds(206, 142, 483, 27);
		contentPane.add(label_mensagem);

		btnCancelar.setBounds(504, 173, 89, 23);
		contentPane.add(btnCancelar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) tabela_midias.getModel();

				int index = tabela_midias.getSelectedRow();

				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Selecione uma midia a ser excluida!");
					limparCampos();
					return;
				}

				int cod = (int) model.getValueAt(index, 0);

				Midia m = new Midia();

				try {

					m = MySql.buscaMidia(cod);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				int opc = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a midia:\n" + "Codigo: "
						+ m.getId() + "\n " + "Nome: " + m.getDescricao());
				if (opc == 0) {
					try {
						MySql.removeMidia(m);
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
		btnExcluir.setBounds(600, 173, 89, 23);
		contentPane.add(btnExcluir);

		lblObsNosCampos = new JLabel(
				"Obs: Nos campos de valores R$ n\u00E3o use mais de um \".\" ponto para evitar erros.");
		lblObsNosCampos.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblObsNosCampos.setBounds(234, 117, 455, 14);
		contentPane.add(lblObsNosCampos);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { txt_descricao, txt_custo,
				txt_quantidade, btnGravar, label_descricao, lblCustoR, lblQuantidadeInicial }));
	}

	protected void limparCampos() {
		// TODO Auto-generated method stub
		dispose();
		FrmCadastroMidias f = new FrmCadastroMidias();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
