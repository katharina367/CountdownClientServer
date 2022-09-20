
public class ServerProtocol {
	private static String welcome = "Countdown 0.9 - Welcome";
	private static String from = "Countdown from ";
	private static String number = "-?\\d+";
	private static String start = "Starting Countdown from ";
	private static String bye = "Countdown finished - Bye";
	
	public static String getWelcome() {
		return welcome;
	}
	
	public static Boolean isValidFrom(String s) {
		if (s == null || !(s.matches(from + number))) return false;
		else return true;
	}
	
	public static String getStart(Integer i) {
		return start + getNumber(i);
	}
	
	public static String getNumber(Integer i) {
		return Integer.toString(i);
		
	}
	
	public static String getBye() {
		return bye;
	}
	
	public static Integer extractNumber(String s) {
		return Integer.parseInt(s.substring(s.lastIndexOf(' ') + 1));
	}
}
