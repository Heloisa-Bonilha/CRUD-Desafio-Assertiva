package source;

public class Id {
	private static int id;
	public void setId(int id) {
		Id.id = id;
	}
	public static int getId() {
		return id;
	}
}
