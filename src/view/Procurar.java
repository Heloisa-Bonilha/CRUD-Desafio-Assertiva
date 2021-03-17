package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Procurar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Procurar frame = new Procurar();
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
	public Procurar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PROCURAR POR:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 248, 220));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 37, 414, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 93, 414, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("NOME");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				source.Procurar.setTexto(textField.getText());
				source.Procurar.setColuna("nome");
				SelectProcurar p;
				try {
					p = new SelectProcurar();
					p.criaJanela();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(36, 153, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("LOGIN");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				source.Procurar.setTexto(textField.getText());
				source.Procurar.setColuna("login");
				SelectProcurar p;
				try {
					p = new SelectProcurar();
					p.criaJanela();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(179, 153, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("ID");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				source.Procurar.setTexto(textField.getText());
				source.Procurar.setColuna("id");
				SelectProcurar p;
				try {
					p = new SelectProcurar();
					p.criaJanela();
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(314, 153, 89, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("DATA ");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				source.Procurar.setTexto(textField.getText());
				source.Procurar.setColuna("data_cadastro");
				SelectProcurar p;
				try {
					p = new SelectProcurar();
					p.criaJanela();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(181, 208, 89, 23);
		contentPane.add(btnNewButton_4);
	}
}
