package threading;
/*
 * Java is a multi-threaded programming language, Java thread priorities are in the range between(min:1-max:10)
 * threads are separated each other by their names.
 * */
public class Main {

    public static void main(String[] args) {
        StopwatchThread thread1 = new StopwatchThread("thread1");

        StopwatchThread thread2 = new StopwatchThread("thread2");

        StopwatchThread thread3 = new StopwatchThread("thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
