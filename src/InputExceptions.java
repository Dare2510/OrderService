import java.util.Scanner;

public class InputExceptions extends Exception{

	public InputExceptions(String message) {
		super(message);
	}
}

class InputReader{
	private static final Scanner scanner = new Scanner(System.in);

	public static int readInt(String message){
		System.out.println(message);
		return scanner.nextInt();

	}

	public static String readString(String message){
		System.out.println(message);
		return scanner.next();

	}

	public static double readDouble(String message){
		System.out.println(message);
		return scanner.nextDouble();

	}

}
