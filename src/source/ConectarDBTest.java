package source;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;


public class ConectarDBTest {
	static ConectarDB db = new ConectarDB();
	@Test
	public void statementDB() {
		assertNotEquals(null, db.statementDB());
	}
	@Test
	public void connectionDB() {
		assertNotEquals(null, db.connectionDB());
	}
	@Test
	public void testarTabela() {
		assertNotEquals(null, db.testarTabela());
	}
	//Testa a conexão ao DB, pedindo antes as informações pelo console
	@BeforeClass
	public static void setScannerDB() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite");
		System.out.println("Localhost:");
		db.setLocalhost(sc.nextLine());
		System.out.println("Database:");
		db.setDatabase(sc.nextLine());
		System.out.println("Nome:");
		db.setNome(sc.nextLine());
		System.out.println("Senha:");
		db.setSenha(sc.nextLine());
		System.out.println("Tabela:");
		TabelaDB.setTabela(sc.nextLine());
		sc.close();
	}

}
