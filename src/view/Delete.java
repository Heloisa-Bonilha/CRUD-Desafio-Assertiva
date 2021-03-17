package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import source.Id;
import source.Select;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QualId frame = new QualId();
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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUAL ID VOC\u00CA DESEJA FAZER A OPERA\u00C7\u00C3O?");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 248, 220));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 47, 414, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 119, 414, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("MOSTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.Select s;
				try {
					//Chama tela Select
					s = new view.Select();
					s.criaJanela();
					s.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(0, 238, 434, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//chama metodo
				delete();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(177, 159, 75, 23);
		contentPane.add(btnNewButton_1);
	}
	public void delete() {
		
		try {
			Select select = new Select();
			source.Delete del = new source.Delete();
			Id ids = new Id();
			int id = Integer.parseInt(textField.getText());
			//Pega todos os ids existentes no DB
			ArrayList<Integer> idExiste = select.selectId();
			//Verifica se o id digitado existe no DB
			if(idExiste.contains(id)) {
				//Executa operação de delete e mostra mensagem
				ids.setId(id);
				del.deleteSQL();
				dispose();
				JOptionPane.showMessageDialog(null, "Dados Deletados!");
				Operacoes op = new Operacoes();
				op.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "ID inválido!");
			}
		} catch (SQLException e1) {
			//Mostra mensagem de erro
			JOptionPane.showMessageDialog(null, "ID inválido!");
			e1.printStackTrace();
		}
		catch(NumberFormatException e2) {
			//Exception do parseInt, se o que digitou no campo não for um numero inteiro
			JOptionPane.showMessageDialog(null, "ID inválido!");
			e2.printStackTrace();
		}
	}
}
