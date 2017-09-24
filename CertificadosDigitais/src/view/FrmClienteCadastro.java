package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmClienteCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	public FrmClienteCadastro() {
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPica = new JLabel("Nome:");
		lblPica.setBounds(10, 11, 86, 14);
		contentPane.add(lblPica);
		
		textField = new JTextField();
		textField.setBounds(106, 8, 318, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone 1:");
		lblTelefone.setBounds(10, 40, 86, 14);
		contentPane.add(lblTelefone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 37, 114, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTelefone_1 = new JLabel("Telefone 2:");
		lblTelefone_1.setBounds(223, 40, 79, 14);
		contentPane.add(lblTelefone_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(312, 37, 112, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 68, 46, 14);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(106, 65, 318, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 93, 46, 14);
		contentPane.add(lblCpf);
		
		textField_4 = new JTextField();
		textField_4.setBounds(106, 90, 318, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 118, 46, 14);
		contentPane.add(lblCidade);
		
		textField_5 = new JTextField();
		textField_5.setBounds(106, 115, 318, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 143, 46, 14);
		contentPane.add(lblEstado);
		
		textField_6 = new JTextField();
		textField_6.setBounds(106, 140, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(202, 143, 46, 14);
		contentPane.add(lblCep);
		
		textField_7 = new JTextField();
		textField_7.setBounds(234, 140, 190, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 168, 86, 14);
		contentPane.add(lblLogradouro);
		
		textField_8 = new JTextField();
		textField_8.setBounds(106, 165, 318, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(10, 193, 86, 14);
		contentPane.add(lblNumero);
		
		textField_9 = new JTextField();
		textField_9.setBounds(106, 190, 103, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(223, 196, 66, 14);
		contentPane.add(lblBairro);
		
		textField_10 = new JTextField();
		textField_10.setBounds(304, 190, 120, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 218, 94, 14);
		contentPane.add(lblComplemento);
		
		textField_11 = new JTextField();
		textField_11.setBounds(106, 215, 153, 20);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Fazer algo aqui !");
			}
		});
		btnGravar.setBounds(335, 227, 89, 23);
		contentPane.add(btnGravar);
	}
}
