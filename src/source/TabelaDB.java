package source;

public class TabelaDB {
	private static String nomeTabela="tabela_login";
	
	public static void setTabela(String tabela) {
		TabelaDB.nomeTabela = tabela;
	}
	public static String getTabela() {
		return nomeTabela;
	}
}
