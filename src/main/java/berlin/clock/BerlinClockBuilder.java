package berlin.clock;


public class BerlinClockBuilder {

	private static final int SET_SIZE = 5;
	private static final int MAX_HOURS = 24;
	private static final int MAX_MIN = 59;

	public static BerlinClock build(final String HHMMSS) {

		Integer[] hhmmss = parse(HHMMSS);
		BerlinClock bh = new BerlinClock(HHMMSS);
		
		bh.setHoursSets(setLights(getCompleteSets(hhmmss[0]), SetProperties.HOURS_5));
		bh.setHoursPartialSet(setLights(getPartialSets(hhmmss[0]), SetProperties.HOURS_1));
		
		bh.setMinSets(setLights(getCompleteSets(hhmmss[1]), SetProperties.MIN_5));
		bh.setMinPartialSet(setLights(getPartialSets(hhmmss[1]), SetProperties.MIN_1));
		
		bh.setSec(setLights(getSeconds(hhmmss[2]), SetProperties.SEC));
		
		bh.setTimeZone(Clock.getInstance().getTimeZone());
		
		return bh;
	}

	private static String setLights(final int on, SetProperties part) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < part.getPadding(); i++) {
			if(i < on) {
				
				if(part.isMarkQuarters(i))
					sb.append(part.getQuarterColour());
				else
					sb.append(part.getOnColour());

			} else {
				sb.append(part.getOffColour());
			}
		}
		return sb.toString();
	}
	
	private static int getCompleteSets(final int value) {
		return value / SET_SIZE;
	}

	private static int getPartialSets(final int value) {
		return  value - ((value / SET_SIZE) * SET_SIZE);
	}

	public static int getSeconds(final int seconds) {
		//is even/odd. negate.
		return (seconds % 2) ^ 1;
	}

	public static Integer[] parse(final String hhmmss) {

		Integer[] iHHMMSS = new Integer[3];
		// restricts format, digits and some values
		if(hhmmss.matches("([0-2]{0,1}[0-9]):([0-5]{0,1}[0-9]):([0-5]{0,1}[0-9])")) {

			String[] HHMMSS = hhmmss.split(":");

			for(int i = 0; i < 3; i++) {
				
				int partValue = Integer.parseInt(HHMMSS[i]);

				// Hours 00 - 24
				if(i == 0 && partValue >= 0 && partValue <= MAX_HOURS)
					iHHMMSS[i] = partValue;

				// Minutes && secs 00 - 59
				if(i > 0 && partValue >= 0 && partValue <= MAX_MIN)
					iHHMMSS[i] = partValue;
			}
		} 
		return iHHMMSS;
	}

	public static <T> void print(T ... s) {
		for(T t : s) {
			System.out.print(t+" ");
		}
	}
}
