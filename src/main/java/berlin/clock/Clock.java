package berlin.clock;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class Clock {

	private TimeZone timeZone;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	private static final int MAX_OFFSET = 13;
	private static final int MIN_OFFSET = -12;

	private static class ClockHolder {
		private static final Clock INSTANCE = new Clock();
	}

	public static final Clock getInstance() {
		return ClockHolder.INSTANCE;
	}

	private Clock() {
		timeZone = TimeZone.getDefault();
	}

	public void setOffset(final String gmtOffsetHrs) {

		if(gmtOffsetHrs != null && gmtOffsetHrs.matches("[-]{0,1}[0-2]{0,1}[0-9]")) {
			int offset = 0;
			offset = Integer.parseInt(gmtOffsetHrs);
			if(offset <= MAX_OFFSET && offset >= MIN_OFFSET) {
				String gmtTimeZone = String.format("GMT" + (offset >= 0 ? "+" : "-") + "%02d", Math.abs(offset));
				timeZone = TimeZone.getTimeZone(gmtTimeZone);
			}
		}
	}

	public String getOffset() {
		return timeZone.getDisplayName();
	}

	public String getTimeZone() {
		return timeZone.getDisplayName();
	}

	public String getTime() {
		long timeInMillis = Calendar.getInstance().getTimeInMillis() + timeZone.getRawOffset();
		return sdf.format(new Date(timeInMillis));
	}	

	public BerlinClock getTimeBerlinFormat() {
		return BerlinClockBuilder.build(getTime());
	}

	public BerlinClock getTimeBerlinFormat(final String time){
		return BerlinClockBuilder.build(time);
	}
}
