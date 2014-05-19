package berlin.clock;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) {
		Console console = System.console();
		String s = console.readLine("Enter a time (hh:mm:ss) or press enter.");
		BerlinClock bc = new BerlinClock();
		if("".equals(s)) {
			bc = BerlinClockBuilder.build(sdf.format(new Date()));
		} else {
			bc = BerlinClockBuilder.build(s);
		}
		BerlinClockBuilder.print(bc, "\n");
	}

}
