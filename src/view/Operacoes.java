package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.ComandosSQL;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Operacoes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operacoes frame = new Operacoes();
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
	public Operacoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ou se preferir, digite o comando:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 235, 205));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 139, 414, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("INSERIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert insert;
				try {
					//Chamar Insert
					insert = new Insert();
					insert.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(33, 61, 115, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ATUALIZAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamar classe para pedir o ID que vai atualizar
				QualId id = new QualId();
				id.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 51));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(283, 61, 121, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("DELETAR");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamar classe para pedir o ID que irá deletar
				dispose();
				Delete id = new Delete();
				id.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(new Color(0, 0, 51));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(157, 61, 115, 33);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("MOSTRAR");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Select s;
				try {
					//Chamar classe Select
					s = new Select();
					s.criaJanela();
					s.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
			
		});
		btnNewButton_1_2.setForeground(new Color(0, 0, 51));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_2.setBounds(229, 105, 115, 33);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("ENCERRAR");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Encerrar sistema
				System.exit(0);
			}
		});
		btnNewButton_1_3.setForeground(new Color(0, 0, 51));
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_3.setBounds(0, 238, 434, 23);
		contentPane.add(btnNewButton_1_3);
		
		JLabel lblQualOperaoVoc = new JLabel("QUAL OPERA\u00C7\u00C3O VOC\u00CA DESEJA REALIZAR?");
		lblQualOperaoVoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblQualOperaoVoc.setForeground(new Color(255, 235, 205));
		lblQualOperaoVoc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQualOperaoVoc.setBounds(10, 11, 414, 40);
		contentPane.add(lblQualOperaoVoc);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 177, 414, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ComandosSQL sql = new ComandosSQL();
				try {
					//Executar o comando inserido e mostrar mensagem de confirmação
					if(sql.executeComandoSQL(textField.getText())) {
						JOptionPane.showMessageDialog(null, "Comando executado!");
						textField.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "Comando inválido!");
					}
				} catch (SQLException e1) {
					//Se o comando falhar, mostrar mensagem de erro
					JOptionPane.showMessageDialog(null, "Comando inválido!");
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_2.setBounds(10, 207, 414, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1_2_1 = new JButton("PROCURAR");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Procurar p = new Procurar();
				p.setVisible(true);
			}
		});
		btnNewButton_1_2_1.setForeground(new Color(0, 0, 51));
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_2_1.setBounds(102, 105, 115, 33);
		contentPane.add(btnNewButton_1_2_1);
	}
}
