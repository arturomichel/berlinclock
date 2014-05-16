package berlin.clock;

import berlin.clock.BerlinHeuer;

public class BerlinHeuerProvider {

	private static String YELLOW = "Y";
	private static String RED = "R";
	private static String OFF = "O";

	public static void main(String[] args) {		
		
		print(toBerlinString("23:59:59"));

	}

	public static BerlinHeuer toBerlinString(final String HHMMSS){
		Integer[] hhmmss = parse(HHMMSS);
		StringBuilder sb = new StringBuilder();

		if(hhmmss[2] != null) {
			sb.append(toBerlinString(getSeconds(hhmmss[2]),1));
			sb.append(" ");
		} else {
			sb.append("- ");
		}

		if(hhmmss[0] != null){
			sb.append(toBerlinString(getUpperRow(hhmmss[0]),4));
			sb.append(" ");
			sb.append(toBerlinString(getLowerRow(hhmmss[0]),4));
			sb.append(" ");
		} else {
			sb.append("- ");
		}

		if(hhmmss[1] != null){
			sb.append(toBerlinString(getUpperRow(hhmmss[1]),11));
			sb.append(" ");
			sb.append(toBerlinString(getLowerRow(hhmmss[1]),4));
		} else {
			sb.append("-");
		}

		return new BerlinHeuer(HHMMSS, sb.toString());
	}

	private static String toBerlinString(final int on, final int total){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < total; i++){
			if(i < on)
				sb.append(RED);
			else
				sb.append(OFF);
		}
		return sb.toString();
	}

	private static int getUpperRow(final int value){
		return value/5;
	}

	private static int getLowerRow(final int value){
		return  value - ((value/5) * 5);
	}

	private static int getSeconds(final int seconds){
		//is even/odd. negate.
		return (seconds % 2) ^ 1;
	}

	private static Integer[] parse(final String hhmmss){

		Integer[] iHHMMSS = new Integer[3];
		// restricts format, digits and some values
		if(hhmmss.matches("([0-2][0-9]):([0-5][0-9]):([0-5][0-9])")) {

			String[] HHMMSS = hhmmss.split(":");

			for(int i = 0; i < 3; i++){
				int part = Integer.parseInt(HHMMSS[i]);

				// Hours 00 - 24
				if(i == 0 && part >= 0 && part <= 24)
					iHHMMSS[i] = part;

				// Minutes && secs 00 - 59
				if(i > 0 && part >= 0 && part <= 59)
					iHHMMSS[i] = part;
			}
		} 
		return iHHMMSS;
	}

	private static <T> void print(T ... s){
		for(T t : s){
			System.out.print(t+" ");
		}
	}
}
