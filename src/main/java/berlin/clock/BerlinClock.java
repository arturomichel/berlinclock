package berlin.clock;

import java.util.TimeZone;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BerlinClock {

	private String time;
	
	private String hoursSets;
	
	private String hoursPartialSet;
	
	private String minSets;
	
	private String minPartialSet;
	
	private String sec;
	
	private String timeZone;

	public BerlinClock() {
		super();
	}

	public BerlinClock(final String time, final String hoursSet1, final String hoursSet2,
			final String minSet1, final String minSet2, final String sec) {
		super();
		this.time = time;
		this.hoursSets = hoursSet1;
		this.hoursPartialSet = hoursSet2;
		this.minSets = minSet1;
		this.minPartialSet = minSet2;
		this.sec = sec;
		this.timeZone = TimeZone.getDefault().getDisplayName();
	}

	public BerlinClock(final String time){
		this(time, null, null, null, null, null);
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHoursSets() {
		return hoursSets;
	}

	public void setHoursSets(String hoursSets) {
		this.hoursSets = hoursSets;
	}

	public String getHoursPartialSet() {
		return hoursPartialSet;
	}

	public void setHoursPartialSet(String hoursPartialSet) {
		this.hoursPartialSet = hoursPartialSet;
	}

	public String getMinSets() {
		return minSets;
	}

	public void setMinSets(String minSets) {
		this.minSets = minSets;
	}

	public String getMinPartialSet() {
		return minPartialSet;
	}

	public void setMinPartialSet(String minPartialSet) {
		this.minPartialSet = minPartialSet;
	}

	public String getSec() {
		return sec;
	}

	public void setSec(String sec) {
		this.sec = sec;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public String toString() {
		return "BerlinClock [time=" + time + ", hoursSets=" + hoursSets + ", hoursPartialSet=" + hoursPartialSet + ", minSets=" + minSets + ", minPartialSet=" + minPartialSet + ", sec=" + sec + ", timeZone=" + timeZone + "]";
	}

}
