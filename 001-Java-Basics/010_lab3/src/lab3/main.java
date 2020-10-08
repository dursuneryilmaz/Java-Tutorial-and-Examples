package lab3;

/*
 * lab3
 * prime numbers
 * 
 */
public class main {

    public static void main(String[] args) {
        //bug
        int number = -2;
        int remainder = number % 2;
        //System.out.println(remainder);
        boolean isPrime = true;

        if(number==1){
            System.out.println("Not Prime!");
            return;
        }

        if(number<1){
            System.out.println("Invalid Number");
            System.exit(remainder);
        }

        for (int i=2; i<number;i++){
            if(number % i == 0){
                isPrime = false;
            }
        }

        if(isPrime){
            System.out.println("Prime.");
        }else{
            System.out.println("Not Prime!");
        }

    }
}
