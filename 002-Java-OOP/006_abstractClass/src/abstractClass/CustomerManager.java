package abstractClass;

public class CustomerManager {
	//kind of stategy design pattern
    BaseDatabaseManager databaseManager;

    public void getCustomers(){
        databaseManager.getData();
    }
}
