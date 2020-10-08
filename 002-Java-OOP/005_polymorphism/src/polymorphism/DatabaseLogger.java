package polymorphism;

public class DatabaseLogger extends BaseLogger {
	// this method inherited from BaseLogger but it has written againd in different
	// way.
	// this action called method overriding
	@Override

	public void log(String message) {
		System.out.println("Logged to database : " + message);
	}
}
