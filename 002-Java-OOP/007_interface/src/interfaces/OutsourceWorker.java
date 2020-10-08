package interfaces;

// Company B's staff who works in Company A as a OutsourceWorker
public class OutsourceWorker implements IWorkable {
	@Override
	public void work() {
		System.out.println("Outsoruced Worked.");
	}

	@Override
	public void shift() {
		System.out.println("OutSourced in Shift.");
	}
}
