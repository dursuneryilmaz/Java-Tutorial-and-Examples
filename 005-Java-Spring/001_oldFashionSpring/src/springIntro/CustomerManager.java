package springIntro;

public class CustomerManager implements ICustomerService {
/*
    // Dependency injection design pattern
	private ICustomerDal customerDal;

	public ICustomerDal getCustomerDal() {
		return customerDal;
	}
*/
	
	// Setter injection
	private ICustomerDal customerDal;
	public void setCustomerDal(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}

	public void add() {
		// Business rules
		customerDal.add();
	}
}
