package view;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import source.Select;

import java.awt.Color;
import javax.swing.JTable;
import java.awt.Font;

@SuppressWarnings("serial")
public class Decrypt extends JFrame {
	
	JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
    Select select = new Select();
    public Decrypt() throws SQLException {
        super ("Dados do Banco");
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(139, 0, 0));
        //Seta dado com os valores decriptografados
        source.Decrypt decrypt = new source.Decrypt();
        String[][] dado = decrypt.decrypt();
        //Seta coluna com as colunas do DB
        ArrayList<String> coluna = new ArrayList<>(select.selectColunas());
    	for(int i=0;i<coluna.size();i++) {
    		coluna.set(i, coluna.get(i).replaceAll("_", " ").toUpperCase());
    	}
    	//Seta a tabela com os dados e coluna do DB
    	tabela = new JTable(dado, coluna.toArray());
    	tabela.setFont(new Font("Tahoma", Font.BOLD, 11));
    	tabela.setBackground(new Color(139, 0, 0));
    	tabela.setForeground(new Color(255, 239, 213));
        tabela.setGridColor(new Color(0,0,0));
        tabela.setBounds(10, 11, 414, 239);
        getContentPane().add(tabela);
        
    }

    public void criaJanela() throws SQLException{
    	
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
    	
        view.Select lc = new view.Select();
        lc.criaJanela();
    }
}
