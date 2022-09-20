
public class ClientProtocol {
	private static String welcome = "Countdown 0.9 - Welcome";
	private static String from = "Countdown from ";
	private static String start = "Starting Countdown from ";
	private static String bye = "Countdown finished - Bye";

	
	public static String getFrom(int i) {
		return from + i;
	}
	
	public static String getStart(int i) {
		return start + i;
	}
	
	public static boolean isValidWelcome(String s) {
		return s.matches(welcome);
	}
	
	public static boolean isValidStart (String s, int i) {
		return s.matches(start + i);
	}
	
	public static boolean isNumber(String s) {
		return s.matches("-?\\d+");
	}
	
	public static boolean isValidBye(String s) {
		return s.matches(bye);
	}
}


