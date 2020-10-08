package innerClass;
/*
 * this class is in different package named innerClass 
 * when using a class or method from another package that package should be imported see statics/Main class
 * 
 * */

public class DatabaseHelper {
	public static class Crud { // Create read update delete
		public static void Delete() {
			System.out.println("item deleted!");
		}

		public static void Update() {
			System.out.println("item updated!");
		}
	}

	public static class Connection {
		public static void createConnection() {
			System.out.println("Connection opened!");
		}
	}
}
