package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.Criptografia;
import source.Select;
import source.Update;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class NovaSenha extends JFrame {
	private JPanel contentPane;
	private JPasswordField passwordField;
	Select select = new Select();
	source.Update up = new Update();
	Criptografia crypt = new Criptografia();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaSenha frame = new NovaSenha();
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
	public NovaSenha() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("DIGITE SUA SENHA ANTIGA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 238));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 62, 414, 26);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(10, 113, 414, 31);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chama metodo que verifica a senha
				verificaSenha();
			}
		});
		btnNewButton.setBounds(170, 196, 89, 23);
		contentPane.add(btnNewButton);
	}
	public void verificaSenha() {
		//Seta variavel com a senha inserida
		String senha = String.valueOf(passwordField.getPassword());
		try {
			//pega a senha atual direto do DB, antes de atualizar
			String atual=select.conteudoBanco("aes_decrypt(senha,'"+crypt.getCriptografia()+"')");
			//Verifica senhas
			if(atual.equals(senha)) {
				dispose();
				try {
					//Executa operação de Update, mostra mensagem e chama tela Operacoes
					up.updateSQL();
					JOptionPane.showMessageDialog(null, "Banco de Dados alterado!");
					Operacoes op = new Operacoes();
					op.setVisible(true);
				} catch (Exception e1) {
					//Mostra mensagem de erro
					JOptionPane.showMessageDialog(null, "Entrada Inválida!");
					e1.printStackTrace();
				}
				
			}
			else {
				//Mostra mensagem de erro
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		} catch (SQLException e1) {
			//Mostra mensagem de erro
			JOptionPane.showMessageDialog(null, "Senha incorreta!");
			e1.printStackTrace();
		}
	}

}
