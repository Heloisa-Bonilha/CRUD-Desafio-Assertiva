package source;

import java.util.ArrayList;

public class DadosView {
	private static ArrayList<String> dados = new ArrayList<String>();
	//Método que guarda os dados que foram inseridos no JFrame
	public ArrayList<String> setDadosInsert(String dado) {
		dados.add(dado);
		return dados;
	}
	//Método que zera a variavel dados
	public ArrayList<String> setDadosZero() {
		dados = new ArrayList<>();
		return dados;
	}
	public ArrayList<String> getDados(){
		return dados;
	}
}
