package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmCadastroEmpresas extends JFrame {

	private JPanel contentPane;
	private JTextField txt_nome_fantasia;
	private JTextField txt_razao_social;
	private JTextField txt_cnpj;
	private JTextField txt_telefones;
	private JTextField txt_email;
	private JTextField txt_site;

	public FrmCadastroEmpresas() {
		setTitle("Cadastro de Empresas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Fantasia:");
		lblNewLabel.setBounds(10, 11, 131, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setBounds(10, 34, 131, 14);
		contentPane.add(lblRazoSocial);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 61, 131, 14);
		contentPane.add(lblCnpj);
		
		JLabel lblTelefones = new JLabel("Telefones:");
		lblTelefones.setBounds(10, 86, 131, 14);
		contentPane.add(lblTelefones);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 113, 131, 14);
		contentPane.add(lblEmail);
		
		JLabel lblSite = new JLabel("Site:");
		lblSite.setBounds(10, 140, 131, 14);
		contentPane.add(lblSite);
		
		JLabel lblRespLegalNa = new JLabel("Resp. Legal na RF 1:");
		lblRespLegalNa.setBounds(10, 169, 131, 14);
		contentPane.add(lblRespLegalNa);
		
		JLabel lblRespLegalNa_1 = new JLabel("Resp. Legal na RF 2:");
		lblRespLegalNa_1.setBounds(10, 198, 131, 14);
		contentPane.add(lblRespLegalNa_1);
		
		JComboBox combo_responsavel_1 = new JComboBox();
		combo_responsavel_1.setBounds(165, 166, 259, 20);
		contentPane.add(combo_responsavel_1);
		
		JComboBox combo_responsavel_2 = new JComboBox();
		combo_responsavel_2.setBounds(165, 195, 259, 20);
		contentPane.add(combo_responsavel_2);
		
		txt_nome_fantasia = new JTextField();
		txt_nome_fantasia.setBounds(165, 8, 259, 20);
		contentPane.add(txt_nome_fantasia);
		txt_nome_fantasia.setColumns(10);
		
		txt_razao_social = new JTextField();
		txt_razao_social.setColumns(10);
		txt_razao_social.setBounds(165, 31, 259, 20);
		contentPane.add(txt_razao_social);
		
		txt_cnpj = new JTextField();
		txt_cnpj.setColumns(10);
		txt_cnpj.setBounds(165, 58, 259, 20);
		contentPane.add(txt_cnpj);
		
		txt_telefones = new JTextField();
		txt_telefones.setColumns(10);
		txt_telefones.setBounds(165, 83, 259, 20);
		contentPane.add(txt_telefones);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(165, 110, 259, 20);
		contentPane.add(txt_email);
		
		txt_site = new JTextField();
		txt_site.setColumns(10);
		txt_site.setBounds(165, 137, 259, 20);
		contentPane.add(txt_site);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnGravar.setBounds(335, 265, 89, 23);
		contentPane.add(btnGravar);
	}
}
