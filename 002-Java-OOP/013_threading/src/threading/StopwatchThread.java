package threading;
// implementing way to thread 
public class StopwatchThread implements Runnable {

	private Thread thread;
	private String threadName;

	public StopwatchThread(String threadName) {
		this.threadName = threadName;
		System.out.println("Creating : " + threadName);
	}

	// implement a run() method provided by a Runnable interface
	@Override
	public void run() {
		System.out.println("Running : " + threadName);

		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println(threadName + " : " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException exception) {
			System.out.println("Interrupted : " + threadName);
		}

		System.out.println("Thread done : " + threadName);

	}

	public void start() {
		System.out.println("Thread instance being created.");
		if (thread == null) {
			// instantiate a Thread object
			thread = new Thread(this, threadName);
			// // start it by calling start() method, which executes a call to run( )
			// method.
			thread.start();
		}
	}

}
