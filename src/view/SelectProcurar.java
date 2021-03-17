package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JTable;

import source.TabelaDB;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SelectProcurar extends JFrame {
	
	JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
    source.Procurar procurar = new source.Procurar();
    source.Select select = new source.Select();
    public SelectProcurar() throws SQLException {

		
		
        super ("Dados do Banco");
        setType(Type.POPUP);
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(139, 0, 0));
        //Pega os dados do banco
    	String[][] dados = procurar.procurar();
    	//Pega as colunas do banco
    	ArrayList<String> colunas = new ArrayList<>(select.selectColunas());
    	for(int i=0;i<colunas.size();i++) {
    		colunas.set(i, colunas.get(i).replaceAll("_", " ").toUpperCase());
    	}
    	//Seta a tabela com os dados e colunas do banco
    	tabela = new JTable(dados, colunas.toArray());
    	tabela.setFont(new Font("Tahoma", Font.BOLD, 11));
    	tabela.setBackground(new Color(139, 0, 0));
    	tabela.setForeground(new Color(255, 239, 213));
        tabela.setGridColor(new Color(0,0,0));
        tabela.setBounds(10, 11, 414, 239);
        getContentPane().add(tabela);
        
        JButton btnNewButton = new JButton("DESCRIPTOGRAFAR");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//chama tela que verifica a chave de criptografia
        		try {
					source.Decrypt.setColumn();
					source.Decrypt.setStringSQL("SELECT "+source.Decrypt.getColumn()+" FROM "+TabelaDB.getTabela()+" WHERE "+source.Procurar.getColuna()+" like '%"+source.Procurar.getTexto()+"%'");
	        		dispose();
	        		CryptKey key = new  CryptKey();
	        		key.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        getContentPane().add(btnNewButton, BorderLayout.SOUTH);
    }

    public void criaJanela() throws SQLException{
    	
    	//Cria uma janela para a tabela com os dados
    	setBounds(400, 100, 450, 300);
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 2));
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);
  
        getContentPane().add(painelFundo);
        setSize(600, 300);
        setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select lc = new Select();
					lc.setVisible(true);
			        lc.criaJanela();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
}
