package interfaces;
/*
 * interfaces 
 * Another way to achieve abstraction in Java, is with interfaces.
 * An interface is a completely "abstract class" that is used to group related methods with empty bodies.
 * A class can implements many interface at the same time. Multiple implements allowed
 * in this scenario there are different type of workers in a company and company has different responsibility to serve them
 * OutsourceWorker from Company B, Worker from Company A, Robot from Company A are the type of workers 
 * OutsourceWorker just work in Company A and their salary and rights provided by Company B
 * Worker is a staff of Company A and their all needs provided by Company A
 * */

public class Main {

    public static void main(String[] args) {
    	// own worker can have different type of action
    	Worker worker = new Worker();
    	worker.work();
    	worker.eat();
    	worker.raise();
    	worker.shift();
    	worker.pay();
    	
    	// but outsourced worker has only working related actions
    	OutsourceWorker outsourceWorker = new OutsourceWorker();
    	outsourceWorker.work();
    	outsourceWorker.shift();
    	
    }
}
