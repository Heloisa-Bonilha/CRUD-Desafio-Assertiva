package source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Update {
	ConectarDB db = new ConectarDB();
	public boolean updateSQL() throws Exception {
		Select select = new Select();
		Connection con = db.connectionDB();
        PreparedStatement stmt = null;
        String dado="";
        //Pega as colunas do DB e trata para retirar os dados AUTO INCREMENTE
        ArrayList<String> colunas = select.selectColunas();
        colunas.remove("id");
        colunas.remove("data_cadastro");
        //Monta string dado com as colunas e ? do prparedStatement
        for(int i=0;i<colunas.size();i++) {
        	if(i+1!=colunas.size()) {
        		
        		dado += colunas.get(i)+"=";
        		if(colunas.get(i).contains("senha")) {
        			dado += "aes_encrypt(?,'ctt'),";
        		}
        		else {
        			dado += "?,";
        		}
        		
        	}
        	else {
        		dado += colunas.get(i)+"=";
        		if(colunas.get(i).contains("senha")) {
        			dado += "aes_encrypt(?,'ctt')";
        		}
        		else {
        			dado += "?";
        		}
        	}
        }
        //Monta string para comando sql
        String sql = "UPDATE "+TabelaDB.getTabela()+" SET "+dado+" WHERE id = "+Id.getId();
        try {
        	DadosView d = new DadosView();
            stmt = con.prepareStatement(sql);
            for(int i=1;i<=colunas.size();i++) {
            	//Usando o preparedStatement, substituimos o ? pelo dados inseridos no JFrame
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
