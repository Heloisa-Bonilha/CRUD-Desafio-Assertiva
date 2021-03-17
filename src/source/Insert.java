package source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Insert {
	ConectarDB db = new ConectarDB();
	public boolean insertSQL() throws Exception {
		Select select = new Select();
		Connection con = db.connectionDB();
        PreparedStatement stmt = null;
        //Pega colunas do DB e retira colunas AUTO INCREMENTADAS (id e data : pega data atual do sistema)
        ArrayList<String> colunas = select.selectColunas();
        colunas.remove("id");
        colunas.remove("data_cadastro");
        //Trata a String para gerar um comando SQL e adiciona os dados do JFrame
        String nomeColunas = "(";
        String values ="(";
        for(int i=0;i<colunas.size();i++) {
        	if(i+1!=colunas.size()) {
        		
        		nomeColunas += colunas.get(i)+",";
        		if(colunas.get(i).contains("senha")) {
        			values += "aes_encrypt(?,'ctt'),";
        		}
        		else {
        			values += "?,";
        		}
        		
        	}
        	else {
        		nomeColunas += colunas.get(i)+")";
        		if(colunas.get(i).contains("senha")) {
        			values += "aes_encrypt(?,'ctt'))";
        		}
        		else {
        			values += "?)";
        		}
        	}
        }
        //Monta a string para o comando SQL
        String sql = "insert into "+TabelaDB.getTabela()+" "+nomeColunas+" values "+values;
        try {
        	DadosView d = new DadosView();
            stmt = con.prepareStatement(sql);
            //Usando o prepareStatement, substituimos o ? pelo dado digitado no JFrame
            for(int i=1;i<=colunas.size();i++) {
            stmt.setString(i, d.getDados().get(i-1));
            }
            stmt.execute();
            stmt.close();
            return true;
            
        } catch (Exception e) {
        	e.printStackTrace();
        	 return false;
        }
        
	}
}
