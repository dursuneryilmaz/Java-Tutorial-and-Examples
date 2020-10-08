package interfaces;

// Company A's staff
public class Worker implements IWorkable, IEatable, IPayable {
	@Override
	public void work() {
		System.out.println("Worker worked.");
	}

	@Override
	public void eat() {
		System.out.println("Worker ear.");
	}

	@Override
	public void pay() {
		System.out.println("Worker paid.");
	}

	@Override
	public void raise() {
		System.out.println("Worker salary raised.");
	}

	@Override
	public void shift() {
		System.out.println("Worker in shift.");
	}
}
