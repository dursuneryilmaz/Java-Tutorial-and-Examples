package lab5;

/*
 * lab5
 * bold/thin vowel letter
 * 
 */
public class main {

    public static void main(String[] args) {
        char harf = 'I';

        switch (harf) {
            case 'A':
            case 'I':
            case 'O':
            case 'U':
                System.out.println("Bold Vowel");
                break;
            default:
                System.out.println("Thin Vowel");
        }
    }
}
