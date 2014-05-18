package berlin.clock;

import berlin.clock.BerlinClock;

public class BerlinClockBuilder {


	public static BerlinClock build(final String HHMMSS){
	
		Integer[] hhmmss = parse(HHMMSS);
		BerlinClock bh = new BerlinClock(HHMMSS);
		
		bh.setHours20(setLights(getUpperSet(hhmmss[0]), BerlinClockSets.HOURS_5));
		bh.setHours1(setLights(getLowerSet(hhmmss[0]), BerlinClockSets.HOURS_1));
		bh.setMin5(setLights(getUpperSet(hhmmss[1]), BerlinClockSets.MIN_5));
		bh.setMin1(setLights(getLowerSet(hhmmss[1]), BerlinClockSets.MIN_1));
		bh.setSec(setLights(getSeconds(hhmmss[2]), BerlinClockSets.SEC));
		
		return bh;
	}

	private static String setLights(final int on, BerlinClockSets part){
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

	private static int getUpperSet(final int value){
		return value/5;
	}

	private static int getLowerSet(final int value){
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
