package springIntro;

public class MsSqlCustomerDal implements ICustomerDal {
	String connectionString;

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	@Override
	public void add() {
		System.out.println("MsSql connection string-> " + connectionString);
		System.out.println("MsSql Database Added!");
	}
}
