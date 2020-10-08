package primitiveDataTypes;
/*
 * primitive data types
 * 
 * */
public class main {

	public static void main(String[] args) {
		// boolean type can get two state true or false and use 1 byte memory
		boolean isActive = false;
		
		// char type can get single unicode character false and use 2 bytes memory
		char oneLetter = 'D';
		
		// byte type can get integers in range -128 to +127  and use 1 byte memory
		byte numberOfMounths = 12;
		
		// short type can get integers in range -32768 to +32767, and use 2 bytes memory
		short totalWorkDayPerDecade = 3560;
		
		// int type can get integers in range -2147483648 to +2147483647, and use 4 bytes memory
		int rowNumber = 2147479999;
		
		// boolean type can get integers in range -9223372036854775808 and +9223372036854775807, and use 8 bytes memory
		// L has used to declare number type is long otherwise accepts as int
		long streamView = 9223372036854775807L;
		
		// float type can get floating point number in range -3.40282347*10^38 to -1.40239846*10^-45, and use 4 bytes memory
		// F has used to declare number type is float otherwise accepts as double
		float winRate = 0.88F;
		
		// float type can get floating point number in range (-)(+) ~1.7*10^308 to (-)(+) ~4.9*10^-324, and use 4 bytes memory
		double percentage = 2.45;
		
		// printing variables to the console with explanations
		System.out.println("Status: "+ isActive);
		System.out.println("My First Letter: "+ oneLetter);
		System.out.println("Number of mounths: "+ numberOfMounths);
		System.out.println("Total work day per decade: "+ totalWorkDayPerDecade);
		System.out.println("Row number: "+ isActive);
		System.out.println("Total number of stream viewers: "+ streamView);
		System.out.println("Win rate: "+ winRate);
		System.out.println("Percentage: "+ percentage);

	}

}
