package springIntro;

public class CustomerManager implements ICustomerService {
	// Dependency injection design pattern
	private ICustomerDal customerDal;

	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	public void add() {
		// Business rules
		customerDal.add();
	}
}
