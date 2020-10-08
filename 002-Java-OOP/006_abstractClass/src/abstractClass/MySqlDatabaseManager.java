package abstractClass;
// a class can extends only an abstract class. there is no multiplicity
public class MySqlDatabaseManager extends BaseDatabaseManager{
    @Override
    public void getData() {
        System.out.println("Data Fetched: My sql");
    }
}
