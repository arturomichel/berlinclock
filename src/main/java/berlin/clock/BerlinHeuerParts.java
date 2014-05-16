package berlin.clock;

public enum BerlinTimeParts {

	HOURS_5(false, 4, 5),
	HOURS_1(false, 4, 1),
	MIN_5(true,11,5),
	MIN_1(false,4,5),
	SEC(false,1,1);
	
	private boolean markQuarters;
	
	private int padding;
	
	private int base;

	private BerlinTimeParts(boolean markQuarters, int padding, int base) {
		this.markQuarters = markQuarters;
		this.padding = padding;
		this.base = base;
	}

	public boolean isMarkQuarters() {
		return markQuarters;
	}

	public int getPadding() {
		return padding;
	}

	public int getBase() {
		return base;
	}
	
	
}
