package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.MySql;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FrmLancaCertificacao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtData;
	private JTextField textField_4;

	public FrmLancaCertificacao() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 868, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSolicitacaoN = new JLabel("Solicitacao N\u00BA");
		lblSolicitacaoN.setBounds(10, 28, 90, 14);
		contentPane.add(lblSolicitacaoN);
		
		textField = new JTextField();
		textField.setBounds(90, 25, 168, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCertificado = new JLabel("Certificado");
		lblCertificado.setBounds(289, 28, 77, 14);
		contentPane.add(lblCertificado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(376, 25, 466, 20);
		contentPane.add(comboBox);
		
		JLabel lblMidia = new JLabel("Midia");
		lblMidia.setBounds(289, 59, 46, 14);
		contentPane.add(lblMidia);
		
		JLabel lblDescontoR = new JLabel("Desconto R$ ");
		lblDescontoR.setBounds(630, 412, 96, 14);
		contentPane.add(lblDescontoR);
		
		textField_1 = new JTextField();
		textField_1.setBounds(727, 409, 115, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPuk = new JLabel("PUK");
		lblPuk.setBounds(10, 136, 46, 14);
		contentPane.add(lblPuk);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 133, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPin = new JLabel("PIN");
		lblPin.setBounds(212, 136, 46, 14);
		contentPane.add(lblPin);
		
		textField_3 = new JTextField();
		textField_3.setBounds(257, 133, 109, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblResponsavelLegal = new JLabel("Responsavel Legal");
		lblResponsavelLegal.setBounds(10, 202, 109, 14);
		contentPane.add(lblResponsavelLegal);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(135, 199, 613, 20);
		contentPane.add(comboBox_2);
		
		JLabel lblIndicadoPor = new JLabel("Indicado por");
		lblIndicadoPor.setBounds(10, 237, 90, 14);
		contentPane.add(lblIndicadoPor);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(135, 234, 613, 20);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 278, 17, 14);
		contentPane.add(lblNewLabel);
		
		txtData = new JTextField();
		txtData.setBounds(193, 78, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar data no BD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					MySql.gravaData(convDataParaFormatoSql(txtData.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnNewButton.setBounds(127, 98, 152, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("pega data atual");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dataa = dataAtualEmString();
				txtData.setText(dataa);
				
			}
		});
		btnNewButton_1.setBounds(149, 56, 130, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblDigiteNoFormato = new JLabel("Digite no formato dd/mm/yyyy >>>");
		lblDigiteNoFormato.setBounds(2, 81, 181, 14);
		contentPane.add(lblDigiteNoFormato);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(376, 53, 466, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}
	

	public String convDataParaFormatoSql (String dataSistema) {
	    java.util.Date dataFormatada;
	    String dataBanco = "";//variavel que vai receber a data para o banco
	    try {//Conversão da data do sistema para formato da data do Banco
	        dataFormatada = new SimpleDateFormat("dd/MM/yyyy").parse(dataSistema);
	        dataBanco = new SimpleDateFormat("yyyy-MM-dd").format(dataFormatada);
	    } catch (ParseException ex) {
	    }
	    return dataBanco;
	    
	}
	
	private String dataAtualEmString() {
		Date dataHoje = new Date(); //cria um date com a data do dia
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		String dataa = formataData.format(dataHoje);
		return dataa;
	}
}
