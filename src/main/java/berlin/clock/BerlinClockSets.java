package berlin.clock;

public enum BerlinHeuerParts {
	
	HOURS_5(false, 4, Colours.RED, Colours.RED, Colours.OFF),
	HOURS_1(false, 4, Colours.RED, Colours.RED, Colours.OFF),
	MIN_5(true,11, Colours.YELLOW, Colours.RED, Colours.OFF),
	MIN_1(false,4, Colours.YELLOW, Colours.YELLOW, Colours.OFF),
	SEC(false,1, Colours.YELLOW, Colours.RED, Colours.OFF);
	
	private boolean markQuarters;
	
	private int padding;
	
	private String onColour;

	private String quarterColour;
	
	private String offColour;
	
	
	
	private BerlinHeuerParts(boolean markQuarters, int padding, String onColour, String quarterColour, String offColour) {
		this.markQuarters = markQuarters;
		this.padding = padding;
		this.onColour = onColour;
		this.quarterColour = quarterColour;
		this.offColour = offColour;
	}

	public boolean isMarkQuarters() {
		return markQuarters;
	}

	public int getPadding() {
		return padding;
	}
	
	public String getOnColour() {
		return onColour;
	}

	public String getQuarterColour() {
		return quarterColour;
	}

	public String getOffColour() {
		return offColour;
	}

	public static final class Colours {
		public static String YELLOW = "Y";
		public static String RED = "R";
		public static String OFF = "O";
	}
}
