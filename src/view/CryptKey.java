package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.Criptografia;

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
public class CryptKey extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	Criptografia crypt = new Criptografia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CryptKey frame = new CryptKey();
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
	public CryptKey() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DIGITE A CHAVE DE CRIPTOGRA\u00C7\u00C3O");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 248, 220));
		lblNewLabel.setBounds(10, 59, 414, 30);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(10, 126, 414, 41);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Seta variavel
				String key = String.valueOf(passwordField.getPassword());
				//Verifica chave de criptografia
				if(key.equals(crypt.getCriptografia())) {
					dispose();
	        		Decrypt d;
					try {
						//chama classe para descriptografar
						d = new Decrypt();
						d.criaJanela();
						d.setVisible(true);
					} catch (SQLException e1) {
						//Mostra mensagem de erro
						JOptionPane.showMessageDialog(null, "Chave inválida!");
						e1.printStackTrace();
					}
				}
				else {
					//Mostra mensagem de erro
					JOptionPane.showMessageDialog(null, "Chave inválida!");
					passwordField.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(165, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
