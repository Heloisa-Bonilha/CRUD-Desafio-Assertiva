package view;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.ComandosSQL;
import source.DadosView;
import source.Formatacoes;
import source.Select;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Insert extends JFrame {
	Formatacoes f = new Formatacoes();
	private JPanel contentPane;
	private JTextField textField;
	public int i=0;
	ComandosSQL sql = new ComandosSQL();
	private JLabel lblNewLabel = new JLabel();
	private ArrayList<String> colunas = new ArrayList<>();
	private JPasswordField passwordField;
	DadosView d = new DadosView();
	source.Insert insert = new source.Insert();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Insert() throws SQLException {
		//Chama função para inicializar a operação
		inicializaInsertString();
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(22, 129, 386, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Digite as informa\u00E7\u00F5es");
		lblNewLabel_1.setForeground(new Color(255, 250, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(22, 11, 386, 39);
		contentPane.add(lblNewLabel_1);
		
		
		lblNewLabel.setForeground(new Color(255, 248, 220));
		lblNewLabel.setBackground(new Color(255, 248, 220));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setText(colunas.get(i).toUpperCase().replaceAll("_", " "));
		lblNewLabel.setBounds(22, 87, 390, 39);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(22, 138, 386, 20);
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chama metodo para formar a String Insert SQL
				insertString();
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(165, 207, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
	}
	
	public void inicializaInsertString() throws SQLException {
		//Inicializa Variaveis
		Select select = new Select();
		d.setDadosZero();
		colunas.addAll(select.selectColunas());
		colunas.remove("id");
		colunas.remove("data_cadastro");
	}
	public void insertString() {
		if(colunas.get(i).contains("senha")) {
			//Verifica se o tamanho digitado é menor que 32 (tamanho DB)
			if(String.valueOf(passwordField.getPassword()).length()<=32) {
			d.setDadosInsert(String.valueOf(passwordField.getPassword()));
			}
			else {
				//Se for maior que 32, corta a String.
				JOptionPane.showMessageDialog(null, "Texto excedido no tamanho!\nFoi feito uma redução do texto!");
				d.setDadosInsert(String.valueOf(passwordField.getPassword()).substring(0,31));
			}
			//Zera a variavel
			passwordField.setText("");
		}
		else {
			//Verifica se o tamanho digitado é menor que 254 (tamanho DB)
			if(textField.getText().length()<=254) {
				d.setDadosInsert(textField.getText());
			}
			else {
				//Se for maior que 254, corta a String.
				JOptionPane.showMessageDialog(null, "Texto excedido no tamanho!\nFoi feito uma redução do texto!");
				d.setDadosInsert(textField.getText().substring(0, 253));
			}
			//Zera a variavel
			textField.setText("");
		}
		if(i<colunas.size()-1) {
			i++;
			//Seta o Label com o nome da Coluna do DB
			lblNewLabel.setText(colunas.get(i).toUpperCase());
			if(colunas.get(i).contains("senha")) {
				//Se for a coluna de senha, disabilita o campo de texto e habilita o campo Password
				textField.setVisible(false);
				passwordField.setVisible(true);
				passwordField.setText("");
				contentPane.add(passwordField);
			}
		}
		else {
			try {
				//Executa operação de Insert e volta para a tela de Operação
				insert.insertSQL();
				dispose();
				Operacoes op = new Operacoes();
				op.setVisible(true);
			} catch (Exception e1) {
				//Mostra mensagem de erro
				JOptionPane.showMessageDialog(null, "Entrada inválida!");
				dispose();
				e1.printStackTrace();
			}
		}
	}
	
	
}
