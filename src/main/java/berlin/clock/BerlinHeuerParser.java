package berlin.clock;

import berlin.clock.BerlinHeuer;

public class BerlinHeuerParser {


	public static BerlinHeuer toBerlinString(final String HHMMSS){
		Integer[] hhmmss = parse(HHMMSS);
		StringBuilder sb = new StringBuilder();

		if(hhmmss[2] != null) {
			sb.append(toBerlinString(getSeconds(hhmmss[2]),BerlinHeuerParts.SEC));
			sb.append(" ");
		} else {
			sb.append("-");
		}

		if(hhmmss[0] != null){
			sb.append(toBerlinString(getUpperRow(hhmmss[0]),BerlinHeuerParts.HOURS_5));
			sb.append(" ");
			sb.append(toBerlinString(getLowerRow(hhmmss[0]),BerlinHeuerParts.HOURS_1));
			sb.append(" ");
		} else {
			sb.append("- ");
		}

		if(hhmmss[1] != null){
			sb.append(toBerlinString(getUpperRow(hhmmss[1]),BerlinHeuerParts.MIN_5));
			sb.append(" ");
			sb.append(toBerlinString(getLowerRow(hhmmss[1]),BerlinHeuerParts.MIN_1));
		} else {
			sb.append("-");
		}

		return new BerlinHeuer(HHMMSS, sb.toString());
	}

	private static String toBerlinString(final int on, BerlinHeuerParts part){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < part.getPadding(); i++){
			if(i < on){
				if(part.isMarkQuarters() && i%3 == 2)
					sb.append(part.getQuarterColour());
				else
					sb.append(part.getOnColour());

			} else {
				sb.append(part.getOffColour());
			}
		}
		return sb.toString();
	}

	private static int getUpperRow(final int value){
		return value/5;
	}

	private static int getLowerRow(final int value){
		return  value - ((value/5) * 5);
	}

	public static int getSeconds(final int seconds){
		//is even/odd. negate.
		return (seconds % 2) ^ 1;
	}

	public static Integer[] parse(final String hhmmss){

		Integer[] iHHMMSS = new Integer[3];
		// restricts format, digits and some values
		if(hhmmss.matches("([0-2][0-9]):([0-5][0-9]):([0-5][0-9])")) {

			String[] HHMMSS = hhmmss.split(":");

			for(int i = 0; i < 3; i++){
				int partValue = Integer.parseInt(HHMMSS[i]);

				// Hours 00 - 24
				if(i == 0 && partValue >= 0 && partValue <= 24)
					iHHMMSS[i] = partValue;

				// Minutes && secs 00 - 59
				if(i > 0 && partValue >= 0 && partValue <= 59)
					iHHMMSS[i] = partValue;
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
