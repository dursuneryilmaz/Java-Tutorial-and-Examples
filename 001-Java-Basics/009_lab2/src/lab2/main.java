package lab2;

/*
 * lab2
 * Friend Numbers
 * 
 */
public class main {

    public static void main(String[] args) {
	    // 220-284 friend number example
    	// 30 140 not friend

        int num1=220;
        int num2 = 284;
        int sum1=0;
        int sum2=0;

        for(int i=1;i<num1;i++){
            if(num1%i==0){
                sum1 = sum1 +i;
            }
        }

        for(int i=1;i<num2;i++){
            if(num2%i==0){
                sum2 = sum2 +i;
            }
        }

        if(num1==sum2 && num2 ==sum1){
            System.out.println("Friend Number.");
        }else{
            System.out.println("Not Friend Number!");
        }
    }
}
