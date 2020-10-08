package stringManupilation;

/*
 * String Manipulation
 * There are many manipulation for strings and some of them can be found below
 * */
public class main {

	public static void main(String[] args) {
		// create a base string and print it
		String baseMsg = "To day is sunny day.";
        System.out.println("Base String : "+baseMsg);
        
        // every char is an element of a string blank is included
        // getting the number of elements in string or find length of string
        System.out.println("Number of Chars (Elements): " + baseMsg.length());
        // string elements can be accessible using index, 5th element means element in 4th index because indexing starts from 0
        System.out.println("5th Element : " + baseMsg.charAt(4));
        // a string can be append another string
        System.out.println("Concatenated String: "+baseMsg.concat(" Yuppi!"));
        // string starting char can be checked if given char is the starting char returns true
        System.out.println("Starting Char Check: "+baseMsg.startsWith("T"));
        // same as the starting char but for ending char
        System.out.println("Ending Char Check: "+baseMsg.endsWith("."));

        // strings can be reconstructed to char array, array size and splitted string size should be equal.
        char[] msgChars = new char[6];
        baseMsg.getChars(0,6,msgChars,0);
        System.out.print("Char array: ");
        System.out.println(msgChars);
        // a char or char group first seen and last seen index 
        System.out.println("Given word 'is's first seen at index: "+ baseMsg.indexOf("is"));
        System.out.println("Given word 'day's last seen at index: "+ baseMsg.lastIndexOf("day"));
        // every char in a string can be replaced any char
        String newMsg = baseMsg.replace(' ','-');
        System.out.println("' ' replaced with '-': "+newMsg);
        // strings can be split substrings
        System.out.println("Substring in given range: "+baseMsg.substring(3,6));
        // every word can be accessed which splitted by knowing delimiter
        System.out.println("\nBase String Words");
        for (String word : baseMsg.split(" ")){
            System.out.println("-"+word);
        }
        // upper case, lower case, trim
        System.out.println("Lower Cased: "+baseMsg.toLowerCase());
        System.out.println("Upper Cased: "+baseMsg.toUpperCase());
        System.out.println("Trimmed: "+baseMsg.trim());

	}

}
