package springIntro;

public class OracleCustomerDal implements ICustomerDal{

	@Override
	public void add() {
		System.out.println("Oracle Database Added!");
		
	}

}
