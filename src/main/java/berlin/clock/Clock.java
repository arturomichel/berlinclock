package berlin.clock;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class Clock {
	
	private TimeZone tz;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	private static class ClockHolder {
		private static final Clock INSTANCE = new Clock();
	}
	
	public static final Clock getInstance() {
		return ClockHolder.INSTANCE;
	}
	
	private Clock() {
		tz = TimeZone.getDefault();
	}
	
	public void setTimeZone(final String gmtOffsetHrs) {
		
		if(gmtOffsetHrs != null && gmtOffsetHrs.matches("[0-2]*[0-9]")) {
			
			int offset = 0;
			offset = Integer.parseInt(gmtOffsetHrs);
			String gmtTimeZone = String.format("GMT" + (offset >= 0 ? "+" : "-") + "%02d", Math.abs(offset));
			tz = TimeZone.getTimeZone(gmtTimeZone);
		}
	}
	
	public String getTime() {
		long timeInMillis = Calendar.getInstance().getTimeInMillis() + tz.getRawOffset();
		return sdf.format(new Date(timeInMillis));
	}	
	
	public BerlinClock getBerlinClock() {
		return BerlinClockBuilder.build(getTime());
	}
	
	public BerlinClock getBerlinClock(final String time){
		return BerlinClockBuilder.build(time);
	}
}
