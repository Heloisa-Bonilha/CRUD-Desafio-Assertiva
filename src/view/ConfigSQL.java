package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.ConectarDB;
import source.TabelaDB;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ConfigSQL extends JFrame {

	private JPanel contentPane;
	private JTextField local;
	private JTextField database;
	private JTextField nome;
	private JPasswordField senha;
	private JTextField tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfigSQL frame = new ConfigSQL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConfigSQL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setForeground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conectar ao banco de dados");
		lblNewLabel.setForeground(new Color(255, 239, 213));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 13, 434, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(255, 239, 213));
		lblNewLabel_1.setBackground(new Color(255, 250, 250));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(47, 118, 101, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Localhost:");
		lblNewLabel_1_1.setForeground(new Color(255, 239, 213));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBackground(new Color(255, 250, 250));
		lblNewLabel_1_1.setBounds(47, 47, 101, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Database:");
		lblNewLabel_1_2.setForeground(new Color(255, 239, 213));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBackground(new Color(255, 250, 250));
		lblNewLabel_1_2.setBounds(47, 83, 101, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Senha:");
		lblNewLabel_1_3.setForeground(new Color(255, 239, 213));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBackground(new Color(255, 250, 250));
		lblNewLabel_1_3.setBounds(47, 152, 101, 32);
		contentPane.add(lblNewLabel_1_3);
		
		local = new JTextField();
		local.setBounds(137, 55, 236, 20);
		contentPane.add(local);
		local.setColumns(10);
		
		database = new JTextField();
		database.setBounds(137, 87, 236, 20);
		contentPane.add(database);
		database.setColumns(10);
		
		nome = new JTextField();
		nome.setBounds(137, 126, 236, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JButton conectar = new JButton("CONECTAR");
		conectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//chama metodo que realiza operação
				conectar();
			}
		});
		conectar.setFont(new Font("Tahoma", Font.BOLD, 12));
		conectar.setBounds(169, 227, 101, 23);
		contentPane.add(conectar);
		
		senha = new JPasswordField();
		senha.setBounds(137, 161, 236, 20);
		contentPane.add(senha);
		
		JLabel tabela1 = new JLabel("Tabela:");
		tabela1.setForeground(new Color(255, 239, 213));
		tabela1.setFont(new Font("Tahoma", Font.BOLD, 14));
		tabela1.setBackground(new Color(255, 250, 250));
		tabela1.setBounds(47, 187, 101, 32);
		contentPane.add(tabela1);
		
		tabela = new JTextField();
		tabela.setColumns(10);
		tabela.setBounds(137, 195, 236, 20);
		contentPane.add(tabela);
	}
	public void conectar() {
		//Setar as variáveis com os dados inseridos
		ConectarDB db = new ConectarDB();
		db.setLocalhost(local.getText());
		db.setDatabase(database.getText());
		db.setNome(nome.getText());
		db.setSenha(String.valueOf(senha.getPassword()));
		TabelaDB.setTabela(tabela.getText());
		//verificar se as informações inseridas estão corretas
		if(db.statementDB()!=null && db.testarTabela()!=null) {
			// Apresentar mensagem de confirmação e chamar Operacoes
			JOptionPane.showMessageDialog(null,"Conectado!");
			Operacoes op = new Operacoes();
			dispose();
			op.setVisible(true);
		}
		else {
			//Apresentar uma mensagem de erro na tela e zerar os campos
			JOptionPane.showMessageDialog(null,"Informações inválidas!");
			local.setText("");
			database.setText("");
			nome.setText("");
			senha.setText("");
			tabela.setText("");
		}
	}
}
